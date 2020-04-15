package com.zcz.study.batis.controller;

import com.zcz.study.batis.entiry.Users;
import com.zcz.study.batis.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description
 * @Date 2020/4/15 17:12
 * @Author zcz
 */
@RestController
public class UserController {
    @Autowired
    private UsersMapper usersMapper;
    @GetMapping("/users")
    public List<Users> getUsers(){
        return usersMapper.selectList(null);
    }

    @GetMapping("/add")
    public int addUsers(){
        Users users = new Users();
        users.setUsername("kkk");
        users.setFaceImage("http://");
        users.setFaceImageBig("http://");
        users.setPassword("qweewq");
        users.setQrcode("rrrrrrr");
        users.setNickName("nick");
        users.setCid("shshshsh");
        return usersMapper.insert(users);
    }
}
