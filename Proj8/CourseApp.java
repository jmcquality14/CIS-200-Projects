/**
 * (description of the project)
 * @author (your name)
 * @version (which number project this is)
 */
 
import java.util.*;

public class CourseApp {

	public static void main ( String [] args ) {
		
		Scanner s = new Scanner( System.in );
		boolean repeat = true;
		ArrayList < Course > classes = new ArrayList<Course>();
		System.out.println();
		
		do {
			// Course Information
			try {
				System.out.print("Enter the name of the course you wish to enroll in: ");
				String courseName = s.nextLine();
				if ( courseName.length() == 0 ) {
					throw new Exception( "No Input Given" );
				}
				
				System.out.print("Enter the course's number: ");
				String courseNumber = s.nextLine();
				if ( courseNumber.length() == 0 ) {
					throw new Exception( "No Input Given" );
				}
				
				// Instructors Information
				System.out.println("Enter the course instructor's information. ");
				
					System.out.print("\tInstructor's Full Name(first, last): ");
					String Name = s.nextLine();
					if ( Name.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					String [] fullname = Name.split(" ");
					
					System.out.print("\tUsername: ");
					String username = s.nextLine();
					if ( username.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
				Instructor instructor = new Instructor( fullname[1], fullname[0] , username );
				
				// Book Information
				System.out.println("Enter the course textbook's information. ");
					
					System.out.print("\tTextbook's Title: ");
					String title = s.nextLine();
					if ( title.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					System.out.print("\tTextbook's Author: ");
					String author = s.nextLine();
					if ( author.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					System.out.print("\tTextbook's price: ");
					double price = Double.parseDouble( s.nextLine() );
					
					TextBook textbook = new TextBook( title, author , price );
				
				Course cur = new Course( courseNumber, courseName, instructor , textbook );
				classes.add( cur ); 
				
				System.out.print("Do you wish to enter another course(Y/N): ");
				char answer = s.nextLine().charAt(0);
				do {
					if ( ( answer == 'y' ) || ( answer == 'Y' ) ) {
						repeat = true;
					} else if ( ( answer == 'N' ) || ( answer == 'n' ) ) {
						repeat = false;
					} else {
						System.out.println("Invalid Answer. Please enter Y)es or N)o.");
					}
				} while ( !( answer == 'y' || answer == 'n' || answer == 'N' || answer == 'Y' ) );
					
			} catch ( NumberFormatException e ) {
				System.out.println("A number was not given. Please enter a number.");
			} catch ( Exception e ) {
				System.out.println("Please re-enter proper inputs.");
			}
			
		} while ( repeat ) ;
		
		for ( int index = 0 ; index < classes.size() ; index++ ) {
			System.out.println("\n" + classes.get( index ).toString() );
			String wait = s.nextLine();
		}
		
		boolean notFound = true;
		do {
			System.out.print("Enter a course number: ");
			String number = s.nextLine();
			for ( int index = 0 ; index < classes.size() ; index++ ) {
				String tempstr = classes.get( index ).getNumber();
				if (  tempstr.equalsIgnoreCase( number ) ) {
					classes.remove( index );
					System.out.print("The course " + number + " has been removed from the course list.");
					notFound = false;
				}
			}
			
			if ( notFound ) 
				System.out.println("\nThe course " + number + " was not found. Re-enter a course number");
			
		} while ( notFound );
		
	System.out.println("\nEnter one more course.\n");
	
	do {
			// Course Information
			try {
				System.out.print("Enter the name of the course you wish to enroll in: ");
				String courseName = s.nextLine();
				if ( courseName.length() == 0 ) {
					throw new Exception( "No Input Given" );
				}
				
				System.out.print("Enter the course's number: ");
				String courseNumber = s.nextLine();
				if ( courseNumber.length() == 0 ) {
					throw new Exception( "No Input Given" );
				}
				
				// Instructors Information
				System.out.println("Enter the course instructor's information. ");
				
					System.out.print("\tInstructor's Full Name(first, last): ");
					String Name = s.nextLine();
					if ( Name.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					String [] fullname = Name.split(" ");
					
					System.out.print("\tUsername: ");
					String username = s.nextLine();
					if ( username.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
				Instructor instructor = new Instructor( fullname[1], fullname[0] , username );
				
				// Book Information
				System.out.println("Enter the course textbook's information. ");
					
					System.out.print("\tTextbook's Title: ");
					String title = s.nextLine();
					if ( title.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					System.out.print("\tTextbook's Author: ");
					String author = s.nextLine();
					if ( author.length() == 0 ) {
						throw new Exception( "No Input Given" );
					}
					
					System.out.print("\tTextbook's price: ");
					double price = Double.parseDouble( s.nextLine() );
					
					TextBook textbook = new TextBook( title, author , price );
				
				Course cur = new Course( courseNumber, courseName, instructor , textbook );
				classes.add( cur ); 
				repeat = false;
					
			} catch ( NumberFormatException e ) {
				System.out.println("A number was not given. Please enter a number.");
				repeat = true;
			} catch ( Exception e ) {
				System.out.println("Please re-enter proper inputs.");
				repeat = true;
			}
			
		} while ( repeat ) ;
		
		for ( int index = 0 ; index < classes.size() ; index++ ) {
			System.out.println("\n" + classes.get( index ).toString() );
			String wait = s.nextLine();
		}
		
	} // end of main 
		
} // end of courseApp