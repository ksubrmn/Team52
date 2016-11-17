package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a tracker
 */
public class WaterReportTracker implements Serializable {
    private  List<WaterSourceReport> sourceReports;
    private  List<WaterPurityReport> purityReports;

    /**
     * Sets the list of source reports to an existing list
     * @param sourceReports An existing list of sourceReports
     */
    public void setSourceReports(Collection<WaterSourceReport> sourceReports) {
        this.sourceReports = new ArrayList<>();
        this.sourceReports.addAll(sourceReports);
    }

    /**
     * Sets the list of purity reports to an existing list
     * @param purityReports An existing list of purityReports
     */
    public void setPurityReports(Collection<WaterPurityReport> purityReports) {
        this.purityReports = new ArrayList<>();
        this.purityReports.addAll(purityReports);
    }

    /**
     * Creates new Water Report Tracker
     */
    public WaterReportTracker() {
        sourceReports = new ArrayList<>();
        purityReports = new ArrayList<>();
    }


    /**
     * Adds a new Source Report to the list of Source Reports
     *
     * @param date the date of the report
     * @param time the time of the report
     * @param latitude the latitude of the location of the source
     * @param longitude the longitude of the location of the source
     * @param username the user who reported the source
     * @param waterType the type of water at the source
     * @param waterCondition the condition of the water at the source
     * @return true if the report was added
     */
    public boolean addSourceReport(LocalDate date, String time, float latitude,
                                   float longitude, String username,
                                   WaterType waterType,
                                   WaterCondition waterCondition) {
        WaterSourceReport newReport = new WaterSourceReport(date, time,
                sourceReports.size() +1, username, latitude, longitude,
                waterType, waterCondition );
        return sourceReports.add(newReport);
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

    /**
     * Adds a purity report to the list of purity reports
     *
     * @param date the date the report was submitted
     * @param time the time the report was submitted
     * @param username the user who submitted the report
     * @param latitude the latitude of the location of the water source
     * @param longitude the longitude of the location of the water source
     * @param waterCondition the water condition at the source
     * @param virusPPM the virus level in parts per million at the source
     * @param contaminantPPM the contaminant level in parts per million at the
     *                       source
     * @param location Where it happened
     * @return true if the report was added successfully
     */
    public boolean addPurityReport(LocalDate date, String time, String username,
                                   float latitude, float longitude,
                                   WaterCondition waterCondition,
                                   float virusPPM, float contaminantPPM,
                                   String location) {
        WaterPurityReport newReport = new WaterPurityReport(date, time,
                purityReports.size() + 1, username, latitude, longitude,
                waterCondition, virusPPM, contaminantPPM, location);
        return purityReports.add(newReport);
    }
}
