package model;

import java.time.LocalDate;

public class WaterSourceReport {
    private LocalDate date;
    private String time;
    private int reportNumber;
    private String reporterName;
    private float latitude, longitude;
    private WaterType waterType;
    private WaterCondition waterCondition;


    //Getters and setters for properties

    public LocalDate getDate() {return date; }
    //public void setDate(LocalDate date) { this.date = date; }

    public String getTime() {return time; }
    //public void setTime(String time) { this.time = time; }

    public int getReportNumber() { return reportNumber; }

    //public void setReportNumber(int reportNumber) { this.reportNumber = reportNumber; }

    public String getReporterName() { return reporterName; }

    //public void setReporterName(String reporterName) { this.reporterName = reporterName; }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

/*    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }*/

/*    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }*/

    public WaterType getWaterType() { return waterType; }
    //public void setWaterType(WaterType accountType) { this.waterType = waterType; }

    public WaterCondition getWaterCondition() { return waterCondition; }
    //public void setWaterCondition(WaterCondition waterCondition) { this.waterCondition = waterCondition; }

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
                             String reporterName, float latitude, float longitude,
                             WaterType waterType, WaterCondition waterCondition) {
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
                + ", " + longitude + "<br>Type: " + waterType + "<br>Condition: "
                + waterCondition + "<br>Created by " + reporterName + " on " + date;
    }
}
