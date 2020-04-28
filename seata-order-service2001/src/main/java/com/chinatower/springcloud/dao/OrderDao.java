package com.chinatower.springcloud.dao;

import com.chinatower.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunxl
 * @date 2020/4/10 13:22
 */
@Mapper
public interface OrderDao {
    //1.新建订单
    void create(Order order);

    //2.修改订单状态，从0改为1
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
