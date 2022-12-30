package leapyear;

import java.time.LocalDate;

public class UserMainCode {

	public static boolean isLeapYear(String next) {
		if(LocalDate.parse(next).isLeapYear())
		return true;
		return false;
	}

}
