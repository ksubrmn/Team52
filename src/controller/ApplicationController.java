package controller;

import fxapp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import model.AccountType;

public class ApplicationController {

    Main main;

    @FXML
    Button LogoutButton;

    /**
     * Sets Main application state
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;
        LogoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                main.setUser(null);
                main.showHomeScreen();
            }
        });
    }

    /**
     * Handles edit button action
     */
    public void HandleEditButton() {
        main.showEditInformationScreen();
    }

    public void HandleSubmitReportButton() {
        main.showSubmitReportScreen();
    }

    public void HandleSubmitPurityReportButton() {
        if (main.getUser().getAccountType() == AccountType.Worker || main.getUser().getAccountType() == AccountType.Manager){
            main.showSubmitPurityReportScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Access Denied");
            alert.setContentText("Only Workers and Managers can create Water Purity Reports.");
            alert.showAndWait();
        }

    }

    public void HandleViewReportButton() {
        main.showViewReportScreen();
    }

    public void HandleMapViewButton() {
        main.showMapScreen();
    }
}
