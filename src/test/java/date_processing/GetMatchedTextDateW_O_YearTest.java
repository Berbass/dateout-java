package test.java.date_processing;

import org.junit.jupiter.api.Test;
import utils.DateProcessing;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetMatchedTextDateW_O_YearTest {
    @Test
    void testDDMMMM_FrDate() {
        String input = "10 Octobre";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentYear(), Calendar.OCTOBER, 10, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testMMMDD_UnspacedFrDate() {
        String input = "fév13";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentYear(), Calendar.FEBRUARY, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMM_EnDate() {
        String input = "13 Apr";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentYear(), Calendar.APRIL, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testMMMMDD_UnspacedEnDate() {
        String input = "June13";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentYear(), Calendar.JUNE, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }
}
