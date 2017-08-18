/**
 * Cipher handles the encryption and decryption of
 * messages according to the four-square cipher algorithm.
 *
 * <Add remaining required documentation here>
 */
 
import java.util.ArrayList;

public class Cipher {
	private Square plain1;
	private Square plain2;
	private Square cipher1;
	private Square cipher2;

	/**
	 * Cipher creates the four squares based on
	 * two keys for the four-square cipher algorithm.
	 *
	 * @param key1 The first key (no Q's)
	 * @param key2 The second key (no Q's)
	 */
	public Cipher(String key1, String key2) {
		//COMPLETE THIS CONSTRUCTOR
		//CREATE plain1, plain2, cipher1, and cipher2
		plain1 = new Square();
		plain2 = new Square();
		cipher1 = new Square( key1 );
		cipher2 = new Square( key2 );
	} // end 2 arg constructor

	/**
	 * encrypt returns the encrypted message using the
	 * four-square cipher algorithm
	 *
	 * @param message The message to encrypt
	 *
	 * @return The encrypted message
	 */
	public String encrypt(String message) {
		//COMPLETE THIS METHOD
			
			// Setup
			String encryptedMessage = "";
			ArrayList<String> LetterGroups;
			LetterGroups = new ArrayList <String> ();
			int letterCounter = 0;
			
			// Groups letters in message by pairs
			while ( letterCounter < message.length() ) {
				if ( ( message.length() - letterCounter ) != 1 ) {
					LetterGroups.add( message.substring( letterCounter , letterCounter + 2 ) );
					letterCounter += 2;
				} else {
					LetterGroups.add( message.substring( letterCounter ) );
					letterCounter++;
				}
			}
			
			for ( int index = 0 ; index < LetterGroups.size() ; index++ ) {
				
				char firstLetter = LetterGroups.get( index ).charAt(0);
				char secondLetter = '_' ;
				
				if ( LetterGroups.get( index ).length() > 1 ) {
					secondLetter = LetterGroups.get( index ).charAt(1);
				}
				
				// gets the positions of the characters in plain
				int[] firstPosition = plain1.getPos( firstLetter );
				int[] secondPosition = plain2.getPos( secondLetter );
				
				// gets the chars from the the corresponding position in cipher
				char encryptedLetter1 = cipher1.getChar( firstPosition[0], secondPosition[1] );
				char encryptedLetter2 = cipher2.getChar( secondPosition[0] , firstPosition[1] );	
				
				/*
				try {
					encryptedLetter1 = cipher1.getChar( firstPosition[0] , secondPosition[1] );
				} catch ( Exception e ) {
					encryptedLetter1 = ' ';
				}
				
				try {
					encryptedLetter2 = cipher2.getChar( secondPosition[0] , firstPosition[1] );
				} catch ( Exception e ) {
					encryptedLetter2 = ' ';
				}
				*/
				
				encryptedMessage += encryptedLetter1;
				encryptedMessage += encryptedLetter2;
			}
		//RETURN THE ENCRYPTED message
		//UPDATE THIS LINE WHEN DONE
		return encryptedMessage;
	} // end encrypt

	/**
	 * decrypt returns the decrypted message using the
	 * four-square cipher algorithm
 	 *
	 * @param message The message to decrypt
	 *
	 * @return The decrypted message
	 */
	public String decrypt(String message) {
		//COMPLETE THIS METHOD
		
		// Setup
			String decryptedMessage = "";
			ArrayList<String> LetterGroups;
			LetterGroups = new ArrayList <String> ();
			int letterCounter = 0;
			
			// Groups letters in message by pairs
			while ( letterCounter < message.length() ) {
				if ( ( message.length() - letterCounter ) != 1 ) {
					LetterGroups.add( message.substring( letterCounter , letterCounter + 2 ) );
					letterCounter += 2;
				} else {
					LetterGroups.add( message.substring( letterCounter ) );
					letterCounter++;
				}
			}
			
			for ( int index = 0 ; index < LetterGroups.size() ; index++ ) {
				
				char firstLetter = LetterGroups.get(index).charAt(0);
				char secondLetter = '_';
				
				if ( LetterGroups.get( index ).length() > 1 ) {
					secondLetter = LetterGroups.get( index ).charAt(1);
				}
				
				// gets the positions of the characters in cipher
				int[] firstPosition = cipher1.getPos( firstLetter );
				int[] secondPosition = cipher2.getPos( secondLetter );
			
				// gets the chars from the the corresponding position in plain
				char decryptedLetter1 = plain1.getChar( firstPosition[0] , secondPosition[1] );
				char decryptedLetter2 = plain2.getChar( secondPosition[0] , firstPosition[1] );
				
				/*
				try {
					decryptedLetter1 = plain1.getChar( firstPosition[0], secondPosition[1]);
				} catch ( Exception e ) {
					decryptedLetter1 = ' ';
				}
				
				try {
					decryptedLetter2 = plain2.getChar( secondPosition[0], firstPosition[1]);
				} catch ( Exception e ) {
					decryptedLetter2 = ' ';
				}
				*/
				// adds the letters to the finalMessage
				decryptedMessage += decryptedLetter1; 
				decryptedMessage += decryptedLetter2;
			}
			
		//RETURN THE DECRYPTED message
		//UPDATE THIS LINE WHEN DONE
		return decryptedMessage;
	} // end decrypt
} // end class