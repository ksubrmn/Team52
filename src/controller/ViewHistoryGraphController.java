package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.WaterPurityReport;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class ViewHistoryGraphController {

    private Main main;

    @FXML
    Label GraphTitle;

    @FXML
    Button DoneButton;

    @FXML
    LineChart<String, Float> HistoryGraph;

    private final String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /**
     * Handles done button pressed event
     */
    public void handleDonePressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state
     * Gets account list
     * @param main The facade
     */
    public void setMainApp(Main main, String location, int year, String type) {
        GraphTitle.setText("Graph for " + year + " " + location);
        this.main = main;
        try {
            final FileInputStream fis = new FileInputStream("purityreports.out");
            final ObjectInputStream ois = new ObjectInputStream(fis);
            final Object deserializedObject = ois.readObject();
            if (deserializedObject instanceof List) {
                main.setPurityReports( (List<WaterPurityReport>) deserializedObject);
            } else {
                System.out.println("Not expected to deserialize " + deserializedObject.getClass().getName());
            }
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        List<List<Float>> averagePPM = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            averagePPM.add(new ArrayList<>());
        }
        if (type.equals("virus")) {
            for (WaterPurityReport report : main.getWaterReportTracker().getPurityReports()) {
                if (report.getLocation().equals(location) && report.getDate().getYear() == year) {
                    averagePPM.get(report.getDate().getMonthValue()).add(report.getVirusPPM());
                }
            }
        } else if (type.equals("contaminant")) {
            for (WaterPurityReport report : main.getWaterReportTracker().getPurityReports()) {
                if (report.getLocation().equals(location) && report.getDate().getYear() == year) {
                    averagePPM.get(report.getDate().getMonthValue()).add(report.getContaminantPPM());
                }
            }
        } else {
            System.out.println("Error: type in setMainApp of ViewHistoryGraphController was not valid");
            return;
        }
        XYChart.Series<String, Float> series = new XYChart.Series<>();
        series.setName("Months");
        for (int i = 1; i < 12; i++) {
            if (averagePPM.get(i).size() == 0) {
                series.getData().add(new XYChart.Data<String, Float>(months[i], 0f));
            } else {
                float total = 0;
                for (float f: averagePPM.get(i)) {
                    total += f;
                }
                series.getData().add(new XYChart.Data<String, Float>(months[i],
                        (total / averagePPM.get(i).size())));
            }
        }
        HistoryGraph.getData().add(series);
    }
}
