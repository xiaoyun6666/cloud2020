package com.chinatower.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunxl
 * @date 2020/4/10 16:46
 */
@Mapper
public interface StorageDao {
    //扣减库存
    void decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
