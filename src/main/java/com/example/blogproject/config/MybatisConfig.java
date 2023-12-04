package com.example.blogproject.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.blogproject.mapper")
public class MybatisConfig {
    
}
