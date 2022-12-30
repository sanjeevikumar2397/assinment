package arraylistassinment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UserMainCode {

	public static String[] convertToStringArray(List<String> list) {
		Collections.sort(list);
		String[] res=new String[list.size()];
		Iterator<String> res1=list.iterator();
		while (res1.hasNext()) {
			for (int i = 0; i < res.length; i++) {
				res[i]=res1.next();
				
			}
			
		}
		
		return res;
		
		
		
	}

}
