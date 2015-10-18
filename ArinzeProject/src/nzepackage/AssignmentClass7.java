package nzepackage;

import java.util.Scanner;

public class AssignmentClass7 {

	public static void main(String[] args) {
		
//		Score ranges are 
//		0 - 39 = Failed
//		40 - 69 = Passed
//		70 - 100 = Excellent
		
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter your score:");
        String examscore = scan.nextLine();

        
        int ConvertToString = Integer.parseInt(examscore);
        
        if(ConvertToString <=39){
        System.out.println("You have failed the exam");
        
        if(ConvertToString <= 20){
        	System.out.println("You are not suppose to be in school...You are suppose to be selling cow !");
        }
	  
      }else if(ConvertToString == 40 || ConvertToString <=69) {
        System.out.println("You have passed");
        
      }else if(ConvertToString ==70 || ConvertToString <= 100) {
    	  System.out.println("You have an excellent result");
    	  if(ConvertToString >=90){
    		  System.out.println("You have won a scholarship!");
    	  }
    	  
      }else{
    	  System.out.println("Your score is not valid");
      }
}
	
}