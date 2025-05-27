package com.example.TaskApi.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomDateTest {

    @Test
    void testValidDate(){
        CustomDate customDate = new CustomDate(2025, 5, 20);
        assertEquals(2025, customDate.getYear());
        assertEquals(5, customDate.getMonth());
        assertEquals(20, customDate.getDay());
    }
    @Test
    void testInvalidMonth(){

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomDate(2025, 13, 1);
        });
        assertEquals("Invalid month", exception.getMessage());

    }
    @Test
    void testInvalidDay(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomDate(2025, 10, 32);
        });
        assertEquals("Invalid day", exception.getMessage());

    }

    @Test
    void testValidMonthInvalidDay(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CustomDate(2025, 2, 30);
        });
        assertEquals("Invalid day", exception.getMessage());


    }





}