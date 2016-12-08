package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.WaterPurityReport;
import model.WaterSourceReport;
import netscape.javascript.JSObject;

/**
 * Represents the screen with a map on it
 */
public class MapScreenController implements Initializable,
        MapComponentInitializedListener {

    private Main main;
    private GoogleMap map;

    @FXML
    private GoogleMapView mapView;

    /**
     * Handles returning to menu from map via Back button
     */
    public void handleBackPressed() {
        main.showApplicationScreen();
    }

    /**
     * Initializes reference to facade
     * @param main the facade
     */
    public void setMainApp(Main main) {
        this.main = main;
        mapInitialized();
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();
        LatLong center = new LatLong(33.8, -84.4);
        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);
        map = mapView.createMap(options);
        for (WaterSourceReport report: main.getWaterReportTracker()
                .getSourceReports()) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(report.getLatitude(),
                    report.getLongitude());
            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title("Report: " + report.getReportNumber())
                    .icon("../media/paleblue_MarkerS");
            Marker marker = new Marker(markerOptions);
            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions
                                = new InfoWindowOptions();
                        infoWindowOptions.content(report.getDescription());
                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });
            map.addMarker(marker);
        }
        for (WaterPurityReport report: main.getWaterReportTracker()
                .getPurityReports()) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(report.getLatitude(),
                    report.getLongitude());
            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title("Report: " + report.getReportNumber())
                    .icon("../media/yellow_MarkerP");
            Marker marker = new Marker(markerOptions);
            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions
                                = new InfoWindowOptions();
                        infoWindowOptions.content(report.getDescription());
                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });
            map.addMarker(marker);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }
}
