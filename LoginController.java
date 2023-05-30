package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginController {

	/*
	 * 체크박스 : adminCheckBox 사용자 아이디 : useridTextField 사용자 암호 : passwordPasswordField
	 * 로그인 버튼 : loginButton 회원가입 버튼 : registrationButton 취소 버튼 : cancelButton 창닫기 버튼
	 * : closeButton
	 */

	@FXML
	private CheckBox adminCheckBox;
	@FXML
	private TextField useridTextField;
	@FXML
	private PasswordField passwordPasswordField;
	@FXML
	private Button loginButton;
	@FXML
	private Button registrationButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button closeButton;
	@FXML
	private Label loginMessageLabel;
	
	boolean isUserLogin = false;
	// 창 닫기 버튼 클릭 이벤트
	public void closeButtonOnAction(ActionEvent e) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	public void loginButtonOnAction(ActionEvent e) {
		loginMessageLabel.setText("사용자 아이디와 암호를 검사합니다...");

		if (loginButton.getText().equals("로그인") == true) {

			if (useridTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
				if (adminCheckBox.isSelected() == true) {
					loginMessageLabel.setText("관리자 로그인...");
					validateAdminLogin();
				} else {
					loginMessageLabel.setText("사용자 로그인...");
					validateMemberLogin();
				}
			} else {
				loginMessageLabel.setText("아 이 디 와  암 호 를  입 력 해 주 세 요");
			}
		} else if (loginButton.getText().equals("로그아웃") == true) {
			loginMessageLabel.setText("로그아웃...");
			logout();
		}
	}

	public void adminCheckBoxOnAction(ActionEvent e) {
		if (adminCheckBox.isSelected() == true) {
			registrationButton.setText("관리자 회원관리");
			registrationButton.setDisable(true);
			useridTextField.setText("");
			passwordPasswordField.setText("");
		} else {
			registrationButton.setText("회원가입");
			registrationButton.setDisable(false);
			useridTextField.setText("");
			passwordPasswordField.setText("");
		}
	}

	public void registrationButtonOnAction(ActionEvent e) {
		try {
			if (adminCheckBox.isSelected() == true) {
				Parent root1 = FXMLLoader.load(getClass().getResource("membership.fxml"));
				Stage membershipStage = new Stage();
				membershipStage.setTitle("관리자 회원관리 모듈");
				membershipStage.setScene(new Scene(root1, 600, 400));
				membershipStage.getIcons().add(new Image("application/instagram.png"));
				membershipStage.show();

			} else {
				if(isUserLogin == true) {
					Parent root2 = FXMLLoader.load(getClass().getResource("modification.fxml"));
					Stage modification = new Stage();
					modification.setTitle("사용자 회원정보 수정");
					modification.setScene(new Scene(root2, 600, 400));
					modification.getIcons().add(new Image("application/instagram.png"));
					modification.show();
				} else {
					Parent root3 = FXMLLoader.load(getClass().getResource("registration.fxml"));
					Stage registration = new Stage();
					registration.setTitle("사용자 회원가입 모듈");
					registration.setScene(new Scene(root3, 600, 400));
					registration.getIcons().add(new Image("application/instagram.png"));
					registration.show();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void cancelButtonOnAction(ActionEvent e) {
		adminCheckBox.setSelected(false);
		useridTextField.setText("");
		passwordPasswordField.setText("");
	}

	public boolean isAdminLogin() {
		DBConnection connDB = new DBConnection();
		Connection conn = connDB.getConnection();

		String sql = "select admin_id, admin_password " + " from admin_accounts" + " where admin_id=?"
				+ " and admin_password=?";

		boolean result = false;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useridTextField.getText());
			pstmt.setString(2, passwordPasswordField.getText());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
			}

			pstmt.close();
			rs.close();
			conn.close();

		} catch (Exception err) {

		}
		return result;
	}

	public boolean isMemberLogin() {
		DBConnection connDB = new DBConnection();
		Connection conn = connDB.getConnection();

		String sql = "select user_id, user_password " + " from member_accounts" + " where user_id=?"
				+ " and user_password=?";

		boolean result = false;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useridTextField.getText());
			pstmt.setString(2, passwordPasswordField.getText());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = true;
				isUserLogin = true;
				Main.global_user_id = useridTextField.getText();
			}

			pstmt.close();
			rs.close();
			conn.close();

		} catch (Exception err) {

		}
		return result;
	}

	void validateAdminLogin() {
		if (isAdminLogin() == true) {
			loginMessageLabel.setText("관리자 로그인 성공!! 환영합니다^^");
			useridTextField.setText("");
			passwordPasswordField.setText("");
			registrationButton.setDisable(false);
			loginButton.setText("로그아웃");
		} else {
			loginMessageLabel.setText("관리자 아이디 또는 암호가 잘못됐습니다!");
		}
	}

	void validateMemberLogin() {
		if (isMemberLogin() == true) {

			loginMessageLabel.setText("사용자 로그인 성공 !! 환영합니다^^");
			useridTextField.setText("");
			passwordPasswordField.setText("");
			loginButton.setText("로그아웃");
			registrationButton.setText("회원정보 수정");
		} else {
			loginMessageLabel.setText("사용자 아이디 또는 암호가 잘못됐습니다!");
		}
	}

	void logout() {
		loginButton.setText("로그인");
		registrationButton.setText("회원가입");
		adminCheckBox.setSelected(false);
		isUserLogin = false;
		Main.global_user_id = null;
	}

}
