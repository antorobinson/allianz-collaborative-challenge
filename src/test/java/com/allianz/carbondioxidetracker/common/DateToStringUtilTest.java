package com.allianz.carbondioxidetracker.common;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DateToStringUtilTest {

    @Test
    public void testToString() {

        Date date = null ;
        Assertions.assertThat(DateToStringUtil.toString(date)).isNull() ;

        date = new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime() ;
        Assertions.assertThat(DateToStringUtil.toString(date)).isNotNull() ;
    }
}
