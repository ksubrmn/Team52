package model;


/**
 * Created by kalyasubramanian1 on 10/12/16.
 */
public class WaterSourceReport {
    private String date;
    private String time;
    private int reportNumber;
    private String reporterName;
    private String location;
    private WaterType waterType;
    private WaterCondition waterCondition;


    //Getters and setters for properties

    public String getDate() {return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() {return time; }
    public void setTime(String time) { this.time = time; }

    public int getReportNumber() { return reportNumber; }

    public void setReportNumber(int reportNumber) { this.reportNumber = reportNumber; }

    public String getReporterName() { return reporterName; }

    public void setReporterName(String reporterName) { this.reporterName = reporterName; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public WaterType getWaterType() { return waterType; }
    public void setWaterType(WaterType accountType) { this.waterType = waterType; }

    public WaterCondition getWaterCondition() { return waterCondition; }
    public void setWaterCondition(WaterCondition waterCondition) { this.waterCondition = waterCondition; }

}
