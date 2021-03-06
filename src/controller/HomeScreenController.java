package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Handles the Main Logged In Screen
 */
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
     * @param main the facade
     */
    public void setMainApp(Main main) {
        this.main = main;
    }
}
