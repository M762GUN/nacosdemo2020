package com.alibaba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain.class,args);
    }
}
