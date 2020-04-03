package com.chinatower.springcloud.service;

import com.chinatower.springcloud.entities.CommonResult;
import com.chinatower.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yunxl
 * @date 2020/4/2 9:43
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

     @GetMapping(value="/payment/get/{id}")
     public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

     @GetMapping(value = "/payment/feign/timeout")
     public String paymentFeignTimeout();
}
