package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.WaterReportTracker;
import model.WaterSourceReport;

public class ReportDetailsController {

    @FXML
    TextField dateField, timeField, latField, longField,
            waterTypeField, waterConditionField, reportNumberField, reporterField;

    private Main main;
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
     * @param main The facade
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker, int reportNumber) {
        this.main = main;
        this.waterReportTracker = waterReportTracker;
        System.out.println("here");
        this.report = this.waterReportTracker.getSourceReports().get(reportNumber -1);

        reportNumberField.setText("" + reportNumber);
        reporterField.setText(report.getReporterName());

        dateField.setText(report.getDate().toString());
        timeField.setText(report.getTime());
        latField.setText("" + report.getLatitude());
        longField.setText("" + report.getLongitude());
        waterTypeField.setText(report.getWaterType().toString());
        waterConditionField.setText(report.getWaterCondition().toString());

    }
}
