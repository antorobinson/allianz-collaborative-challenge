package com.allianz.carbondioxidetracker.util;

import java.util.Calendar;
import java.util.Date;

public class CurrentTimeCalendar {

	public static Date getCurrentTimeUsingCalendar(){
		Calendar calendar = Calendar.getInstance();
		Date date=calendar.getTime();
		return date;
	}
}
