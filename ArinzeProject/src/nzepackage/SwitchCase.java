package nzepackage;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		Scanner dataa = new Scanner(System.in);
		System.out.println("Please Enter your score:");
		String examdata = dataa.nextLine();
		
		int ConvertToInteger = Integer.parseInt(examdata);
		
		switch(ConvertToInteger){
		case 39:
			System.out.println("You have failed the exam again!");
		    break;
		case 69:
			System.out.println("You have passed!");
		    break;
		
		case 100:
			System.out.println("You have an excellent result");
			break;
			
		default:
			System.out.println("Your score is not valid for this entry");
		}

	}

}
