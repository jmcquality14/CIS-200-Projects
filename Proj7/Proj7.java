/**
 * Proj7.java
 * Jackson McQuality / Lab Section Thursday 4-6pm Atef Khan 
 *
 *
 * This project implements the four-square cipher, allowing for encryption and decryption.
 */

public class Proj7 {
	public static void main(String[] args) {
		
		// Creates IO object for User input
		IO input = new IO();
				
	// Complete the MAIN method
		// Get the KEYS and MESSAGE using IO class
		String first_key = input.firstKey();
		String second_Key = input.secondKey();
		// Pass KEYS to the CIPHER class to ENCRYPT/DECRYPT
		Cipher cipherCode = new Cipher( first_key , second_Key );
		// Use CIPHER class to ENCRYPT/DECRYPT
		char answer = input.encryptOrDecrypt();
		String CodedMessage = "";
		if (  answer == 'e' || answer == 'E' ) {
			boolean choice = true;
			String userMessage = input.message( choice );
			CodedMessage = cipherCode.encrypt( userMessage );
			input.printResults( CodedMessage ,  choice );
		} else if (  answer == 'd' || answer == 'D' ) {
			boolean choice = false;
			String userMessage = input.message( choice );
			CodedMessage = cipherCode.decrypt( userMessage );
			input.printResults( CodedMessage ,  choice );
		}
	// Use IO class to display encrypted or decrypted message
 } // end main
} // end class