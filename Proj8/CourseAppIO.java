/**
 * Program allows the user to enter information about courses taught at KSU and adds each course
 * to a list of courses already entered.
 *
 * @author Jackon McQuality
 * @version Proj8
 */
 
import java.util.*;

public class CourseAppIO {

	public static void main ( String [] args ) {
		
		IO input = new IO();
		boolean repeat = true;
		ArrayList < Course > classes = new ArrayList<Course>();
		System.out.println();
		
		do {
			// Course Information
			try {
				
				String courseName = input.getCourseName();
					if ( courseName.length() == 0 ) 
						throw new Exception( "No Input Given" );
		
				String courseNumber = input.getCourseNumber();
					if ( courseNumber.length() == 0 ) 
						throw new Exception( "No Input Given" );
					
				Instructor instructor = input.getInstructor();
					if ( instructor.getLastName().length() == 0 ) 
						throw new Exception( "No Input Given" );
					if ( instructor.getFirstName().length() == 0 ) 
						throw new Exception( "No Input Given" );
					if ( instructor.getUserName().length() == 0 ) 
						throw new Exception( "No Input Given" );

				TextBook textbook = input.getTextBook();
					if ( textbook.getTitle().length() == 0 )
						throw new Exception( "No Input Given" );
					if ( textbook.getAuthor().length() == 0 )
						throw new Exception( "No Input Given" );
					
				Course cur = new Course( courseNumber, courseName, instructor , textbook );
				classes.add( cur ); 
				
				repeat = input.enterAnotherCourse();
					
			} catch ( NumberFormatException e ) {
				System.out.println("A number was not given. Please enter a number.");
			} catch ( Exception e ) {
				System.out.println("Please re-enter proper inputs.");
			}
			
		} while ( repeat ) ;
		
		input.displayCourseList( classes );
		
		input.removeCourse( classes );
		
		input.displayCourseList( classes );
				
		System.out.println("\nEnter one more course.\n");
		do {
			// Course Information
			try {
				
					String courseName = input.getCourseName();
		
					String courseNumber = input.getCourseNumber();

					Instructor instructor = input.getInstructor();
				
					TextBook textbook = input.getTextBook();
				
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
		
		input.displayCourseList( classes );
		
	}  // end of main 
		
} // end of courseApp