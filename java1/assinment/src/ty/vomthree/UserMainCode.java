package ty.vomthree;

public class UserMainCode {
	
	public static int reverseNumber(int number) {
		String reverse="";
		while(number!=0) {
			int lastNumber=number%10;
			reverse=reverse+lastNumber;
			number=number/10;
		}
		int reverseNumber=Integer.parseInt(reverse);
		return reverseNumber;
	}

}
