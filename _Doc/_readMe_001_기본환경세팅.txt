 ********************************************************************************************************************************
     * SPRING BOOT + REACT
        https://m.blog.naver.com/rudnfskf2/222148407272
        https://sundries-in-myidea.tistory.com/71
        https://ojava.tistory.com/185?category=348319


    * SPRING BOOT+ vue
      * spring boot + vue.js 연동
         https://jamong-icetea.tistory.com/207
         https://ojava.tistory.com/152
      * project
        https://github.com/jinseogood/vue-springboot-board  ( https://dev-jsk.tistory.com/127 )
        https://github.com/SwiftlyAside/ProjektFinal
        https://github.com/ednadev/project-book
        https://github.com/YeonCheolGit/mybatis-wine-price  ( ?? )


 참고 :  https://tychejin.tistory.com/304
       https://ojava.tistory.com/185?category=348319
       https://mr-spock.tistory.com/3
********************************************************************************************************************************

1. node.js설치
   1.1. node.js 다운로드  > Stable 버전인 'node-v14.17.0-x64.msi' 다운로드하고 기본 설정대로 설치   한다,.
           https://nodejs.org/ko/          * 14.14.0 LTS  버전.  2021-05-17  Stable 버전
            ------------------------------------------------------------
               * 설치 폴더 >  C:\Program Files\nodejs\
               * 설치 확인 >  C:\Users\uuser>npm -v
                                   6.14.13
            ------------------------------------------------------------
              * Node.js를 설치하게 되면 Node Package Manager인 NPM은 자동으로 설치된다.
                이를 통해 원하는 패키지를  npm install ~~ 의 형태로 설치할 수 있고,
                작성 코드를 빌드하고 서버를 켜는 행위도 npm을 통해 수행할 수 있다.

   1.2. vue-cli 설치
               npm install -g @vue/cli

2. Eclipse Vue.js 플러그인 설치
     Help -> Eclipse Marketplace... 에서 Vue.js :: CodeMix... 설치


3. Eclipse  spring boot + vue 프로젝트 설정
    3.1. Spring Boot 프로젝트 생성
    3.2. Vue-CLI 프로젝트 생성  * vue create vue --no-git
             3.2.1. Command창 실행후, '3.1' 에서 생성한 프로젝트 폴더로 이동
             3.2.2. D:\br_framework\workspaces\shop-vue-front\vue create vue --no-git
                      > vue create 프로젝트명 git미생성   ( vue.js 프로젝트 생성시 옵션이 없으면 자동으로 .git을 생성함)
                    *  vue create 명령어가 처음이라면 아래 문구를 맞이한다.  Y 입력한다. ( 캡쳐 못함)
                           ?  Your connection to the default npm registry seems to be slow.
                           Use https://registry.npm.taobao.org for faster installation? (Y/n)
                    * Default (Vue 3) ([Vue 3] babel, eslint) 를 선택. ( 키패드 이동)
             3.2.3. Eclipse 에서 vue 프로젝트 생성 확인

4. Eclipse  spring boot + vue 프로젝트 실행
       4.1. Vue 프로젝트 실행
             4.1.1. Command창 실행후, vue  프로젝트 폴더로 이동
                       D:\br_framework\workspaces\shop-vue-front\vue
             4.1.2. babel.config.js  수정
                      - 파일명수정 : vue.config.js
                          *파일명 수정안하고 npm run build 시 에러 발생
                       - 코드 수정(vue.config.js)
                            module.exports = {
                              //presets: [    '@vue/cli-plugin-babel/preset'  ]  // default code
                              outputDir: "../src/main/resources/static",
                              indexPath: "../static/index.html",
                              devServer: {
                                  port : 9091   // 접속 포트 변경
                                , proxy: "http://localhost:9191"     // devServer :  Back-End , 즉 Spring Boot의 내장 was의 주소를 작성하게 되면 된다.
                              },
                              chainWebpack: config => {
                                const svgRule = config.module.rule("svg");
                                svgRule.uses.clear();
                                svgRule.use("vue-svg-loader").loader("vue-svg-loader");
                              }
                            };
             4.1.2. npm install              * ../vue/package.json에 설정된 모든 패키지 설치
                    D:\br_framework\workspaces\shop-vue-front\vue\npm install
                        * package.json 이 변경된 경우에만
                          > WARN 은 일단 PASS..

             4.1.2. npm run build          * vue build
                    D:\br_framework\workspaces\shop-vue-front\vue\npm run build

             4.1.3.  build 확인.  '4.1.2.(vue.config.js)' 에서 설정한 경로에 파일이 배포되었는지 확인.



5. spring boot , vue 사이트 접속 확인
    5.1. vue 사이트 접속 확인
         4.1.3. 서버 실행.   npm run serve
                  D:\br_framework\workspaces\shop-vue-front\vue\npm run serve
         4.1.3. Vue 사이트 접속 확인  http://localhost:9091/

     5.2. Spring Boot 사이트 접속 확인
         5.2.1. Eclipse > Windows > Show View > Other..      BootDashboard 추가

         5.2.2. 생성한 boot 프로젝트 서버 실행

         5.2.3.  boot 접속 확인    http://localhost:8080/

6. GitHub 연결
   6.1.
