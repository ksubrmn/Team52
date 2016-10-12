package controller;

import fxapp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

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
}
