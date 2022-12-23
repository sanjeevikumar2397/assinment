package com.te.checkcharactersstring;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the input");
		String input = scanner.nextLine();
		System.out.println("Enter length of the string ");
		Integer length = scanner.nextInt();
		
		if (input.length()>2*length) {
			String result = FormingNewWord.formNewWord(input,length);
			System.out.println("New word is: "+result);
			
		}
		else {
			System.out.println("kindly enter the length of word is greater than enter length");
		}
		
	}
}