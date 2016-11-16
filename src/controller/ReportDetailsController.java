package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.WaterReportTracker;
import model.WaterSourceReport;

/**
 * Handles the Screen with the Report Details on it
 */
public class ReportDetailsController {

    @FXML
    private TextField dateField, timeField, latField, longField,
            waterTypeField, waterConditionField, reportNumberField,
            reporterField;

    private Main main;

    /**
     * Handles cancel button pressed event
     */
    public void HandleBackButtonPressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state for a given user
     * @param main The facade
     * @param reportNumber Which report to show
     * @param waterReportTracker Where to pull from
     */
    public void setMainApp(Main main, WaterReportTracker waterReportTracker,
                           int reportNumber) {
        this.main = main;
        WaterSourceReport report = waterReportTracker.getSourceReports()
                .get(reportNumber -1);

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
