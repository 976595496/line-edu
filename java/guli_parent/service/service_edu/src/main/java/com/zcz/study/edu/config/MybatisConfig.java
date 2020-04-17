package com.zcz.study.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Classname MybatisConfig
 * @Description
 * @Date 2020/4/17 15:08
 * @Author zcz
 */
@Configuration
@MapperScan("com.zcz.study.edu.mapper")
public class MybatisConfig {
    /**
     * @Author zcz
     * @Description 乐观锁
     * @Date 2020/4/16  15:57
     * @Return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * @Author zcz
     * @Description 分页
     * @Date 2020/4/16  15:58
     * @Return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * @Author zcz
     * @Description 逻辑删除
     * @Date 2020/4/16  15:58
     * @Return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * @Author zcz
     * @Description 性能监控
     * @Date 2020/4/16  15:58
     * @Return
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(100);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
