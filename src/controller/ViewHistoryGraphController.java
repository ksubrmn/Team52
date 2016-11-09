package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.AccountType;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ViewHistoryGraphController {

    private Main main;

    @FXML
    Label GraphTitle;

    @FXML
    Button DoneButton;

    @FXML
    LineChart HistoryGraph;

    /**
     * Handles done button pressed event
     */
    public void handleDonePressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state
     * Gets account list
     * @param main The facade
     */
    public void setMainApp(Main main, String location, int year, String type) {
        GraphTitle.setText("Graph for " + year + " " + location);
        this.main = main;
    }
}
