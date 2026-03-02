package com.example.backend.controller;

import com.example.backend.entity.Admin;
import com.example.backend.response.R;
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

    /**
     * 是否成功
     * 如果失败，需要知道错误显示
     * 如果成功，返回数据
     */
    @Operation(summary = "添加管理员信息")
    @PostMapping("/admin/add")
    public R add(@RequestBody Admin admin){
        adminService.save(admin);
        return R.success();
    }
    @Operation(summary = "查询所有管理员信息")
    @GetMapping("/admin/list")
    public R<List<Admin>> list(){
        return R.data(adminService.list());
    }
    @Operation(summary = "修改管理员信息")
    @PostMapping("/admin/update")
    public R update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return R.success();
    }
    @Operation(summary = "删除管理员信息")
    @PostMapping("/admin/del")
    public R del(@RequestParam Long id){
        adminService.removeById(id);
        return R.success();
    }
}
