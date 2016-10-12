package model;
import java.util.ArrayList;
import java.util.List;
import fxapp.Main;
import model.User;
/**
 * Created by kalyasubramanian1 on 10/12/16.
 */
public class WaterReportTracker {
    private List<WaterSourceReport> reports;
    private Main main;

    public WaterReportTracker() {
        reports = new ArrayList<>();
    }



    public boolean addReport(String date, String time, String location,
                             WaterType waterType, WaterCondition waterCondition) {
        WaterSourceReport newReport = new WaterSourceReport(date, time,
                reports.size() +1, main.getUser().getUsername(),location, waterType, waterCondition );

        reports.add(newReport);


        return true;
    }

    public int size() {
        return reports.size();
    }
}
