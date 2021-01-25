/*
 * This is only for an interview purpose in Allianz Technology,
 * This code is developed by 4 interview candidates.
 * This is written in free version Java 8 .
 * This is written in spring boot version 2.4.2 .
 * This is an open source .
 * This code meets most of the SOLID principles.
 * No Copyrights or no rights reserved .
 * Any one can use this code for their organization, personal or learning purposes.
 * ANY ONE CAN ALTER THIS CODE OR THIS FILE.
 * @author Team Player-1
 * @author Team Player-2
 * @author Team Player-3
 * @author Team Player-4
 */
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
