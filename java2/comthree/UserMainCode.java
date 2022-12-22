package ty.comthree;

public class UserMainCode {

	public static int getSumOfSquareOfDigits(int num) {
		int sum=0;
		while (num!=0) {
			int lastNumber=num%10;
			sum=sum+(lastNumber*lastNumber);
			num/=10;
			
			
		}
		return sum;
	}
}
