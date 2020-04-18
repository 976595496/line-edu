package com.zcz.study.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Classname EduApplication
 * @Description
 * @Date 2020/4/17 15:06
 * @Author zcz
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.zcz.study")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
