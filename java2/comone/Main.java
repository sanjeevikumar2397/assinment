package ty.comone;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your number");
		int num=s.nextInt();
		int result=UserMainCode.sumOfOddEvenPosition(num);
        if (result==1) {
        	System.out.println(true);
		
		}
        else
        	System.out.println(false);
}
}