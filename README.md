# MemberShip
회원관리 프로그램

프로세스 : 회원가입 , 로그인 , 회원정보 수정 , 관리자 로그인 , 관리자 회원관리<br>
구현언어 : JavaFx , SceneBuilder , Oracle
<br>

# 버전 및 환경
javaJDK 15.0.2 <br>
JavaFX SDK 15.0.1 <br>
SceneBuilder 16.0.0

## module-info.java 
   {<br>
	requires javafx.controls;<br>
	requires javafx.fxml;<br>
	requires javafx.graphics;<br>
	requires java.sql;<br>
	requires javafx.base;<br>
	<br>
	opens application;<br>
}
### 목차
(1)로그인<br>
(2)회원가입<br>
(3)관리자 로그인<br>
(4)관리자 회원관리<br>
# 실행화면
## (1) 로그인
사용자 아이디와 암호를 입력해 데이터베이스에 있는 아이디 비밀번호와 일치하면 로그인 됩니다.
![image](https://github.com/woojin0jang/MemberShip/assets/102105000/f7bea56b-e2e6-401e-808b-a005f1679b24)
## (2) 회원가입
아이디가 데이터베이스에 있는 아이디와 달라야하고, 모든 값을 입력 후 회원가입을 누르면<br>사용자 데이터베이스에 데이터가 삽입됩니다. 

![image](https://github.com/woojin0jang/MemberShip/assets/102105000/146c4fbd-5abb-4610-a92a-d1514d957eb5)
## (3) 회원정보 수정
로그인이 되어있는 사용자가 회원정보 수정을 누르면 자신의 회원정보가 자동으로 <br>들어옵니다. (아이디는 수정이 불가능합니다.)

![image](https://github.com/woojin0jang/MemberShip/assets/102105000/7737e054-7e58-48f4-a01d-7980adb4f519)
## (4) 관리자 로그인
![image](https://github.com/woojin0jang/MemberShip/assets/102105000/963a755f-fd9f-43b6-a0a7-a523e922dccf)
## (5) 관리자 회원관리
![image](https://github.com/woojin0jang/MemberShip/assets/102105000/e23a9cd8-36bc-4c24-aa70-602316d9afa5)




