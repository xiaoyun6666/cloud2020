package com.chinatower.springcloud.service;

import com.chinatower.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunxl
 * @date 2020/4/10 13:42
 */
public interface OrderService {
    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
