package com.cm.easydates;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateConverterTest {

    @Test
    void testFormatDateValid() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2025-07-11");

        String formatted = DateConverter.formatDate(date, "dd/MM/yyyy");
        assertEquals("11/07/2025", formatted);
    }

    @Test
    void testFormatDateWithTime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse("2025-07-11 15:45");

        String formatted = DateConverter.formatDate(date, "EEEE dd MMM yyyy 'à' HH'h'mm");
        assertNotNull(formatted);
    }

    @Test
    void testFormatDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateConverter.formatDate(null, "dd/MM/yyyy");
        });
    }

    @Test
    void testFormatDateInvalidPattern() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateConverter.formatDate(new Date(), "");
        });
    }
}
