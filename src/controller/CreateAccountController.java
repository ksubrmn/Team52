package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.AccountType;

public class CreateAccountController {

    private Main main;

    @FXML
    TextField NewUsernameBox;

    @FXML
    TextField NewPasswordBox;

    @FXML
    ComboBox AccountTypeSelection;

    @FXML
    Button SubmitButton;

    @FXML
    Button CancelButton;

    public void handleSubmitPressed() {
        if (NewUsernameBox.getText() != null && !NewUsernameBox.getText().equals("")
                && NewPasswordBox.getText() != null) {
            if (main.getAccountTracker().addAccount(NewUsernameBox.getText(),
                    NewPasswordBox.getText(), (AccountType)
                    AccountTypeSelection.getSelectionModel().getSelectedItem())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Account");
                alert.setHeaderText("Create new account");
                alert.setContentText("Account " + NewUsernameBox.getText() + " created");
                alert.showAndWait();
                main.showHomeScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error creating new account");
                alert.setContentText("Account could not be created, name already in use");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error creating new account");
            alert.setContentText("Not all fields filled in");
            alert.showAndWait();
        }
    }

    public void handleCancelPressed() {
        main.showHomeScreen();
    }

    public void setMainApp(Main main) {
        this.main = main;
        ObservableList<AccountType> list = FXCollections.observableArrayList();
        for (AccountType type: AccountType.values()) {
            list.add(type);
        }
        AccountTypeSelection.setItems(list);
        AccountTypeSelection.getSelectionModel().select(0);
    }
}
