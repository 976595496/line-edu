package com.zcz.study.config.exceptionhandler;

import com.zcz.study.commonutils.Result;
import com.zcz.study.config.exception.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public Result error(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error().message("执行了全局异常处理..");
    }

    //指定出现什么异常执行这个方法
    @ExceptionHandler(CustomerException.class)
    @ResponseBody //为了返回数据
    public Result customerError(CustomerException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.error()
                .code(e.getCode())
                .message(e.getMsg());
    }
}
