package com.example.backend.controller;

import com.example.backend.entity.Admin;
import com.example.backend.sevice.impl.AdminServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;
    @PostMapping("/admin/add")
    public Long add(@RequestBody Admin admin){
        adminService.save(admin);
        return admin.getId();
    }
    @GetMapping("/admin/list")
    public List<Admin> list(){
        return adminService.list();
    }
    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return admin.getId();
    }
    @PostMapping("/admin/del")
    public String del(@RequestParam Long id){
        adminService.removeById(id);
        return "success";
    }
}
