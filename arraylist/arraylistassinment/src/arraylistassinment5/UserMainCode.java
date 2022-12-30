package arraylistassinment5;

import java.util.List;

public class UserMainCode {

	public static void arrayListSubtractor(List<Integer> list, List<Integer> list1) {
		for(int i=0;i<list.size();i++) {
		
			for(int j=0;j<list1.size();j++) {
				if(list.get(i)!=list1.get(j)) {
					System.out.println(list.get(i));
					
				}
				else
					System.out.println("hi");
			}
		}
		
	}

}
