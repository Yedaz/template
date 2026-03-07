package com.example.backend.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class CaptchCache {
    // 验证码缓存
    private static ConcurrentHashMap<String, String> captchaMap = new ConcurrentHashMap<>();
    // 存储验证码
    public static void storeCaptcha(String captchaId, String captcha) {
        captchaMap.put(captchaId, captcha);
    }
    // 删除验证码
    public void removeCaptcha(String captchaId) {
        captchaMap.remove(captchaId);
    }
    public boolean validateCaptcha(String captchaId, String captcha) {
        // 获取存储验证码
        String cacheCaptcha = captchaMap.get(captchaId);
        if (cacheCaptcha == null) {
            return false;
        }
        if (!cacheCaptcha.equals(captcha)) {
            return false;
        }
        // 验证码验证成功后，删除验证码
        removeCaptcha(captchaId);
        return true;
    }
}
