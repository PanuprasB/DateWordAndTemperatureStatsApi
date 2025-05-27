package com.example.TaskApi.utils;

public class NumberToTextUtils {

    public static String processTens(int number) {

        StringBuilder words = new StringBuilder();
        int tens = number / 10;
        switch (tens) {
            case 0:
                words.append("");
                break;
            case 1:
                return processTeens(number);
            case 2:
                words.append("dvidešimt ");
                break;
            case 3:
                words.append("trisdešimt ");
                break;
            case 4:
                words.append("keturiasdešimt ");
                break;
            case 5:
                words.append("penkiasdešimt ");
                break;
            case 6:
                words.append("šešiasdešimt ");
                break;
            case 7:
                words.append("septyniasdešimt ");
                break;
            case 8:
                words.append("aštuoniasdešimt ");
                break;
            case 9:
                words.append("devyniasdešimt ");
                break;
            default:
                throw new IllegalArgumentException("Invalid number: " + number);
        }
        words.append(processOnes(number % 10));

        return words.toString();

    }

    public static String processTeens(int number) {
        switch (number) {
            case 10:
                return "dešimt ";
            case 11:
                return "vienuolika ";
            case 12:
                return "dvylika ";
            case 13:
                return "trylika ";
            case 14:
                return "keturiolika ";
            case 15:
                return "penkiolika ";
            case 16:
                return "šešiolika ";
            case 17:
                return "septyniolika ";
            case 18:
                return "aštuoniolika ";
            case 19:
                return "devyniolika ";
            default:
                throw new IllegalArgumentException("Invalid number: " + number);
        }
    }

    public static String processOnes(int number) {
        switch (number) {
            case 0:
                return "";
            case 1:
                return "vienas ";
            case 2:
                return "du ";
            case 3:
                return "trys ";
            case 4:
                return "keturi ";
            case 5:
                return "penki ";
            case 6:
                return "šeši ";
            case 7:
                return "septyni ";
            case 8:
                return "aštuoni ";
            case 9:
                return "devyni ";
            default:
                throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}
