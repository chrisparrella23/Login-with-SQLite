package authentication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FailureController {
	
	public FailureController() {
		
	}
	
	@FXML
	private Button button;
	
	@FXML
	private void goBack() {
		App a = new App();
		a.changeScene("LoginView.fxml");
	}
}
