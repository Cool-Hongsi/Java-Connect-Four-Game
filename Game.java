package Task2;

import java.util.Scanner;

public class Game {
	  public static void main (String[] args) {
		  
		  ///////////////////////////////////////////////////////////////////////////////
		  /* Declare Variables */
		  
		  int i, j, count = 0, repeat = 1;
		  
		  String[][] board = new String[7][15];
		  // In order to divide each section, have to create two dimensional array
		  // 7 -> row (including ------)
		  // 15 -> column (including space between | |)
		  
		  ///////////////////////////////////////////////////////////////////////////////
		  /* Creating the Board */
		  
		  for (i=0; i<board.length; i++) {
		  // board.length -> 7 (row value)
			  
			for (j=0; j<board[i].length; j++) {
			// board[i].length -> 15 (column value)
				  
			    if (j % 2 == 0) {
			    	board[i][j] = "|";
			    	// even number position -> |
			    }
		        
			    else {
			    	board[i][j] = " ";
			    	// odd number position -> space
			    }
			      
			    if (i == 6) {
			    	board[i][j]= "-";
			        // in order to print ------------ at the end of board every time
			    }
			 }
		  }

		  ///////////////////////////////////////////////////////////////////////////////
		  /* Print Board */
		  
		  for (i=0; i<board.length; i++) {
		      for (j=0; j<board[i].length; j++) {
		    	  System.out.print(board[i][j]);
		      }
		        
		      System.out.println();
		  }
		    
		  ///////////////////////////////////////////////////////////////////////////////
		  /* Drop Red & Yellow in Board */
		    
		  while(repeat == 1) {
		  // it will be executed until repeat == 0
		  // repeat == 0 means one of color has a win !
		       
		  if (count % 2 == 0) {
		  // Play Red First (even number means Red Turn)   
		      RedTurn(board);
		      System.out.println();
		  }
		       
		  else {
		  // Play Yellow Second (odd number means Yellow Turn) 
		      YellowTurn(board);
		      System.out.println();
		  }
		       
		  count++;
		  // Important !!!! have to increase one every time in order to pass next turn
		       
		  // Print Board every time
		  for (i=0; i<board.length; i++) {
			  for (j=0; j<board[i].length; j++) {
				  System.out.print(board[i][j]);
			  }
			        
			  System.out.println();
		  }
		       
		  ///////////////////////////////////////////////////////////////////////////////
		  /* Check Winner (Hardest Part) */ 
			   
		  if (Winner(board) != null) {
		  // If one of color has a win, the value of return will ' not ' be null
				   
			  if (Winner(board).toUpperCase() == "R") {
				  System.out.println("The red player won");
			  }
				   
			  else if(Winner(board).toUpperCase() == "Y") {
				  System.out.println("The yellow player won");
			  }
				   
			  else {
				  System.out.println("Nobody has a win");
			  }
			             
			  repeat = 0;
			  // One of color has a win!
			  // Stop to do while loop
		  }
	  }
  }
	  
  ///////////////////////////////////////////////////////////////////////////////
  /* RedTurn Method */

