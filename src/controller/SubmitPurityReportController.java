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
import model.User;
import model.WaterCondition;

public class SubmitPurityReportController {

    private Main main;
    private User user;

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





    /**
     * Sets Main application state
     * @param main
     */
    public void setMainApp(Main main, User user) {
        this.main = main;
        this.user = user;

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
            float virus = Float.parseFloat(virusField.getText());
            float con = Float.parseFloat(contaminantField.getText());
            if (main.getWaterReportTracker().addPurityReport(dateField.getValue(),
                    timeField.getText(),
                    main.getUser().getUsername(), latitude, longitude,
                    (WaterCondition) waterCondition.getSelectionModel().getSelectedItem(), virus, con)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Water Purity Report Created");
                alert.setHeaderText("Purity Report created");
                alert.setContentText("Water Purity Report #" + main.getWaterReportTracker().purityReportSize()
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
