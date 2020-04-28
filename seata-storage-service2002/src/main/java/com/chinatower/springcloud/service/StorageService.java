package com.chinatower.springcloud.service;


/**
 * @author yunxl
 * @date 2020/4/10 16:56
 */
public interface StorageService {
    //扣减库存
    void decreaseStorage(Long productId, Integer count);
}
