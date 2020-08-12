package com.alibaba.springcloud.service.fallback;

import com.alibaba.springcloud.service.OpenFeignMemberService;
import org.springframework.stereotype.Component;

//这是一个容错类，需要实现Feign所在的借口，并去实现借口中的所有方法
//一旦Feign远程调用出现问题了，就会进入当前类中同名方法，执行容错逻辑
@Component
public class MemberServiceFallback implements OpenFeignMemberService {

    @Override
    public String member() {
        return "远程调用会员服务异常，进入容错逻辑";
    }

    @Override
    public String findMemberById(Integer id) {
        return "远程调用会员id服务异常，进入容错逻辑";
    }
}
