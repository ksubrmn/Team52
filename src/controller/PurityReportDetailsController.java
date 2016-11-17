package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.WaterPurityReport;
import model.WaterReportTracker;

/**
 * Represents the Detailed Purity Report Screen
 */
public class PurityReportDetailsController {

    @FXML
    private TextField dateField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField latField;

    @FXML
    private TextField longField;

    @FXML
    private TextField waterConditionField;

    @FXML
    private TextField virusField;

    @FXML
    private TextField contaminantField;

    @FXML
    private TextField reportNumberField;

    @FXML
    private TextField reporterField;

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
     * @param reportNumber Which report to show
     * @param waterReportTracker Which tracker to pull from
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker,
                           int reportNumber) {
        this.main = main;
        //this.waterReportTracker = waterReportTracker;
        WaterPurityReport report = waterReportTracker.getPurityReports()
                .get(reportNumber -1);

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
