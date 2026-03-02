package com.example.backend.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpringBoot4+Vue3脚手架项目")
                        .version("1.0.0")
                        .description("SpringBoot4+Vue3脚手架接口文档")
                        .contact(new Contact().name("脚手架").url("www.template.com")));
    }
}
