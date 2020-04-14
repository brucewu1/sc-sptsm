package com.vfuchong.sptsm.common.exception;

/**
 *  错误码 统一格式：CCXXX
 *  CC是模块代码；XXX具体错误代码
 *  错误码主要是对外返回
 */
public enum ErrorCode implements IErrorCode {
    /**
     * 参数说明：参数1是错误代码，参数2是响应给客户端的错误信息，参数3为系统日志打印信息以及写入操作表的错误信息
     * {@link BizException#BizException(IErrorCode, Object...)} 构造方法是为响应给客户端的信息赋值，日志打印的错误信息赋值需要
     * 使用{@link BizException#setArgs(Object...)}方法
     */

    /*==================================公共错误 000XXX start==================================================*/
    // 成功，禁止修改
    SUCCESS("0", "success"),
    // 系统内部错误
    SYSTEM_ERROR("00001", "system error", "system error, %s"),
    // 数据库错误 查询数据库出错。没有更新到预期的记录。
    DB_ERROR("00002", "DB error", "DB error: %s"),
    // 远程服务错误 和远程服务器交互出错 比如：连接超时，远程服务器返回数据有问题（包括通卡公司返回的签名有问题）等
    REMOTE_ERROR("00003", "remote service error", "request service error. %s"),
    // 远程服务器没有返回
    REMOTE_RESP_NULL("00004", "remote service response null", "[%s] request service response null."),
    // 远程服务器返回错误码
    REMOTE_RESP_ERROR("00005", "remote service response error", "[%s] request service response error. errorCode:%s, errorMsg:%s"),
    // 不支持的操作，不支持的功能
    UNSUPPORTED_OPERATION("00006", "unsupported operation", "unsupported operation [%s]"),
    // 参数为空
    PARAM_IS_EMPTY("00007", "missing params:%s"),
    // 参数错误 接口调用者传入约定以外的值。
    PARAM_ERROR("00008", "param error", "param error %s"),
    // 系统缺少相关参数配置
    CONFIG_MISSING("00009", "missing config", "missing config, %s"),
    // 系统资源不足
    SYSTEM_RESOURCES_NOT_ENOUGH("00010", "system resources not enough", "system resources not enough, %s"),
    // 加密机连接或加密失败
    HSM_DECRYPT_FAIL("00011", "failed to connect hsm or no data decrypted"),
    // 签名错误 华为、OPPO等手机厂商的签名
    SIGN_ERROR("00012", "verify sign error"),
    // 密钥解析错误
    PARSE_KEY_ERROR("00013", "parse key error", "parse key error, %s"),
    // 不支持的操作
    NOT_SUPPORT_OPT("00014", "inner error", "not support [%s] opt"),

    /** sd相关错误预留100-199 **/
    // 获取的token为空
    GET_TOKEN_IS_NULL("00100", "[%s] get token is null"),
    // 获取Token失败
    GET_TOKEN_FAIL("00101", "get token fail", "get token fail,%s"),
    //  keyData为空
    KEY_DATA_IS_NULL("00102", "keydata is null"),
    // 外部认证失败
    EXT_AUTH_FAIL("00103", "failed to process NWExtAuth with SD[%s]"),
    // 安全通道没有成功建立
    INVALID_SECURITY_CHANNEL("00104","invalid security channel"),
    // MAC1校验错误
    MAC1_ERROR("00105","mac1校验失败"),
    //APDU内容为空
    APDU_CONTENT_IS_NULL("00106","apduContent is null![%s]"),
    /*==================================公共错误 end===========================================================*/

    /*==================================查询订单 20XXX start==================================================*/
    /*==================================查询订单 end===========================================================*/

    /*==================================创建订单 21XXX start==================================================*/
    // 机型不支持
    UNSUPPORTED_DEVICE_MODEL("21001", "unsupported model. cardCode[%s] deviceModel[%s]"),
    // 业务已关闭
    SERVER_CLOSED("21002", "[CreateOrderHandler] card is closed, cardCode[%s] cardStatus[%s]"),
    // 优惠额度不足
    QUOTA_NOT_ENOUGH("21003", "Insufficient preferential quota"),
    // 优惠名额已经用完
    DISCOUNT_QUOTA_USED_UP("21004", "优惠名额已经用完"),
    // 当前手机型号在当前时间存在多个活动
    TOO_MANY_ACTIVITY("21005", "当前手机型号在当前时间存在多个活动"),
    // 已经退款成功，防重复
    ALREADY_REFUND_SUCCESS("21007", "refund success ,do not try again. orderNo:%s"),
    // 已经退款失败，防重复
    ALREADY_REFUND_FAIL("21008", "refund fail ,do not try again. orderNo:%s"),
    // 已经退款申请，防重复
    ALREADY_REFUND_APPLY("21009", "refund applied ,do not try again. orderNo:%s"),
    // 不能多次退款，防重复
    CAN_NOT_MULTIPLE_REFUND("21010", "orderNo:%s was refunded,multiple refunds are not supported, orderRefund.refundNo:%s,request refundNo:%s"),

