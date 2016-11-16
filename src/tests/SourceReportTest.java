package tests;

import model.*;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Helen Stallworth on 11/15/2016.
 * Tests to check correctness of WaterReportTracker#addSourceReport
 */
public class SourceReportTest {

    /**
    @ org.junit.Before
    public void setUp() throws Exception {


    } */

    @org.junit.Test
    public void addAccount() throws Exception {
        WaterReportTracker tracker = new WaterReportTracker();
        LocalDate date = LocalDate.now();

        assertTrue(tracker.addSourceReport(date, "12:00", 10, 16, "Username",
                WaterType.Bottled, WaterCondition.Potable));
        assertFalse(tracker.addSourceReport(date, "12:00", 10, 16, "Username",
                WaterType.Bottled, WaterCondition.Potable));

    }

    /**
    @org.junit.After
    public void tearDown() throws Exception {

    }
    */
}
