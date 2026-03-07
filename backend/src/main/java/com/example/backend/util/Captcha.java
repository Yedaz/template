package com.example.backend.util;

import lombok.Data;

@Data
public class Captcha {
    /**
     * 验证码id
     */
    private String captchaId;
    /**
     * 验证码图片
     */
    private String captchaImage;
}
