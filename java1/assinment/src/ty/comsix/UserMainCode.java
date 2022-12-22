package ty.comsix;

public class UserMainCode {
	public static int addPalindromes(int lowerRange,int upperRange) {
		int add=0;
		for(int i=lowerRange;upperRange>i;i++) {
			int poliNumber=checkPolindromes(i);
			if(poliNumber!=1) {
				add=add+poliNumber;
				//System.out.println(poliNumber);
			}
		}
		return add;
	}
	public static int checkPolindromes(int lowerRange) {
		int lowerRange1=lowerRange;
		String reverse="";
		while(lowerRange1!=0) {
		int lastNumber1=lowerRange1%10;
		reverse=reverse+lastNumber1;
		lowerRange1=lowerRange1/10;
		}
		int polindrome2=Integer.parseInt(reverse);
		if(lowerRange1==polindrome2) {
			return lowerRange1;
		}
		else {
			return 1;
		}
	}

}
