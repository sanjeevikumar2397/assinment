package com.te.checkcharactersstring;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string :");
		int res=UserMainCode.checkCharacters(scanner.nextLine());
		if (res==1) {
			System.out.println("valid");
		}
		else
			System.out.println("invalid");
			
	

}
}