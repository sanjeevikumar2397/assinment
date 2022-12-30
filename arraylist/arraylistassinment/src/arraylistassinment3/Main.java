 package arraylistassinment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the size of the array");
		int size= s.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i <size; i++) {
			list.add(s.nextInt());
			
		}
		List<Integer> res=UserMainCode.removeMultipleOfThree(list);
		for (Integer integer : res) {
			System.out.println(integer);
			
		}
	}

}
