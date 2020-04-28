package com.chinatower.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author yunxl
 * @date 2020/4/10 17:12
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减账户余额
     */
    void decreaseAccount(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
