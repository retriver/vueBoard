import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// import Home from '@/components/Home'

Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		name: 'Main',
		redirect: '/home',
	},
	{
		path: '*',
		name: '404',
		component: () => import('@/views/error/404.vue'),
	},
	{
		path: '/home',
		name: 'Home',
		component: Home,
	},
	{
		path: '/list',
		name: 'BoardList',
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () =>
			import(/* webpackChunkName: "about" */ '../views/board/ListView.vue'),
	},
	{
		path: '/write',
		name: 'BoardWrite',
		component: () => import('../views/board/WriteView.vue'),
	},
	{
		path: '/detail',
		name: 'BoardDetail',
		component: () => import('../views/board/DetailView.vue'),
	},
	{
		path: '/edit',
		name: 'BoardEdit',
		component: () => import('../views/board/EditView.vue'),
	},
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes,
	/*
	  , routes :[
					{
						path: '/',
						name: 'Main',
						redirect: '/home',
					},
					{
						path: '*',
						name: '404',
						component: () => import('@/views/error/404.vue'),
					}
				 ]
    */
})

//beforeEach  :  웹페이지를 열기 전에 수행하는 동작
router.beforeEach((to, from, next) => {

	console.log('%cThis is a text with a background color 000', 'background: #27e887; color: #ffffff')
	console.log('%cto.name : ' + to.name, 'background: #000000; color: #ffffff')
	console.log('%cto.path : ' + to.path, 'background: #000000; color: #ffffff')
	console.log('%cfrom.name : ' + from.name, 'background: #ffffff; color: #ff0000')
	console.log('%cnext : ' + next, 'background: #ffffff; color: #0000ff')

	  /*
	  const publicPages = ['Login','Register'];  // publicPages  로그인 여부를 확인하지 않는 페이지
	  const authRequired = !publicPages.includes(to.name);  // 인증 요구하지 않음.
	  const loggedIn = localStorage.getItem('user');

 	  //로그인 여부 확인이 필요하고(authRequired), 로그인이 되어 있지 않으면(!loggedIn)
	  if (authRequired && !loggedIn)
	  {
	    // 로그인 페이지로 강제 이동
	    router.push({ name: 'Login', query: { to: to.path }});
	  }
	  else
	  {
	    next();
	  }
	  */

	// beforeEach 이후 페이지이동
	next();
})

export default router
