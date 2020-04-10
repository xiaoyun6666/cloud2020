package com.chinatower.springcloud.service;

import com.chinatower.springcloud.entities.CommonResult;
import com.chinatower.springcloud.entities.Payment;
import com.chinatower.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yunxl
 * @date 2020/4/9 19:06
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentFeignService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
