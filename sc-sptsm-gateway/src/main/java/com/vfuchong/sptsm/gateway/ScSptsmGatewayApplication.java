package com.vfuchong.sptsm.gateway;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.vfuchong.sptsm.gateway.common.GatewayConstans;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;

@SpringBootApplication
@EnableAsync
@NacosPropertySource(dataId = GatewayConstans.DATA_ID_SETTINGS, groupId = GatewayConstans.GROUP_GATEWAY, autoRefreshed = true)
public class ScSptsmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScSptsmGatewayApplication.class, args);
    }
    
    @Bean
    public AsyncTaskExecutor taskExecutor() {
        // 异步执行线程数据复制
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("async-executor");
        // 装饰异步线程执行代码
        executor.setTaskDecorator(runnable -> {
            final Map<String, String> copyOfContextMap = MDC.getCopyOfContextMap();
    
            return () -> {
                // 复制MDC数据到子线程
                if(copyOfContextMap != null) {
                    MDC.setContextMap(copyOfContextMap);
                }
                runnable.run();
            };
        });
        executor.setMaxPoolSize(30);
        executor.setCorePoolSize(10);
        
        return executor;
    }
}
