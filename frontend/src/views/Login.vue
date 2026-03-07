<template>
  <div class="login-container"> 
    <div class="login-container-content">
      <div class="login-container-content-bg">
        <div class="login-container-content-top">
          <div style="text-align: center; padding-bottom: 25px;">
            <img class="login-logo" src="@/assets/images/login/logo.jpg" alt="logo">
            <span class="login-title">后台管理系统</span>
          </div>
        </div>
        <div class="login-container-content-main">
          <el-form 
            :model="form" 
            :rules="rules" 
            ref="formRef" 
            size="large"
          >
            <el-form-item prop="username" class="form-item">
              <el-input 
                v-model="form.username"
                :prefix-icon="User" 
                style="width: 368px; height: 40px; font-size: 16px;" 
                placeholder="请输入用户名"
              ></el-input>
            </el-form-item>

            <el-form-item prop="userpwd" class="form-item">
              <el-input 
                v-model="form.userpwd"
                :prefix-icon="Lock" 
                style="width: 368px; height: 40px; font-size: 16px;" 
                placeholder="请输入密码" 
                type="password" 
                show-password
              ></el-input>
            </el-form-item>

            <el-form-item prop="captchaCode" class="form-item">
              <div style="display: flex; align-items: center; gap: 10px;">
                <el-input 
                  v-model="form.captchaCode"
                  style="width: 268px; height: 40px; font-size: 16px;" 
                  placeholder="验证码"
                />
                <img :src="captchaImage" @click="getCaptcha" style="width: 90px; height: 40px; cursor: pointer; object-fit: cover;"/>
                
              </div>
            </el-form-item>

            <el-form-item class="form-item">
              <el-button 
                style="width: 368px; height: 40px; font-size: 16px;" 
                type="primary"
                :loading="btnLoading" 
                @click="onSubmit"
              >
                登 录
              </el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref, onMounted } from "vue";
import { User, Lock } from '@element-plus/icons-vue';
import { adminApi } from "@/api/admin-api";
import { ElMessage, ElForm } from "element-plus";
import { commonApi } from "@/api/common-api";
import router from "@/router";
import { useAdminStore } from "@/stores/admin";

// 1. 表单引用（修复：定义formRef）
const formRef = ref();

// 2. 加载状态（修复：定义btnLoading）
const btnLoading = ref(false);

// 3. 表单数据（修复：定义form并绑定字段）
const form = reactive({
  username: undefined, // 用户名
  userpwd: undefined,  // 密码
  captchaId: undefined,
  captchaCode: undefined // 验证码
});
const captchaImage = ref('')
async function getCaptcha() {
    try{
        let captchaResult = await commonApi.getCaptcha();
         console.log('验证码返回数据:', captchaResult); 
        captchaImage.value = captchaResult.data.captchaImage
        form.captchaId = captchaResult.data.captchaId
    } catch(e){
        console.error('获取验证码失败:', e);
    }
    
}
onMounted(getCaptcha)
// 4. 表单校验规则（修复：定义rules）
const rules = reactive({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
  ],
  userpwd: [
    { required: true, message: '请输入密码', trigger: 'blur' },
  ],
  captchaCode: [
    { required: true, message: '请输入验证码', trigger: 'blur' },
  ]
});

// 6. 登录提交方法（修复：实现核心逻辑）
function onSubmit() {
  formRef.value.validate().then(async () =>{
    try {
        btnLoading.value = true;
        let result = await adminApi.login(form);
        useAdminStore().setAdminInfo(result.data);
        router.push('/index');
    } catch (e: any) {
        getCaptcha();
    } finally {
        btnLoading.value = false;
    }
  })
};
</script>

<style lang = "less">
@import '../styles/login.less';
</style>