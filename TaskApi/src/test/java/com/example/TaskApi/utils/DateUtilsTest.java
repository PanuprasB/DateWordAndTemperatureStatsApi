package com.example.TaskApi.utils;


import com.example.TaskApi.model.CustomDate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {



    @Test
    void TestValidCustomDate() {
        String dateString = "2025-03-05";

        CustomDate result = DateUtils.convertToCustomDate(dateString);

        assertEquals(2025, result.getYear());
        assertEquals(3, result.getMonth());
        assertEquals(5, result.getDay());
    }



    @Test
    void TestCustomDateYearZero() {
        String dateString = "0000-02-04";

        CustomDate result = DateUtils.convertToCustomDate(dateString);

        assertEquals(0, result.getYear());
        assertEquals(2, result.getMonth());
        assertEquals(4, result.getDay());
    }
}