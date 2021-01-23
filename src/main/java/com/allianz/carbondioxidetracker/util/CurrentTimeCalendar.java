package com.allianz.carbondioxidetracker.util;

import java.util.Calendar;
import java.util.Date;

public class CurrentTimeCalendar {

	private CurrentTimeCalendar() {
	}

	public static Date getCurrentTimeUsingCalendar(){

		final Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}
