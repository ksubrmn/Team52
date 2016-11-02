package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;
import model.WaterPurityReport;
import model.WaterReportTracker;

public class PurityReportDetailsController {

    @FXML
    TextField dateField, timeField, latField, longField,
            waterConditionField,virusField,contaminantField, reportNumberField, reporterField;

    private Main main;
    private User user;
    private WaterReportTracker waterReportTracker;
    private WaterPurityReport report;

    /**
     * Handles cancel button pressed event
     */
    public void HandleBackButtonPressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state for a given user
     * @param main
     * @param user current user
     */
    public void setMainApp(Main main, User user, WaterReportTracker waterReportTracker, int reportNumber) {
        this.main = main;
        this.user = user;
        this.waterReportTracker = waterReportTracker;
        System.out.println("here");
        this.report = this.waterReportTracker.getPurityReports().get(reportNumber -1);

        reportNumberField.setText("" + reportNumber);
        reporterField.setText(report.getReporterName());

        dateField.setText(report.getDate().toString());
        timeField.setText(report.getTime());
        latField.setText("" + report.getLatitude());
        longField.setText("" + report.getLongitude());
        waterConditionField.setText(report.getWaterCondition().toString());
        virusField.setText("" + report.getVirusPPM());
        contaminantField.setText("" + report.getContaminantPPM());

    }
}