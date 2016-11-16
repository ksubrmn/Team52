package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import model.WaterCondition;
import model.WaterReportTracker;

/**
 * Created by Christina Chung on 11/15/16.
 */
public class ReportTrackerTest {

    @org.junit.Test
    public void testPurityReport() throws Exception {

        WaterReportTracker w = new WaterReportTracker();
        LocalDate date = null;
        String time = "10:20";
        String username = "user";
        float latitude = (float) 34.4;
        float longitude = (float) 84.4;
        float virusPPM = (float) .3;
        float contaminantPPM = (float) 1.4;
        String location = "near";



        assertTrue(w.addPurityReport(date, time, username, latitude,
                longitude, WaterCondition.TreatableClear, virusPPM, contaminantPPM, location));

        assertEquals(w.purityReportSize(), 1);
        assertEquals(w.sourceReportSize(), 0);

        assertTrue(w.addPurityReport(date, time, username, latitude,
                longitude, WaterCondition.TreatableClear, virusPPM, contaminantPPM, location));

        assertEquals(w.purityReportSize(), 2);
        assertEquals(w.sourceReportSize(), 0);

    }

}
