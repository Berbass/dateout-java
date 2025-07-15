package test.java.date_processing;

import org.junit.jupiter.api.Test;
import utils.DateProcessing;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class GetCurrentCenturyTest {
    @Test
    void testGetCurrentCentury() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        assertEquals(currentYear, DateProcessing.getCurrentCentury() + currentYear % 100,
                     "The current century should match the current year.");
    }
}
