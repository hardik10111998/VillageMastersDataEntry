package com.hardik.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String convertTimeToString(Date date) {
		DateFormat df = new SimpleDateFormat("hh:mm aa");
		return df.format(date);
		
	}
}
