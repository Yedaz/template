package com.example.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器错误"),
    USER_NOT_EXIST(400, "用户不存在"),
    USER_EXIST(400, "用户已存在"),
    USER_NOT_LOGIN(400, "用户未登录"),
    USER_NOT_ADMIN(400, "用户不是管理员"),
    USER_NOT_AUTHORIZED(400, "用户无权限"),
    USER_NOT_PERMITTED(400, "用户无权限"),
    USER_NOT_FOUND(400, "用户未找到");
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;
}
