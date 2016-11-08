package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.*;

public class ViewReportController {

    private Main main;

    @FXML
    Button ViewReportButton;

    @FXML
    Button BackButton;

    @FXML
    ComboBox Reports;

    /**
     * Sets Main application state
     * @param main The facade
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker) {
        this.main = main;
        ObservableList<WaterSourceReport> list = FXCollections.observableArrayList();
        list.addAll(waterReportTracker.getSourceReports());
        Reports.setItems(list);
        Reports.getSelectionModel().select(0);
    }

    /**
     * Handles edit button action
     */
    public void HandleBackButton() {
        main.showApplicationScreen();
    }
    public void HandleViewReportButton() {
        WaterSourceReport selectedReport = (WaterSourceReport) Reports.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {
            int reportNumber = selectedReport.getReportNumber();
            main.showReportDetailsScreen(reportNumber);
        }
    }
}
