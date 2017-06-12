package application;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegsiterController implements Initializable {
	RegisterModel regmodel = new RegisterModel();

	@FXML
	Stage stage;
	Hyperlink forgotpassword;
	Hyperlink Regsiter;
	Label isConnected;

	@FXML
	private TextField txtemail;
	@FXML
	private TextField txtpassword;
	@FXML
	private TextField txtname;
	@FXML
	private TextField txtemailaddress;
	@FXML
	private TextField txtpass;
	@FXML
	private TextField txtdob;

	@FXML
	private ComboBox<String> txtcity;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		if (regmodel.isDBConnected()) {
			System.out.println("connected");
		} else {
			System.out.println("not connected");
		}

	}

	public void setCityDetails() {

		txtcity.getItems().clear();
		Iterator<String> itr = regmodel.DisplayCity().iterator();
		while (itr.hasNext()) {
			txtcity.getItems().addAll(itr.next());
		}

	}

	public void LoginCheck(ActionEvent event) {
		if (regmodel.isLogin(txtemail.getText(), txtpassword.getText())) {
			System.out.println("Successfull");
		}

		else {
			System.out.println("failure");
		}
	}

	public void Registrationcheck(ActionEvent event) {
		if (regmodel.Register(txtname.getText(), txtemailaddress.getText(), txtpass.getText(), txtdob.getText(),
				txtcity.getValue())) {
			System.out.println("Regsitered successfully");

		} else {
			System.out.println("Regsitered not successfully");
		}
	}

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

		RegsiterController controllerlist = fxmlLoader.getController();
		controllerlist.setCityDetails();

		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("Register");
		stage.setScene(new Scene(root, 400, 500));

		stage.showAndWait();

	}

}
