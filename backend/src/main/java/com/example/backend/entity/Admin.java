package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("admin")
@Schema(description = "管理员信息实体")
public class Admin {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Long id;
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    private String username;
    /**
     * 密码
     */
    @Schema(description = "密码")
    private String userpwd;
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String name;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private String sex;
    /**
     * 手机
     */
    @Schema(description = "手机")
    private String tel;
    /**
     * 头像
     */
    @Schema(description = "头像")
    private String headurl;
}
