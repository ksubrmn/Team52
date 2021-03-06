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

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

@SuppressWarnings("ALL")
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

    /**
     * Handles submit button pressed event
     */
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

    /**
     * Handles cancel button pressed event
     */
    public void handleCancelPressed() {
        main.showHomeScreen();
    }

    /**
     * Sets main app state
     * Gets account list
     * @param main The facade
     */
    public void setMainApp(Main main) {
        this.main = main;
        ObservableList<AccountType> list = FXCollections.observableArrayList();
        Collections.addAll(list, AccountType.values());
        AccountTypeSelection.setItems(list);
        AccountTypeSelection.getSelectionModel().select(0);
    }
}
