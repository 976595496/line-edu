package com.zcz.study.batis.entiry;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @Classname Users
 * @Description
 * @Date 2020/4/15 16:57
 * @Author zcz
 */
@Data
public class Users {
    @TableId(type = IdType.UUID)
    private String id;
    private String username;
    private String password;
    private String faceImage;
    private String faceImageBig;
    private String nickName;
    private String qrcode;
    private String cid;
    @TableLogic
    private Short deleted;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
