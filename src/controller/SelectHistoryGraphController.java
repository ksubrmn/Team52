package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SelectHistoryGraphController {

    private Main main;

    @FXML
    TextField LocationBox;

    @FXML
    Button CancelButton;

    @FXML
    RadioButton virusButton;

    @FXML
    RadioButton contaminantButton;

    @FXML
    TextField YearBox;

    /**
     * Handles submit button pressed event
     */
    public void handleSubmitPressed() {
        if (LocationBox.getText() != null && !LocationBox.getText().equals("")
                && YearBox.getText() != null && !YearBox.getText().equals("")) {
            try {
                int year = Integer.parseInt(YearBox.getText());
                if (virusButton.isSelected()) {
                    main.showViewHistoryGraphScreen(LocationBox.getText(), year, "virus");
                } else if (contaminantButton.isSelected()) {
                    main.showViewHistoryGraphScreen(LocationBox.getText(), year, "contam");
                } else {
                    System.out.println("Error: Neither Virus nor Contaminant Radio Button selected");
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error selecting history graph parameters");
                alert.setContentText("Year field did not contain a valid year");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error selecting history graph parameters");
            alert.setContentText("Not all fields filled in");
            alert.showAndWait();
        }
    }

    /**
     * Handles cancel button pressed event
     */
    public void handleCancelPressed() {
        main.showApplicationScreen();
    }

    /**
     * Sets main app state
     * Gets account list
     * @param main The facade
     */
    public void setMainApp(Main main) {
        this.main = main;
    }
}
