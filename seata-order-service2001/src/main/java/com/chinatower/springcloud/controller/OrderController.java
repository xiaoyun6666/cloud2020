package com.chinatower.springcloud.controller;

import com.chinatower.springcloud.domain.CommonResult;
import com.chinatower.springcloud.domain.Order;
import com.chinatower.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/10 14:15
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
