/**    
* Proj2.java  
* Jackson McQuality / Lab Section A Thursday 4:00-6:00pm / Atef Khan   
*  
* The following program determines a user's total savings after retirement by prompting the user for their level of education, their current age, and the age they plan on retiring. The program determines the user's total savings
* by multiplying the average yearly salary of workers with the same level of education as the user by the number of years until the user reaches their desire age of retirement. The program then compares the user's savings to the
* savings the user could have if the user had a higher or lower level of education.
*/

// Imported directories
import java.util.*;
import java.text.*;

public class Proj2
{	public static void main ( String [] args )
	{
		// Constants
		final int weeklyEarningsWithNoDegree = 493;
		final int weeklyEarningsWithHighSchoolDegree = 678;
		final int weeklyEarningsWithBachelorDegree = 1137;
		final int weeklyEarningsWithMasterDegree = 1341;
		final int weeklyEarningsWithDoctorateDegree = 1623;
		
		//Dollar amount format 
		DecimalFormat df = new DecimalFormat ("$###,###,###");
		
		// displays a menu
		System.out.println(" \t 1 = No Degree \n \t 2 = High School Degree \n \t 3 = Bachelor's Degree \n \t 4 = Master's Degree \n \t 5 = Doctorate Degree \n");
	
		// scanner for retrieving user input
		Scanner s = new Scanner(System.in);
		String input;
	
		int educationLevel = 0;	
		String Education = "education";
		int AnnualSalary = 0;
						
		System.out.print("Enter the number that corresponds to your degree: ");
		input = s.nextLine();
		educationLevel = Integer.parseInt(input);
		System.out.println(" ");
						
			if ( educationLevel == 1 )
			{
				Education = "No Degree";
				AnnualSalary = ( 52 * weeklyEarningsWithNoDegree );
			}
			else if ( educationLevel == 2 )
			{
				Education = "High School Degree";
				AnnualSalary = ( 52 * weeklyEarningsWithHighSchoolDegree );
			}
			else if ( educationLevel == 3 )
			{
				Education = "Bachelor's Degree";
				AnnualSalary = ( 52 * weeklyEarningsWithBachelorDegree );
			}
			else if ( educationLevel == 4 )
			{
				Education = "Masters Degree";
				AnnualSalary = ( 52 * weeklyEarningsWithMasterDegree );
			}
			else if ( educationLevel == 5 )
			{
				Education = "Doctorate Degree";
				AnnualSalary = ( 52 * weeklyEarningsWithDoctorateDegree );
			}
			else
			{
				System.out.print("You entered an invalid menu choice. \nPlease re-run the program and enter in a valid choice(1-5)." );
				System.exit(0);
			}
			
		int currentYear;
		System.out.print("Enter the current year: ");
		input = s.nextLine();
		currentYear = Integer.parseInt(input);
	
		int userAge;
		System.out.print("Enter your current age: ");
		input = s.nextLine();
		userAge = Integer.parseInt(input);
	
		int AgeOfRetirement;
		System.out.print("Enter planned age for retirement: ");
		input = s.nextLine();
		AgeOfRetirement = Integer.parseInt(input);
	
		System.out.println(" ");
		int yearsTillRetirement = AgeOfRetirement - userAge;
		int yearOfRetirement = currentYear + yearsTillRetirement;
		long amountMade = (AgeOfRetirement - userAge) * AnnualSalary;
				
		System.out.println("Based on current statistics and your " + Education);
		System.out.println("Your annual salary will be " + df.format(AnnualSalary) );
		System.out.println("Retiring at age " + AgeOfRetirement + " in " + yearOfRetirement  + " you will have a total of " + df.format(amountMade) );

		if ( educationLevel == 1)
		{
			System.out.println("With a High School Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithHighSchoolDegree ) * yearsTillRetirement ) - amountMade ) + " more than having no Degree." );
			System.out.println("With a Bachelor's Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithBachelorDegree ) * yearsTillRetirement ) - amountMade ) + " more than having no Degree." );
			System.out.println("With a Masters Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithMasterDegree ) * yearsTillRetirement ) - amountMade ) + " more than having no Degree." );
			System.out.println("With a Doctorate Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithDoctorateDegree ) * yearsTillRetirement ) - amountMade ) + " more than having no Degree." );
		}
		else if ( educationLevel == 2)
		{
			System.out.println("That is " + df.format( amountMade - ( (52 * weeklyEarningsWithNoDegree ) * yearsTillRetirement ) ) + " more than if you had no degree." );
			System.out.println("With a Bachelor's Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithBachelorDegree ) * yearsTillRetirement ) - amountMade ) + " more than having a High School Degree." );
			System.out.println("With a Masters Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithMasterDegree ) * yearsTillRetirement ) - amountMade )  + " more than having a High School Degree." );
			System.out.println("With a Doctorate Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithDoctorateDegree ) * yearsTillRetirement ) - amountMade ) + " more than having a High School Degree." );
		}
		else if ( educationLevel == 3)
		{	
			System.out.println("That is " + df.format( amountMade - ( (52 * weeklyEarningsWithHighSchoolDegree ) * yearsTillRetirement ) ) + " more than if you had a High School Degree." );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithNoDegree ) * yearsTillRetirement ) ) + " more than if you had no degree."  );
			System.out.println("With a Masters Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithMasterDegree ) * yearsTillRetirement ) - amountMade ) + " more than having a Bachelor's Degree." );
			System.out.println("With a Doctorate Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithDoctorateDegree ) * yearsTillRetirement ) - amountMade ) + " more than having a Masters Degree." );
		}
		else if ( educationLevel == 4)
		{
			System.out.println("That is " + df.format( amountMade - ( (52 * weeklyEarningsWithNoDegree ) * yearsTillRetirement ) ) + " more than if you had no degree." );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithHighSchoolDegree ) * yearsTillRetirement ) ) + " more than if you had a High School Degree."  );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithBachelorDegree ) * yearsTillRetirement ) ) + " more than if you had a Bachelor's Degree." );
			System.out.println("With a Doctorate Degree, you can earn " + df.format( ( (52 * weeklyEarningsWithDoctorateDegree ) * yearsTillRetirement ) - amountMade ) + " more than having no Degree." );
		}
		else
		{
			System.out.println("That is " + df.format( amountMade - ( (52 * weeklyEarningsWithNoDegree ) * yearsTillRetirement ) ) + " more than if you had no degree." );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithHighSchoolDegree ) * yearsTillRetirement ) ) + " more than if you had a High School Degree."  );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithBachelorDegree ) * yearsTillRetirement ) ) + " more than if you had a Bachelor's Degree." );
			System.out.println("And " + df.format( amountMade - ( (52 * weeklyEarningsWithMasterDegree ) * yearsTillRetirement ) ) + " more than if you had a Masters Degree." );
		}
		
		System.exit(0);
	}
}