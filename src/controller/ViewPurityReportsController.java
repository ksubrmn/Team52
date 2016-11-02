package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.User;
import model.WaterPurityReport;
import model.WaterReportTracker;

public class ViewPurityReportsController {

    private Main main;

    private WaterReportTracker waterReportTracker;

    @FXML
    Button ViewReportButton;

    @FXML
    Button BackButton;

    @FXML
    ComboBox Reports;

    /**
     * Sets Main application state
     * @param main
     */
    public void setMainApp(Main main, User user, WaterReportTracker waterReportTracker) {
        this.main = main;
        ObservableList<WaterPurityReport> list = FXCollections.observableArrayList();
        for (WaterPurityReport type: waterReportTracker.getPurityReports()) {
            list.add(type);
        }
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
