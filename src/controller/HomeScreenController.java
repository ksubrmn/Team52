package controller;

import fxapp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    /**
     * Handles pressing of the login button
     */
    public void loginButtonPressed() {
        main.showLoginScreen();
    }

    /**
     * Handles pressing of the registration button
     */
    public void registrationButtonPressed() {
        main.showCreateAccountScreen();
    }

//    @FXML
//    public void RegistrationButtonPressed() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Registration");
//        alert.setHeaderText("Text");
//        alert.setContentText("User ID: user\nPassword: password");
//        alert.showAndWait();
//    }

    /**
     * Handles login vs registration choice
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;
    }
}
