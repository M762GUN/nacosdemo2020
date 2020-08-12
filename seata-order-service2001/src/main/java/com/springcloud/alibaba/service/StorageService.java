package com.springcloud.alibaba.service;

import com.springcloud.alibaba.domain.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam(value = "productId")Long productId, @RequestParam(value = "count") Integer count);//调他库存减少

}
