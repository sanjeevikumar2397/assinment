package zigzag;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the string");
		int res=UserMainCode.getLastDayOfMonth(s.next());
		System.out.println(res);

}
}