package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Represents a Water Purity Report
 */
public class WaterPurityReport implements Serializable{

    private final LocalDate date;
    private final String time;
    private final String reporterName;
    private final String location;
    private final float latitude;
    private final float longitude;
    private final float virusPPM;
    private final float contaminantPPM;
    private final int reportNumber;
    private final WaterCondition waterCondition;

    //Getters and setter for properties

    /**
     * Returns the date
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

   /* public void setDate(LocalDate date) {
        this.date = date;
    }*/

    /**
     * Returns the reporter name
     * @return the reporter name
     */
    public String getReporterName() {
        return reporterName;
    }

/*    public void setReporterName(String name) {
        this.reporterName = reporterName;
    }*/

    /**
     * Returns the latitude
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

/*    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }*/

    /**
     * Returns the longitude
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

/*    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }*/

    /**
     * Returns the report number
     * @return the report number
     */
    public int getReportNumber() {
        return reportNumber;
    }

/*    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }*/

    /**
     * Returns the virus PPM
     * @return the virus PPM
     */
    public float getVirusPPM() {
        return virusPPM;
    }

/*    public void setVirusPPM(int virusPPM) {
        this.virusPPM = virusPPM;
    }*/

    /**
     * Returns the contaminant PPM
     * @return the contaminant PPM
     */
    public float getContaminantPPM() {
        return contaminantPPM;
    }

/*    public void setContaminantPPM(int contaminantPPM) {
        this.contaminantPPM = contaminantPPM;
    }*/

    /**
     * Returns the water condition
     * @return the water condition
     */
    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

/*    public void setWaterCondition(WaterCondition waterCondition) {
        this.waterCondition = waterCondition;
    }*/

    /**
     * Returns the time
     * @return the time
     */
    public String getTime() {
        return time;
    }
/*
    public void setTime(String time) {
        this.time = time;
    }*/

    /**
     * Creates new Water Purity Report
     *
     * @param date the date the report was submitted
     * @param time the time the report was submitted
     * @param reportNumber the report number
     * @param reporterName the name of the user who reported
     * @param latitude the latitude of the water source
     * @param longitude the longitude of the water source
     * @param waterCondition the water condition at the source
     * @param virusPPM the virus count in parts per million at the source
     * @param contaminantPPM the contaminant count in parts per million at the
     *                       source
     * @param location Where it happened
     */
    public WaterPurityReport(LocalDate date, String time, int reportNumber,
                             String reporterName, float latitude,
                             float longitude,
                             WaterCondition waterCondition, float virusPPM,
                             float contaminantPPM, String location) {
        this.date = date;
        this.time = time;
        this.reportNumber = reportNumber;
        this.reporterName = reporterName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.waterCondition = waterCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.location = location;
    }

    @Override
    public String toString() {
        return "#" + reportNumber + " by " + reporterName;
    }


    /**
     * Returns a HTML-friendly description of the data
     * @return The HTML description
     */
//    public String getDescription() {
//        return "<h2>Report " + reportNumber + "</h2><br>Location: " + latitude
//                + ", " + longitude + "<br>Condition: " + waterCondition
//                + "<br>Virus PPM: " + virusPPM + "  Contaminant PPM: "
// + contaminantPPM
//                + "<br>Created by " + reporterName + " on " + date;
//    }

    /**
     * Gets the location name
     * @return The location name
     */
    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return "<h2>Report " + reportNumber + "</h2><br>Location: " + latitude
                + ", " + longitude
                + "<br>Condition: " + waterCondition + "<br>Created by "
                + reporterName + " on " + date;
    }
}
