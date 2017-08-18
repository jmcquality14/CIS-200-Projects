import java.util.*;

public class IO {
	
	private Scanner s;
	
	/**
	 * This is a constructor that initalizes an IO object
	 * @param none
	 * @return nothing
	 */
	public IO () {
		s = new Scanner( System.in );
	} // end of IO
	
	
	/**
	 * Gets the name of a course from the user 
	 * @param none
	 * @return String that is the name of a course
	 */
	public String getCourseName() {
		System.out.print("Enter the name of the course you wish to enroll in: ");
		String Name = s.nextLine();
		return Name;
	} // end of getCourseName
	
	
	/**
	* Gets the course number of a class from the user 
	* @param none
	* @return String that is the number of a course
	*/
	public String getCourseNumber() {
		System.out.print("Enter the course's number: ");
		String Number = s.nextLine();
		return Number;
	} // end of getCourseNumber
	
	
	/**
	 * Gets information from user about the instructor of a particular course
	 * @param none
	 * @return Instructor object that holds information on a instructor who teaches a course
	 */
	public Instructor getInstructor() {
		System.out.println("Enter the course instructor's information. ");
				
			System.out.print("\tInstructor's Full Name(first, last): ");
			String Name = "  "; 
			Name = s.nextLine();
			
			String [] fullname = Name.split(" ");
			
			System.out.print("\tUsername: ");
			String username = "  ";
			username = s.nextLine();
			
		Instructor professor = new Instructor( fullname[1], fullname[0] , username );
		return professor;
	} // end of getInstructor
	
	
	/**
	* Gets information from user about required textbooks in a particular course
	* @param none
	* @return TextBook object that holds information on a required textbook in a course
	*/ 
	public TextBook getTextBook() {
		System.out.println("Enter the course textbook's information. ");
					
			System.out.print("\tTextbook's Title: ");
			String title = s.nextLine();
			
			System.out.print("\tTextbook's Author: ");
			String author = s.nextLine();
			
			System.out.print("\tTextbook's price: ");
			double price = Double.parseDouble( s.nextLine() );
			
		TextBook textbook = new TextBook( title, author , price );
		return textbook;
	} // end of TextBook 
	
	
	/**
	* Removes one course from the course list
	* @param ArrayList holding Course taught at KSU
	* @return nothing
	*/ 
	public void removeCourse( ArrayList< Course > c ) {		
		boolean notFound = true;
		do {
			
			System.out.print("Enter a course number: ");
			String number = s.nextLine();
			
			for ( int index = 0 ; index < c.size() ; index++ ) {
				String tempstr = c.get( index ).getNumber();
				if (  tempstr.equalsIgnoreCase( number ) ) {
					c.remove( index );
					System.out.print("The course " + number + " has been removed from the course list.\n\n");
					notFound = false;
				}
			}
			if ( notFound ) 
				System.out.println("\nThe course " + number + " was not found. Re-enter a course number");
		} while ( notFound );
		return ;
	} // end of remove course
	
	
	/**
	* Allows user to enter one more course
	* @param none
	* @return Boolean value that will tell the program if the user wants to enter another course
	*/ 
	public boolean enterAnotherCourse() {
		boolean repeat = false;
		System.out.print("Do you wish to enter another course(Y/N): ");
		char answer = ' ';
		do {
			answer = s.nextLine().charAt(0);
			if ( ( answer == 'y' ) || ( answer == 'Y' ) ) {
				repeat = true;
			} else if ( ( answer == 'N' ) || ( answer == 'n' ) ) {
				repeat = false;
			} else {
				System.out.println("Invalid Answer. Please enter Y)es or N)o.");
			}
		} while ( !( answer == 'y' || answer == 'n' || answer == 'N' || answer == 'Y' ) );
		
		return repeat;			
	} // end of enterAnotherCourse
	
	
	/**
	* Displays all the Courses added to the course list
	* @param ArrayList holding Courses taught at KSU
	* @return nothing
	*/ 
	public void displayCourseList( ArrayList< Course > c) {
		for ( int index = 0 ; index < c.size() ; index++ ) {
			System.out.println("\n" + c.get( index ).toString() );
			String wait = s.nextLine();
		}
		return;
	}// end of displayCourseLst
	
	
} // end of IO