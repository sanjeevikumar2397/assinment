package ty.comfour;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		int number = s.nextInt();
		int values=UserMainCode.getUnique(number);
		if(values>1)
			System.out.println("not unique");
		else
			System.out.println("unique");

	}
}