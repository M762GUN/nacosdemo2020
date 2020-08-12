package com.alibaba.springcloud.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.springcloud.service.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(
        value = "pitch-member",//这个是远程被调用的服务名，必须一致
        fallback = MemberServiceFallback.class) //fallback用于指定当前feign借口的容错类
public interface OpenFeignMemberService {

    @GetMapping("/member")
    String member();

    // openfeign如果有参数默认会改成post请求, 需要生效get请求，需要在参数上加 RequestParam注解
    @GetMapping("/params")
    String findMemberById(@RequestParam("id") Integer id);
}
