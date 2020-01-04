package com.robintime.alibaba.dubbo.core;

import com.alibaba.dubbo.config.AbstractConfig;
import com.alibaba.dubbo.config.spring.beans.factory.annotation.DubboFeignBuilder;
import com.alibaba.dubbo.config.spring.beans.factory.annotation.FeignClientToDubboProviderBeanPostProcessor;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Set;

import static com.alibaba.boot.dubbo.util.DubboUtils.BASE_PACKAGES_PROPERTY_NAME;
import static com.alibaba.boot.dubbo.util.DubboUtils.DUBBO_PREFIX;
import static java.util.Collections.emptySet;

/**
 * @ConditionalOnProperty：触发条件，当配置文件中存在预设条件则触发当前自动配置
 * @ConditionalOnClass：触发条件，当 classpath 下存在预设类则触发当前自动配置
 */
@Configuration
@ConditionalOnProperty(prefix = DUBBO_PREFIX, name = "enabled", matchIfMissing = true, havingValue = "true")
@ConditionalOnClass(AbstractConfig.class)
public class SpringCloudAlibabaDubboAutoConfiguration {
    @ConditionalOnProperty(name = BASE_PACKAGES_PROPERTY_NAME)
    @ConditionalOnClass(ConfigurationPropertySources.class)
    @Bean
    public FeignClientToDubboProviderBeanPostProcessor feignClientToDubboProviderBeanPostProcessor(Environment environment) {
        Set<String> packagesToScan = environment.getProperty(BASE_PACKAGES_PROPERTY_NAME, Set.class, emptySet());
        return new FeignClientToDubboProviderBeanPostProcessor(packagesToScan);
    }

    @Bean
    public Feign.Builder feignDubboBuilder() {
        return new DubboFeignBuilder();
    }
}