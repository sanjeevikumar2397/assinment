package arraylistassinment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserMainCode {
   

	public static void sortMergedArrayList(int size, int size1) {
		Scanner s=new Scanner(System.in);
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i <size; i++) {
			list.add(s.nextInt());
		}
		List<Integer> list1=new ArrayList<Integer>();
		for (int i = 0; i <size1; i++) {
			list1.add(s.nextInt());
		}
		List<Integer> result=new ArrayList<Integer>(list);
		result.addAll(list1);
     	Collections.sort(result);

     	     	System.out.println(result.get(4));
     	     	System.out.println(result.get(6));
     		
     	
          	
			
		}
			
		
		
	}
	