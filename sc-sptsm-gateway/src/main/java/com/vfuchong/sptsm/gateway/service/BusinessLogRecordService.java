package com.vfuchong.sptsm.gateway.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vfuchong.sptsm.common.apdu.CPLCAPDUResp;
import com.vfuchong.sptsm.common.enums.SourceOrderChnlEnum;
import com.vfuchong.sptsm.common.util.ByteUtil;
import com.vfuchong.sptsm.common.util.JsonUtils;
import com.vfuchong.sptsm.gateway.routedefine.DictProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class BusinessLogRecordService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DictProperties dictProperties;
    
    /**
     * 记录前置系统异常日志信息（异步操作）
     *
     * @param cardCode
     * @param sourceChnl
     * @param seId
     * @param cardNo
     * @param commandId
     * @param startTime
     * @param respCode
     * @param returnDesc
     * @param traceId
     */
    private void recordBusinessExecuteTime(String cardCode, String sourceChnl, String seId, String cardNo,
                                          String commandId, long startTime, String respCode, String returnDesc, String traceId) {
        long endTime = System.currentTimeMillis();

        // 保存流程操作流水
        jdbcTemplate.update("insert into pm_business_opt_log(card_code, source_chnl, se_uid, card_no, business_type, command_id," +
                " execute_time, step_id, is_last_step, opt_code, opt_msg, trace_id, create_time) " +
                "values (?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)",
                cardCode, sourceChnl, seId, cardNo, 1, commandId, (endTime - startTime), -1, 0, respCode, returnDesc, traceId, new Date());
    }
    
    @Async
    public void saveErrorLog(Object requestBody, String code, String optMsg, Long startTime, String traceId) {
        try {
            if(!(requestBody instanceof String)) {
                log.warn("request body not string object, so not save to db");
                return;
            }
            if(!JsonUtils.isJson((String) requestBody)) {
                log.info("request body is not a json data, so not save to db");
                return;
            }
            startTime = startTime != null ? startTime : System.currentTimeMillis();
            String seId = "";
            String command = "";
            String cardNo = null;
            String sourceChnl = null;
            JsonObject jsonObject = JsonParser.parseString((String) requestBody).getAsJsonObject();
            String cplc = "";
            if (jsonObject.has("cplc") && !jsonObject.get("cplc").isJsonNull()) {
                cplc = jsonObject.get("cplc").getAsString();
                CPLCAPDUResp cplcResp = new CPLCAPDUResp(ByteUtil.hexToByteArray(cplc), 0);
                seId = cplcResp.getUid();
            }
            
            if (jsonObject.has("command") && !jsonObject.get("command").isJsonNull()) {
                command = jsonObject.get("command").getAsString();
            }
            if (jsonObject.has("cardNo") && !jsonObject.get("cardNo").isJsonNull()) {
                cardNo = jsonObject.get("cardNo").getAsString();
            }
            
            String issureId = "";
            if (jsonObject.has("issuerid") && !jsonObject.get("issuerid").isJsonNull()) {
                issureId = jsonObject.get("issuerid").getAsString();
            }
            
            if (jsonObject.has("caller") && !jsonObject.get("caller").isJsonNull()) {
                String caller = jsonObject.get("caller").getAsString();
                sourceChnl = SourceOrderChnlEnum.valueOf(caller).value;
            }
            String cardCode = dictProperties.getCardCodeDict().get(issureId);
            cardCode = StringUtils.isNotEmpty(cardCode) ? cardCode : issureId;
            // 保存异常操作日志
            recordBusinessExecuteTime(cardCode, sourceChnl, seId, cardNo, command,
                    startTime, code, optMsg, traceId);
        } catch (Exception e) {
            log.error("save log to db error", e);
        }
    }
}
