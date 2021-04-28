package authentication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class UserInfoController implements Initializable {

	String[] userInfo = LoginController.userInfo;
	
	@FXML
	private Label username = new Label();
	@FXML
	private Label password = new Label();
	@FXML
	private Label firstName = new Label();
	@FXML
	private Label lastName = new Label();
	@FXML
	private Label phone = new Label();
	@FXML
	private Label email = new Label();
	
	public UserInfoController() {
		setFields();
	}
	
	private void setFields() {
		username.setText("User Name: " + userInfo[0]);
		password.setText("Password: " + userInfo[1]);
		firstName.setText("First Name: " + userInfo[2]);
		lastName.setText("Last Name: " + userInfo[3]);
		phone.setText("Phone: " + userInfo[4]);
		email.setText("E-mail: " + userInfo[5]);
	}
	
	@FXML
	private void goBack() {
		App a = new App();
		a.changeScene("LoginView.fxml");
	}
	
	@FXML
	private void goToChangePassword() {
		App a = new App();
		a.changeScene("PasswordChangeView.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setFields();
	}
}
