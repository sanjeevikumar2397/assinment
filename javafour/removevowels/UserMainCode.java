package com.te.removevowels;

public class UserMainCode {
	public static String removeEvenVowels(String input) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i =0; i< input.length(); i++) {
			if ((i % 2) == 0) {
				stringBuffer = stringBuffer.append(input.charAt(i));
			} else if ((i % 2) != 0) {
				if (input.charAt(i) != 'a' && input.charAt(i) != 'e' && input.charAt(i) != 'i' && input.charAt(i) != 'o'
						&& input.charAt(i) != 'u' && input.charAt(i) != 'A' && input.charAt(i) != 'E'
						&& input.charAt(i) != 'I' && input.charAt(i) != 'O' && input.charAt(i) != 'U') {

					stringBuffer = stringBuffer.append(input.charAt(i));

				}
			}

		}
		return stringBuffer.toString();

	}


}
