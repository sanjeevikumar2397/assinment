package priceCalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMainCode {

	public static Float arrayCalculator(Map<String, Float> map, int devices) {
		Scanner s=new Scanner(System.in);
		List<String>list=new ArrayList<String>();
		Float price= 0F;
		for(int i=0;i<devices;i++) {
			list.add(s.next());
		}

		Iterator<String> i=map.keySet().iterator();
		while (i.hasNext()) {
			String key = (String) i.next();
			Float value=map.get(key);
			for(int j=0;j<list.size();j++) {
				if(list.get(j).equals(key)) {
					price=price+value;
					
				}
			}
			
		}
		
			
			
		
		
		return price;
	}

}
