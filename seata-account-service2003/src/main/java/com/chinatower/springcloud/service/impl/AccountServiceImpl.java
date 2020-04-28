package com.chinatower.springcloud.service.impl;

import com.chinatower.springcloud.dao.AccountDao;
import com.chinatower.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author yunxl
 * @date 2020/4/10 17:20
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decreaseAccount(Long userId, BigDecimal money) {
        log.info("------->account--service 扣减余额开始");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decreaseAccount(userId,money);
        log.info("------->account--service 扣减余额开始");

    }
}
