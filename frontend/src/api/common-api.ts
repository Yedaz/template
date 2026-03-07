import { get, post } from '@/utils/request'

export const commonApi = {
    /**
     * 获取验证码
     * @param {*} params 
     * @returns 
     */
    getCaptcha: () => {
        return get('/common/getCaptcha', {})
    }
}