 /**
 * IO handles all input and output for the
 * four-square encryption algorithm
 *
 * <Add remaining required documentation here>
 */

import java.util.*;

public class IO {
	private Scanner s;

	/**
	 * IO sets up a new Scanner to System.in
	 */
	public IO() {
		
		s = new Scanner(System.in);
		
	}

	/**
	 * firstKey returns the first key from the user
	 *
	 * @return The first key from the user
	 */
	public String firstKey() {
		//COMPLETE THIS TO GET THE FIRST KEY
		System.out.print("Enter the first key: ");
		String FIRST_KEY = s.nextLine().toLowerCase();
		FIRST_KEY = FIRST_KEY.replaceAll( "\\s" , "" );
		//UPDATE THIS LINE WHEN DONE
		return FIRST_KEY;
	} // end firstKey


	/**
	 * secondKey returns the second key from the user
	 *
	 * @return The second key from the user
	 */
	public String secondKey() {
		//COMPLETE THIS TO GET THE SECOND KEY
		System.out.print("Enter the second key: ");
		String SECOND_KEY = s.nextLine().toLowerCase();
		SECOND_KEY = SECOND_KEY.replaceAll( "\\s" , "" );
		//UPDATE THIS LINE WHEN DONE
		return SECOND_KEY;
	} // end secondKey

	/**
	 * gets and returns whether the user wants to encrypt or decrypt
	 *
	 * @return 'e' for encryption, and 'd' for decryption
	 */
	public char encryptOrDecrypt() {
		//COMPLETE THIS TO GET THE ENCRYPT OR DECRYPT OPTION
		System.out.print("Enter (e)ncrypt or (d)ecrypt: ");
		String Answer = s.nextLine();
		char ENCRYPTION_OR_DECRYPTION = Answer.charAt(0);
		//UPDATE THIS LINE WHEN DONE
		return ENCRYPTION_OR_DECRYPTION;
	} // end encryptOrDecrypt

	/**
	 * message returns the message from the user
	 *
	 * @param encrypt True if encrypting, false if decrypting
	 *
	 * @return The message from the user
	 */
	public String message(boolean encrypt) {
		//COMPLETE THIS TO GET THE MESSAGE
		String MESSAGE;
		if ( encrypt ) {
			System.out.print("Enter the message to encrypt: ");
			MESSAGE = s.nextLine().toLowerCase();
			MESSAGE = MESSAGE.replaceAll( "\\s" , "" );
		} else { 
			System.out.print("Enter the message to decrypt: ");
			MESSAGE = s.nextLine().toLowerCase();
			MESSAGE = MESSAGE.replaceAll( "\\s" , "" );
		}
		//UPDATE THIS LINE WHEN DONE
		return MESSAGE;
	} // end message

	/**
	 * printResults prints the encrypted and decrypted messages
	 *
	 * @param msg The resulting message
	 * @param encrypt True if encrypting, false if decrypting
	 */
	public void printResults(String msg, boolean encrypt) {
		//COMPLETE THIS TO PRINT THE RESULTS
		if ( encrypt ) {
			// Give encrypted message 
			System.out.println("\nEncrypted message: " + msg );
		} else if ( !encrypt ) {
			// Give decrypted message
			System.out.println("\nDecrypted message: " + msg );
		}
	} // end printResults

	/*
	 * printError prints an error message
	 *
	 * @param err The error message to print
	 */
	public void printError(String err) {
		//COMPLETE THIS TO PRINT THE ERROR MESSAGE
		System.out.println( err );
	} // end printError

} // end class