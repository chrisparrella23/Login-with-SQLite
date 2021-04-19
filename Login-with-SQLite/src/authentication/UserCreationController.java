package authentication;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserCreationController {

	public UserCreationController() {
		
	}
	
	@FXML
	private Button button;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;
	
	@FXML
	private void createUser(ActionEvent event) throws IOException {
		App a = new App();
		String[] newInfo = {username.getText(), password.getText(), firstName.getText(), 
				lastName.getText(), phone.getText(), email.getText()};
		for (int i = 0; i < newInfo.length; i++) {
			System.out.println(newInfo[i]);
		}
//		UserUtils.userCreation("UserDB.sqlite", null, 6);
	}
}
