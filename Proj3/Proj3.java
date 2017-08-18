/**    
* Proj3.java  
* Jackson McQuality / Lab Section A Thursday 4:00 - 6:00pm / Atef Khan   
*  
* The following program prompts the user for two different points that do not have a undefined slope inbetween them and are between the values of (0,0) and (9,9). If the user gives the computer an invalid point, the program will 
* prompt the user with a notification of error and will ask the user to re-enter two valid points until it is given. The program then will calculate and display the equation of the line connecting the two points. Next, the program 
* will print a graph with the plotted points. Last, it will ask the user if it wishes to re-run the program. If the input is y or Y, the program will re-run. Otherwise, the program will end.  
*/

// imported directories
import java.util.*;
import java.text.*;

public class Proj3 {
	public static void main (String [] args ) {
		// initalizing scanner
		Scanner s = new Scanner(System.in);
		// initalizing decimal format
		DecimalFormat df = new DecimalFormat("0.00");
		// declaring variables
		double x1;
		double x2;
		double y1;
		double y2;
		char answer;
		boolean goodNums;
		// do loop for re-runing program
		do {
			// do loop for gathering data points
			do {	
					goodNums = true;
					System.out.print("\nEnter x1: ");
					x1 = Double.parseDouble(s.nextLine());
					System.out.print("Enter y1: ");
					y1 = Double.parseDouble(s.nextLine());
					System.out.print("Enter x2: ");
					x2 = Double.parseDouble(s.nextLine());
					System.out.print("Enter y2: ");
					y2 = Double.parseDouble(s.nextLine());
					// if loop checking validity of data points
					if ( !((x1 > -1) && (x1 < 10) && (y1 > -1) && (y1 < 10) && (x2 > -1) && (x2 < 10) && (y2 > -1) && (y2 < 10 )) ) {
						System.out.println("All points must be between (0,0) and (9,9).");
						goodNums = false;
					}
					else if ( x1 == x2 ) {
						if (y1 == y2 ) {
							System.out.print("Point values must be different. \n");
							goodNums = false;
						}
						else {
							System.out.print("Line between points must have a slope \n(i.e. x1 and x2 must differ)\n");
							goodNums = false;
						}
					}					
			} while ( goodNums == false ); // end of do loop
			
			System.out.println("");
			
			// Calculate the  slope between (x1,y1) & (x2,y2)
			double slope = ( (y2 - y1 ) / (x2 - x1 ) );
			// Calculate the intercept
			double intercept = (y1 - (slope * x1 ) );
			// Print Eguation
			System.out.println("y = " + df.format(slope) + " x + " + df.format(intercept) + "\n");
			
			// variables for holding the place value of our x-axis and y-axis on grid 
			int rowNumber =0;
			int columnNumber =0;
			
			// For loop for printing graph
			for (int row = 10; row >= 0; row--) // determines what row we are currently in
			{	
				// determines what column we are in
				for ( int columns = 0; columns <= 10; columns++ ) {
					//prints character of the current column
					if ( columns == 0) {
						rowNumber = row - 1;
						if ( rowNumber >= 0) {
						System.out.print(rowNumber);
						}
						else {
							System.out.print(" ");
						} // end of inner if
					} // end of if loop
					else if ( columns == 1 ) {
						if ( ( y1 == ( row - 1 ) ) && ( x1 == ( columns - 1 ) ) ) {
							System.out.print("*");
						}
						else if ( ( y2 == ( row -1) ) && ( x2 == ( columns - 1) ) ) {
							System.out.print("*");
							
						}
						else if ( row >= 1) {
							System.out.print("|");
						}
						else {
							System.out.print(columnNumber);
							columnNumber++;
						} // end of inner if
					} // end of else if loop
					else if ( (columns > 1) && (columns < 10) ) {
						if ( row == 0) {
						System.out.print(" " + columnNumber);
						columnNumber++;
						}
						else if ( (( (y1 + 1) == row) && ( (x1 + 1) == columns) ) ) {
							System.out.print(" *");
						}
						else if (( (y2 + 1) == row) && ( (x2 + 1) == columns)) {
							System.out.print(" *");
							
						}
						else if ( row == 1) {
							System.out.print(" _");
						}
						else {
							System.out.print("  ");
						} // end of inner if
					} // end of else if loop
					else if ( columns == 10 ) {
						if ( row == 0) {
						System.out.println(" " + columnNumber);
						columnNumber++;
						}
						else if ( (( (y1 + 1) == row) && ( (x1 + 1) == columns) ) ) {
							System.out.println(" *");
						}
						else if (( (y2 + 1) == row) && ( (x2 + 1) == columns)) {
							System.out.println(" *");
							
						}
						else if ( row == 1) {
							System.out.println(" _");
						}
						else {
							System.out.println("  ");
						}
					} // end of else if loop
				} // end of inner for loop						
			} // end of outer for loop
			// Prompts user for re-running program
			System.out.print("\nRun program again?(Y/N) ");
			String Repeat = s.nextLine();
			answer = Repeat.charAt(0);
		}while( (answer == 'y') || (answer == 'Y') ); // end of do while loop
	} // end of main
} // end of class