    /*==================================创建订单 end===========================================================*/

    /*==================================获取开卡充值金额 22XXX start==========================================*/
    /*==================================获取开卡充值金额 end===================================================*/

    /*==================================下载安装 230XXX start==================================================*/
    // 芯片类型为空 安装参数和芯片类型有关
    ESE_TYPE_IS_NULL("23006", "[InstallForInstallAndMakeSelectable] seChipManuFacturer is null"),
    // 卡片库存不足
    CARD_STOCK_NOT_ENOUGH("23007", "卡片库存不足"),
    // 下载APDU执行失败
    DOWNLOAD_INSTALL_APDU_EXECUTE_FAIL("23008", "loadInstall APDU executed failed"),
    /*==================================下载安装 end===========================================================*/

    /*==================================个人化 开卡 24XXX start=================================================*/
    // 不能开卡（实例未创建）
    CAN_NOT_OPEN_CARD("24001", "未创建实例，无法个人化", "未创建实例，无法个人化，当前状态[%s]"),
    // 订单未支付 开卡和充值的时候，需要订单已经支付
    ORDER_NOT_PAY("24002", "order not paid", "order:%s not paid"),
    // 订单不存在 根据订单号和渠道查询不到订单
    ORDER_NOT_FOUND("24003", "order not found", "order:%s not found, sourceChnl:%s"),
    // 订单状态异常
    ORDER_STATUS_ERROR("24004", "订单状态异常,订单号:%s"),
    // seApplication没有记录
    SE_APPLICATION_NOT_FOUND("24005", "seId[%s] 未开过卡"),
    // 写卡MAC失败
    WRITE_MAC_FAIL("24008", "writing mac failed. result is %s"),
    // 上报订单失败
    UPLOAD_ORDER_FAIL("24009", "the request of the upload order exception"),
    // 没有找到cardMaintain或者cityCode
    NO_CITY_CODE("24011", "卡号[%s]卡片信息有误,无法获取城市代码信息"),
    // 个人化APDU数据为空
    PERSONALIZE_APDU_IS_NULL("24013", "prepare personalize data is null, personalizeType[%s]"),
    // 固定报文域组包规则不存在 见表fixpack_rule
    PACKET_ENCODE_RULE_NOT_FOUND("24015", "packet encode rule not found. msg_rule_cd:%s"),
    PACKET_ENCODE_ERROR("24016", "packet message error:%s"),
    PACKET_DECODE_ERROR("24017", "packet message error:%s"),
    // 个人化APDU执行失败
    PERSONALIZE_APDU_EXECUTE_FAIL("24016", "open card APDU executed failed"),

    /*==================================个人化 开卡 end======================================================== */

    /*==================================充值 25XXX start======================================================*/
    // 不能充值(不是开卡成功状态)
    CAN_NOT_RECHARGE("25001", "personalize no completed, not allowed recharge", "personalize no completed, not allowed recharge, current state:%s, orderNo:%s"),
    // 订单已充值成功，不能重复执行
    ALREADY_RECHARGE_SUCCESS("25002", "repeat orders recharge", "repeat orders recharge, orderNo:%s"),
    // 余额超过上限
    BALANCE_EXCEED_LIMIT("25005", "balance out of limit", "The current balance[%s] and czFee[%s] out of the upper limit, orderNo[%s]"),
    // 充值失败，联系客服。 充值状态有问题
    RECHARGE_FAIL_CCS("25006", "Recharge error, please contact customer service"),
    // 卡号不匹配。从0015文件中读取的卡号和接口请求的卡号不一致
    CARD_NO_MISMATCH("25007", "cardNo not match"),
    // 网点不存在
    CITY_TERMINAL_NOT_FOUND("25008", "CityTerminalRel not found. cardCode[%s]"),
    // 不支持的外部城市代码card_external_code
    UNSUPPORTED_EXT_CITY_CODE("25010", "not support issueId:%s"),
    // 不支持的mobile mode
    UNSUPPORTED_MOBILE_MODE("25011", "not support mobile model:%s"),
    // 充值APDU执行失败
    RECHARGE_APDU_EXECUTE_FAIL("25012", "recharge APDU executed failed"),
    ORDER_NOT_FOUND_RECHARGE("25013", "order not found", "order not found, [%s]"),
    /*==================================充值 end===============================================================*/

