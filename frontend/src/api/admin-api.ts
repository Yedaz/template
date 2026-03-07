import { get, post } from '@/utils/request';

export const adminApi = {
    /**
     * 添加管理员
     * @param param 
     * @returns 
     */
    add: (param : any) => {
        return post('/admin/add', param);
    },
    /**
     * 修改管理员
     * @param param 
     * @returns 
     */
    update: (param : any) => {
        return post('/admin/update', param);
    },
    /**
     * 删除管理员
     * @param ids 管理员id列表
     * @returns 
     */
    delete: (ids : any) => {
        return post('/admin/del?ids=' + ids, {});
        // return post('/admin/del', { ids });
    },
    /**
     * 
     * 获取管理员列表
     * @param param 
     * @returns 
     */
    queryPageList: (param : any, pageNum: any, pageSize: any) => {
        return post('/admin/list?pageNum=' + pageNum + '&pageSize=' + pageSize, param)
    },
    /**
     * 检验用户名是否存在
     * @param username 用户名
     * @returns 
     */
    checkUsername: (param : any) => {
        return get('/admin/checkUsername' + param);
    },
    /**
     * 登录
     * @param param 
     * @returns 
     */
    login: (param : any) => {
        return post('/admin/login', param);
    },
}