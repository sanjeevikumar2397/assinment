package com.te.checkcharactersstring;

public class UserMainCode {

	public static int checkCharacters(String nextLine) {
		if(nextLine.charAt(0)==nextLine.charAt(nextLine.length()-1)) {
			return 1;
		}
		else
			return -1;
	}

	
}
