package controller;

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
import netscape.javascript.JSObject;
import model.WaterSourceReport;
import java.net.URL;
import java.util.ResourceBundle;

public class MapScreenController implements Initializable, MapComponentInitializedListener{

    private Main main;
    private GoogleMap map;

    @FXML
    private GoogleMapView mapView;

    public void handleBackPressed() {
        main.showApplicationScreen();
    }

    public void setMainApp(Main main) {
        this.main = main;
        mapInitialized();
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();
        LatLong center = new LatLong(34, -88);
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
        for (WaterSourceReport report: main.getWaterReportTracker().getReports()) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(report.getLatitude(), report.getLongitude());
            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title("Report: " + report.getReportNumber());
            Marker marker = new Marker(markerOptions);
            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
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
