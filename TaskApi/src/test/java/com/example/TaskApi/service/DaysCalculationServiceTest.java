package com.example.TaskApi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysCalculationServiceTest {

    @Test
    void calculateDaysBetweenDates() {
        String dateOne = "2025-01-01";
        String dateTwo = "2025-01-10";

        DaysCalculationService service = new DaysCalculationService();
        int result = service.getNumberOfDays(dateOne, dateTwo);

        assertEquals(9, result);
    }

    @Test
    void calculateDaysBetweenIdenticalDates() {
        String dateOne = "2025-01-01";
        String dateTwo = "2025-01-01";

        DaysCalculationService service = new DaysCalculationService();
        int result = service.getNumberOfDays(dateOne, dateTwo);

        assertEquals(0, result);
    }

    @Test
    void calculateDaysBetweenWhenDateOneIsAfterDateTwo() {
        String dateOne = "2025-01-10";
        String dateTwo = "2025-01-01";

        DaysCalculationService service = new DaysCalculationService();
        int result = service.getNumberOfDays(dateOne, dateTwo);

        assertEquals(9, result);
    }

}