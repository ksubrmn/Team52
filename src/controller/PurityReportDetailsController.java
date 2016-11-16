package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.WaterPurityReport;
import model.WaterReportTracker;

public class PurityReportDetailsController {

    @FXML
    private TextField dateField, timeField, latField, longField,
            waterConditionField,virusField,contaminantField, reportNumberField, reporterField;

    private Main main;
    //private WaterReportTracker waterReportTracker;
    //private WaterPurityReport report;

    /**
     * Handles cancel button pressed event
     */
    public void HandleBackButtonPressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state for a given user
     * @param main the facade
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker, int reportNumber) {
        this.main = main;
        //this.waterReportTracker = waterReportTracker;
        System.out.println("here");
        WaterPurityReport report = waterReportTracker.getPurityReports().get(reportNumber -1);

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
