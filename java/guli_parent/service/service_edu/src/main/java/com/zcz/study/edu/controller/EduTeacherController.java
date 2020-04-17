package com.zcz.study.edu.controller;


import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.zcz.study.edu.entity.EduTeacher;
import com.zcz.study.edu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/find/all")
    public List<EduTeacher> findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return list;
    }

    @DeleteMapping("{id}")
    public Boolean removeTeacher(@PathVariable String id){
        Boolean flg = eduTeacherService.removeById(id);
        return flg;
    }
}

