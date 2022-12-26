package com.te.assignment2;

import java.util.StringTokenizer;

public class UserMainCode {

	public static Integer getSubstring(String input, String x) {

		Integer flag = 0;
		while (input.contains(x)) {

			flag++;
			input = input.replaceFirst(x, "-");

		}

		return flag;
	}

}
