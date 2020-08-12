package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.service.OpenFeignMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OpenFeignController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Resource
    private OpenFeignMemberService openFeignMemberService;


    @GetMapping("/feign1")
    public String feign1(){
        return openFeignMemberService.member();
    }

    @GetMapping("/feign2/{id}")
    public String feign2(@PathVariable Integer id){

        return openFeignMemberService.findMemberById(id);
    }

    @GetMapping("/info")
    public Object getMemberServerInfo(){
        // 通过服务名称获取nacos上的服务信息        pitch-member:为会员的服务名称
        List<ServiceInstance> instances = discoveryClient.getInstances("pitch-member");
        return instances;
    }

}
