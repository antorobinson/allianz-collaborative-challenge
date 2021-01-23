package com.allianz.carbondioxidetracker.common;

import java.util.Date;

public class DateToStringUtil {

    private DateToStringUtil() {
    }

    public static String toString(Date date) {

        if (IEmptyValidation.isEmpty(date)) return null ;

        return date.toString() ;
    }
}
