package com.chinatower.springcloud.service;


/**
 * @author yunxl
 * @date 2020/4/2 14:15
 */
public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_TimeOut(Integer id);
    public String paymentCircuitBreaker(Integer id);
}
