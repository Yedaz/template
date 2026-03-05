package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.backend.entity.Admin;
import com.example.backend.exception.BussinessException;
import com.example.backend.response.R;
import com.example.backend.response.ResponseCode;
import com.example.backend.sevice.impl.AdminServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @CrossOrigin
    public R add(@RequestBody Admin admin){
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Admin::getUsername,admin.getUsername());
       if (adminService.count(lambdaQueryWrapper) > 0){
            throw new BussinessException(ResponseCode.USERNAME_EXIST);
        }
        adminService.save(admin);
        return R.success();
    }
    @Operation(summary = "查询所有管理员信息")
    @PostMapping("/admin/list")
    @CrossOrigin
    public R<PageInfo<Admin>> list(@RequestBody Admin admin, @RequestParam Integer pageNum, @RequestParam Integer pageSize){
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(admin.getName() != null, Admin::getName,admin.getName());
        lambdaQueryWrapper.like(admin.getTel() != null, Admin::getTel,admin.getTel());
        lambdaQueryWrapper.orderByDesc(Admin::getId);
        PageHelper.startPage(pageNum,pageSize);
        List<Admin> list = adminService.list(lambdaQueryWrapper);
        PageInfo<Admin> pageInfo = new PageInfo(list);
        return R.data(pageInfo);
    }
    @Operation(summary = "修改管理员信息")
    @PostMapping("/admin/update")
    @CrossOrigin
    public R update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return R.success();
    }
    @Operation(summary = "删除管理员信息")
    @PostMapping("/admin/del")
    @CrossOrigin
    public R del(@RequestParam List<Long> ids){
        adminService.removeByIds(ids);
        return R.success();
    }
}
