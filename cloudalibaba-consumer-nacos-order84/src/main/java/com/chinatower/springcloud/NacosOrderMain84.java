package com.chinatower.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yunxl
 * @date 2020/4/9 17:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class,args);
    }
}
