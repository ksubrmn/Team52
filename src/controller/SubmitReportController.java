package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.AccountType;
import model.WaterCondition;
import model.WaterType;

public class SubmitReportController {

    Main main;

    @FXML
    Button CancelReportButton;

    @FXML
    ComboBox waterType;

    @FXML
    ComboBox waterCondition;

    @FXML
    TextField timeField;

    @FXML
    TextField dateField;

    @FXML
    TextField locationField;

    /**
     * Sets Main application state
     * @param main
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
    public void HandleSubmitButton() {

        if (main.getWaterReportTracker().addReport(dateField.getText(),
                timeField.getText(), locationField.getText(),
                (WaterType) waterType.getSelectionModel().getSelectedItem(),
                (WaterCondition) waterCondition.getSelectionModel().getSelectedItem())) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Water Report Created");
            alert.setHeaderText("Report created");
            alert.setContentText("Water Report #" + main.getWaterReportTracker().size() + " created");
            alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error creating new report");
            alert.setContentText("Report could not be created");
            alert.showAndWait();
        }
    }
}
