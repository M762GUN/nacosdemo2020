package com.alibaba.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.springcloud.service.FlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private FlowService flowService;

    @GetMapping("/testA")
    public String testA(){
//        flowService.common();
        return "-------------testA";
    }

    @GetMapping("/testB")
    public String testB(){
//        flowService.common();
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "-------------testB";
    }

    //测试异常比例
    @GetMapping("/testD")
    public String testD()
    {
        // 降级RT
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        //降级异常比例
        log.info("testD 异常比例");
        int age = 10/0;
        return "------testD";
    }

    //测试异常数
    @GetMapping("/testE")
    public String testE()
    {
        // 降级RT
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");

        //降级异常比例
        log.info("testE 异常数");
        int age = 10/0;
        return "------testE";
    }


    @GetMapping("/testHotKey") // rest地址
    @SentinelResource(value = "testHotKey" , blockHandler = "deal_testHotKey")
                                            //这个value值可以随意，但是最好跟rest一致，规范。
                                            // 设置热点规则时，如果资源名加/就是走的rest，不加就是Sentinel
                                            //blockHandler是个兜底方法，如果控制台限流，则走此方法
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int age = 10/0;
        return "-------------testHotKey";
    }
    //这个方法是相当于做了个好看的错误页面，对用户很友好，比报异常好看
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "-----对不起，服务器正在升级！--------deal_testHotKey"; // Sentinel系统默认提示：Blocked by Sentinel (flow limiting)
    }


}
