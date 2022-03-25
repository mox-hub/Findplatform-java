package com.ming.findplatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName :RestConfig
 * @Description :
 * @Author :Mox
 * @Date :2022/2/28 10:36
 * @Version : v1.0
 **/

@Configuration
public class RestConfig {
    @Autowired
    RestTemplateBuilder builder;
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
