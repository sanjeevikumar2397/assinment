package ty.comfour;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your 1st number");
		int a=s.nextInt();
		System.out.println("Enter your 2nd number");
		int b=s.nextInt();
		System.out.println("Enter your 3rd number");
		int c=s.nextInt();
		int result=UserMainCode.getLucky(a,b,c);
		System.out.println(result);


}
}