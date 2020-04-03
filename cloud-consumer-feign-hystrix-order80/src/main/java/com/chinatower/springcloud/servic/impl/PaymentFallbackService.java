package com.chinatower.springcloud.servic.impl;

import com.chinatower.springcloud.servic.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author yunxl
 * @date 2020/4/2 21:10
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService----paymentInfo_OK---/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService----paymentInfo_TimeOut---/(ㄒoㄒ)/~~";
    }
}
