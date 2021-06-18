import Vue from 'vue'

//Vuex :  개발하는 애플리케이션의 모든 컴포넌트에 대한 중앙 집중식 저장소 역활 및 관리
//        데이터를 store라는 파일을 통해 관리하고 프로젝트 전체에 걸쳐 활용할 수 있게 해 주는 방법
import Vuex from 'vuex'


//  java  서비스단 연동 참고
//     > https://amanokaze.github.io/blog/Vuejs-Setting-with-SB/


Vue.use(Vuex)

// 스낵바 설정
export const SET_SNACKBAR = 'SET_SNACKBAR'

export default new Vuex.Store({
	state: {
		sb: {
			show: false,
			msg: '',
			color: '',
		},
	},
	mutations: {
		[SET_SNACKBAR](state, sb) {
			state.sb = sb
		},
	},
	actions: {},
	modules: {},
})
