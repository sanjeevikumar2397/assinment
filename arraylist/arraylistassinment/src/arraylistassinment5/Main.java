package arraylistassinment5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main  {
 public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter the size of 1st list ");
	int size=s.nextInt();
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<size;i++) {
		list.add(s.nextInt());
	}
	System.out.println("enter the size of 2nd list ");
	int size1=s.nextInt();
	List<Integer> list1=new ArrayList<Integer>();
	for(int i=0;i<size1;i++) {
		list.add(s.nextInt());
	}
	UserMainCode.arrayListSubtractor(list,list1);
	
}
}
