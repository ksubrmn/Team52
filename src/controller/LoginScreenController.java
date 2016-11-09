package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.List;

import model.User;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


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

    /**
     * Handles pressing of the submit button
     * Alerts user if login is not successful
     */
    public void submitButtonPressed() {
        if (main.getAccountTracker().checkAccount(usernameTextField.getText(),
                passwordField.getText())) {
            main.setUser(main.getAccountTracker().getUser(usernameTextField.getText()));
            main.showApplicationScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.initOwner();
            alert.setTitle("Error");
            alert.setHeaderText("Failed Login Attempt");
            alert.setContentText("Username or password was incorrect");
            alert.showAndWait();
        }
    }

    /**
     * Handles cancel button, sending user back to home screen
     */
    public void cancelButtonPressed() {
        main.showHomeScreen();
    }

    /**
     * Initializes reference to facade
     * @param main the facade
     */
    public void setMainApp(Main main) {
        this.main = main;
        try
        {
            final FileInputStream fis = new FileInputStream("users.out");
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object deserializedObject = ois.readObject();

            if (deserializedObject instanceof List)
            {
                main.setAccountTracker( (List<User>) deserializedObject);

            }
            else
            {
                System.out.println("Not expected to deserialize " + deserializedObject.getClass().getName());
            }

            ois.close();


        }
        catch (Exception ex)
        {
            // Print stack trace to standard error for simple demonstration
            ex.printStackTrace();
        }
    }
}
