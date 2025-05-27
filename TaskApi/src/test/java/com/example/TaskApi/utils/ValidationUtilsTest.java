package com.example.TaskApi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void testNumberInRange() {
        assertDoesNotThrow(() -> ValidationUtils.validateNumber(1150));
    }

    @Test
    void testNumberTooLarge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateNumber(1000000000);
        });
        assertEquals("Number must be positive and smaller than a billion (1 to 999999999)", exception.getMessage());
    }

    @Test
    void testNumberTooSmall() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateNumber(-1);
        });
        assertEquals("Number must be positive and smaller than a billion (1 to 999999999)", exception.getMessage());
    }
    @Test
    void testValidDateFormat() {
        assertDoesNotThrow(() -> ValidationUtils.validateDateRange("2025-01-01", "2025-01-02"));
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateDateRange("02-01-01", "2025-01-01");
        });
        assertEquals("Invalid date format. Use YYYY-MM-DD", exception.getMessage());
    }

    @Test
    void testCorrectDateRange() {
        assertDoesNotThrow(() -> ValidationUtils.validateDateRange("2025-01-01", "2025-12-31"));
    }

    @Test
    void testStartDateAfterEndDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateDateRangeForTemperatureStats("2025-12-31", "2025-01-01");
        });
        assertEquals("Start date must be before end date", exception.getMessage());
    }

    @Test
    void testStartDateEqualEndDate() {
        assertDoesNotThrow(() -> ValidationUtils.validateDateRange("2025-01-01", "2025-01-01"));
    }

    @Test
    void testStartDateBeforeLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidationUtils.validateDateRangeForTemperatureStats("1940-01-01", "2025-01-01");
        });
        assertEquals("Start and end dates must be after 1940-01-01", exception.getMessage());
    }


}