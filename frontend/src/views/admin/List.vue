<template>
    <div class="list-container">
        <el-form :inline="true" class="list-form">
            <el-form-item label="姓名">
                <el-input v-model="queryForm.name" placeholder="请输入姓名"></el-input>
            </el-form-item>
            <el-form-item label="电话">
                <el-input v-model="queryForm.tel" placeholder="请输入电话号码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button @click="onSearch()" type="primary">查询</el-button>
                <el-button type="success" @click="add()">新增</el-button>
                <el-button type="danger">批量删除</el-button>
                <el-button type="info">重置</el-button>
            </el-form-item>
        </el-form>
        <el-divider border-style="dashed" />
        <el-table border :data="datalist" v-loading="listLoading" style="width: 100%" :header-cell-style="{ background: '#f5f5f5', color: '#000', fontWeight: 'bold' }">
            <el-table-column type="selection" width="55" />
            <el-table-column header-align="center" align="center" prop="username" label="用户名" />
            <el-table-column header-align="center" align="center" prop="name" label="姓名" />
            <el-table-column header-align="center" align="center" prop="sex" label="性别" />
            <el-table-column header-align="center" align="center" prop="tel" label="电话" />
            <el-table-column header-align="center" align="center" prop="headurl" label="头像" />
            <el-table-column header-align="center" align="center" label="操作" width="160">
                <template #default="scope">
                    <el-button type="text" size="small">编辑</el-button>
                    <el-button type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination @current-change="handleCurrentPageChange" background layout="prev, pager, next" :total="total" style="float: right;margin: 10px 20px 20px 0px;" />
        <Addorupdate @refresh="getList" ref="addorupdateRef" />
    </div>
</template>
<script setup lang="ts">
import { onMounted, ref, reactive } from 'vue';
import { adminApi } from '@/api/admin-api';
import Constants from '@/utils/constants';
import Addorupdate from './Addorupdate.vue';

//列表数据
const datalist = ref([]);
//列表加载状态
const listLoading = ref(false);
//数据总条数
const total = ref(0);
//定义应用新增或修改组件的响应式变量
const addorupdateRef = ref();
//表单的初始值
const qeryFormState = {
    name: '',
    tel: '',
    pageNum: 1,
    pageSize: Constants.PAGE_SIZE
};
//表单查询条件对象
const queryForm = reactive({...qeryFormState});
async function getList() {
    try {
        listLoading.value = true;
        let responseModel = await adminApi.queryPageList(queryForm, queryForm.pageNum, queryForm.pageSize);
        datalist.value = responseModel.data.list;
        total.value = responseModel.data.total;
    } catch (error) {
        console.log(error);
    } finally {
        listLoading.value = false;
    }
}
// 查询方法
function  onSearch() {
    queryForm.pageNum = 1;
    getList();
}

//分页查询方法
function handleCurrentPageChange(val: number) {
    queryForm.pageNum = val;
    getList();
}

/**
 * 新增管理员
 */
function add() {
    addorupdateRef.value.showModel();
}

onMounted(getList);
</script>