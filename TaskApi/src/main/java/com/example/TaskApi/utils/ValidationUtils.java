package com.example.TaskApi.utils;

import com.example.TaskApi.model.CustomDate;

import java.time.LocalDate;

public class ValidationUtils {
    public static void validateNumber(int number) {
        if (number < 1 || number > 999999999) {
            throw new IllegalArgumentException("Number must be positive and smaller than a billion (1 to 999999999)");
        }
    }

    public static void validateDateRange(String dateOne, String dateTwo) {
        if (dateOne == null || dateTwo == null) {
            throw new IllegalArgumentException("You need to provide two dates");
        }
        if (dateOne.isEmpty() || dateTwo.isEmpty()) {
            throw new IllegalArgumentException("Dates cannot be empty");
        }
        validateDateFormat(dateOne);
        validateDateFormat(dateTwo);
    }

    public static void validateDateRangeForTemperatureStats(String dateOne, String dateTwo) {
        validateDateRange(dateOne, dateTwo);
        CustomDate startDate = DateUtils.convertToCustomDate(dateOne);
        CustomDate endDate = DateUtils.convertToCustomDate(dateTwo);

        CustomDate startDateLimit = DateUtils.convertToCustomDate("1940-01-02");

        LocalDate yesterday = LocalDate.now().minusDays(1);

        CustomDate endDateLimit = new CustomDate(yesterday.getYear(), yesterday.getMonthValue(),yesterday.getDayOfMonth() );

        if (startDate.getDays() > endDate.getDays()) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        if (startDate.getDays() < startDateLimit.getDays() || endDate.getDays() < startDateLimit.getDays()) {
            throw new IllegalArgumentException("Start and end dates must be after 1940-01-01");
        }
        if (endDate.getDays() > endDateLimit.getDays()) {
            throw new IllegalArgumentException("End date must be before today");
        }

    }

    private static void validateDateFormat(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid date format. Use YYYY-MM-DD");
        }
    }
}

