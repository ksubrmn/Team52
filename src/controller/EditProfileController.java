package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Handles the Screen that allows uses to edit their profile
 */
public class EditProfileController {

    @FXML
    private TextField EmailBox;

    @FXML
    private TextField AddressBox;

    @FXML
    private TextField TitleBox;

    private Main main;
    private User user;

    /**
     * Handles save button press event
     */
    public void handleSavePressed() {
        if ("".equals(EmailBox.getText()) || "".equals(AddressBox.getText())
                || "".equals(TitleBox.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error saving account information");
            alert.setContentText("All text fields must be filled");
            alert.showAndWait();
        } else {
            user.setEmail(EmailBox.getText());
            user.setAddress(AddressBox.getText());
            user.setTitle(TitleBox.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account");
            alert.setHeaderText("Update Account Information");
            alert.setContentText("Account information successfully updated");
            alert.showAndWait();
            try
            {
                final FileOutputStream fo = new FileOutputStream("users.out");
                final ObjectOutputStream oos = new ObjectOutputStream(fo);
                oos.writeObject(main.getAccountTracker().getAccounts());
                oos.flush();
                oos.close();

            }
            catch (Exception e) {
                e.printStackTrace();
            }
            main.showApplicationScreen();
        }
    }

    /**
     * Handles cancel button pressed event
     */
    public void handleCancelPressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state for a given user
     * @param main the facade
     * @param user current user
     */
    public void setMainApp(Main main, User user) {
        this.main = main;
        this.user = user;
        EmailBox.setText(user.getEmail());
        AddressBox.setText(user.getAddress());
        TitleBox.setText(user.getTitle());
    }
}
