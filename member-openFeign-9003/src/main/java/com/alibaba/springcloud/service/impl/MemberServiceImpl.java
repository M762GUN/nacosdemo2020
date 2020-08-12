package com.alibaba.springcloud.service.impl;

import com.alibaba.springcloud.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Value("${server.port}")
    private String port;

    @Override
    public String member() {
        return "hello admin"+port;
    }

    @Override
    public String findMemberById(Integer id) {
        return "hello id"+id+"  "+port;
    }

}
