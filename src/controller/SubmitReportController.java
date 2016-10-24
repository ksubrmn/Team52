package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.AccountType;
import model.WaterCondition;
import model.WaterType;
import model.User;

import java.time.LocalDate;

public class SubmitReportController {

    private Main main;
    private User user;

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
     * @param main
     */
    public void setMainApp(Main main, User user) {
        this.main = main;
        this.user = user;
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
            if (main.getWaterReportTracker().addReport(dateField.getValue(),
                    timeField.getText(), latitude, longitude,
                    main.getUser().getUsername(),
                    (WaterType) waterType.getSelectionModel().getSelectedItem(),
                    (WaterCondition) waterCondition.getSelectionModel().getSelectedItem())) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Water Report Created");
                alert.setHeaderText("Report created");
                alert.setContentText("Water Report #" + main.getWaterReportTracker().size()
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
