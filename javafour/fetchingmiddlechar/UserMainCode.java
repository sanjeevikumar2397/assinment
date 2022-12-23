package com.te.fetchingmiddlechar;

import java.util.StringTokenizer;

public class UserMainCode {

	public static void getMiddleChars(String next) {
        String res=new String(next);
		System.out.println(res.length());
		System.out.println(next.substring(res.length()/2-1,(res.length()/2)+1));
		
		
	}

}
