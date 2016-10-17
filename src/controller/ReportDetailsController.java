package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;
import model.WaterReportTracker;
import model.WaterSourceReport;

public class ReportDetailsController {

    @FXML
    TextField dateField, timeField, locationField,
            waterTypeField, waterConditionField, reportNumberField, reporterField;

    private Main main;

    private User user;

    private WaterReportTracker waterReportTracker;

    private WaterSourceReport report;







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
        this.report = this.waterReportTracker.getReports().get(reportNumber -1);

        reportNumberField.setText("" + reportNumber);
        reporterField.setText(report.getReporterName());

        dateField.setText(report.getDate().toString());
        timeField.setText(report.getTime());
        locationField.setText(report.getLocation());
        waterTypeField.setText(report.getWaterType().toString());
        waterConditionField.setText(report.getWaterCondition().toString());

    }
}
