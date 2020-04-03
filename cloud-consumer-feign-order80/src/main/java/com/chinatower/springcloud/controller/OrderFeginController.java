package com.chinatower.springcloud.controller;

import com.chinatower.springcloud.entities.CommonResult;
import com.chinatower.springcloud.entities.Payment;
import com.chinatower.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/2 10:13
 */
@RestController
@Slf4j
public class OrderFeginController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon,客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
