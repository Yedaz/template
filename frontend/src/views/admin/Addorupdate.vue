<template>
  <el-dialog
    v-model="Visible"
    title="新增"
    width="30%"
  >
    <el-form :rules="rules" :model="form" ref="formRef" label-width="100px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="form.username" style="width: 50%"/>
    </el-form-item>
    <el-form-item label="密码" prop="userpwd">
      <el-input v-model="form.userpwd" style="width: 50%"/>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input v-model="form.name" style="width: 50%"/>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-select v-model="form.sex" style="width: 50%" placeholder="请选择性别">
        <el-option label="男" value="男" />
        <el-option label="女" value="女" />
      </el-select>
    </el-form-item>
    <el-form-item label="手机号" prop="tel">
      <el-input v-model="form.tel" style="width: 50%"/>
    </el-form-item>
    <el-form-item label="头像" prop="headurl">
      <el-input v-model="form.headurl" style="width: 50%"/>
    </el-form-item>
    </el-form>

    <template #footer>
      <div class="dialog-footer">
        <el-button @click="Visible = false">取消</el-button>
        <el-button type="primary" @click="onSubmit()">
          确定
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive, ref } from "vue";
import { adminApi } from "@/api/admin-api";

//对话框显示状态
const Visible = ref(false);
const btnLoading = ref(false);
const emit = defineEmits(['refresh'])

function showModel() {
  Visible.value = true;
}
// 公开父组件可以调用的方法
defineExpose({showModel})
// 表单组件
const formRef = ref();
const formDefault = {
    id:undefined,
    username:undefined,
    userpwd:undefined,
    name:undefined,
    sex:undefined,
    tel:undefined,
    headurl:undefined
}
let form = reactive({...formDefault});

function onSubmit() {
    btnLoading.value = true;
    formRef.value.validate().then(async () =>{
        adminApi.add(form).then(() =>{
            btnLoading.value = false;
            Visible.value = false;
            emit('refresh')
        })
    })
}

const rules = reactive({
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'blur',
    },
  ],
  userpwd: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'blur',
    },
  ],
  name: [
    {
      required: true,
      message: '请输入姓名',
      trigger: 'blur',
    },
  ],
  sex: [
    {
      required: true,
      message: '请选择性别',
      trigger: 'change',
    },
  ],
  tel: [
    {
      required: true,
      message: '请输入手机号',
      trigger: 'blur',
    },
  ],
  headurl: [
    {
      required: true,
      message: '请输入头像',
      trigger: 'blur',
    },
  ],
})

</script>