    /*==================================删卡26XXX (包括format.ese) start======================================*/
    // 退款金额大于订单总金额
    REFUND_MORE_THAN_TOTAL("26001", "退款金额大于订单总金额"),
    // 删卡APDU执行失败
    DELETE_APDU_EXECUTE_FAIL("26003", "delete APDU executed failed"),
    // 卡余额被修改
    DIFFERENT_CARD_BALANCE("26005", "卡片:%s读卡余额:%s与备份余额:%s存在差异，禁止删卡"),
    // 没有余额 卡片恢复的时候，需要写入余额，余额是必须的
    CARD_BALANCE_NOT_FOUND("26006", "未找到卡片余额信息"),
    NOT_FOUND_BACKUP_DATA_DELETE("26007", "卡片:%s未找到备份数据，禁止删卡"),
    CARD_OVER_DRAW("26008", "卡片已透支，无法删除。请充值后重试"),

    /*==================================删卡(包括format.ese) end===============================================*/

    /*==================================移除和恢复 27XXX start================================================*/
    // 没有备份数据
    MIGRATE_BACKUP_NOT_FOUND("27001", "卡片:%s未找到备份数据或还未删卡"),
    // 未备份%s应用的0015文件数据
    BACKUP_MISSING_0015("27002", "恢复数据组装异常", "未备份[%s]应用的0015文件数据"),
    // 卡数据缺少%s标签
    DP_MISSING_TAG("27005","dp data file missing tag[%s]"),
    // 圈存密钥解析错误
    LOAD_KEY_PARSE_ERROR("27006", "圈存密钥解析错误"),
    // 该设备已经开过同类型卡或已恢复卡数据，无法再次进行恢复操作
    CAN_NOT_RESTORE("27007", "该设备已经开过同类型卡或已恢复卡数据，无法再次进行恢复操作"),
    // 恢复订单号与下载安装请求时的订单号不匹配
    ORDER_NO_MISMATCH("27008", "恢复订单号与下载安装请求时的订单号不匹配"),
    // 生成移除订单时，移除策略现在不满足。规定时间期限内， 同一卡号申请移除次数超过规定
    REMOVE_CHECK_BEYOND_LIMIT("27010", "beyond limit of remove count, cardno[%s]"),
    // 申请恢复订单时， 同一卡号存在未完成的恢复订单
    RESTORE_EXIST_UNHANDLED_ORDER("27011", "had unhandled order"),
    // 迁卡备份APDU执行失败
    MIGRATE_BACKUP_APDU_EXECUTE_FAIL("27012", "migrate backup APDU executed failed"),
    // 迁卡恢复APDU执行失败
    MIGRATE_RESTORE_APDU_EXECUTE_FAIL("27013", "migrate restore APDU executed failed"),
    // 应用不存在
    INSTANCE_NOT_EXIST("27014", "应用实例不存在"),
    // 迁卡条件检查APDU执行失败
    CHECK_APDU_EXECUTE_FAIL("27015", "apdu executed failed"),
    // 河北迁卡检查余额，超过5元返回此错误码
    CHECK_BALANCE_OVER_RANGE("27016", "balance out of range"),

    /*==================================移除和恢复 end=========================================================*/

    /*==================================退款 28XXX start======================================================*/
    // 不允许退款
    CAN_NOT_REFUND("28001", "不允许退款", "不允许退款,退款类型[%s], 订单类型[%s], 订单状态[%s]"),
    // 退款金额不匹配
    REFUND_AMOUNT_NOT_MATCH("28002", "退款金额不匹配", "退款金额不匹配,orderNo[%s]"),
    // 退款信息为空
    ORDER_REFUND_NOT_FOUND("28003", "not found refund order info", "not found refund order info, refund orderNo is: %s"),
    // 华为退款异常
    HUAWEI_REFRUND_EXCEPTION("28004","Hauwei_refund_exception : %s"),
    /*==================================退款 end===============================================================*/

