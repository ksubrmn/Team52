package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

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

        try
        {
            final FileInputStream fis = new FileInputStream("sourcereports.out");
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object deserializedObject = ois.readObject();

            if (deserializedObject instanceof List)
            {
                main.setSourceReports( (List<WaterSourceReport>) deserializedObject);

            }
            else
            {
                System.out.println("Not expected to deserialize " + deserializedObject.getClass().getName());
            }

            ois.close();


        }
        catch (Exception ex)
        {
            // Print stack trace to standard error for simple demonstration
            ex.printStackTrace();
        }
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
