package priceCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Map<String,Float> map=new HashMap<String, Float>();
		
		System.out.println("enter the count");
		int size=s.nextInt();
		
		for(int i=0;i<size;i++) {
			map.put(s.next(),s.nextFloat());
		}
		System.out.println("how many devices");
		int devices=s.nextInt();
		Float res=UserMainCode.arrayCalculator(map,devices);
		System.out.println(res);
	}

}
