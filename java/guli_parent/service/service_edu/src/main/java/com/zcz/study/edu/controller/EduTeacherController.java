package com.zcz.study.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcz.study.commonutils.Result;
import com.zcz.study.edu.entity.EduTeacher;
import com.zcz.study.edu.entity.vo.TeacherQueryVo;
import com.zcz.study.edu.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zcz
 * @since 2020-04-17
 */
@RestController
@RequestMapping("/edu/edu-teacher")
public class EduTeacherController {


    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation("所有讲师列表")
    @GetMapping("/find/all")
    public List<EduTeacher> findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    @ApiOperation("根据 id 逻辑删除讲师")
    @DeleteMapping("{id}")
    public Boolean removeTeacher(@ApiParam(name = "id", value = "讲师 id", required = true) @PathVariable String id){
        Boolean flg = eduTeacherService.removeById(id);
        return flg;
    }


    @ApiOperation("分页查询讲师列表")
    @GetMapping("/page/{current}/{limit}")
    public Result<List<EduTeacher>> findByPage(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable("current") Integer current,
                                               @ApiParam(name = "limit", value = "分页数", required = true) @PathVariable("limit") Integer limit){
        Page<EduTeacher> page = new Page<>(current, limit);
        IPage<EduTeacher> eduTeacherIPage = eduTeacherService.page(page, null);
        return Result.ok()
                .data("total", eduTeacherIPage.getTotal())
                .data("row", eduTeacherIPage.getRecords());
    }

    //4 条件查询带分页的方法
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public Result<List<EduTeacher>> pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                  @RequestBody(required = false) TeacherQueryVo teacherQuery) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);

        //构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }

        //调用方法实现条件查询分页
        eduTeacherService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); //数据list集合
        return Result.ok().data("total",total).data("rows",records);
    }

    //添加讲师接口的方法
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if(save) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return Result.ok().data("teacher",eduTeacher);
    }

    //讲师修改功能
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}

