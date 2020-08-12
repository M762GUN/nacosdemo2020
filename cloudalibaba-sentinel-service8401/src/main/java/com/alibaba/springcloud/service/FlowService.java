package com.alibaba.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FlowService {

    //定义资源 value指定资源名称
    @SentinelResource("common")
    public void common(){
        log.info("common......");
    }

}
