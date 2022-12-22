package ty.comtwo;

public class UserMainCode {

	public static int addNumber(int num) {
		int sum = 1;
		for (int i = 2; i <= num; i++) {
			if (validateNumber(i)) {
				sum = sum + i;
			}

		}
		return sum;

	}

	public static boolean validateNumber(int n) {
		for (int j = 2; j < n; j++) {
			if (n % j == 0)
				return true;
			
		}

		return false;

	}

}
