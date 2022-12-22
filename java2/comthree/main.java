package ty.comthree;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your number");
		int num=s.nextInt();
		int result=UserMainCode.getSumOfSquareOfDigits(num);
		System.out.println(result);
	}

}
