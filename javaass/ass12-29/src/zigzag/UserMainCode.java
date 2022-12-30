package zigzag;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class UserMainCode {

	public static int getLastDayOfMonth(String next) {
		return LocalDate.parse(next).lengthOfMonth();
	
	}

}
