package ty.comtwo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your number");
		int num=s.nextInt();
		int result=UserMainCode.addNumber(num);
		System.out.println(result);
}
}