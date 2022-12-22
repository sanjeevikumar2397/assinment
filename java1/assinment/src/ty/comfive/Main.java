package ty.comfive;

import java.util.Scanner;

import ty.comfour.UserMainCode;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		int number = s.nextInt();
		int values=UserMainCode.getUnique(number);
		
			System.out.println(values);

	}

}
