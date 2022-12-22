package ty.comseven;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the number");
		int number=s.nextInt();
		int result=UserMainCode.getSumOfFiibos(number);
		System.out.println(result);
	}

}
