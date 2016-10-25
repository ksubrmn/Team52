package model;

import java.util.ArrayList;
import java.util.List;
import fxapp.Main;
import model.User;
import java.time.LocalDate;

public class WaterReportTracker {
    private List<WaterSourceReport> reports;
    private Main main;

    public WaterReportTracker() {
        reports = new ArrayList<>();
    }

    public boolean addReport(LocalDate date, String time, float latitude,
                             float longitude, String username,
                             WaterType waterType, WaterCondition waterCondition) {
        WaterSourceReport newReport = new WaterSourceReport(date, time,
                reports.size() +1, username, latitude, longitude, waterType,
                waterCondition );
        reports.add(newReport);
        return true;
    }

    /**
     * Returns the number of reports being tracked
     * @return number of reports
     */
    public int size() {
        return reports.size();
    }

    /**
     * Gets the list of currently tracked reports
     * @return the list of currently tracked reports
     */
    public List<WaterSourceReport> getReports() {
        return reports;
    }
}
