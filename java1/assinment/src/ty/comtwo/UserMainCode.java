package ty.comtwo;

public class UserMainCode {
	public static int sumOfSquareOfEvenDigit(int num) {
		int square=0;
		while(num!=0) {
			int values=num%10;
			if (values%2==0) {
				square=square+(values*values);
			}
		    num=num/10;
		}
		return square;
		
	}

}
