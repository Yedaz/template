import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/index',
      name: 'index',
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

export default router
