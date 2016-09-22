package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeScreenController {

    @FXML
    private Button LoginButton;

    @FXML
    private Button RegistrationButton;

    private Main main;

    @FXML
    public void loginButtonPressed() {

    }

    @FXML
    public void RegistrationButtonPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setHeaderText("Text");
        alert.setContentText("User ID: user\nPassword: password");
        alert.showAndWait();
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
