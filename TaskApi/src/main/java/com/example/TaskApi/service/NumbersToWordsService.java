package com.example.TaskApi.service;

import com.example.TaskApi.utils.NumberToTextUtils;

import org.springframework.stereotype.Service;

@Service

public class NumbersToWordsService {

    public String convertNumberToWords(int number) {
        StringBuilder words = new StringBuilder();
        if (number >= 1000000) {
            int millions = number / 1000000;

            words.append(processHundreds(millions));
            number %= 1000000;
            if (millions==1){
                words.append("milijonas ");
            }
            else if (millions % 100 >= 11 && millions % 100 <= 19 || millions % 10 == 0) {
                words.append("milijonų ");
            }
            else if (millions % 10 == 1) {
                words.append("milijonas ");
            }   else {
                words.append("milijonai ");
            }
        }
        if (number >= 1000) {
            int thousands = number / 1000;
            words.append(processHundreds(thousands));

            number %= 1000;
            if (thousands==1){
                words.append("tūkstantis ");
            }
            else if (thousands % 100 >= 11  && thousands % 100 <= 19|| thousands % 10 == 0) {
                words.append("tūkstančių ");

            }
            else if(thousands % 10 == 1) {
                words.append("tūkstantis ");
            } else {
                words.append("tūkstančiai ");
            }
        }
        if (number > 0) {
            words.append(processHundreds(number));

        }
        return words.toString();

    }


    public String processHundreds(int number) {
        StringBuilder words = new StringBuilder();
        int hundreds = number / 100;
        switch (hundreds) {
            case 0:
                words.append("");
                break;
            case 1:
                words.append("šimtas ");
                break;
            case 2:
                words.append("du šimtai ");
                break;
            case 3:
                words.append("trys šimtai ");
                break;
            case 4:
                words.append("keturi šimtai ");
                break;
            case 5:
                words.append("penki šimtai ");
                break;
            case 6:
                words.append("šeši šimtai ");
                break;
            case 7:
                words.append("septyni šimtai ");
                break;
            case 8:
                words.append("aštuoni šimtai ");
                break;
            case 9:
                words.append("devyni šimtai ");
                break;
            default:
                throw new IllegalArgumentException("Invalid number: " + number);
        }
        words.append(NumberToTextUtils.processTens(number % 100));
        return words.toString();

    }
}
