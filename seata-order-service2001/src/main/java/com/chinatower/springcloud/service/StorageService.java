package com.chinatower.springcloud.service;

import com.chinatower.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yunxl
 * @date 2020/4/10 13:43
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decreaseStorage(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
