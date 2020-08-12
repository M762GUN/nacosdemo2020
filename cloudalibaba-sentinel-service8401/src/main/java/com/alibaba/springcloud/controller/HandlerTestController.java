package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HandlerTestController {

    @GetMapping("/demoHandler") // rest地址
    @SentinelResource(value = "demoHandler" ,
                        fallbackClass = CustomerBlockHandler.class,
                        blockHandlerClass = CustomerBlockHandler.class,
                        blockHandler = "handlerException2",
                        fallback = "fallback")
                    //这就是自定义异常处理类，减少代码膨胀，做到解耦
                    // fallback返回的所有异常，作用域比block大
    public String demoHandler(){
        return "-------------demoHandler";
    }


}
