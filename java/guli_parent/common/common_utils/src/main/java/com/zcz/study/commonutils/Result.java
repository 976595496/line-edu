package com.zcz.study.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>guli_parent</h3>
 *
 * <p>统一返回结果</p>
 *
 * @Author zcz
 * @Date 2020-04-18 16:18
 */

@Data
public class Result<T> {

    @ApiModelProperty("是否成功")
    private Boolean Success;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回消息")
    private String message;

    @ApiModelProperty("返回数据")
    private Map<String, T> data = new HashMap<String, T>();


    private Result() { }

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUSSECC);
        result.setMessage("成功");
        return result;
    }


    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage("失败");
        return result;
    }

    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, T value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, T> map){
        this.setData(map);
        return this;
    }
}
