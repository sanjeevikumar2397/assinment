package ty.com;

public class Main1 {


		public static int checkSum(int number) {
			int add=0;
			while(number!=0) {
				int values=number%10;
				add=add+values;
				number=number/10;
			}
			if (add%2==0) {
				return 1;
			}
			else
				return -1;
		


}
}
