/**
 * 封装 ajax 请求
 * @author ye
 * @Date 2026-03-04
 */
import axios, { type AxiosRequestConfig } from 'axios';
import { saveLocalStorage, getLocalStorage, clearLocalStorage } from './utils';
import Constants from './constants';
import { ElMessage, ElMessageBox } from 'element-plus';

//token的名称   需要和服务端配置一致
const TOKEN_NAME = 'template_token';

// 创建 axios 对象
const request = axios.create({
    baseURL: import.meta.env.VITE_API_URL, // 基础 URL
    timeout: 5000, // 请求超时时间
});

// 退出系统
function logout() {
    clearLocalStorage();
    location.href = '/';
}

// =========================请求拦截器=========================

request.interceptors.request.use(
    (config) => {
        // 在请求头中添加 token
        const token = getLocalStorage(Constants.USER_TOKEN);
        if (token) {
            config.headers[TOKEN_NAME] = token;
        } else {
            delete config.headers[TOKEN_NAME];
        }
        return config;
    },
    (error: any) => {
        return Promise.reject(error);
    }
);

// =========================响应拦截器=========================

// 添加响应拦截器
request.interceptors.response.use(
    (response) => {
        // 根据content-type判断响应类型,判断是否为json数据
        let contentType = response.headers['content-type']?response.headers['content-type'] : response.headers['Content-Type'];
        if (contentType.indexOf('application/json') === -1) {
            return Promise.resolve(response);
        }
        // 如果返回的数据类型是 Blob
        if(response.data && response.data instanceof Blob) {
            return Promise.reject(response);
        }

        const res = response.data;
        if (res.code && res.code !== 200) {
            // 'token' 过期或者账号在别处登录
            if (res.code === 11012 || res.code === 11011) {
                ElMessage.closeAll();
                ElMessage.error('登录状态已过期，请重新登录');
                setTimeout(logout, 300);
                return Promise.reject(res);
            }
            // 长时间未操作系统，需要重新登录
            if (res.code === 30001) {
                ElMessageBox.confirm('长时间未操作系统，是否重新登录？', '提示', {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning',
                }).then(() => {
                    logout();
                });
                setTimeout(logout, 3000);
                return Promise.reject(res);
            }
            ElMessage.closeAll();
            if(res.message) {
                ElMessage.error(res.message);
            }
            return Promise.reject(res);
        }else {
            return Promise.resolve(res);
        }
    },
    (error: any) => {
        // 对响应错误做点什么
        if (error.message.indexOf('timeout') !== -1) {
            ElMessage.closeAll();
            ElMessage.error('请求超时，请稍后重试');
        } else if (error.message == 'Network Error') {
            ElMessage.closeAll();
            ElMessage.error('网络异常，请稍后重试');
        } else if (error.message.indexOf('Request') !== -1) {
            ElMessage.closeAll();
            ElMessage.error('请求失败，请稍后重试');
        }
        return Promise.reject(error);
    }
);

// ========================= 通用请求，get, post ==========================

/**
 * 通用请求封装
 * @param config
 */
export const http = (config: AxiosRequestConfig<any>) => {
    return request.request(config);
};
/**
 * get 请求封装
 * @param url 请求地址
 * @param params 请求参数
*/
export const get = (url: string, params?: any) => {
    return http({ url, method: 'get', params });
};

/**
 * post 请求封装
 * @param url 请求地址
 * @param data 请求参数
*/
export const post = (url: string, data: {}) => {
    return http({ data, url, method: 'post', });
};






