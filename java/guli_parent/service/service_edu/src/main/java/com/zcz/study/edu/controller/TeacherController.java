package com.zcz.study.edu.controller;


import com.zcz.study.edu.entity.Teacher;
import com.zcz.study.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/find/all")
    public List<Teacher> findAll(){
        List<Teacher> list = teacherService.list(null);
        return list;
    }
}

