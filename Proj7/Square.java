/**
 * Square represents one of the squares in the four-square
 * cipher algorithm.
 *
 * <Add remaining required documentation here>
 */

public class Square {
	private char[][] matrix;

	/**
	 * Square constructs a matrix with the letters A-Z, skipping Q.
	 */
	 
	public Square() {
		int a = '0';
		matrix = new char[5][5];
		for ( int rows = 0 ; rows < matrix.length ; rows++ ) {
			for ( int columns = 0 ; columns < matrix[rows].length ; columns++ ) {
				char letter = ( char )( a +  49 );
				if ( letter != 'q' ) {
					matrix[rows][columns] = letter;
					a++;
				} else {
					a++;
					letter = ( char )( a +  49 ); 
					matrix[rows][columns] = letter;
					a++;
				}
				// System.out.print( matrix[rows][columns] );
			}
			// System.out.println( );
		}
		// System.out.println( );
	} // end no-arg constructor

	/**
	 * Square first puts the characters from key into
	 * the matrix, and then fills the matrix with the remaining
	 * letters (skipping Q).
	 *
	 * @param key One of the encryption keys
	 */
	public Square(String key) {
		//COMPLETE THIS CONSTRUCTOR
		//FILL matrix WITH key, THEN REMAINING A-Z, SKIPPING Q
		
		int index = 0;
		int a = '0';
		matrix = new char[5][5];
		String tempKey = removeDups( key );
		
		for ( int rows = 0 ; rows < matrix.length ; rows++ ) {
			for ( int columns = 0 ; columns < matrix[rows].length ; columns++ ) {
				
				// Checks if there is another character in String Key
				if ( index < tempKey.length() ) {
					matrix[rows][columns] = tempKey.charAt(index);
					index++;
				} // If there is no other character in String Key
				else {
					char letter = ( char )( a +  49 );
					// If letter is Q 
					if ( letter == 'q' ) {
						a++;
						letter = ( char )( a +  49 ); 				
					} 
					
					// Checks to make sure all letters are distinct
					boolean distinct = true;;
					do {
						distinct = true;
						for ( int num = 0; num < tempKey.length() ; num++ ) {
							if ( letter == tempKey.charAt(num) ) {
								distinct = false ;
								a++;
								letter = ( char )( a +  49 );
							} 
						}
					} while ( !distinct );
					letter = ( char )( a +  49 );
					matrix[rows][columns] = letter;
					a++;
				}
				// System.out.print( matrix[rows][columns] );
			}
			// System.out.println( );
		}
		// System.out.println( );
	} // end one-arg constructor
	
	/**
	 * getChar returns the character at a given
	 * row and column in the matrix.
	 *
	 * @param row The row to look in
	 * @param col The column to look in
	 *
	 * @return The character at (row, col)
	 */
	public char getChar(int row, int col) {
		//COMPLETE THIS METHOD
		//RETURN THE CHARACTER IN MATRIX AT POSITION row,col
		//UPDATE THIS LINE WHEN DONE
		return matrix[ row ][ col ];
	} // end getChar
	
	/**
	 * getPos returns the [row,col] position
	 * of the given character.
	 *
	 * @param c The character to look for
	 *
	 * @return A 1D array holding the row and col of c stored in [0] and [1]
	 */
	public int[] getPos(char c) {
		//COMPLETE THIS METHOD
		//RETURN this array holding the row and col of c stored in [0] and [1], respectively
		int[] pos = new int[2];
		// Search through matrix for 'c' and, when found
		// store row in pos[0] and col in pos[1]
		for ( int row = 0; row < matrix.length; row++ ) {
			for ( int col = 0; col < matrix[row].length; col++ ) {
				if ( matrix[row][col] == c ) {
					pos[0] = row;
					pos[1] = col;
					return pos;
				}
			}
		}
		// If NOT found...
		//Leave this code in so that it will compile
		//Assuming char is found so don't need to
		//add code to handle if the char isn't found
		// character not found
		pos[0] = -1;
		pos[1] = -1;
		return pos;	 
	} // end getPos
	
	/**
	 * strContains returns whether the given string
	 * contains the given character
	 *
	 * @param str The string to search
	 * @param c The character to search for
	 *
	 * @return true if c is in str else false
	 */
	private boolean strContains(String str, char c) {

		//COMPLETE THIS METHOD (Optional, but strongly suggested)
		boolean containsLetter = false;
		for ( int index = 0 ; index < str.length() ; index++ ) {
			if ( str.charAt( index ) == c ) {
				containsLetter = true;
			}
		}
		return containsLetter;
		
	} // end strContains
	
	/*
	 * removeDups removes all duplicate characters
	 * from the string
	 *
	 * @param key The string to remove duplicates from
	 *
	 * @return The string with all duplicates removed
	 */
	private String removeDups(String key) {
		//COMPLETE THIS METHOD (Optional, but strongly suggested)
		String keysInMessage = "";
		for ( int letter = 0 ; letter < key.length() ; letter++ ) {
			if ( !strContains( keysInMessage , key.charAt( letter ) ) ) { // !keysInMessage.contains( String.valueOf( key.charAt( i ) ) ) ) {
				keysInMessage += key.charAt( letter );
			}
		}
		return keysInMessage ;

	} // end removeDups	
}