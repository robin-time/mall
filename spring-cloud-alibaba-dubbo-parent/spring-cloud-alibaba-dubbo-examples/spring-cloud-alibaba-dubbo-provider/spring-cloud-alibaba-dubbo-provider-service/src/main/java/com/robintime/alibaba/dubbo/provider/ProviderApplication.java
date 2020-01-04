package com.robintime.alibaba.dubbo.provider;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author: liuxiaoyong
 * @Date: 2019-12-20 16:29
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }

    /**
     * 代码层面配置dubbo端口
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);
        protocolConfig.setName("dubbo");
        return protocolConfig;
    }
}
