# java-skeleton-project

### 프로젝트 설명
마이리얼트립의 Java 표준을 정하기 위한 프로젝트

### Build File 설명
* $PROJECT_ROOT/build.gradle
  * Project Build를 위한 기초 정보
  * 포함된 Library
    * Spring Boot
    * IntelliJ Plugin
    * SonarQube
    * Lombok
    * slf4j/logback
    * JUnit
    * AssertJ
    * Mockito
* $PROJECT_ROOT/gradle.properties
  * Library Version 정보 명시
  * projectGroup : 생성할 프로젝트에 맞게 수정 필요함
  * sonarQubeProjectKey : SonarQube에 생성한 Project Key
  * sonarQubeLoginToken : 조직/프로젝트 별 생성한 Login Token
* $PROJECT_ROOT/settings.gradle
  * Project 정보 변경 필요
  * rootProject.name : 생성할 프로젝트에 맞게 수정
  * include
    * api
    * batch
    * client
    * core
    * domain
    * infrastructure
* $PROJECT_ROOT/api/build.gradle
  * core, domain, insfrastructure를 조합하여 Build
  * 아래 Component에 대한 dependency 추가되어 있음
    * spring-boot-autoconfigure
    * spring-boot-starter-web
    * spring-boot-starter-actuator
    * springfox-swagger2
    * springfox-swagger-ui
    
### Component 설명
* api
  * REST API Server
  * Swagger를 통한 API 명세 제공
  * Core / Domain / Infrastructure를 활용하여 Web 서비스 제공
  * MVC의 Controller 역할
  * Request / Response 관리 및 Filter / Interceptor / Handler 기능 구현
* batch
  * Batch Module
  * 배치 작업이 필요할 시 Core / Domain / Infrastructure를 활용하여 구현
* client
  * 타 도메인에 Rest API Library 제공 용도
  * Feign Client 등을 활용
* core
  * Business Logic은 아니지만 프로젝트 전반에서 공통적으로 사용되는 모듈
  * Exception, Enum, DTO, Utility 성 모듈등
* domain
  * Business Logic
  * Service, Repository, Domain(Entity, Aggregate, Aggregate Root)
* infrastructure
  * 외부 시스템과의 연동을 위한 모듈
  * Networking Module
  * JPA / MyBatis 등의 DB Persistent Framework 연동 모듈
  * Kafka / RabbitMQ 등의 MQ 연동 모듈
  * Redis / Elasticache 등의 No-SQL 연동 모듈
### 배포 방식
* Jenkins Build -> S3 -> Code Deploy -> Create Instance(Blue/Green Only) -> Deploy Jar -> Run with Docker
* Jenkins Project (Multi Branch) 생성 필요함
* skeleton project에서는 api만 서버 배포 대상임
  * batch도 배포가 필요할 경우 JenkinsFile-x 를 참고
### 배포 설정
* $ROOT_PROJECT/api/JenkinsFile-{Environment} 파일 필요
* 각 환경별(dev/test/stage/prod) 파일 내의 environment 설정 변경 필요
  * APPLICATION_NAME : Code Deploy에 정의된 Applicatoin Name
### 로컬 개발 환경 세팅
* JDK
  * MyBatis의 Multi-Line Query 작성이 필요 없을 경우 JDK11 환경에서 테스트 됨
  * Multi-Line Query를 사용해야 할 경우 JDK15 사용해야 함.
* DB등은 Local Docker를 활용함.
  * /docker/scripts 에 실행 스크립트 사용
  * chmod +x *.sh를 통해 실행 권한 추가 필요
  * /docker/
* API 서버 실행은 IntelliJ의 Gradle Tab에서 실행
  * ex) java-skeleton-project > api > Tasks > applicatoin > bootRun
  * profile option 설정
    * -Dspring.config.activate.on-profile=local