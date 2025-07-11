package com.cm.easydates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for converting and formatting dates.
 */
public class DateConverter {

    /**
     * Formats a {@link Date} object into a string using the given pattern.
     *
     * @param date    The {@link Date} to format. Must not be null.
     * @param pattern The desired date pattern (e.g. "dd/MM/yyyy", "yyyy-MM-dd HH:mm").
     * @return A formatted date string.
     * @throws IllegalArgumentException if date is null or pattern is null/blank.
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null.");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Pattern must not be null or blank.");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * Formats a {@link LocalDate} object into a string using the given pattern.
     *
     * @param localDate The {@link LocalDate} to format. Must not be null.
     * @param pattern   The desired date pattern (e.g. "dd/MM/yyyy").
     * @return A formatted date string.
     * @throws IllegalArgumentException if localDate is null or pattern is null/blank.
     */
    public static String formatLocalDate(LocalDate localDate, String pattern) {
        if (localDate == null) {
            throw new IllegalArgumentException("LocalDate must not be null.");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Pattern must not be null or blank.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(formatter);
    }

    /**
     * Formats a {@link LocalDateTime} object into a string using the given pattern.
     *
     * @param localDateTime The {@link LocalDateTime} to format. Must not be null.
     * @param pattern       The desired date-time pattern (e.g. "dd/MM/yyyy HH:mm:ss").
     * @return A formatted date-time string.
     * @throws IllegalArgumentException if localDateTime is null or pattern is null/blank.
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            throw new IllegalArgumentException("LocalDateTime must not be null.");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Pattern must not be null or blank.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * Converts a {@link LocalDate} to a {@link Date} using the system default time zone.
     *
     * @param date the LocalDate to convert
     * @return the corresponding Date object
     * @throws IllegalArgumentException if the input is null
     */
    public static Date localDateToDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("LocalDate must not be null.");
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a {@link LocalDateTime} to a {@link Date} using the system default time zone.
     *
     * @param dateTime the LocalDateTime to convert
     * @return the corresponding Date object
     * @throws IllegalArgumentException if the input is null
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("LocalDateTime must not be null.");
        }
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a {@link Date} to a {@link LocalDate} using the system default time zone.
     *
     * @param date the Date to convert
     * @return the corresponding LocalDate object
     * @throws IllegalArgumentException if the input is null
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null.");
        }
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * Converts a {@link Date} to a {@link LocalDateTime} using the system default time zone.
     *
     * @param date the Date to convert
     * @return the corresponding LocalDateTime object
     * @throws IllegalArgumentException if the input is null
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null.");
        }
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Converts a {@link LocalDate} to a {@link LocalDateTime} at the start of the day.
     *
     * @param date the LocalDate to convert
     * @return the corresponding LocalDateTime object
     * @throws IllegalArgumentException if the input is null
     */
    public static LocalDateTime localDateToLocalDateTime(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("LocalDate must not be null.");
        }
        return date.atStartOfDay();
    }

    /**
     * Converts a {@link LocalDateTime} to a {@link LocalDate}, discarding the time part.
     *
     * @param dateTime the LocalDateTime to convert
     * @return the corresponding LocalDate object
     * @throws IllegalArgumentException if the input is null
     */
    public static LocalDate localDateTimeToLocalDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("LocalDateTime must not be null.");
        }
        return dateTime.toLocalDate();
    }
}
