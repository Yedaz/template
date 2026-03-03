import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {
      path: '/',
      name: 'welcome',
      // route level code-splitting
      // this generates a separate chunk (Welcome.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/welcomeVue.vue'),
    },
  ],
})

export default router
