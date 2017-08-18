/**
 * Proj5.java
 * Jackson McQuality Lab Section A Thursday 4:00 - 6:00pm Atef Khan
 *
 * The program is to simulate the  Game of Life. The user give the computer an command line arquement that represents the name of a file that stores an arrangement of 1's and 0's. The program then reads in the file and 
 * stores the pattern of 1's and 0's in an array. The program then reads the array and displays the same pattern of "*" and ".", with 1's equaling *'s, alive cells, and 0's equaling .'s, dead cells. The program then 
 * updates the array according to the following rules:
 *			1) Any live cell with fewer than two live neighbors dies of loneliness 
 *			2) Any live cell with more than three live neighbors dies of overcrowding 
 *			3) Any dead cell with exactly three live neighbors comes to life 
 *			4) Any live cell with two or three neighbors stays alive 
 *			5) Any dead cell that does not have exactly three live neighbors remains dead 
 * The prgram the displays the updated, new array of cells. The program then repeats continuously until closed.
*/ 

// import directories
import java.util.*;
import java.io.*;

public class Proj5 {
	public static void main ( String [] args ) throws IOException {
		// 
		int [][] boardOfCells = readBoard( args[0] );
		//
		boolean loop = true;
		while ( loop ) {
			// Displays Animation of Cells
			String display = boardDisplay( boardOfCells );
			System.out.print( display );
			// creates an array that stores the values of the updated array
			int [][] updatedBoardOfCells = update( boardOfCells );
			// sets array boardOfCells to equal updatedBoardOfCells using copy method
			boardOfCells = copy(updatedBoardOfCells);
			// Slows down for animation
			try {
				Thread.sleep(400);
			}
			catch (InterruptedException e) {}	
		} // end of while
	} // end of main
	
///////////////////////////////////////////////////////////////////

	/**
	 *  This method should read the specified input file, read it into an int[][] array, and return that array.
	 *
	 * parameters: The name of a file stored in a string is passed to this method and stored in the String filename
	 * returns: The method returns an array of integers that represent the arrangement of 1's and 0's in the file passed in
	 */
	public static int [][] readBoard( String filename ) throws IOException {
		Scanner inFile = new Scanner( new File( filename ) );
		
		int rows = Integer.parseInt(inFile.nextLine());
		int columns = Integer.parseInt(inFile.nextLine());
		
		System.out.println("rows: " + rows);
		System.out.println("Columns: " + columns);
		
		int [][] board = new int [rows][columns];
		
		for ( int rowNums = 0; rowNums < rows ; rowNums++ ) {
			String line = inFile.nextLine();
			for ( int columnNums = 0 ; columnNums < columns ; columnNums++ ) {
				if ( line.charAt(columnNums) == '1' ) {
					board[rowNums][columnNums] = 1;
				} else if ( line.charAt(columnNums) == '0' ) {
					board[rowNums][columnNums] = 0;
				} 
			}
		}

		inFile.close();
		
		return board;
		
	} // end of readBoard

	/**
	 * This method should return the String representing the cells array (so that it would print as a grid if printed).
	 *
	 * parameters: A array of integers that stores the arrangement of 0's and 1's that represent the pattern of alive and dead cells
	 * returns: The method returns a string that displays the pattern of alive and dead cells
	 */
	public static String boardDisplay(int[][] cells) {
		
		StringBuilder build = new StringBuilder(); 
		
		for ( int RowNums = 0 ; RowNums < cells.length ; RowNums++ ) {
			for ( int ColumnNums = 0 ; ColumnNums < cells[RowNums].length ; ColumnNums++ ) {
				if ( ColumnNums == cells[0].length - 1 ) {
					if ( cells[RowNums][cells[0].length - 1] == 1 ) {
					build.append("*\n");
					} else if ( cells[RowNums][cells[0].length - 1] == 0 ) {
					build.append(".\n");
					}
				} else if ( cells[RowNums][ColumnNums] == 1 ) {
					build.append("*");
				} else if ( cells[RowNums][ColumnNums] == 0 ) {
					build.append(".");
				}
			}
		}
		
		return build.toString();
	} // end of board display
	
	/**
	 * This method should return the next generation of the cells array. 
	 *
	 * Parammeters: A array of integers that stores an arrangement of 0's and 1's that represent the pattern of alive and dead cells 
	 * Return: The method returns array of integers that represents an update arrangement of alive and dead cells, which are represented by 1's and 0's 
	 */
	public static int[][] update(int[][] cells) {
		
		int [][] update = new int [cells.length][cells[0].length];
		
		for (int i = 0 ; i < cells.length ; i++ ) {
			int numOfNeighbors = 0;
			for (int j = 0 ; j < cells[i].length ; j++ ) {
				numOfNeighbors = neighbors( cells , i , j );
				if ( cells[i][j] == 1 ) { // alive 
					if ( ( numOfNeighbors > 3 ) || ( numOfNeighbors < 2 ) ) {
						update[i][j] = 0;
					} else {
						update[i][j] = cells[i][j];
					}
				} else if ( cells[i][j] == 0 ) { // dead
					if (  numOfNeighbors == 3 ) {
						update[i][j] = 1; 
					} else {
						update[i][j] = cells[i][j];
					}
				} 
			}
		}
		return update;
	} // end of update
	
	/**
	 * This method should return the number of live neighbors that position (row,col) has in the cells array.
	 *
	 * parameters: An array of integers, an integer that represent the row number,  and an integer that represents the column number are passed to the method
	 * returns: The method returns an integer that holds the number of alive neighboring cells around a cell located in row n of column m in the arry of integers
	 */
	public static int neighbors(int[][] cells, int row, int col) {
	
		int neighbors = 0;
		
		try {
			if ( cells[row - 1][col - 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row - 1][col] == 1 )
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row - 1][col + 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row][col - 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row][col + 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row + 1][col - 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row + 1][col] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		try {
			if ( cells[row + 1][col + 1] == 1 ) 
				neighbors++;
		} catch ( IndexOutOfBoundsException e ) {}
		
		return neighbors;
	} // end of neighbors	
					
	/**
	 * A method written by me , the student. The method is to take an array and return an exact copy of the array
	 *
	 * parameters: An array of integers that represent the arrangement of cells
	 * returns: The method returns an array of integers that is an exact copy of the array passed into the mehod
	 */
	public static int[][] copy( int [][] board ) {
		
		int [][] copyArray = new int [board.length][board[0].length];
		
		for ( int i = 0; i < board.length ; i++ ) {
			for ( int j = 0; j < board[i].length ; j++ ) {
			copyArray[i][j] = board[i][j];
			}
		}
				
		return  copyArray;
		
	} // end of copy
} // end of class