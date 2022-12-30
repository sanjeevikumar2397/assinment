package ageforvoting;

import java.time.LocalDate;

public class UserMainCode {
	static String getAge(String next) {
		 if(LocalDate.now().compareTo(LocalDate.parse(next))>=18) {
		return "eligible";
		 }
		 else
		return "not eligible";
	}


}
