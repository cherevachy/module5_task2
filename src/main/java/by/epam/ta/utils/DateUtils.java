package by.epam.ta.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");

	public static String getDate(int month) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, month);
		Date date = cal.getTime();
		return dateFormat.format(date);
	}
}
