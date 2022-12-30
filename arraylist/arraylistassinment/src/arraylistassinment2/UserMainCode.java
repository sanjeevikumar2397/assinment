package arraylistassinment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMainCode {

	public static void matchcharacter(int size) {
		Scanner s=new Scanner(System.in);
		List<String> list=new ArrayList<String>();
		for(int i=0;i<size;i++) {
			list.add(s.next());
		}
		
	}

}
