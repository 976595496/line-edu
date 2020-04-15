package com.zcz.study.batis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcz.study.batis.entiry.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Classname UsersMapper
 * @Description
 * @Date 2020/4/15 17:01
 * @Author zcz
 */
@Component
public interface UsersMapper extends BaseMapper<Users> {
}
