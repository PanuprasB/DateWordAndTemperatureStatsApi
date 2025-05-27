package com.example.TaskApi.model;

public class CustomDate {
    private final int year;
    private final int month;
    private final int day;
    private final int days;

    public CustomDate(int year, int month, int day) {
        if (year < 0) throw new IllegalArgumentException("Year must be between 0000 and 9999");
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month");
        if (!isValidDayOfTheMonth(year,month,day)) throw new IllegalArgumentException("Invalid day");
        this.year = year;
        this.month = month;
        this.day = day;
        this.days = calculateDays();

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getDays() {
        return days;
    }

    private int calculateDays() {
        int days = 0;

        for (int i = 0; i < this.year; i++) {
            if (isLeapYear(i)) {
                days += 1;
            }
            days += 365;
        }

        for (int i = 1; i < this.month; i++) {
            switch (i) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    days += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    days += 30;
                    break;
                case 2:
                    if (isLeapYear(this.year)) {
                        days += 29;
                    } else {
                        days += 28;
                    }
                    break;
            }
        }
        days += this.day;
        return days;
    }

    private boolean isValidDayOfTheMonth(int year, int month, int day) {
        if(day < 1 || day > 31) {
            return false;
        }
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            case 4: case 6: case 9: case 11:
                return day <= 30;
            default:
                return true;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}

