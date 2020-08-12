package com.alibaba.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.alibaba.springcloud.dao"})
public class MyBatisConfig {
}
