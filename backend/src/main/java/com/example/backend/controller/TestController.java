package com.example.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：me
 * @date ：Created in 2026/3/1
 */
@RestController
public class TestController {
    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return "hello1 " + name;
    }
}
