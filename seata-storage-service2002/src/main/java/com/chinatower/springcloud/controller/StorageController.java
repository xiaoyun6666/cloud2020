package com.chinatower.springcloud.controller;

import com.chinatower.springcloud.domain.CommonResult;
import com.chinatower.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/10 17:01
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decreaseStorage(Long productId, Integer count){
        storageService.decreaseStorage(productId,count);
        return new CommonResult(200,"扣减库存成功");
    }
}
