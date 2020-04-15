package com.zcz.study.batis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname BatisApplication
 * @Description
 * @Date 2020/4/15 14:28
 * @Author zcz
 */
@SpringBootApplication
@MapperScan("com.zcz.study.batis.mapper")
public class BatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatisApplication.class, args);
    }
}
