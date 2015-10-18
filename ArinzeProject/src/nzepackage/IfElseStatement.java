package nzepackage;

import java.util.Scanner;

public class IfElseStatement {

	public static void main(String[] args) {
		
//		int age = 50;
		
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter your age:");
		int result = scan.nextInt();
		
		if(result >= 1 && result <=50){
		
		System.out.println("You are younger than me.");
		
		}else{
		
		System.out.println("You are older than me!");
		}
		
		}

	}


