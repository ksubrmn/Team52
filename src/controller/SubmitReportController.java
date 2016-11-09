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
import model.WaterType;

public class SubmitReportController {

    private Main main;

    @FXML
    Button CancelReportButton;

    @FXML
    ComboBox waterType;

    @FXML
    ComboBox waterCondition;

    @FXML
    TextField timeField;

    @FXML
    DatePicker dateField;

    @FXML
    TextField latField;

    @FXML
    TextField longField;

    /**
     * Sets Main application state
     * @param main The facade
     */
    public void setMainApp(Main main) {
        this.main = main;

        ObservableList<WaterType> list = FXCollections.observableArrayList();
        for (WaterType type: WaterType.values()) {
            list.add(type);
        }
        waterType.setItems(list);
        waterType.getSelectionModel().select(0);


        ObservableList<WaterCondition> list1 = FXCollections.observableArrayList();
        for (WaterCondition type: WaterCondition.values()) {
            list1.add(type);
        }
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
            if (main.getWaterReportTracker().addSourceReport(dateField.getValue(),
                    timeField.getText(), latitude, longitude,
                    main.getUser().getUsername(),
                    (WaterType) waterType.getSelectionModel().getSelectedItem(),
                    (WaterCondition) waterCondition.getSelectionModel().getSelectedItem())) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Water Report Created");
                alert.setHeaderText("Report created");
                alert.setContentText("Water Report #" + main.getWaterReportTracker().sourceReportSize()
                        + " created by " + main.getUser().getUsername());
                alert.showAndWait();
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
            alert.setContentText("Make sure Latitude and Longitude are valid numbers");
            alert.showAndWait();
        }
    }
}
