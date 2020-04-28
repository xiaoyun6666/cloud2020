package com.chinatower.springcloud.service.impl;

import com.chinatower.springcloud.dao.StorageDao;
import com.chinatower.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/10 16:56
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decreaseStorage(Long productId, Integer count) {
        log.info("------->storage--service 扣减库存开始");
        storageDao.decreaseStorage(productId,count);
        log.info("------->storage--service 扣减库存结束");

    }
}
