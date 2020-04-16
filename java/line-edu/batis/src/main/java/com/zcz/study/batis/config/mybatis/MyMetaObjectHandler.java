package com.zcz.study.batis.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @Classname MyMetaObjectHandler
 * @Description
 * @Date 2020/4/16 15:22
 * @Author zcz
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("version", 1, metaObject);
    }

    public void updateFill(MetaObject metaObject) {

    }
}
