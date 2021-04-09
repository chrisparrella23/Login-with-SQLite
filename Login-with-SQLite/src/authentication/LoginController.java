package authentication;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	public LoginController() {
		
	}
	
	@FXML
	private Button button;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	@FXML
	private void userLogin(ActionEvent event) throws IOException {
		App a = new App();
		
//		String[] loginInfo = LoginUtils.getLoginInfo(username.getText(), password.getText());
		String userName = username.getText();
		String passWord = password.getText();
		String[] loginInfo = {userName, passWord};
		String[] userInfo = LoginUtils.login("UserDB.sqlite", loginInfo);
		if (userInfo[0] == null) {
			a.changeScene("FailureView.fxml");
		} else {
//			a.changeScene(SuccessView.fxml);
			for (int i = 0; i < userInfo.length; i++) {
				System.out.println(userInfo[i]);
			}
		}
	}

}
