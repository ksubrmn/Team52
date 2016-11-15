package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.WaterCondition;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

public class SubmitPurityReportController {

    private Main main;

    @FXML
    Button CancelReportButton;

    @FXML
    DatePicker dateField;

    @FXML
    TextField timeField;

    @FXML
    TextField latField;

    @FXML
    TextField longField;

    @FXML
    ComboBox waterCondition;

    //ComboBox<WaterCondition> waterCondition;

    @FXML
    TextField virusField;

    @FXML
    TextField contaminantField;

    @FXML
    TextField LocationName;

    /**
     * Sets Main application state
     * @param main The facade
     */
    @SuppressWarnings("unchecked")
    public void setMainApp(Main main) {
        this.main = main;

        ObservableList<WaterCondition> list1 = FXCollections.observableArrayList();
        Collections.addAll(list1, WaterCondition.values());

        waterCondition.setItems(list1);
        waterCondition.getSelectionModel().select(0);
    }

    /**
     * Handles cancel button action
     */
    public void HandleCancelButton() {
        main.showApplicationScreen();
    }



    /**
     * Handles submit button action
     */
    public void HandleSubmitButton() {
        try {
            float latitude = Float.parseFloat(latField.getText());
            float longitude = Float.parseFloat(longField.getText());
            float virus = Float.parseFloat(virusField.getText());
            float con = Float.parseFloat(contaminantField.getText());
            if (main.getWaterReportTracker().addPurityReport(dateField.getValue(),
                    timeField.getText(),
                    main.getUser().getUsername(), latitude, longitude,
                    (WaterCondition) waterCondition.getSelectionModel().getSelectedItem(),
                    virus, con, LocationName.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Water Purity Report Created");
                alert.setHeaderText("Purity Report created");
                alert.setContentText("Water Purity Report #" + main.getWaterReportTracker().purityReportSize()
                        + " created by " + main.getUser().getUsername());
                alert.showAndWait();
                try
                {
                    final FileOutputStream fo = new FileOutputStream("purityreports.out");
                    final ObjectOutputStream oos = new ObjectOutputStream(fo);
                    oos.writeObject(main.getWaterReportTracker().getPurityReports());
                    oos.flush();
                    oos.close();

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                main.showApplicationScreen();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error creating new report");
                alert.setContentText("Report could not be created");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error creating new report");
            alert.setContentText("Make sure fields valid numbers");
            alert.showAndWait();
        }
    }
}
