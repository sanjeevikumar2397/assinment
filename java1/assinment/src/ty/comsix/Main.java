package ty.comsix;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the lower range");
		int lowerRange=s.nextInt();
		System.out.println("enter the upper range");
		int upperRange=s.nextInt();
		int result=UserMainCode.addPalindromes(lowerRange, upperRange);
		System.out.println(result);
	}

}
