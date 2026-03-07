package com.example.backend.controller;

import com.example.backend.exception.BussinessException;
import com.example.backend.response.R;
import com.example.backend.response.ResponseCode;
import com.example.backend.util.CaptchCache;
import com.example.backend.util.Captcha;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

@RestController
public class CommonController {
    @Resource
    private DefaultKaptcha defaultKaptcha;
    @Resource
    private CaptchCache captchCache;
    /**
     * 获取验证码
     * @return
     */
    @CrossOrigin
    @GetMapping("/common/getCaptcha")
    public R<Captcha> getCaptcha() {
        String captchaText = defaultKaptcha.createText();
        BufferedImage image = defaultKaptcha.createImage(captchaText);
        String base64Code = "";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
            base64Code = Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (IOException e) {
            throw new BussinessException(ResponseCode.USERNAME_EXIST);
        }
        Captcha captcha = new Captcha();
        captcha.setCaptchaImage("data:image/png;base64," + base64Code);
        String captchaid = UUID.randomUUID().toString().replace("-", "");
        captcha.setCaptchaId(captchaid);
        captchCache.storeCaptcha(captchaid, captchaText);
        return R.data(captcha);
    }

}
