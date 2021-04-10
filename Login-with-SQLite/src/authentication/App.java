package authentication;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private static Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stg = primaryStage;
		primaryStage.setResizable(false);
		
		Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
		primaryStage.setTitle("Log In");
		primaryStage.setScene(new Scene(root, 278, 300));
		primaryStage.show();
	}
	
	public void changeScene(String fxml) {
		Parent pane;
		try {
			pane = FXMLLoader.load(getClass().getResource(fxml));
			stg.getScene().setRoot(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
