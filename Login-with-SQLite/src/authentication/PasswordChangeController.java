package authentication;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PasswordChangeController {
	
	String[] userInfo = LoginController.userInfo;
	
	public PasswordChangeController() {
		
	}
	
	@FXML
	private TextField newPassword;
	@FXML
	private Button button;
	
	@FXML
	private void changePassword(ActionEvent event) throws IOException {
		String newPass = newPassword.getText();
		boolean isChanged = UserUtils.changePassword("UserDB.sqlite", userInfo[0], newPass);
		
		if (isChanged) {
			App a = new App();
			a.changeScene("UserInfoView.fxml");
			// Password does not show as changed upon switching scenes. Why?
			System.out.println("Password changed successfully.");
		}
	}
}
