package com.springcloud.alibaba.service;

import com.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "account/decrease")
    CommonResult decrease(@RequestParam(value = "userId")Long userId, @RequestParam(value = "money") BigDecimal money);//调他库存减少


}
