package ty.comfour;

public class UserMainCode {
	public static int getLucky(int a, int b, int c) {

		int sum = 0;

		if ((a + b + c) >= 9 && (a + b) >= 9 && (b + c) <= 9 && (a + c) <= 9) {
			if (a + c <= 9 && b + c <= 9) {
				sum = a + b;
			} else
				sum = sum + b;

			sum = sum + c;
			System.out.println("if1");

		}

		if ((a + b + c) >= 9 && (c + b) >= 9 && (a + b) <= 9) {
			if (a + b <= 9) {
				sum = a + b;
			} else if ((b + c) >= 9) {
				sum = sum + c;

			} else
				sum = sum + b;
			System.out.println("if2");
		}
		if ((a + b + c) >= 9 && (a + b) >= 9 && (a + c) >= 9) {
			if ((b + c) >= 9 && (b + a) >= 9)
				sum = sum + c;
			else if (b + c <= 9) {
				sum = c + b;

			} else
				sum = sum + b;
			System.out.println("if3");
		}

		if ((a + b + c) <= 9) {
			sum = sum + a + b + c;
			System.out.println("if4");
		}

		if ((a + b + c) >= 9 && (a + b) >= 9 && (b + c) >= 9 && a + c <= 9) {
			sum = a + c;
			System.out.println("if5");
		}

		return sum;
	}
}