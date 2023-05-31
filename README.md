# MemberShip
회원관리 프로그램

프로세스 : 회원가입 , 로그인 , 회원정보 수정 , 관리자 로그인 , 관리자 회원관리<br>
구현언어 : JavaFx , SceneBuilder , Oracle
<br>

# 버전 및 환경
jdk 15.0.2
javafx 15.0.1
SceneBuilder 16.0.0

module-info.java {

	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
	
	opens application;
}





