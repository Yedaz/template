<template>
    <div class="header">
        <div class="header-menu">
            <div class="header-logo">
                <div class="header-title">脚手架后台管理系统</div>
            </div>
            <div class="header-rinfo">
                当前用户：
                <span> {{ admin.name }} </span>
                <span class="header-exit">
                    <a @click="loginout()">退出</a>
                </span>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { useAdminStore } from '@/stores/admin';
import { adminApi } from '@/api/admin-api';
import { storeToRefs } from 'pinia'
const adminStore = useAdminStore();
const { admin } = storeToRefs(adminStore);

async function loginout() {
    try {
        await adminApi.loginout();
        window.location.href = '/login';
    } catch (error) {
        console.log(error);
    }
}
