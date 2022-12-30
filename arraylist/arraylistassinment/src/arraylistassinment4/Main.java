package arraylistassinment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		List<String> list=new ArrayList<String>();
		System.out.println("Enter the size of the list");
		int size= s.nextInt();
		for (int i = 0; i <size; i++) {
			list.add(s.next());
		}
		String[] res= UserMainCode.convertToStringArray(list);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
			
		}
	}

}
