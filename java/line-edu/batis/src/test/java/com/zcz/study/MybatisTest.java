package com.zcz.study;

import com.zcz.study.batis.entiry.Users;
import com.zcz.study.batis.mapper.UsersMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Classname MybatisTest
 * @Description
 * @Date 2020/4/15 17:00
 * @Author zcz
 */
@SpringBootTest
public class MybatisTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void getUsers(){
        List<Users> users = usersMapper.selectList(null);
    }
}
