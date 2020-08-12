package com.alibaba.springcloud.myhandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FallBackHandler {
    public static String fallback(Throwable e){
        return "Throwable";
    }
}
