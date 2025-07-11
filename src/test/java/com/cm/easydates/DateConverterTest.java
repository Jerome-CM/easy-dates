package com.cm.easydates;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateConverterTest {

    @Test
    void testFormatDate_validInput_shouldReturnFormattedString() {
        Date date = new Date(0); // 1 Jan 1970
        String formatted = DateConverter.formatDate(date, "dd/MM/yyyy");
        assertEquals("01/01/1970", formatted);
    }

    @Test
    void testFormatDate_nullDate_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatDate(null, "dd/MM/yyyy"));
        assertEquals("Date must not be null.", exception.getMessage());
    }

    @Test
    void testFormatDate_blankPattern_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatDate(new Date(), "  "));
        assertEquals("Pattern must not be null or blank.", exception.getMessage());
    }

    @Test
    void testFormatLocalDate_validInput_shouldReturnFormattedString() {
        LocalDate date = LocalDate.of(2023, 7, 11);
        String formatted = DateConverter.formatLocalDate(date, "MM/dd/yyyy");
        assertEquals("07/11/2023", formatted);
    }

    @Test
    void testFormatLocalDate_nullInput_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatLocalDate(null, "dd/MM/yyyy"));
        assertEquals("LocalDate must not be null.", exception.getMessage());
    }

    @Test
    void testFormatLocalDate_blankPattern_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatLocalDate(LocalDate.now(), ""));
        assertEquals("Pattern must not be null or blank.", exception.getMessage());
    }

    @Test
    void testFormatLocalDateTime_validInput_shouldReturnFormattedString() {
        LocalDateTime dateTime = LocalDateTime.of(2025, 7, 11, 15, 30, 45);
        String formatted = DateConverter.formatLocalDateTime(dateTime, "yyyy-MM-dd HH:mm:ss");
        assertEquals("2025-07-11 15:30:45", formatted);
    }

    @Test
    void testFormatLocalDateTime_nullInput_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatLocalDateTime(null, "dd/MM/yyyy HH:mm"));
        assertEquals("LocalDateTime must not be null.", exception.getMessage());
    }

    @Test
    void testFormatLocalDateTime_blankPattern_shouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                DateConverter.formatLocalDateTime(LocalDateTime.now(), " "));
        assertEquals("Pattern must not be null or blank.", exception.getMessage());
    }

    @Test
    void testLocalDateToDate() {
        LocalDate localDate = LocalDate.of(2023, 7, 11);
        Date result = DateConverter.localDateToDate(localDate);
        assertNotNull(result);
    }

    @Test
    void testLocalDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 7, 11, 15, 30);
        Date result = DateConverter.localDateTimeToDate(localDateTime);
        assertNotNull(result);
    }

    @Test
    void testDateToLocalDate() {
        Date date = new Date();
        assertNotNull(DateConverter.dateToLocalDate(date));
    }

    @Test
    void testDateToLocalDateTime() {
        Date date = new Date();
        assertNotNull(DateConverter.dateToLocalDateTime(date));
    }

    @Test
    void testLocalDateToLocalDateTime() {
        LocalDate localDate = LocalDate.of(2023, 7, 11);
        LocalDateTime result = DateConverter.localDateToLocalDateTime(localDate);
        assertEquals(localDate.atStartOfDay(), result);
    }

    @Test
    void testLocalDateTimeToLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 7, 11, 10, 0);
        LocalDate result = DateConverter.localDateTimeToLocalDate(localDateTime);
        assertEquals(localDateTime.toLocalDate(), result);
    }

    @Test
    void testNullInputsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> DateConverter.localDateToDate(null));
        assertThrows(IllegalArgumentException.class, () -> DateConverter.localDateTimeToDate(null));
        assertThrows(IllegalArgumentException.class, () -> DateConverter.dateToLocalDate(null));
        assertThrows(IllegalArgumentException.class, () -> DateConverter.dateToLocalDateTime(null));
        assertThrows(IllegalArgumentException.class, () -> DateConverter.localDateToLocalDateTime(null));
        assertThrows(IllegalArgumentException.class, () -> DateConverter.localDateTimeToLocalDate(null));
    }
}
