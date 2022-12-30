package arraylistassinment1;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the size of the array one");
			int size=s.nextInt();
			System.out.println("Enter the size of the array two");
			int size1=s.nextInt();
			UserMainCode.sortMergedArrayList(size,size1);
			
		}

}
