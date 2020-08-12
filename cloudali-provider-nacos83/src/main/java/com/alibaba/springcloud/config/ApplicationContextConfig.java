package com.alibaba.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //RestTemplate和Ribbon去做负载均衡要加这个注解
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
