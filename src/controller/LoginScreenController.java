package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    private Main main;

    @FXML
    public void submitButtonPressed() {
        if (usernameTextField.getText().equals("user")
                && passwordField.getText().equals("password")) {
            //TODO: Remove this temp code
            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.initOwner();
            alert.setTitle("Error");
            alert.setHeaderText("Failed Login Attempt");
            alert.setContentText("Username or password was incorrect");
            alert.showAndWait();
        }
    }

    @FXML
    public void cancelButtonPressed() {

    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