    // 80开始,内部后台使用
    /*==================================卡数据解析80XXX start===================================================*/
    // 不是一个目录
    NOT_DIR("80001", "file:%s is invalid or is not a directory"),
    // 文件不存在
    FILE_NOT_EXISTS("80002", "文件:%s不存在 [%s]"),
    // 解析CPK文件失败
    PARSE_CPK_FILE_FAIL("80003", "failed to parse CPK file[%s]"),
    // 解析ATS文件失败
    PARSE_ATS_FILE_FAIL("80004", "failed to parse ats file[%s]"),
    // 解析PBOC文件失败
    PARSE_PBOC_FILE_FAIL("80005", "failed to parse pboc file[%s]"),
    // DP文件已经被解析，在dp_file表中有记录。防重复
    DP_FILE_ALREADY_PARSED("80006", "DP文件:%s已被解析，请勿重复请求"),
    // 没有找到相关的DGI数据
    DP_DGI_NOT_FOUND("80007", "not find DGI for cardNo :%s"),
    // DGI数据缺少某个标签
    DP_DGI_MISSING_TAG("80008", "dgi data missing tag[%s]"),
    // DGI标签值错误
    TAG_VALUE_NOT_ENOUGH("80009", "tag:%s error: the length of the tag value data is not enough"),
    // 文件不是TLV格式 对应每个标签都是tag-length-value格式（标签【2字节】，值字节数【1字节】，值）
    TLV_FORMAT_ERROR("80010", "the file is not a TLV format", "the file is not a TLV format. location[%s] tag[%s] %s"), // 位置 标签名称 原因
    // 非法的标签名
    TAG_NAME_ERROR("80011", "incorrect dgi tag name [%s], location %s"),
    // DGI length 为负数
    TAG_LENGTH_ERROR("80012", "error:data invalid, location %s"),
    // tag的值错误
    TAG_VALUE_ERROR("80013", "the data of tag[%s] is error %s"),
    // 验证电子钱包文件完整性失败
    EWALLET_FILE_VALIDATE_FAIL("80014", "failed to validate ewallet file:%s"),
    // PBOC文件长度不足，期待%s字节，但是只读取到%s字节
    PBOC_FILE_LENGTH_NOT_ENOUGH("80015", "The length of PBOC file is not enough, except %s bytes, but only found %s bytes."),
    // 数据错误 dgi实际数量和声称数量不一致
    DGI_NUMBER_MISMATCH("80016", "error:data valid, total dgi num [%s], parse real dgi num only [%s]"),
    // DGI起始标志不是“86
    DGI_NOT_START_WITH_86("80017", "DGI起始标志不是“86, location %s"),
    /*==================================卡数据解析 end============================================================*/
    /*==================================用户角色权限等管理系统通用功能 81XXX start ===============================*/
    // 权限url重复
    PERMISSION_URL_REPEAT("81001", "权限重复,请修改url代码"),
    /*==================================用户角色权限等管理系统通用功能 end =======================================*/

    /*==================================其他99XXX (比如身份认证、领取发票等) start================================*/
    // 签到失败
    CHECK_IN_FAIL("99001", "check in fail:%s"),
    // 支付宝商家不存在
    ALIPAY_MERCHANT_NOT_FOUND("99003", "alipay merchant not found", "alipay merchant not found. userId:%s appId:%s"),
    // 查询充值备付金失败
    QUERY_PREPAID_DEPOSIT_FAIL("99004", "查询充值备付金失败"),
    // 盛京通重复领取发票
    INVOICE_RECEIVE("99005", "%s订单,不能重复领取发票"),
    // 甬城通余额已通知过
    ALREADY_NOTIFY_BALANCE("99008", "%s,该卡号已通知过余额"),
    TOO_MANY_REQUESTS("99998", "服务器繁忙，请稍后重试"),

    /*==================================其他(比如身份认证、领取发票等) end========================================*/
    ;

    /**
     * pm_business_opt_log操作表记录信息
     */
    private String message;
    /**
     * 客户端响应信息
     */
    private String returnMsg;
    /**
     * 异常描述，支持String.format格式
     */
    private String errorCode;

    ErrorCode(String errorCode, String returnMsg) {
        this(errorCode, returnMsg, returnMsg);
    }

    ErrorCode(String errorCode, String returnMsg, String message) {
        this.message = message;
        this.returnMsg = returnMsg;
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getReturnMsg() {
        return returnMsg;
    }

    public ErrorCode setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }

    public ErrorCode setMessage(String msg) {
        this.message = msg;
        return this;
    }
    public static boolean isRemoteError(String errorCode) {
        return REMOTE_ERROR.errorCode.equals(errorCode)
                || REMOTE_RESP_NULL.errorCode.equals(errorCode) || REMOTE_RESP_ERROR.errorCode.equals(errorCode);
    }

    public static boolean isAPDUError(String errorCode) {
        return DOWNLOAD_INSTALL_APDU_EXECUTE_FAIL.errorCode.equals(errorCode)
                || PERSONALIZE_APDU_EXECUTE_FAIL.errorCode.equals(errorCode) || MIGRATE_BACKUP_APDU_EXECUTE_FAIL.errorCode.equals(errorCode)
                || RECHARGE_APDU_EXECUTE_FAIL.errorCode.equals(errorCode) || MIGRATE_RESTORE_APDU_EXECUTE_FAIL.errorCode.equals(errorCode)
                || DELETE_APDU_EXECUTE_FAIL.errorCode.equals(errorCode) || CHECK_APDU_EXECUTE_FAIL.errorCode.equals(errorCode);
    }
}
