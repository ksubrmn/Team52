package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.WaterPurityReport;
import model.WaterReportTracker;

public class ViewPurityReportsController {

    private Main main;

    @FXML
    Button ViewReportButton;

    @FXML
    Button BackButton;

    @FXML
    ComboBox Reports;

    /**
     * Sets Main application state
     * @param main the facade
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker) {
        this.main = main;
        ObservableList<WaterPurityReport> list = FXCollections.observableArrayList();
        list.addAll(waterReportTracker.getPurityReports());
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
        WaterPurityReport selectedReport = (WaterPurityReport) Reports.getSelectionModel().getSelectedItem();
        if (selectedReport != null) {
            int reportNumber = selectedReport.getReportNumber();
            main.showPurityReportDetailsScreen(reportNumber);
        }
    }
}
