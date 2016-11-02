package model;

import java.time.LocalDate;

public class WaterPurityReport {

    private LocalDate date;
    private String time, reporterName;
    private float latitude, longitude, virusPPM, contaminantPPM;
    private int reportNumber;
    private WaterCondition waterCondition;

    //Getters and setter for properties

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String name) {
        this.reporterName = reporterName;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int reportNumber) {
        this.reportNumber = reportNumber;
    }

    public float getVirusPPM() {
        return virusPPM;
    }

    public void setVirusPPM(int virusPPM) {
        this.virusPPM = virusPPM;
    }

    public float getContaminantPPM() {
        return contaminantPPM;
    }

    public void setContaminantPPM(int contaminantPPM) {
        this.contaminantPPM = contaminantPPM;
    }

    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(WaterCondition waterCondition) {
        this.waterCondition = waterCondition;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WaterPurityReport(LocalDate date, String time, int reportNumber,
                             String reporterName, float latitude, float longitude,
                             WaterCondition waterCondition, float virusPPM,
                             float contaminantPPM) {
        this.date = date;
        this.time = time;
        this.reportNumber = reportNumber;
        this.reporterName = reporterName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.waterCondition = waterCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
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
                + ", " + longitude + "<br>Condition: " + waterCondition
                + "<br>Virus PPM: " + virusPPM + "  Contaminant PPM: " + contaminantPPM
                + "<br>Created by " + reporterName + " on " + date;
    }
}
