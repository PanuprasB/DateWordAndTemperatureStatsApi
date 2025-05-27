package com.example.TaskApi.utils;

import com.example.TaskApi.model.CustomDate;

public class DateUtils {

    public static CustomDate convertToCustomDate(String date) {
        String[] parts = date.split("-");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid date format");
        }
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return new CustomDate(year, month, day);
    }


}
