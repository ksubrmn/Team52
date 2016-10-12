package controller;

import fxapp.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class SubmitReportController {

    Main main;

    @FXML
    Button CancelReportButton;

    /**
     * Sets Main application state
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

    }

    /**
     * Handles cancel button action
     */
    public void HandleCancelButton() {
        main.showApplicationScreen();
    }
    public void HandleSubmitButton() {
        main.showApplicationScreen();
    }
}
