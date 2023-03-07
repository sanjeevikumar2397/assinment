package com.te.pdfgenerator;

public class abc {
	public static void main(String[] args) {

		char[] arr = { '1', '2', '1', '1', '0', '0' };
		char[] newArray = new char[6];
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != 'a') {
				int count = 1;
				for (int j = i+1 ; j < arr.length; j++) {

					if (arr[i] == arr[j]) {
						count++;
						newArray[i] = arr[j];
						arr[j] ='a';
						//System.out.println(arr[j]);
					} else if (count == 1) {
						newArray[newArray.length - 1] = arr[i];
					}
				}
			}

		}

		for (int i = 0; i < newArray.length; i++) {

			System.out.print(newArray[i]);

		}
	}
}
