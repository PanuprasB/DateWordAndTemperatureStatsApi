package com.example.TaskApi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersToWordsServiceTest {
    private final NumbersToWordsService service = new NumbersToWordsService();

    @Test
    void testNumberToWordConversion_10012564() {
        int number = 10012564;
        String result = service.convertNumberToWords(number);
        assertEquals("dešimt milijonų dvylika tūkstančių penki šimtai šešiasdešimt keturi", result.trim());
    }

    @Test
    void testNumberToWordConversion_88813214() {
        int number = 88813214;
        String result = service.convertNumberToWords(number);
        assertEquals("aštuoniasdešimt aštuoni milijonai aštuoni šimtai trylika tūkstančių du šimtai keturiolika", result.trim());
    }

    @Test
    void testNumberToWordConversion_15782300() {
        int number = 15782300;
        String result = service.convertNumberToWords(number);
        assertEquals("penkiolika milijonų septyni šimtai aštuoniasdešimt du tūkstančiai trys šimtai", result.trim());
    }

    @Test
    void testNumberToWordConversion_56897100() {
        int number = 56897100;
        String result = service.convertNumberToWords(number);
        assertEquals("penkiasdešimt šeši milijonai aštuoni šimtai devyniasdešimt septyni tūkstančiai šimtas", result.trim());
    }

    @Test
    void testNumberToWordConversion_78000151() {
        int number = 78000151;
        String result = service.convertNumberToWords(number);
        assertEquals("septyniasdešimt aštuoni milijonai šimtas penkiasdešimt vienas", result.trim());
    }

    @Test
    void testNumberToWordConversion_1504011() {
        int number = 1504011;
        String result = service.convertNumberToWords(number);
        assertEquals("vienas milijonas penki šimtai keturi tūkstančiai vienuolika", result.trim());
    }

    @Test
    void testNumberToWordConversion_222222() {
        int number = 222222;
        String result = service.convertNumberToWords(number);
        assertEquals("du šimtai dvidešimt du tūkstančiai du šimtai dvidešimt du", result.trim());
    }

    @Test
    void testNumberToWordConversion_101101111() {
        int number =101101111 ;
        String result = service.convertNumberToWords(number);
        assertEquals("šimtas vienas milijonas šimtas vienas tūkstantis šimtas vienuolika", result.trim());
    }

    @Test
    void testNumberToWordConversion_103101111() {
        int number =103101111 ;
        String result = service.convertNumberToWords(number);
        assertEquals("šimtas trys milijonai šimtas vienas tūkstantis šimtas vienuolika", result.trim());
    }
    @Test
    void testNumberToWordConversion_101113111() {
        int number =101113111 ;
        String result = service.convertNumberToWords(number);
        assertEquals("šimtas vienas milijonas šimtas trylika tūkstančių šimtas vienuolika", result.trim());
    }

}