package ty.comseven;

public class UserMainCode {
	public static int getSumOfFiibos(int number) {
		int num1 = 0;
		int num2 = 1;
		int add = 1;
		for (int i = 2; i <number ; i++) {
			int sum = num1 + num2;
			add = add + sum;
			num1 = num2;
			num2 = sum;

		}
		return add;

	}
}