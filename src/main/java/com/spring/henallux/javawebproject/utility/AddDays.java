package com.spring.henallux.javawebproject.utility;

import java.util.Calendar;
import java.util.Date;

public class AddDays {

	public static Date addDays(Date date, int nbDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		for (int i = 0; i < nbDays; i++) {
			do {
				cal.add(Calendar.DATE, 1);
			} while (isSaturdayOrSunday(cal));
		}
		return cal.getTime();
	}

	private static boolean isSaturdayOrSunday(Calendar cal) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
	}
}
