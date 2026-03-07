import { defineStore } from 'pinia'
import { commonApi } from '@/api/common-api'
import { reactive, computed, ref } from 'vue'
import Constants from '@/utils/constants'
import { getLocalStorage, saveLocalStorage, clearLocalStorage } from '@/utils/utils'
// 你可以任意命名 “defineStore” 中的返回值，但最好用 store 作为名称，同时以 "use" 开头且以 "store" 结尾。
// （比如 useUserStore、useCartStore 等）
// 第一个参数是你应用中 Store 的唯一 ID。
export const useAdminStore = defineStore('admin', () => {
    // 其他配置..
    const token = ref('')
    const admin = reactive({
        id: '',
        username: '',
        name: '',
        tel: ''
    })
    const getToken = computed(() => {
        if(token) {
            return token
        }
        return getLocalStorage(Constants.USER_TOKEN)
    })
    function setAdminInfo(data:any){
        admin.id = data.id
        admin.username = data.username
        admin.name = data.name
        admin.tel = data.tel
        token.value = data.token
        saveLocalStorage(Constants.USER_TOKEN, data.token)
    }
    function loginout(){
        admin.id = ""
        admin.username = ""
        admin.name = ""
        admin.tel = ""
        token.value = ""
        clearLocalStorage();
    }

    return { token, setAdminInfo, loginout}

})