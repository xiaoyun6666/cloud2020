package com.chinatower.springcloud.service;

import com.chinatower.springcloud.entities.CommonResult;
import com.chinatower.springcloud.entities.Payment;
import com.chinatower.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author yunxl
 * @date 2020/4/9 19:10
 */
@Component
public class PaymentFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
