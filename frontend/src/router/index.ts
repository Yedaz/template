import { createRouter, createWebHistory } from 'vue-router'
import { useAdminStore } from '@/stores/admin';



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      name: 'Login',
      // route level code-splitting
      // this generates a separate chunk (Login.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/Login.vue'),
    },
    {
      path: '/index',
      name: 'index',
      redirect: '/welcome',
      // route level code-splitting
      // this generates a separate chunk (Index.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/index.vue'),
      children: [
        {
          path: '/welcome',
          name: 'welcome',
          component: () => import('../views/welcomeVue.vue'),
        },
        {
          path: '/admin',
          name: 'admin',
          component: () => import('../views/admin/List.vue'),
        },
      ]
    }
  ],
})

router.beforeEach(async (to, from) => {
  // 过滤登录页面
  if (to.path === '/login') {
    return true
  }
  // 检查是否有token
  const token = useAdminStore().getToken;
  if (!token) {
    // 没有token，重定向到登录页面
    return {path: '/login'};
  }
})

export default router
