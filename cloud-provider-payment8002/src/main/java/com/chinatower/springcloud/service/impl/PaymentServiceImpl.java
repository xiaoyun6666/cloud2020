package com.chinatower.springcloud.service.impl;

import com.chinatower.springcloud.dao.PaymentDao;
import com.chinatower.springcloud.entities.Payment;
import com.chinatower.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/3/28 11:47
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
