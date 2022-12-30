package discountrateculculation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

public class UserMainCode {

	public static void calculateDiscount(Map<String, String> map1, Map<String, Integer> map2) {
		Iterator<String> i=map1.keySet().iterator();
		while (i.hasNext()) {
			String string = (String) i.next();
			String dor=map1.get(string);
			Iterator<String>i2=map2.keySet().iterator();
			while (i2.hasNext()) {
				String string2 = (String) i2.next();
				Integer price=map2.get(string2);
				//System.out.println(LocalDate.now().compareTo(LocalDate.parse(dor))>=5);
				//System.out.println();
				
				if(string.equals(string2) &&LocalDate.now().compareTo(LocalDate.parse(dor))<=5&&price>=20000) {
					int price1=price*20/100;
					System.out.println(string+" :"+price1);
					break;
				}
				else if (string.equals(string2)&&LocalDate.now().compareTo(LocalDate.parse(dor))>=5&&price>=20000) {
					int price1=price*15/100;
					System.out.println(string+" :"+price1);
					break;
				}
				else if(string.equals(string2)&&price<=20000) {
					int price1=price*5/100;
					System.out.println(string+" :"+price1);
					break;
				}
				
				
				
			}
			
		}
		
	}

}
//A-1011
//2007-11-20
//25000
//B-1012
//2010-12-10
//30000
//C-1013
//2005-11-11
//15000
//D-1014
//2012-12-02
//10000