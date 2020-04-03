package com.chinatower.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yunxl
 * @date 2020/3/31 15:44
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class,args);
    }
}
