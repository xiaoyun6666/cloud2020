package com.chinatower.springcloud.service;

import com.chinatower.springcloud.dao.OrderDao;
import com.chinatower.springcloud.domain.Order;
import com.chinatower.springcloud.service.AccountService;
import com.chinatower.springcloud.service.OrderService;
import com.chinatower.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/10 13:46
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        //1.新建订单
        orderDao.create(order);
        log.info("------>订单微服务开始调用库存，做扣减count");
        //2.扣减库存
        storageService.decreaseStorage(order.getProductId(),order.getCount());
        log.info("------>订单微服务开始调用库存，做扣减count结束");
        log.info("------>订单微服务开始调用账户，做扣减money");
        //3.扣减账户
        accountService.decreaseAccount(order.getUserId(),order.getMoney());
        log.info("------>订单微服务开始调用账户，做扣减money结束");

        //4.修改订单状态
        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("------>修改订单状态结束");
        log.info("------>下订单结束了,(*^_^*)");
    }

    @Override
    public void update(Long userId, Integer status) {

    }
}
