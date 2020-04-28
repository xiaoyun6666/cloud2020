package com.chinatower.springcloud.service;

import com.chinatower.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yunxl
 * @date 2020/4/10 13:43
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
