package com.alibaba.springcloud.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MemberService {
    @GetMapping("/member")
    String member();

    @GetMapping("/params")
    String findMemberById(Integer id);
}
