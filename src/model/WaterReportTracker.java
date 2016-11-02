package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fxapp.Main;

public class WaterReportTracker {
    private List<WaterSourceReport> sourceReports;
    private List<WaterPurityReport> purityReports;
    private Main main;

    public WaterReportTracker() {
        sourceReports = new ArrayList<>();
        purityReports = new ArrayList<>();
    }

    public boolean addSourceReport(LocalDate date, String time, float latitude,
                                   float longitude, String username,
                                   WaterType waterType, WaterCondition waterCondition) {
        WaterSourceReport newReport = new WaterSourceReport(date, time,
                sourceReports.size() +1, username, latitude, longitude, waterType,
                waterCondition );
        sourceReports.add(newReport);
        return true;
    }

    /**
     * Returns the number of sourceReports being tracked
     * @return number of sourceReports
     */
    public int sourceReportSize() {
        return sourceReports.size();
    }

    /**
     * Gets the list of currently tracked sourceReports
     * @return the list of currently tracked sourceReports
     */
    public List<WaterSourceReport> getSourceReports() {
        return sourceReports;
    }

    /**
     * Gets the list of currently tracked purityReports
     * @return the list of currently tracked purityReports
     */
    public List<WaterPurityReport> getPurityReports() {
        return purityReports;
    }

    /**
     * Gets the number of purityReports being tracked
     * @return number of purityReports
     */
    public int purityReportSize() {
        return purityReports.size();
    }

    public boolean addPurityReport(LocalDate date, String time, String username,
                                   float latitude, float longitude,
                                   WaterCondition waterCondition, float virusPPM,
                                   float contaminantPPM) {
        WaterPurityReport newReport = new WaterPurityReport(date, time,
                purityReports.size() + 1, username, latitude, longitude,
                waterCondition, virusPPM, contaminantPPM);
        purityReports.add(newReport);
        return true;
    }
}
