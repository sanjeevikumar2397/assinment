package arraylistassinment3;

import java.util.ArrayList;
import java.util.List;

public class UserMainCode {

	public static List<Integer> removeMultipleOfThree(List<Integer> list) {
		List<Integer> result =new ArrayList<Integer>();
		result.addAll(list);
		for(int i=0;i<result.size();i++) {
			if(i%3==0) {
				result.remove(list.get(i));
				
			}
		}
				return result;
		
	}

}
