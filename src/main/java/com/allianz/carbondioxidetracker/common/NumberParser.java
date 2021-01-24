package com.allianz.carbondioxidetracker.common;

public class NumberParser {

    private NumberParser() {
    }

    public static int parseInt(String s) {

        if (IEmptyValidation.isEmpty(s)) return 0;

        try {
            return (int)Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static double parseDouble(String s) {

        if (IEmptyValidation.isEmpty(s)) return 0;

        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean isNumber(String s) {

        if (IEmptyValidation.isEmpty(s)) return false;

        try {
            Double.parseDouble(s);
            return true ;
        } catch (Exception e) {
            return false;
        }
    }

    public static String toString(Number s) {

        if (IEmptyValidation.isEmpty(s)) return "";

        return s.toString();
    }
}
