/**    
* Proj1.java  
* Jackson McQuality/ Lab Section A Thursday 4:00pm-5:50pm/ Atef Khan   
*  
* Program Calculates a students Score based on his project and exam grades. Also determines how many X-Large pizzas to order for a Computer Science Gaming Club party   
*/ 
 
// imported directories
	import java.util.*;
	import java.text.*;

public class Proj1{
	public static void main (String [] args){
	
	Scanner s = new Scanner(System.in);
	String input; // Where user input is stored
	
	//Start of Overall grade percentage calculator
	
	double proj1_grade;
	System.out.print("Enter project score #1:(0-30): ");
	input=s.nextLine();
	proj1_grade=Double.parseDouble(input); //coverts string into double
	
	double proj2_grade;
	System.out.print("Enter project score #2:(0-30): ");
	input=s.nextLine();
	proj2_grade=Double.parseDouble(input);
	
	double proj3_grade;
	System.out.print("Enter project score #3:(0-30): ");
	input=s.nextLine();
	proj3_grade=Double.parseDouble(input);
	System.out.println(" ");
	
	double midTerm_grade;
	System.out.print("Enter the midterm exam score:(0-100): ");
	input = s.nextLine();
	midTerm_grade=Double.parseDouble(input);
	
	double FinalExam_grade;
	System.out.print("Enter the final exam score:(0-100): ");
	input = s.nextLine();
	FinalExam_grade=Double.parseDouble(input);
	
	// Calculations
	final double MAX_POINTS = 290.00; // CONSTANT
	double TotalPoints = proj1_grade + proj2_grade + proj3_grade + midTerm_grade + FinalExam_grade;
	double GradePercentage = TotalPoints / MAX_POINTS; 
	System.out.printf("Overall Grade Percentage: %.2f",GradePercentage*100);
	System.out.println("%");
	System.out.println(" ");
	
	// Start of Pizza Party Problem
	
	int num_of_people;
	System.out.print("What is the number of people expected at the pizza party? ");
	input = s.nextLine();
	num_of_people=Integer.parseInt(input);
	System.out.println(" ");
	
		final int SLICES_N_XL_PIZZA = 20; // CONSTANT number of slices in an XL pizza
		final int NUM_OF_SLICES_PER_PERSON = 2; // CONSTANT number of slices per person
		int num_of_slices = num_of_people * NUM_OF_SLICES_PER_PERSON; // number of slices needed
		int num_of_pizzas = 1;
		int leftover = SLICES_N_XL_PIZZA - num_of_slices;
		
		while (leftover < 0) // if more than one pizza is needed
		{
			num_of_pizzas = num_of_pizzas + 1;
			leftover = (SLICES_N_XL_PIZZA * num_of_pizzas) - num_of_slices;
		} //Close of While Loop
		
		System.out.printf("For %d people, that would be %d pizza(s) with each person having %d slices each.\n", num_of_people, num_of_pizzas, NUM_OF_SLICES_PER_PERSON);
		System.out.printf("There would be %d slice(s) leftover.\n", leftover );
			
	} //closs void
} // close class