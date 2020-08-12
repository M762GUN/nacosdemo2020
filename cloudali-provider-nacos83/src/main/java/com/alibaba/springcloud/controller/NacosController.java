package com.alibaba.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class NacosController {
    @Resource
    private RestTemplate restTemplate;

    //读取配置文件，实现代码与配置分离
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/nacos1/{id}")
    public String paymentInfo1(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL + "/demoNacos/nacos1/" + id, String.class);
    }

    @GetMapping(value = "/consumer/nacos2/{id}")
    public String paymentInfo2(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverURL + "/demoNacos/nacos2/" + id, String.class);
    }

    @GetMapping(value = "/consumer/zipkin")
    public String paymentInfo3() {
        return restTemplate.getForObject(serverURL + "/consumer/zipkin", String.class);
    }

}
