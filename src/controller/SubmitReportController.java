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
    TextField locationField;


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
    public void HandleSubmitButton() {

        if (main.getWaterReportTracker().addReport(dateField.getValue(),
                timeField.getText(), locationField.getText(),
                main.getUser().getUsername(),
                (WaterType) waterType.getSelectionModel().getSelectedItem(),
                (WaterCondition) waterCondition.getSelectionModel().getSelectedItem())) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Water Report Created");
            alert.setHeaderText("Report created");
            alert.setContentText("Water Report #" + main.getWaterReportTracker().size()
                    + " created by " + main.getUser().getUsername());
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
