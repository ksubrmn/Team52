package controller;

import com.lynden.gmapsfx.GoogleMapView;
import fxapp.Main;
import javafx.fxml.FXML;

public class MapScreenController {

    private Main main;

    @FXML
    private GoogleMapView mapView;

    public void handleBackPressed() {
        main.showApplicationScreen();
    }

    public void setMainApp(Main main) {
        this.main = main;
    }
}
