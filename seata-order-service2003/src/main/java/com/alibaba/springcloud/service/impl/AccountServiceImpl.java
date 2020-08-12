package com.alibaba.springcloud.service.impl;

import com.alibaba.springcloud.dao.AccountDao;
import com.alibaba.springcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Resource
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {

        LOGGER.info("------->account-service中扣减账户余额开始");

        //这个是测试Seata事务的，加上这个延时，访问服务必超时，所以@GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class) 这个注解起作用
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
