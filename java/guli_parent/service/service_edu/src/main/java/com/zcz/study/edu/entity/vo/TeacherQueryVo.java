package com.zcz.study.edu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <h3>guli_parent</h3>
 *
 * <p></p>
 *
 * @Author zcz
 * @Date 2020-04-18 17:50
 */
@Data
public class TeacherQueryVo {

    @ApiModelProperty("讲师名称, 模糊查询")
    private String name;

    @ApiModelProperty("头衔 1 高级讲师  2 首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2020-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2020-01-01 10:10:10")
    private String end;

}
