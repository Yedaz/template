package com.example.backend.controller;

import com.example.backend.entity.Admin;
import com.example.backend.sevice.impl.AdminServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "管理员信息管理")
@RestController
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;
    @Operation(summary = "添加管理员信息")
    @PostMapping("/admin/add")
    public Long add(@RequestBody Admin admin){
        adminService.save(admin);
        return admin.getId();
    }
    @Operation(summary = "查询所有管理员信息")
    @GetMapping("/admin/list")
    public List<Admin> list(){
        return adminService.list();
    }
    @Operation(summary = "修改管理员信息")
    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return admin.getId();
    }
    @Operation(summary = "删除管理员信息")
    @PostMapping("/admin/del")
    public String del(@RequestParam Long id){
        adminService.removeById(id);
        return "success";
    }
}
