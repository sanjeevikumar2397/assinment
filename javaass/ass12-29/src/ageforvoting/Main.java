package ageforvoting;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the string");
		String res=UserMainCode.getAge(s.next());
		System.out.println(res);
	}

	
}
