/**
* Proj4.java 
* Jackson McQuality Lab Section 1 Thursday 4:00 - 6:00pm Atef Khan 
* 
* The program randomly “deals” five playing cards that are unique to the user. Each card will have a suit (Spades, Clubs, Hearts, or Diamonds) and a value (2-10, Jack, Queen, King, or Ace). Then the program determines if the user
* has any special type of hand according to the rules of poker. After displaying the results of the user's hand, the program prompts the user asking if they wish to ‘Play Again?’ If so, the program repeats and ‘deal’ another hand
* of 5 cards, and displays the result. The program will continue until the user replies no to playing again. 
**/

// imported diretories
import java.util.*;
import java.util.Random.*;

public class Proj4 {
	public static void main ( String [] args ) {
		/* You must include the following statements below in the code that you submit to get full credit. Use hardcoded values to test each of the possible hands.
			Project must work if any of the hardcoded arrays are uncomment with your random card generator portion comment out) GTAs will use these values to test your program
			Assume suits are numbered 1-4 Assume 11=Jack, 12=Queen 13=King 14=Ace 
		*/ 
		// Used for testing different hands ... comment out dealing cards and initialize when declared   
		// Royal Flush   int[] value = {10, 12, 14, 13, 11};   int[] suit = {1,1,1,1,1};
		// Straight Flush   int[] value = {9, 7, 8, 6, 5};   int[] suit = {1,1,1,1,1};
		// 4 of kind   int[] value = {9, 7, 9, 9, 9};  int[] suit = {1,2,3,4,1};
		// Full House   int[] value = {9, 7, 9, 7, 9};   int[] suit = {1,2,3,4,1};
		// Flush   int[] value = {9, 10, 8, 6, 5};   int[] suit = {1,1,1,1,1};
		// Straight   int[] value = {9, 7, 8, 6, 5};   int[] suit = {1,2,4,3,1};
		// 3 of kind   int[] value = {9, 7, 9, 2, 9};   int[] suit = {1,2,3,4,1};
		// Two Pair   int[] value = {9, 7, 9, 2, 7};   int[] suit = {1,2,3,4,1};
		// One Pair   int[] value = {9, 7, 8, 2, 7};   int[] suit = {1,2,3,4,1};
		// High Card (Ace)   int[] value = {9, 7, 8, 14, 11};   int[] suit = {1,2,3,4,1};
		
		// initalizing scanner
		Scanner s = new Scanner(System.in);
		// initalizing random 
		Random random = new Random();
		
		System.out.println("** Welcome to the 2017 Las Vegas Poker Festival! **\n   (Application developed by Jackson McQuality)");
		
		// initalizing hand
			// Row stores card value
			int [] value = new int [5];
			int cardNumber;
			// Row stores card suit
			int [] suit = new int [5];
			int cardSuit;	
			
		// Do - while loop for checking if user wants to re-run program
		boolean again = false;
		do {
			System.out.println("\nShuffling cards...\nDealing the Cards...\n\nHere are your five cards...");
			// Do - while loop for checking if multiple copies of cards are dealt	
			boolean copies;
			do {
				
				// randomly picks card value 
				for ( int i = 0; i < value.length; i++ ) {
					cardNumber = random.nextInt(13) + 2;
					value[i] = cardNumber;
				}
				
				// Arranges cards from highest to Lowest
				for ( int j = 0; j < value.length; j++ ) {
					int temp;
					for ( int k = 0; k < value.length - 1 ; k ++ ) {
						if ( value[k] < value[k + 1] ) {
						// swaps card value 
						temp = value[k]; 
						value[k] = value[k + 1];
						value[k + 1] = temp;
						}
					}
				}
				
				// randomly picks card suit
				for ( int L = 0; L < value.length; L++ ) {
					cardSuit = random.nextInt(4) + 1;
					suit[L] = cardSuit;
				}
				
				// Checks for duplicates of cards
				copies = false;
				for ( int m = 0; m < value.length; m++  ) {
					for ( int n = 0; n < value.length ; n++ ) {
						if ( m != n ) {
							if ( ( value[m] == value[n] ) && ( suit[m] == suit[n] ) ) {
									//System.out.print("value[m]= " + value[m] + "\nvalue[n]="  + value[n] + "\nsuit[m]=" + suit[m] + "\nsuit[n]=" + suit[n] );
									copies = true;
							}
						}
					}
				}
			} while ( copies );
			
			// Displays dealt hand
			for ( int o = 0; o < value.length; o++ ) {
				// Shows card value
				if ( value[o] == 14 ) 
					System.out.print("\tAce of ");
				else if ( value[o] == 13 )
					System.out.print("\tKing of ");
				else if ( value[o] == 12 )
					System.out.print("\tQueen of ");
				else if ( value[o] == 11 )
					System.out.print("\tJack of ");
				else 
					System.out.print( "\t" + value[o] + " of " ); 
				// shows card rank
				if ( suit[o] == 1 )
					System.out.println("Spades");
				else if ( suit[o] == 2 )
					System.out.println("Clubs");
				else if ( suit[o] == 3 )
					System.out.println("Hearts");
				else if ( suit[o] == 4 )
					System.out.println("Diamonds");
			}
			
			// Checks hand value
				// checks for Straight
				if ( ((value[4] + 1) == value[3]) && ((value[3] + 1) == value[2]) && ((value[2] + 1) == value[1]) && ((value[1] + 1) == value[0]) ) {
					// checks for a Straight Flush
					if ( (suit[0] == suit[1]) && (suit[1] == suit[2]) && (suit[2] == suit[3]) && (suit[3] == suit[4]) ) {			
						// Checks for a Royal Flush
						if ( (value[0] ==  14 ) && (value[1] == 13 ) && (value[2] == 12 ) && (value[3] == 11 ) && (value[4] == 10 ) ){
							System.out.println("You were dealt a Royal Flush\n");
						} else {
							System.out.println("You were dealt a Straight Flush\n");
						}
					} else {
						System.out.println("You were dealt a Straight\n");
					}
				// Checks for flush
				} else if ( (suit[0] == suit[1]) && (suit[1] == suit[2]) && (suit[2] == suit[3]) && (suit[3] == suit[4]) ) {
					System.out.println("You were dealt a Flush\n");
				// Checks for pairs
				} else if ( (value[0] == value[1]) || (value[1] == value[2]) || (value[2] == value[3]) || (value[3] == value[4])) {
					// checks for Four of a Kind
					if ( ( ( value[0] == value[1] ) && ( value[0] == value[2] ) && ( value[0] == value[3] ) ) || ( ( value[1] == value[2] ) && ( value[1] == value[3] ) && ( value[1] == value[4] ) ) ) { 
						System.out.println("You were dealt a Four of a Kind\n");
					// checks for Three of a Kind
					} else if ( ( ( value[0] == value[1] ) && ( value[0] == value[2] ) ) || ( ( value[2] == value[3] ) && ( value[2] == value[4] ) ) || ( ( value[1] == value[2] ) && ( value[1] == value[3] ) ) ) {
						//checks for full house
						if ( ( ( value[0] == value[1] ) && ( value[0] == value[2] ) && ( value[3] == value[4] ) ) || ( ( value[0] == value[1] ) && ( value[2] == value[3] ) && ( value[2] == value[4] ) ) ) {
							System.out.println("You were dealt a Full House\n");
						} else {
							System.out.println("You were dealt a Three of a Kind\n");
						}
					// Checks for two pairs
					} else if ( ( ( value[0] == value[1] ) && ( value[2] == value[3] ) ) || ( ( value[1] == value[2] ) && ( value[3] == value[4] ) ) || ( ( value[0] == value[1] ) && ( value[3] == value[4] ) ) ) {
						System.out.println("You were dealt a Two Pair\n");
					} else {
						System.out.println("You were dealt a Pair\n");
					}
				// Checks for High Card
				} else {
					System.out.print("High card is a(n) ");
					if ( value[0] == 14 ) 
						System.out.println("Ace\n");
					else if ( value[0] == 13 )
						System.out.println("King\n");
					else if ( value[0] == 12 )
						System.out.println("Queen\n");
					else if ( value[0] == 11 )
						System.out.println("Jack\n");
					else 
						System.out.println( value[0] + "\n" );
				}
				
			// Prompts user for re-running program and checks for correct user input
			char answer;
			do {
				System.out.print("Play Again (Y or N)? ");
				String response = s.nextLine();
				answer = response.charAt(0);
				// checks for correct user input
				if ( ( answer == 'Y') || ( answer == 'y') ) 
					again = true;
				else if ( ( answer == 'N') || ( answer == 'n') )
					again = false;
				else 
					System.out.println("Please enter a \'Y\' or \'N\' only");
			} while ( !( ( ( answer == 'Y') || ( answer == 'y') ) || ( ( answer == 'N') || ( answer == 'n') ) ) ); // end of do-while loop
			
		} while ( again ); // end of do-while loop
		
	} // end of void
	
} // end of class