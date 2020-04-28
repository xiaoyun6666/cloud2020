package com.chinatower.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yunxl
 * @date 2020/4/10 17:18
 */
public interface AccountService {
    /**
     * 扣减余额
     * @param userId
     * @param money
     */
   void decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
