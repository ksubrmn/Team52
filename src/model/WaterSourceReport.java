package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/**
 * Represents a water source report
 */
public class WaterSourceReport implements Serializable{
    private final LocalDate date;
    private final String time;
    private final int reportNumber;
    private final String reporterName;
    private final float latitude;
    private final float longitude;
    private final WaterType waterType;
    private final WaterCondition waterCondition;


    //Getters and setters for properties

    /**
     * Returns the date
     * @return the date
     */
    public ChronoLocalDate getDate() {return date; }
    //public void setDate(LocalDate date) { this.date = date; }

    /**
     * Returns the time
     * @return the time
     */
    public String getTime() {return time; }
    //public void setTime(String time) { this.time = time; }

    /**
     * Returns the report number
     * @return the report number
     */
    public int getReportNumber() { return reportNumber; }

    //public void setReportNumber(int reportNumber) {
    // this.reportNumber = reportNumber; }

    /**
     * Returns the reporter name
     * @return the reporter name
     */
    public String getReporterName() { return reporterName; }

    //public void setReporterName(String reporterName) {
    // this.reporterName = reporterName; }

    /**
     * Returns the latitude
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

/*    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }*/

/*    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }*/

    /**
     * Returns the water type
     * @return the water type
     */
    public WaterType getWaterType() { return waterType; }
    //public void setWaterType(WaterType accountType) {
    // this.waterType = waterType; }

    /**
     * Returns the water condition
     * @return the water condition
     */
    public WaterCondition getWaterCondition() { return waterCondition; }
    //public void setWaterCondition(WaterCondition waterCondition) {
    // this.waterCondition = waterCondition; }

    /**
     * Creates new Water Source Report
     *
     * @param date the date the report was submitted
     * @param time the time the report was submitted
     * @param reportNumber the report number
     * @param reporterName the user who reported the source
     * @param latitude the latitude location of the source
     * @param longitude the longitude location of the source
     * @param waterType the type of water at the location
     * @param waterCondition the condition of the water at the location
     */
    public WaterSourceReport(LocalDate date, String time, int reportNumber,
                             String reporterName, float latitude,
                             float longitude, WaterType waterType,
                             WaterCondition waterCondition) {
        this.date = date;
        this.time = time;
        this.reportNumber = reportNumber;
        this.reporterName = reporterName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    @Override
    public String toString() {
        return "#" + reportNumber + " by " + reporterName;
    }

    /**
     * Returns a HTML-friendly description of the data
     * @return The HTML description
     */
    public String getDescription() {
        return "<h2>Report " + reportNumber + "</h2><br>Location: " + latitude
                + ", " + longitude + "<br>Type: " + waterType
                + "<br>Condition: " + waterCondition + "<br>Created by "
                + reporterName + " on " + date;
    }
}
