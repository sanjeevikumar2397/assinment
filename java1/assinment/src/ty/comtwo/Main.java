package ty.comtwo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter a number");
	int num=s.nextInt();
	int result=UserMainCode.sumOfSquareOfEvenDigit(num);
	System.out.println(result);
    
}
}