package com.alibaba.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handlerException1(BlockException blockException){
        return "200,用户自定义处理异常1，global handlerException1-----------1";
    }

//    public static String handlerException2(BlockException blockException){
//        return "200,用户自定义处理异常2，global handlerException2-----------2";
//    }

}
