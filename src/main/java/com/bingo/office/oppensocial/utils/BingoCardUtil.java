package com.bingo.office.oppensocial.utils;

public class BingoCardUtil {

    public static int[] stringToIntArray(String numbersString) {

        numbersString = numbersString.replaceAll("\\[|\\]", "");

        String[] numbersStr = numbersString.split(",");

        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i].trim());
        }

        return numbers;
    }
}