  public static void RedTurn(String[][] paramBoard) {
	
    System.out.print("Drop a red disk at column (0–6): ");
    
    @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    
    ///////////////////////////////////////////////////////////////////////////////
    /* Check Validation */
    
    String initialValueRed = sc.next();
    boolean intType = isNumeric(initialValueRed);
    int realValueRed = 0;
    
    if(intType == true) {
    	realValueRed = Integer.parseInt(initialValueRed);
        
    	if(realValueRed < 0 || realValueRed > 6) {
        	do {
            		System.out.print("Input Valid Value (0-6): ");
            		realValueRed = sc.nextInt();
        	}while(realValueRed < 0 || realValueRed > 6);
        }
    }
    else {
    	do {
        	System.out.print("Input Valid Value (0-6): ");
        	initialValueRed = sc.next();
        	intType = isNumeric(initialValueRed);
    	}while(intType == false);
    	
        if(intType == true) {
        	realValueRed = Integer.parseInt(initialValueRed);
            
        	if(realValueRed < 0 || realValueRed > 6) {
            	do {
                		System.out.print("Input Valid Value (0-6): ");
                		realValueRed = sc.nextInt();
            	}while(realValueRed < 0 || realValueRed > 6);
            }
        }
    }
    
    int inputRed = (realValueRed * 2) + 1;
    // The position of space is 1 3 5 7 9 11 13
    // If the user put 2 column -> then, the 'R' will be stored in 5 position
    
    for (int row=5; row>=0; row--) {
    	if (paramBoard[row][inputRed] == " ") {
    		paramBoard[row][inputRed] = "R";
    		break;
    		// The reason why ' row ' starts 5 is to store the value into the 5th row (at the bottom)
    		// As decreasing -1, the row will be going up like 5th, 4th, 3th, 2th, 1th, 0th
    		// As long as there is nothing, it will be stored ' R ' in corresponding space
    	}
    }
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  /* YellowTurn Method */
  
  public static void YellowTurn(String[][] paramBoard) {
	  
    System.out.print("Drop a yellow disk at column (0–6): ");
    
    @SuppressWarnings("resource")
	Scanner sc = new Scanner (System.in);
    
    ///////////////////////////////////////////////////////////////////////////////
    /* Check Validation */
    
    String initialValueYellow = sc.next();
    boolean intType = isNumeric(initialValueYellow);
    int realValueYellow = 0;
    
    if(intType == true) {
    	realValueYellow = Integer.parseInt(initialValueYellow);
        
    	if(realValueYellow < 0 || realValueYellow > 6) {
        	do {
            		System.out.print("Input Valid Value (0-6): ");
            		realValueYellow = sc.nextInt();
        	}while(realValueYellow < 0 || realValueYellow > 6);
        }
    }
    else {
    	do {
        	System.out.print("Input Valid Value (0-6): ");
        	initialValueYellow = sc.next();
        	intType = isNumeric(initialValueYellow);
    	}while(intType == false);
    	
        if(intType == true) {
        	realValueYellow = Integer.parseInt(initialValueYellow);
            
        	if(realValueYellow < 0 || realValueYellow > 6) {
            	do {
                		System.out.print("Input Valid Value (0-6): ");
                		realValueYellow = sc.nextInt();
            	}while(realValueYellow < 0 || realValueYellow > 6);
            }
        }
    }
    
    int inputYellow = (realValueYellow * 2) + 1;
    // The position of space is 1 3 5 7 9 11 13
    // If the user put 2 column -> then, the 'Y' will be stored in 5 position
    
    for (int row=5; row>=0; row--) {
    	if (paramBoard[row][inputYellow] == " ") {
    		paramBoard[row][inputYellow] = "Y";
    		break;
    		// The reason why ' row ' starts 5 is to store the value into the 5th row (at the bottom)
    		// As decreasing -1, the row will be going up like 5th, 4th, 3th, 2th, 1th, 0th
    		// As long as there is nothing, it will be stored ' Y ' in corresponding space
    	}
    }
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  /* Validation for Numeric */
  
  public static boolean isNumeric(String initialValueRed) {
	  try {
		  Integer.parseInt(initialValueRed);
		  return true;
	  }
	  catch(NumberFormatException e) {
		  return false;
	  }
  }
  
  ///////////////////////////////////////////////////////////////////////////////
  /* Winner Method */
  
  public static String Winner(String[][] paramBoard) {
	  
	  /////////////////////////////////////////////////////////////////////////////////
	  /* Horizon - each row has to have four same character (R or Y) with connecting */
	  
	  for (int row=0; row<6; row++) {
	  // 0 means at the bottom row
	  // 5 means at the top row
	  // 6 means ------------ (nothing) (so it is excluded)
    
	      for (int space=0; space<7; space+=2) {
	      // space+=2 means the position of space is 1 3 5 7 9 11 13
    	  
	    	  if ((paramBoard[row][space+1] != " ") && (paramBoard[row][space+3] != " ") && (paramBoard[row][space+5] != " ") && (paramBoard[row][space+7] != " ") &&
	    		   // above line means the spaces which are 1th 3rd 5th 7th is empty in each row
	    		 ((paramBoard[row][space+1] == paramBoard[row][space+3]) && (paramBoard[row][space+3] == paramBoard[row][space+5]) && (paramBoard[row][space+5] == paramBoard[row][space+7]))) {
	    		   // above line means each space has same value (R or Y) with connecting
	    		   
	    		   return paramBoard[row][space+1]; // return the corresponding value
	    	  }
	       }
	   }
	  
	   /////////////////////////////////////////////////////////////////////////////////////
	   /* Vertical - each column has to have four same character (R or Y) with connecting */
    
	   for (int column=1; column<15; column+=2) {
	   // 1 means first space as column
	   // 13 means last space as column
	   // 15 means | (nothing) (so it is excluded)
	   // column+=2 means the position of space is 1 3 5 7 9 11 13
		   
		   for (int row=0; row<3; row++) {
    	   
			   if((paramBoard[row][column] != " ") && (paramBoard[row+1][column] != " ") && (paramBoard[row+2][column] != " ") && (paramBoard[row+3][column] != " ") && 
				   // above line means the spaces which are 1th 3rd 5th 7th is empty in each column
			     ((paramBoard[row][column] == paramBoard[row+1][column]) && (paramBoard[row+1][column] == paramBoard[row+2][column]) && (paramBoard[row+2][column] == paramBoard[row+3][column]))) {
				   // above line means each space has same value (R or Y) with connecting
				   
				   return paramBoard[row][column]; // return the corresponding value
			   }
		   }
	   }
    
	   /////////////////////////////////////////////////////////////////////////////////////////////////
	   /* Left Diagonal - each left diagonal has to have four same character (R or Y) with connecting */
    
	   for (int row=0; row<3; row++) {
		   
		   for (int column=1; column<9; column+=2) {
		   // 1 means first space as column in row
		   // 7 means last space as column in row
	       // 9 means space (nothing) (so it is excluded)
		   // column+=2 means the position of space is 1 3 5 7
			   
			   if((paramBoard[row][column] != " ") && (paramBoard[row+1][column+2] != " ") && (paramBoard[row+2][column+4] != " ") && (paramBoard[row+3][column+6] != " ") && 					   
			     ((paramBoard[row][column] == paramBoard[row+1][column+2]) && (paramBoard[row+1][column+2] == paramBoard[row+2][column+4]) && (paramBoard[row+2][column+4] == paramBoard[row+3][column+6]))) {
				   // above two lines mean the spaces which are row & column / row + 1 & column ... is empty
				   
				   // example (column -> 1 -> 3 -> 5 -> 7)
				   
				   // [row][column]      -> O | X
					   
				   // [row+1][column+2]  -> O | X
				   //                       X | O
				   
				   // [row+2][column+4]  -> O | X | X
				   //                       X | O | X
				   //                       X | X | O
					   
				   // [row+3][column+6]  -> O | X | X | X
				   //                       X | O | X | X
			       //                       X | X | O | X
				   //                       X | X | X | O
				   
				   return paramBoard[row][column]; // return the corresponding value
			   }
		   }
	   }
    
	   /////////////////////////////////////////////////////////////////////////////////////////////////
	   /* Right Diagonal - each right diagonal has to have four same character (R or Y) with connecting */
	   
	   for (int row=0; row<3; row++) {
		   
		   for (int column=7; column<15; column+=2) {
		   // 7 means first space as column in row
		   // 13 means last space as column in row
		   // 15 means space (nothing) (so it is excluded)
		   // column+=2 means the position of space is 7 9 11 13 
			   
			   if((paramBoard[row][column] != " ") && (paramBoard[row+1][column-2] != " ") && (paramBoard[row+2][column-4] != " ") && (paramBoard[row+3][column-6] != " ") && 
			     ((paramBoard[row][column] == paramBoard[row+1][column-2]) && (paramBoard[row+1][column-2] == paramBoard[row+2][column-4]) && (paramBoard[row+2][column-4] == paramBoard[row+3][column-6]))) {
				   // above two lines mean the spaces which are row & column / row + 1 & column ... is empty
				   
				   // example (column -> 13 -> 11 -> 9 -> 7)
				   
				   // [row][column]      -> X | O
					   
				   // [row+1][column-2]  -> X | O
				   //                       O | X
				   
				   // [row+2][column-4]  -> X | X | O
				   //                       X | O | X
				   //                       O | X | X
					   
				   // [row+3][column-6]  -> X | X | X | O
				   //                       X | X | O | X
			       //                       X | O | X | X
				   //                       O | X | X | X
				   
				   return paramBoard[row][column]; // return the corresponding value
			   }
		   }
	   }
    
	// There is no corresponding value for return value (keep playing)
    return null;
  }
}
