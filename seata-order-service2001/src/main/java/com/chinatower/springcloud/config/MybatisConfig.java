package com.chinatower.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunxl
 * @date 2020/4/10 14:28
 */
@Configuration
@MapperScan("com.chinatower.springcloud.dao")
public class MybatisConfig {
}
