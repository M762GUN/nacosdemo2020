package com.alibaba.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/demoNacos/nacos1/{id}")
    public String getNacos1(@PathVariable("id") Integer id){
        return "9001网关输出nacos1端口 : " + serverPort + "\t id: " + id;
    }

    @GetMapping(value = "/demoNacos/nacos2/{id}")
    public String getNacos2(@PathVariable("id") Integer id){
        return "9001网关输出nacos2端口 : " + serverPort + "\t id: " + id;
    }

}
