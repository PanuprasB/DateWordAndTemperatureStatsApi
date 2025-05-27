package com.example.TaskApi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToTextUtilsTest {
    @Test
    void testTensNoOnes() {
        String result = NumberToTextUtils.processTens(20);
        assertEquals("dvidešimt ", result);
    }

    @Test
    void testTenWithones() {
        String result = NumberToTextUtils.processTens(22);
        assertEquals("dvidešimt du ", result);
    }

    @Test
    void testTensNoTensWithOnes() {
        String result = NumberToTextUtils.processTens(8);
        assertEquals("aštuoni ", result);
    }

    @Test
    void testTeens() {
        String result = NumberToTextUtils.processTens(13);
        assertEquals("trylika ", result);
    }

    @Test
    void testTensWithZero() {
        String result = NumberToTextUtils.processTens(0);
        assertEquals("", result);
    }

    @Test
    void testTensWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberToTextUtils.processTens(-5);
        });
        assertEquals("Invalid number: -5", exception.getMessage());
    }
}