package com.springcloud.alibaba.service.impl;

import com.springcloud.alibaba.dao.OrderDao;
import com.springcloud.alibaba.domain.Order;
import com.springcloud.alibaba.service.AccountService;
import com.springcloud.alibaba.service.OrderService;
import com.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class) //Seata事务回滚注解，就这一个注解就ok。name为file.conf的key，所有异常全控制
    public void create(Order order) {
        log.info("--------》开始新建订单");
        //1、创建订单
        orderDao.create(order);
        log.info("--------》新建订单结束");


        log.info("--------》订单微服务开始调用库存，做扣减");
        //2、库存做扣减
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("--------》订单微服务开始调用库存，做扣减end");

        //3、扣减账户
        log.info("--------》订单微服务开始调用账户，做扣钱");
//        System.out.println(order.getUserId());
//        System.out.println(order.getMoney());
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("--------》订单微服务开始调用账户，做扣钱end");

        //4、修改订单状态，从0到1,1代表已经完成
        log.info("------->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------->修改订单状态结束");

        log.info("------->下订单结束，！！！！！");

    }
}
