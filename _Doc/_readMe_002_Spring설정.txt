********************************************************************************************************************************
   VUE 레퍼런스
     : https://kr.vuejs.org/v2/guide/index.html

   Vue.js 모듈
     : https://github.com/vuejs/awesome-vue

     크롬 디버깅 툴
     : https://chrome.google.com/webstore/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd?utm_source=chrome-ntp-icon
********************************************************************************************************************************


1. build.gradle 수정
     build.gradle.ver001 참고.

   vue / spring boot 접속 확인   '_[]_서버실행.txt' 참고
    > vue : http://localhost:9091/
    > boot : http://localhost:9090/
       ** 정상접속 확인.


2. 샘플을 vue 폴더에 복사함.
       ㄱ. https://github.com/jinseogood/vue-springboot-board 에서 다운로드.
       ㄴ. vue-springboot-board-master\board-app 파일들을 vue 폴더에 복사
       ㄷ. vue.config.js 수정
        -------------
          //  여기부터 Edward 추가
          ,  outputDir: "../src/main/resources/static"
          , indexPath: "../static/index.html"
          , devServer: {
              port : 9091   // 접속 포트 변경
            , proxy: "http://localhost:9091"     // devServer :  Back-End , 즉 Spring Boot의 내장 was의 주소를 작성하게 되면 된다.
          }
          //  여기부터 Edward 추가  END
        -------------

       ㄹ. npm install        * ../vue/package.json 이 변경된 되었으니..실행   ( package.json에 등록된  lib 다운로드 )
        D:\br_framework\workspaces\board-api\vue>npm install
          ** npm WARN deprecated  된 lib 가 많다..-_-;;

       ㅁ. npm run build          * vue build
        D:\br_framework\workspaces\board-api\vue>npm run build
          *  build 확인.  '4.1.2.(vue.config.js)' 에서 설정한 경로에 파일이 배포되었는지 확인.


3. spring boot , vue 사이트 접속 확인
    3.1. npm run serve    * run server
    3.2. Vue 사이트 접속 확인  http://localhost:9091/


