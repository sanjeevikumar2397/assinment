package discountrateculculation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the size");
		int size=s.nextInt();
		Map<String, String>map1=new HashMap<String, String>();
		Map<String, Integer>map2=new HashMap<String, Integer>();
		System.out.println("enter the (id,DOR,PRICE)");
		for(int i=0;i<size;i++) {
			String id=s.next();
			String dor=s.next();
			map1.put(id, dor);
			map2.put(id, s.nextInt());
		}
		System.out.println(map1);
		System.out.println(map2);
		UserMainCode.calculateDiscount(map1,map2);
	}

}
