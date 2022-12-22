package ty.comfive;

public class UserMainCode {
	public static int countNumber(int number) {
		int a = number;
		int b = number/10;
		int count = 0;
		while (a != 0) {
			int lastNumber = a % 10;
			while (b != 0) {
				int lastnumber2 = b % 10;
				if (lastNumber == lastnumber2) {
					count++;
				}
				b = b / 10;

			}
			a = a / 10;

		}
		return count;
	}

}
