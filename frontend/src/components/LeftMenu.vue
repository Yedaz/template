<template>
    <div class="pdm-sidebar__inner">
        <el-menu :collapseTransition="false" class="pdm-sidebar__menu" background-color="#22272e" text-color="#8a979e" active-text-color="#fff" router>
            <el-menu-item index="welcome" @click="$router.push({path:'/welcome'})">
                <el-icon>
                    <document />
                </el-icon>
                <span slot="title">首页</span>
            </el-menu-item>
            <el-sub-menu index="组织管理" :popper-class="'pdm-sidebar--dark-popper'">
                <template #title>
                    <el-icon>
                    <document />
                    </el-icon>
                    <span slot="title">管理员信息管理</span>
                </template>
                <el-menu-item index="admin" @click="$router.push({path:'/admin'})">
                    <el-icon>
                    <document />
                    </el-icon>
                    <span slot="title">管理员信息管理</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="组织管理2" :popper-class="'pdm-sidebar--dark-popper'">
                <template #title>
                    <el-icon>
                    <document />
                    </el-icon>
                    <span slot="title">组织管理</span>
                </template>
                <el-menu-item index="MisDept" @click="$router.push({name:'MisDept'})">
                    <el-icon>
                    <document />
                    </el-icon>
                    <span slot="title">部门信息管理</span>
                </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="组织管理3" :popper-class="'pdm-sidebar--dark-popper'">
                <template #title>
                    <el-icon>
                    <Clock />
                    </el-icon>
                    <span slot="title">组织管理</span>
                </template>
                <el-menu-item index="MisDept" @click="$router.push({name:'MisDept'})">
                    <el-icon>
                    <Clock />
                    </el-icon>
                    <span slot="title">部门信息管理</span>
                </el-menu-item>
            </el-sub-menu>
        </el-menu>
    </div>
</template>

<script setup lang="ts">
import {
    Document,
    Menu as IconMenu,
    Location,
    Clock,
    Setting,
}from '@element-plus/icons-vue'
const handleOpen = (key: String, keyPath:String[]) => {
    console.log(key, keyPath);
}
const handleClose = (key: String, keyPath:String[]) => {
    console.log(key, keyPath);
}
</script>