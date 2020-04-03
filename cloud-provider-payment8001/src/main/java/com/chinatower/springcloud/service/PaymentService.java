package com.chinatower.springcloud.service;

import com.chinatower.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunxl
 * @date 2020/3/28 11:46
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
