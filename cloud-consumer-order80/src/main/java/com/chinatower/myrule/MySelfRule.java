package com.chinatower.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡路由规则类
 * @author yunxl
 * @date 2020/4/1 10:10
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RoundRobinRule();
    }
}

