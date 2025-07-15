package test.java.date_processing;

import org.junit.jupiter.api.Test;
import utils.DateProcessing;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FullNumbersDateTest {
    @Test
    void testYYYYMMDD_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY MM DD format
        String input = "2023 10 05";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testObviousYYYYDDMM_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY DD MM format
        String input = "2024 15 07";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JULY, 15, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testDDMMYYYY_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY MM DD format
        String input = "05 10 2023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testObviousMMDDYYYY_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY DD MM format
        String input = "07 15 2024";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JULY, 15, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testInvalidMMDDYYYY_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY DD MM format
        String input = "15 15 2024";

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNull(actualDate, "The return value should be null.");
    }

    @Test
    void testInvalidYYYYMMDD_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYY DD MM format
        String input = "2024 15 15";

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNull(actualDate, "The return value should be null.");
    }

    @Test
    void testUnspacedYYYYMMMMDD_Date() {
        // Test the getMatchedFullNumbersDate method with a date in YYYYMMDD format
        String input = "20241005";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testUnspacedDDMMYYYY_Date() {
        // Test the getMatchedFullNumbersDate method with a date in DDMMYYYY format
        String input = "05102023";

        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testUnspacedDDMMYYYY_Date2() {
        String input = "20061960";

        Calendar calendar = Calendar.getInstance();
        calendar.set(1960, Calendar.JUNE, 20, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");
        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testNotSure8DigitsDate() {
        String input = "10110714";

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNull(actualDate, "The return value should be null for ambiguous dates.");
    }

    @Test
    void testNotSure8DigitsDate2() {
        String input = "19111106";

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNull(actualDate, "The return value should be null for ambiguous dates.");
    }

    @Test
    void testUnspacedYYMMDD_Date() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentYearShort = currentYear % 100;

        String twoDigitsYear = currentYearShort > 9 ? String.valueOf(currentYearShort) : "0" + currentYearShort;

        String input = twoDigitsYear + "1005";

        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testUnspacedYYMMDD_Date2() {
        String input = "431005";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentCentury() + 43, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testUnspacedDDMMYY_Date() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentYearShort = currentYear % 100;

        String twoDigitsYear = currentYearShort > 9 ? String.valueOf(currentYearShort) : "0" + currentYearShort;

        String input ="1005" + twoDigitsYear;

        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, Calendar.MAY, 10, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testUnspacedDDMMYY_Date2() {
        String input = "230457";

        Calendar calendar = Calendar.getInstance();
        calendar.set(DateProcessing.getCurrentCentury() + 57, Calendar.APRIL, 23, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testNotSure6Digits_Date() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentYearShort = currentYear % 100;

        if (currentYearShort > 31) {
            assertTrue(true);
            return; // Skip the test if the current year short cannot be a valid day date
        }

        String input = currentYearShort + "05" + currentYearShort;

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNull(actualDate, "The return value should be null for invalid date formats.");
    }

    @Test
    void testDDMMYY_Date() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentYearShort = currentYear % 100;

        String input = "05 10 " + (currentYearShort > 9 ? currentYearShort : "0" + currentYearShort);

        Calendar calendar = Calendar.getInstance();
        calendar.set(currentYear, Calendar.OCTOBER, 5, 0, 0, 0);

        Date expectedDate = calendar.getTime();
        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        assertNotNull(actualDate, "The matched date should not be null.");

        assertEquals(expectedDate.toString(), actualDate.toString(), "The matched date should match the expected date.");
    }

    @Test
    void testNotSureSpaced6Digits_Date() {
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentYearShort = currentYear % 100;

        if (currentYearShort > 31) {
            assertTrue(true);
            return; // Skip the test if the current year short cannot be a valid day date
        }

        String input = currentYearShort + " 05 " + currentYearShort;

        Date actualDate = DateProcessing.getMatchedFullNumbersDate(input);

        System.out.println("Input: " + input);

        assertNull(actualDate, "The return value should be null for invalid date formats.");
    }
}
