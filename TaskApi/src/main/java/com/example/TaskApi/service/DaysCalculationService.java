package com.example.TaskApi.service;

import com.example.TaskApi.model.CustomDate;
import com.example.TaskApi.utils.DateUtils;
import org.springframework.stereotype.Service;

@Service
public class DaysCalculationService {


    public int getNumberOfDays(String dateOne, String dateTwo) {
        CustomDate convertedDateOne = DateUtils.convertToCustomDate(dateOne);
        CustomDate convertedDateTwo = DateUtils.convertToCustomDate(dateTwo);
        return Math.abs(convertedDateOne.getDays() - convertedDateTwo.getDays());
    }


}
