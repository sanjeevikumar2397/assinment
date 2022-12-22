package ty.com;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter a number");
		int number=s.nextInt();
		int result=Main1.checkSum(number);
				if (result==1) {
					System.out.println(number+"give number is even");
					
				}
				else
					System.out.println(number+"given number is odd");
	}

}
