package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;

public class EditProfileController {

    @FXML
    TextField EmailBox, AddressBox, TitleBox;

    private Main main;

    private User user;

    public void handleSavePressed() {
        if (EmailBox.getText().equals("") || AddressBox.getText().equals("") || TitleBox.getText().equals("")) {
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
            main.showApplicationScreen();
        }
    }

    public void handleCancelPressed() {
        main.showApplicationScreen();
    }

    public void setMainApp(Main main, User user) {
        this.main = main;
        this.user = user;
        EmailBox.setText(user.getEmail());
        AddressBox.setText(user.getAddress());
        TitleBox.setText(user.getTitle());
    }
}
