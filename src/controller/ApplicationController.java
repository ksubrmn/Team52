package controller;

import fxapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import model.AccountType;

public class ApplicationController {

    private Main main;

    @FXML
    Button LogoutButton;

    /**
     * Sets Main application state
     * @param main the facade
     */
    public void setMainApp(Main main) {
        this.main = main;
        LogoutButton.setOnAction((ActionEvent e) -> {
                main.setUser(null);
                main.showHomeScreen();
        });
    }

    /**
     * Handles edit button action
     */
    public void HandleEditButton() {
        main.showEditInformationScreen();
    }

    /**
     * Handles submit report action
     */
    public void HandleSubmitReportButton() {
        main.showSubmitReportScreen();
    }

    /**
     * Handles submit purity report action
     */
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

    /**
     * Handles view report action
     */
    public void HandleViewReportButton() {
        main.showViewReportScreen();
    }

    /**
     * Handles view purity report action
     */
    public void HandleViewPurityReportsButton() {
        if ( main.getUser().getAccountType() == AccountType.Manager){
            main.showViewPurityReportsScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Access Denied");
            alert.setContentText("Only Managers can view Water Purity Reports.");
            alert.showAndWait();
        }
    }

    /**
     * Handles view map action
     */
    public void HandleMapViewButton() {
        main.showMapScreen();
    }

    public void HandleHistoryReportButton() {
        if ( main.getUser().getAccountType() == AccountType.Manager) {
            main.showSelectHistoryGraphScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Access Denied");
            alert.setContentText("Only Managers can view History Reports.");
            alert.showAndWait();
        }
    }
}
