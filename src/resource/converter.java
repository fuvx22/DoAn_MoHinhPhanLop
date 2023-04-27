package resource;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class converter {
	public static java.sql.Date toSQLDate(java.util.Date date) {
		String temp = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return Date.valueOf(temp);
	}
}
