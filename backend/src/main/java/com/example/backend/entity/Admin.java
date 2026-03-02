package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String userpwd;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机
     */
    private String tel;
    /**
     * 头像
     */
    private String headurl;
}
