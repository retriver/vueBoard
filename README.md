
1.Spring Boot 프로젝트 생성

2. vue 프로젝트 생성
  D:\br_framework\workspaces\board-api>vue create vue --no-git

3. 파일 복사.
   https://github.com/jinseogood/vue-springboot-board
      |_ board-api  파일을 아래 경로에 복사
            >     D:\br_framework\workspaces\board-api
      |_ board-app   파일을 아래 경로에 복사
            >     D:\br_framework\workspaces\board-api\vue

4. MySQL 테이블 생성
  CREATE TABLE TB_BOARD (
    DOC_NO int(10) not null,
    TITLE varchar(400) not null,
    CONTENT varchar(4000) not null,
    WRITER varchar(400) not null,
    REG_DTTM timestamp  default CURRENT_TIMESTAMP,
    VIEW int(10) default 0, primary key (DOC_NO)
  )ENGINE=InnoDB DEFAULT CHARSET=euckr ;


  create table TB_REPLY (
    REPLY_NO int(10) not null,
    DOC_NO int(10) not null,
    WRITER varchar(400) not null,
    CONTENT varchar(4000) not null,
    REG_DTTM timestamp  default CURRENT_TIMESTAMP,
    primary key (REPLY_NO, DOC_NO),
    foreign key (DOC_NO) references TB_BOARD(DOC_NO)
  );

5. vue.config.js 수정
  module.exports = {
      transpileDependencies: ['vuetify']
      //, presets: [    '@vue/cli-plugin-babel/preset'  ]  // default code
      , outputDir: "../src/main/resources/static"
    , indexPath: "../static/index.html"
    , chainWebpack: config => {
      config.plugin('html').tap(args => {
        args[0].title = 'Board'
        return args
      })
    }
    , devServer: {
        overlay: false
          , port : 9091   // 접속 포트 변경
          , proxy: "http://localhost:9090"     // devServer  :  Back-End , 즉 Spring Boot의 내장 was의 주소  * application.properties > server.port=9090
    }
    /*
    ,chainWebpack: config => {
          const svgRule = config.module.rule("svg");
          svgRule.uses.clear();
          svgRule.use("vue-svg-loader").loader("vue-svg-loader");
      }
      */
  }


6. npm install              * ../vue/package.json에 설정된 모든 패키지 설치
    D:\br_framework\workspaces\board-api\vue>npm install
      * package.json 이 변경된 경우에만
        > WARN 은 일단 PASS..

7. npm run build          * vue build
    D:\br_framework\workspaces\board-api\vue>npm run build


8.  build 확인.  '4.1.2.(vue.config.js)' 에서 설정한 경로에 파일이 배포되었는지 확인.


9. vue 서버 실행 및 접속 확인
    D:\br_framework\workspaces\board-api\vue>npm run serve    * run server
    * Vue 사이트 접속 확인  http://localhost:9091/

10. spring boot 실행 및 접속 확인
     http://localhost:9090


## CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
(1) pom.xml 에 의존성 추가
```
<dependency>
  <groupId>org.apache.httpcomponents</groupId>
  <artifactId>httpclient</artifactId>
  <scope>test</scope>
</dependency>
```
(2) 요청 메소드 또는 클래스에 @CrossOrigin 추가

## Docker
(1) images 다운
```
docker pull 'image name'
```
(2) container 구성
```
docker run -d -p 'port' -e 'password setting' --name 'container name' 'image name' --character-set-server=utf8 --collation-server=utf8_unicode_ci
```
(3) container 실행
```
docker exec -i -t 'container name' bash
```
(4) MySQL 접속
```
mysql -u root -p 'database name'
```

## Spring Boot + Mybatis 프로젝트 구조
src/main/java/package/
src/main/java/package/config      => 설정파일
src/main/java/package/controller  => 컨트롤러
src/main/java/package/domain      => VO
src/main/java/package/repository  => DAO
src/main/java/package/service     => Service

src/main/resources/
src/main/resources/mappers        => Mapper

## MySQL 접속 설정
- resources/application.properties 내 작성
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver => 드라이버
spring.datasource.url=jdbc:mysql://localhost:3306/DB명       => 접속 URL
spring.datasource.username=username                          => 사용자명
spring.datasource.password=password                          => 비밀번호
```

## Log 설정
- resources/logback-spring.xml 생성 후 내용 설정
(1) Console Appender 추가
(2) Logger 설정 (SQL Log 출력 시 jdbc.sqlonly 추가)
(3) Root Logger 설정

## Auto Build 설정
- Spring Devtools 의존성 추가
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <optional>true</optional>
</dependency>
```

## MySQL 시간 동기화
(1) DB Timezone 설정 확인 (미설정일 경우 count 값이 0)
```
select count(*) from mysql.time_zone;
```
(2) Timezone 설정을 위해 명령어 입력
```
# mysql_tzinfo_to_sql /usr/share/zoneinfo | mysql -u root -p mysql
```
(3) DB Timezone 재확인 (기본설정일 경우 SYSTEM 으로 표시)
```
select @@global.time_zone, @@session.time_zone;
```
(4) Timezone Seoul로 변경
```
set global time_zone = 'Asia/Seoul';
set time_zone = 'Asia/Seoul';
```
(5) (3) 쿼리 이용 Timezone Seoul로 변경 확인
(6) 현재시간 확인
```
select now();
```

## mvn 명령어
- 패키지 clean & build, 테스트 제외
```
./mvnw clean package -DskipTests
```

## MySQL DataBase
- DB 생성
```
create database 'database name' default character set utf8;
```
- DB 확인
```
show databases;
```
- DB 사용
```
use 'database name';
```

## MySQL User
- User 생성 (% 는 외부 접근 허용)
```
create user 'user id'@'%' identified by 'password';
```
- User 삭제
```
drop user 'user id'@'%';
```
- 모든 DB, 테이블 권한 부여
```
grant all privileges on *.* to 'user id'@'%';
```
- 권한 적용
```
flush privileges;
```
- 권한 확인
```
show grants for 'user id'@'%';
```