package test.java.date_processing;

import org.junit.jupiter.api.Test;
import utils.DateProcessing;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TextMonthDateTest {
    @Test
    void testDDMMMMYYYY_FrDate() {
        String input = "10 Octobre 2022";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.OCTOBER, 10, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMMMYYYY_FrDate2() {
        String input = "1er janvier 2020";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMMYYYY_FrDate() {
        String input = "13 fév 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.FEBRUARY, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMMYYYY_FrDate2() {
        String input = "13 avr. 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.APRIL, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMMYY_FrDate() {
        String input = "13 avr. 25";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.APRIL, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testInvalidDDMMMYYYY_FrDate() {
        String input = "13 blah. 2023";

        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNull(actualDate, "The return value should be null.");
    }

    @Test
    void testMMMDDYYYY_EnDate() {
        String input = "Feb 13 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.FEBRUARY, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testMMMDDYYYY_EnDate2() {
        String input = "apr. 13 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.APRIL, 13, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testMMMDDYYYY_EnDate3() {
        String input = "Mar 2nd 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.MARCH, 2, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }


    @Test
    void testMMMDDYY_EnDate() {
        String input = "feb 3rd 23";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.FEBRUARY, 3, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMMYY_EnDate() {
        String input = "3rd feb 23";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.FEBRUARY, 3, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testYYYYMMMMDD_EnDate() {
        String input = "2023 October 5th";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedTextMonthDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }
}
