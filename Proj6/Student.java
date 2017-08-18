/**
 * Student.java
 * Jackson McQuality / Lab Section Thursday 4:00 - 6:00 / Atef Khan>
 *
 * Class that holds Student objects and methods
*/ 

import java.text.*;

public class Student {
	
	DecimalFormat df = new DecimalFormat("0.0");
	
		
	// Weight% ( ##% )
		final private double labWeight = 0.10;
		final private double projectWeight = 0.15;
		final private double codeLabWeight = 0.10;
		final private double examsWeight = 0.45;
		final private double finalExamWeight = 0.20;
	
	
	// Students attributes
		private String StudentWID = new String();
		private String StudentName = new String();
		// Points earned in each category
		private double codeLabPtsEarned;
		private double LabPtsEarned;
		private double projectPtsEarned;
		private double examPtsEarned;
		private double finalExamPtsEarned;
		private double overallPercent;
	
	// Constructers 
		/**
		 * (description of the method)
		 *
		 * @param (describe first parameter)
		 * @param (describe second parameter)
		 * (list all parameters, one per line)
		 * @return (describe what is being returned)
		 */
		public Student() {
			this.StudentWID = "N/A";
			this.StudentName = "N/A";
			this.codeLabPtsEarned = 0.0;
			this.LabPtsEarned = 0.0;
			this.projectPtsEarned = 0.0;
			this.examPtsEarned = 0.0;
			this.finalExamPtsEarned = 0.0;
			this.overallPercent = 0.0;
		}
		
		/**
		 * (description of the method)
		 *
		 * @param (describe first parameter)
		 * @param (describe second parameter)
		 * (list all parameters, one per line)
		 * @return (describe what is being returned)
		 */		
		public Student( String WID , String Name , double Lab , double CodeLab , double Project , double Exams , double FinalExam ) {
			this.StudentWID = WID;
			this.StudentName = Name;
			this.codeLabPtsEarned = CodeLab;
			this.LabPtsEarned = Lab;
			this.projectPtsEarned = Project;
			this.examPtsEarned = Exams;
			this.finalExamPtsEarned = FinalExam;
			this.overallPercent = 0.0; //this.findOverallGrade( totalPtsPossible , totalCodeLabPts , totalLabPts , totalProjectPts , totalExamPts , totalFinalExamPts  );
		}
	
	// Methods
		/**
		 * Method is used to pass in information from StudentApp that is used in the private method findOverallGrade()
		 *
		 * @param double totalPossiblePoints represents the total number of points in the overall class 
		 * @param double totalCodeLabPts represents the total number of points possible in the Code Labs catergories
		 * @param double totalLabPts represents the total number of points possible in the Labs catergories
		 * @param double totalProjectPts represents the total number of points possible in the Projects catergories
		 * @param double totalExamPts represents the total number of points possible from the 3 class exams
		 * @param double totalFinalExamPts represents the total number of points possible from the final exam
		 * 
		 * @return Void, returns nothing
		 */
		public void calculate( double totalPossiblePoints , double totalCodeLabPts , double totalLabPts , double totalProjectPts , double totalExamPts , double totalFinalExamPts  ) {
			findOverallGrade( totalPossiblePoints , totalCodeLabPts , totalLabPts , totalProjectPts , totalExamPts , totalFinalExamPts  );
			return;
		}
		
		
		/**
		 * Method is used to find a Student's overall grade in a class
		 *
		 * @param double totalPossiblePoints represents the total number of points in the overall class 
		 * @param double totalCodeLabPts represents the total number of points possible in the Code Labs catergories
		 * @param double totalLabPts represents the total number of points possible in the Labs catergories
		 * @param double totalProjectPts represents the total number of points possible in the Projects catergories
		 * @param double totalExamPts represents the total number of points possible from the 3 class exams
		 * @param double totalFinalExamPts represents the total number of points possible from the final exam
		 *
		 * @return double overallPercent that holds a student's overall grade in the class 
		 */
		private double findOverallGrade( double totalPossiblePoints , double totalCodeLabPts , double totalLabPts , double totalProjectPts , double totalExamPts , double totalFinalExamPts  ) {
			// Calculates Total Possible points 
		
			double codelabAdjPts = totalPossiblePoints * codeLabWeight;
			double studentCodelabAdjPts = (	this.codeLabPtsEarned / totalCodeLabPts) * ( codelabAdjPts );
			
			double labAdjPts = totalPossiblePoints * labWeight;
			double studentLabAdjPts = (	this.LabPtsEarned / totalLabPts) * ( labAdjPts );
			
			double projectAdjPts = totalPossiblePoints * projectWeight;
			double studentProjectAdjPts = (	this.projectPtsEarned / totalProjectPts) * ( projectAdjPts );
			
			double examsAdjPts = totalPossiblePoints * examsWeight;
			double studentExamsAdjPts = ( this.examPtsEarned / totalExamPts) * ( examsAdjPts );
			
			double finalExamAdjPts = totalPossiblePoints * finalExamWeight;
			double studentFinalExamAdjPts = ( this.finalExamPtsEarned / totalFinalExamPts) * ( finalExamAdjPts );

			double totalPointsEarned = ( studentCodelabAdjPts + studentProjectAdjPts + studentLabAdjPts + studentExamsAdjPts + studentFinalExamAdjPts );
			
			this.overallPercent = 100 * ( totalPointsEarned / totalPossiblePoints );
			
			return overallPercent;
		}
		
		/**
		 * Method that is used to rearrange and give 
		 *
		 * @param String studentName is a String that reads the name of the Current Student
		 * 
		 * @return String that reads the students name in a last name, first name order
		 */
		public String lastFirst( String studentName ) {
			String [] name = studentName.split(" ");
			return( name[1] + ", " + name[0] );
		}
		
		/**
		 * Method that is used to find a Student's letter grade
		 *
		 * @param double overallPercent that holds a Students overall percent in class
		 * 
		 * @return Char that represents a student's Letter grade in the class
		 */
		public char findLetterGrade( double overallPercent ) { 
			
			if ( overallPercent > 89.4 ) 
				return 'A' ;
			else if ( overallPercent > 79.4 ) 
				return 'B' ;
			else if ( overallPercent > 68.4 )
				return 'C' ;
			else if ( overallPercent > 58.4 )
				return 'D' ;
			else 
				return 'F' ;
		}
		
		/**
		 * Method is used to return Information about a Student's standing in class
		 *
		 * @param Void, Takes no parameter
		 * 
		 * @return String that holds the information about a particular student
		 */
		public String toString() {
			return ("\nStudent name: " + lastFirst( StudentName ) +
					"\nWID: " + StudentWID +
					"\nOverall %: " + df.format( overallPercent ) + "%" +
					"\nFinal Grade: " +  findLetterGrade( overallPercent ) +
					"\n\t\t Press enter to display next Student...");
		}
		
} // end of student 