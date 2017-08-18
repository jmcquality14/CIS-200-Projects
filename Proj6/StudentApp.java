/**
 * StudentApp.java
 * Jackson McQuality / Lab Section Thursday 4:00 - 6:00 / Atef Khan>
 *
 * The method is meant to store information on student's standings in the CIS 200 class. The program prompts the user for a student's information ( such as Name, WID, and Points earned per category in the class). Using this
 * information, the program calculates a student's overall letter grade in the class. After entering all the student's information ( max of 50), the program displays information on all the student's who where enter. information
 * includes Student's Name, WID, Class Letter Grade, and Overall Class Percent. 
 */ 

import java.util.*;

public class StudentApp {
	
	public static void main ( String [] Args ) {
				
		Scanner s = new Scanner (System.in);

		// total points per category
			final double totalCodeLabPts = 225;
			final double totalExamPts = 150;
			final double totalFinalExamPts = 100;		
			System.out.print("Enter the total points possible for LABS: ");
			final double totalLabPts = Integer.parseInt(s.nextLine());
			System.out.print("Enter the total points possible for PROJECTS: ");
			final double totalProjectPts = Integer.parseInt(s.nextLine());
			final double totalPtsPossible = ( totalCodeLabPts + totalLabPts + totalExamPts + totalFinalExamPts + totalProjectPts );
		
		int numOfStudents = 0;
		Student [] studentArray = new Student[50];
		boolean repeat = true;
		
		do {
			
			studentArray[ numOfStudents ] = StudentInfo();
			studentArray[ numOfStudents ].calculate( totalPtsPossible , totalCodeLabPts , totalLabPts , totalProjectPts , totalExamPts , totalFinalExamPts  );
			numOfStudents++;
			System.out.println("\n" + numOfStudents + " Student(s) entered so far.");
			
			if (  numOfStudents < 51  ) {
				
				System.out.println("Up to 50 students can be entered.");
				System.out.print("Would you like to enter another student? ( Y or N ): ");
					
					boolean invalid = true;
					do {
						String input = s.nextLine();
						char Answer = input.charAt(0);
						
						if ( ( Answer == 'y' ) || ( Answer == 'Y' ) ) {
							repeat = true;
							invalid = false;
						} else if ( ( Answer == 'n' ) || ( Answer == 'N' ) ) {
							repeat = false;
							invalid = false;
						} else {
							System.out.println("Invalid Response!");
							System.out.print("Would you like to enter another student? ( Y or N ): ");
						}
						
					} while ( invalid );
					
			} else {
				repeat = false;
			}
			
		} while ( ( numOfStudents < 50 ) && ( repeat ) );
		
		for ( int index = 0; index < numOfStudents ; index++ ) {
			System.out.println( studentArray[index].toString() ); 
			String spacebarPressed = s.nextLine();
		}
		
		System.out.println("All Students Displayed...");
		
	} // end of main
	
/////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Method is used to gather information from the user about the user
	 *
	 * @param Void, Takes no parameter
	 * 
	 * @return Student Object that holds the points earned in each catergory of class
	 */
	
	public static Student StudentInfo() {
		
		Scanner s = new Scanner (System.in);
		
		System.out.print("\nEnter the student's name ( firstname lastname ): ");
		String name = s.nextLine();
		
		System.out.print("Enter the student's WID: ");
		String WID = s.nextLine();
		
		System.out.print("\nEnter the students total for all LABS: ");
		double LabPoints = Double.parseDouble(s.nextLine());
		
		System.out.print("Enter the students total for all PROJECTS: ");
		double ProjectPoints = Double.parseDouble(s.nextLine());
		
		System.out.print("Enter the students score for CODELABS: ");
		double CodeLabPoints = Double.parseDouble(s.nextLine());
		
		System.out.print("Enter the students total for the 3 CLASS EXAMS: ");
		double ClassExamPoints = Double.parseDouble(s.nextLine());
		
		System.out.print("Enter the students score for the FINAL EXAM: ");
		double FinalExamPoints = Double.parseDouble(s.nextLine());
				
		Student studentInformation = new Student( WID , name , LabPoints , CodeLabPoints , ProjectPoints , ClassExamPoints , FinalExamPoints );
				
		return studentInformation;
		
	} // end of StudentInfo
	
} // end of StudentApp