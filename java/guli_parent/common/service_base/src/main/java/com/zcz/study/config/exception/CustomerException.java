package com.zcz.study.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CustomerException
 * @Description
 * @Date 2020/4/20 13:39
 * @Author zcz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerException extends RuntimeException {
    private Integer code;
    private String msg;
}
