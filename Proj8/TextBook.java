/**
 * @Original Author: Tony Gaddis
 * @Modified by: Dr. Lang
 * @version Project 8 
 * 
 * Textbook.java - Provided to the student
 * Class stores data about the textbook required for the course
 * which includes title, author and price
 *
 * Includes a regular constructor and a constructor used to make a copy 
 * of a created textbook object as well as a toString method
*/

import java.text.*;

public class TextBook
{
	DecimalFormat df = new DecimalFormat( "##0.00" );

   private String title;    // Title of the book
   private String author;   // Author's last name
   private double price; 	// Wholesale cost of the book

   /**
      This constructor initializes the title,
      author, and price fields
      @param textTitle The book's title.
      @param auth The author's name.
      @param price Wholesale cost.
   */
   public TextBook(String t, String a,double p)
   {
      title = t;
      author = a;
      price = p;
   } // end of TextBook

   /**
      The copy constructor initializes the object
      as a copy of another TextBook object.
      @param object2 The object to copy.
   */
   public TextBook(TextBook object2)
   {
      title = object2.title;
      author = object2.author;
      price = object2.price;
   } // end of TextBook copy

 
   /**
      toString method
      @return A string containing textbook information.
   */
   public String toString()
   {
      // Create a string representing the object.
      String str = "\tTitle: " + title +
                   "\n\tAuthor: " + author +
                   "\n\tWhole Sale Price: $" + df.format( price );

      // Return the string.
      return str;
   } // enf of toString
   
   /**
	 * Gets the Title of a TextBook
	 * @param none
	 * @return String that represents the title of a TextBook
	 */ 
   public String getTitle() {
	   return title;
   } // end of getTitle
   
   /**
	 * Get the author of a TextBook
	 * @param none
	 * @return String that represents the author of a TextBook
	 */
   public String getAuthor() {
	   return author;
   } // end of getAuthor 
   
} // end of TextBook