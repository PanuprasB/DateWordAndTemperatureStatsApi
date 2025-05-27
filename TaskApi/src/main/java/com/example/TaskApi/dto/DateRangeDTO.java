package com.example.TaskApi.dto;

public class DateRangeDTO {
    private String dateOne;
    private String dateTwo;


    public DateRangeDTO(String dateOne, String dateTwo) {
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
    }
    public String getDateOne() {
        return dateOne;
    }
    public void setDateOne(String dateOne) {
        this.dateOne = dateOne;
    }
    public String getDateTwo() {
        return dateTwo;
    }
    public void setDateTwo(String dateTwo) {
        this.dateTwo = dateTwo;
    }


}
