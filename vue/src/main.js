import Vue from 'vue'
//  App.vue import
import App from './App.vue'
// 애플리케이션 내 모든 웹페이지 경로 매핑 및 전체 페이지에서 실행할 코드
import router from '@/router/index'
// 애플리케이션 내에서 사용할 함수, 변수 등을 지정하고 관리
import store from '@/store/index'
import vuetify from '@/plugins/vuetify'
// Vuetify-dialog
import VuetifyDialog from 'vuetify-dialog'
import 'vuetify-dialog/dist/vuetify-dialog.css'
// 사용자 정의 페이지 관련 함수
import page from '@/plugins/page'
// 사용자 정의 다이얼로그 관련 함수
import dialog from '@/plugins/dialog'
// 버튼 전역 컴포넌트
import Button from '@/components/common/Button'

Vue.config.productionTip = false
// 사용자 정의 페이지 함수 사용 설정
Vue.use(page)
// 사용자 정의 다이얼로그 함수 사용 설정
Vue.use(dialog)
// Vuetify-dialog 사용 설정
Vue.use(VuetifyDialog, {
	context: {
		vuetify,
	},
})
// 버튼 전역 컴포넌트 선언
Vue.component('Button', Button)

new Vue({
	router,
	store,
	vuetify,
	render: h => h(App),
}).$mount('#app')
