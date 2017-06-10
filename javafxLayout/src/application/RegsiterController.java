package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegsiterController {
	@FXML
	Stage stage;
	Hyperlink forgotpassword;
	Hyperlink Regsiter;
	
	@FXML
	public void forgotpassword() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("ForgotPassword.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("ForgotPassword");
		stage.setScene(new Scene(root, 320, 280));
		stage.showAndWait();
	}

	@FXML
	public void Register() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("Register.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("Register");
		stage.setScene(new Scene(root, 400, 500));
		stage.showAndWait();
	}
}
