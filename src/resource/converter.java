package resource;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class converter {
	public static java.util.Date toSQLDate(Date date) {
		String temp = new SimpleDateFormat("MM-dd-yyyy").format(date);
		return Date.valueOf(temp);
	}
}
