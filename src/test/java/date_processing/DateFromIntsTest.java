package test.java.date_processing;
import org.junit.jupiter.api.Test;
import utils.DateProcessing;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateFromIntsTest {
    @Test
    void testValidDate() {
        // Test the getDateFromInts method with valid date values
        int year = 2023;
        int month = 10; // October
        int day = 5;

        Date expectedDate = DateProcessing.getDateFromInts(year, month, day);

        assertNotNull(expectedDate, "The date should not be null.");

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.OCTOBER, day, 0, 0, 0);

        assertEquals(expectedDate.toString(), calendar.getTime().toString(),
                     "The date should match the expected date created from year, month, and day.");
    }

    @Test
    void testInvalidDate() {
        // Test the getDateFromInts method with invalid date values
        int year = 2023;
        int month = 13; // Invalid month
        int day = 5;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DateProcessing.getDateFromInts(year, month, day);
        });

        String expectedMessage = "Invalid date values provided.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "The exception message should indicate invalid date values.");
    }
}
