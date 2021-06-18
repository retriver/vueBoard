* Vue.js와 NativeScript로 앱개발을 하기위한 환경 세팅하는 방법
            https://uxgjs.tistory.com/185
            https://vuejs-kr.github.io/vue/nativescript/2017/08/11/introduce-vue-nativescript-01/

[Vuejs]
    https://amanokaze.github.io/blog/Vuejs-Setting-with-SB/
    https://uxgjs.tistory.com/112?category=770389
    https://uxgjs.tistory.com/149
    https://blog.buildit.kr/post/7
    https://ichi.pro/ko/2021-nyeon-react-vs-vue-eotteon-geos-eul-sayonghaeyahabnikka-243684195750587


[Quaser]
  > https://godffs.tistory.com/3306?category=712525  
  > https://hihellloitland.tistory.com/76
  > https://quasar.dev/




[ 필요한 모듈 ]
    vuex: Vue.js의 store 관리를 위한 모듈
    axios: HTTP 통신을 위한 모듈
    vee-validate: Form 검증을 위한 모듈
    bootstrap/bootstrap-vue: 웹사이트 제작 프레임워크

1. package.json 에 필요한 모듈들을 dependencies 추가합니다

          "dependencies": {
            "vue": "^2.6.11",
            "vue-router": "^3.1.6",
            "vuex": "^3.1.3",
            "axios": "^0.19.2",
            "bootstrap": "^4.4.1",
            "bootstrap-vue": "^2.11.0",
            "vee-validate": "^2.2.15"
          },


2.  npm install   * dependencies   에 추가된 모듈 인스톨 

3. 파일정보    * 
    App.vue: 프로젝트의 메인 템플릿 파일,가동 시 실행되는 첫 번째 파일로 볼 수 있음    * 실제로는 수정할 부분이 거의 없으며 
    main.js:  프로젝트의 메인 기능을 담당하는 파일로, 애플리케이션 내에서 사용할 모듈 및 컴포넌트를 지정하
            -----------------------------------------------------
            -----------------------------------------------------

