package com.vfuchong.sptsm.gateway.routedefine;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.vfuchong.sptsm.gateway.common.GatewayConstans;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@NacosConfigurationProperties(prefix = "config.dict", dataId = GatewayConstans.DATA_ID_SETTINGS, groupId = GatewayConstans.GROUP_GATEWAY, autoRefreshed = true)
@Configuration
@Getter
@Setter
public class DictProperties {
    /**
     * todo nacos注入map，配置中心删除key时相应的Bean数据不会更新，key仍然会存在，需要等待最新版本或者找其他方法解决
     */
    private Map<String, String> cardCodeDict;
}