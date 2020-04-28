package com.chinatower.springcloud.controller;

import com.chinatower.springcloud.domain.CommonResult;
import com.chinatower.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yunxl
 * @date 2020/4/10 17:18
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decreaseAccount(userId,money);
        return new CommonResult(200,"扣减余额成功");
    }
}
