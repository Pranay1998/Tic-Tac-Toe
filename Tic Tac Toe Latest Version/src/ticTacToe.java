import java.util.Scanner;
import java.util.Random;



public class ticTacToe {
	
	
		//Constants to represent contents of a cell	
	public static final int EMPTY = 0;
	public static final int CROSS = 1;
	public static final int CIRCLE = 2;

		//2D Array for the Mother Board
	private static final int COLUMNS = 3;
	private static final int ROWS = 3;
	public static int[][] board = new int[ROWS][COLUMNS];
	



		//Constants to represent game state

	protected static int playerDecision = 2; //1 or 2 Players
	
	public static int currentState; // DRAW/WIN/LOSE/ON-GOING
	public static int currentTurn; // Current Players Turn

	
	
	protected static int DIFFICULTY; // 1 - easy, 2 - normal, 3- hard
	
	

	//make 3 'X' in a line and return true if possible
	protected static boolean checkX(){
		for (int i = 0 ; i < 3 ;i++){
			if(board [i] [0] == CROSS && board [i] [1] == CROSS && board [i] [2] == EMPTY){
				board[i][2] = CROSS;
				return true;
			}	
			if(board [i] [1] == CROSS && board [i] [2] == CROSS && board [i] [0] == EMPTY){
				board[i][0] = CROSS;
				return true;
			}
			if(board [i] [0] == CROSS && board [i] [2] == CROSS && board [i] [1] == EMPTY){
				board[i][1] = CROSS;
				return true;
			}
		}
		
		for (int i1 = 0 ; i1 < 3 ;i1++){
				if(board  [0][i1] == CROSS && board  [1][i1] == CROSS && board  [2][i1] == EMPTY){
					board[i1][2] = CROSS;
					return true;
				}	
				if(board  [1][i1] == CROSS && board [2] [i1] == CROSS && board  [0][i1] == EMPTY){
					board[0][i1] = CROSS;
					return true;
				}
				if(board  [0][i1] == CROSS && board  [2][i1] == CROSS && board [1][i1] == EMPTY){
					board[1][i1] = CROSS;
					return true;
				}
		}
		
		if(board [0] [0] == CROSS && board [1] [1] == CROSS && board [2] [2] == EMPTY){
			board [2] [2] = CROSS;
			return true;
		}
		if(board [1] [1] == CROSS && board [2] [2] == CROSS && board [0] [0] == EMPTY){
			board [0] [0] = CROSS;
			return true;
		}
		if(board [2] [2] == CROSS && board [0] [0] == CROSS && board [1] [1] == EMPTY){
			board [1] [1] = CROSS;
			return true;
		}
		if(board [0] [2] == CROSS && board [1] [1] == CROSS && board [2] [0] == EMPTY){
			board [2] [0] = CROSS;
			return true;
		}
		if(board [1] [1] == CROSS && board [2] [0] == CROSS && board [0] [2] == EMPTY){
			board [0] [2] = CROSS;
			return true;
		}
		if(board [2] [0] == CROSS && board [0] [2] == CROSS && board [1] [1] == EMPTY){
			board [1] [1] = CROSS;
			return true;
		}
		
		
		
		return false;
	}
	
	//make 3 'O' in a line and return true if possible
	protected static boolean checkO(){
		
		for (int i = 0 ; i < 3 ;i++){
			if(board [i] [0] == CIRCLE && board [i] [1] == CIRCLE && board [i] [2] == EMPTY){
				board[i][2] = CIRCLE;
				return true;
			}	
			if(board [i] [1] == CIRCLE && board [i] [2] == CIRCLE && board [i] [0] == EMPTY){
				board[i][0] = CIRCLE;
				return true;
			}
			if(board [i] [0] == CIRCLE && board [i] [2] == CIRCLE && board [i] [1] == EMPTY){
				board[i][1] = CIRCLE;
				return true;
			}
		}
		
		for (int i1 = 0 ; i1 < 3 ;i1++){
			if(board  [0][i1] == CIRCLE && board  [1][i1] == CIRCLE && board  [2][i1] == EMPTY){
				board[i1][2] = CIRCLE;
				return true;
			}	
			if(board  [1][i1] == CIRCLE && board [2] [i1] == CIRCLE && board  [0][i1] == EMPTY){
				board[0][i1] = CIRCLE;
				return true;
			}
			if(board  [0][i1] == CIRCLE && board  [2][i1] == CIRCLE && board [1][i1] == EMPTY){
				board[1][i1] = CIRCLE;
				return true;
			}
		}
		
		if(board [0] [0] == CIRCLE && board [1] [1] == CIRCLE && board [2] [2] == EMPTY){
			board [2] [2] = CIRCLE;
			return true;
		}
		if(board [1] [1] == CIRCLE && board [2] [2] == CIRCLE && board [0] [0] == EMPTY){
			board [0] [0] = CIRCLE;
			return true;
		}
		if(board [2] [2] == CIRCLE && board [0] [0] == CIRCLE && board [1] [1] == EMPTY){
			board [1] [1] = CIRCLE;
			return true;
		}
		if(board [0] [2] == CIRCLE && board [1] [1] == CIRCLE && board [2] [0] == EMPTY){
			board [2] [0] = CIRCLE;
			return true;
		}
		if(board [1] [1] == CIRCLE && board [2] [0] == CIRCLE && board [0] [2] == EMPTY){
			board [0] [2] = CIRCLE;
			return true;
		}
		if(board [2] [0] == CIRCLE && board [0] [2] == CIRCLE && board [1] [1] == EMPTY){
			board [1] [1] = CIRCLE;
			return true;
		}
		
	
	
	
		return false;
	}
	
	//checks for two 'X' in a line and blocks the third one
	protected static boolean blockX(){
		
		for (int i = 0 ; i < 3 ;i++){
			if(board [i] [0] == CROSS && board [i] [1] == CROSS && board [i] [2] == EMPTY){
				board[i][2] = CIRCLE;
				return true;
			}	
			if(board [i] [1] == CROSS && board [i] [2] == CROSS && board [i] [0] == EMPTY){
				board[i][0] = CIRCLE;
				return true;
			}
			if(board [i] [0] == CROSS && board [i] [2] == CROSS && board [i] [1] == EMPTY){
				board[i][1] = CIRCLE;
				return true;
			}
		}
		
		for (int i1 = 0 ; i1 < 3 ;i1++){
			if(board  [0][i1] == CROSS && board  [1][i1] == CROSS && board  [2][i1] == EMPTY){
				board[i1][2] = CIRCLE;
				return true;
			}	
			if(board  [1][i1] == CROSS && board [2] [i1] == CROSS && board  [0][i1] == EMPTY){
				board[0][i1] = CIRCLE;
				return true;
			}
			if(board  [0][i1] == CROSS && board  [2][i1] == CROSS && board [1][i1] == EMPTY){
				board[1][i1] = CIRCLE;
				return true;
			}
		}
		
		if(board [0] [0] == CROSS && board [1] [1] == CROSS && board [2] [2] == EMPTY){
			board [2] [2] = CIRCLE;
			return true;
		}
		if(board [1] [1] == CROSS && board [2] [2] == CROSS && board [0] [0] == EMPTY){
			board [0] [0] = CIRCLE;
			return true;
		}
		if(board [2] [2] == CROSS && board [0] [0] == CROSS && board [1] [1] == EMPTY){
			board [1] [1] = CIRCLE;
			return true;
		}
		if(board [0] [2] == CROSS && board [1] [1] == CROSS && board [2] [0] == EMPTY){
			board [2] [0] = CIRCLE;
			return true;
		}
		if(board [1] [1] == CROSS && board [2] [0] == CROSS && board [0] [2] == EMPTY){
			board [0] [2] = CIRCLE;
			return true;
		}
		if(board [2] [0] == CROSS && board [0] [2] == CROSS && board [1] [1] == EMPTY){
			board [1] [1] = CIRCLE;
			return true;
		}
		
		
		return false;
	}
	
	
	//checks for two 'O' in a line and blocks the third one
	protected static boolean blockO(){
		
		for (int i = 0 ; i < 3 ;i++){
			if(board [i] [0] == CIRCLE && board [i] [1] == CIRCLE && board [i] [2] == EMPTY){
				board[i][2] = CROSS;
				return true;
			}	
			if(board [i] [1] == CIRCLE && board [i] [2] == CIRCLE && board [i] [0] == EMPTY){
				board[i][0] = CROSS;
				return true;
			}
			if(board [i] [0] == CIRCLE && board [i] [2] == CIRCLE && board [i] [1] == EMPTY){
				board[i][1] = CROSS;
				return true;
			}
		}
		
		for (int i1 = 0 ; i1 < 3 ;i1++){
			if(board  [0][i1] == CIRCLE && board  [1][i1] == CIRCLE && board  [2][i1] == EMPTY){
				board[i1][2] = CROSS;
				return true;
			}	
			if(board  [1][i1] == CIRCLE && board [2] [i1] == CIRCLE && board  [0][i1] == EMPTY){
				board[0][i1] = CROSS;
				return true;
			}
			if(board  [0][i1] == CIRCLE && board  [2][i1] == CIRCLE && board [1][i1] == EMPTY){
				board[1][i1] = CROSS;
				return true;
			}
		}
		
		if(board [0] [0] == CIRCLE && board [1] [1] == CIRCLE && board [2] [2] == EMPTY){
			board [2] [2] = CROSS;
			return true;
		}
		if(board [1] [1] == CIRCLE && board [2] [2] == CIRCLE && board [0] [0] == EMPTY){
			board [0] [0] = CROSS;
			return true;
		}
		if(board [2] [2] == CIRCLE && board [0] [0] == CIRCLE && board [1] [1] == EMPTY){
			board [1] [1] = CROSS;
			return true;
		}
		if(board [0] [2] == CIRCLE && board [1] [1] == CIRCLE && board [2] [0] == EMPTY){
			board [2] [0] = CROSS;
			return true;
		}
		if(board [1] [1] == CIRCLE && board [2] [0] == CIRCLE && board [0] [2] == EMPTY){
			board [0] [2] = CROSS;
			return true;
		}
		if(board [2] [0] == CIRCLE && board [0] [2] == CIRCLE && board [1] [1] == EMPTY){
			board [1] [1] = CROSS;
			return true;
		}
		
		return false;
	}
	
	//Initialize Game board	
	protected static void initGame(){
		for(int i = 0; i < ROWS ; i++){
			for(int j = 0; j < COLUMNS ; j++ ){board[i][j] = EMPTY;}
				
		}
		
		currentTurn = CROSS;
	
	}

	//Checks if Cross has Won
	   protected static boolean isCrossWin(){
		   for (int rows = 0; rows < 3 ; rows ++){
			   if(board[rows][0] == CROSS && board[rows][1] == CROSS && board[rows][2] == CROSS){
				   
				   return true; //3 X's in Rows
			   }
		   }
		   for (int columns = 0; columns < 3 ; columns ++){
			   if(board[0][columns] == CROSS && board[1][columns] == CROSS && board[2][columns] == CROSS){
				   
				   return true; // 3 O's in Columns
			   }
		   }
		   if(board[0][0] == CROSS && board[2][2] == CROSS && board[1][1] == CROSS){
			   
			   return true; //Principle Diagonal 
		   }
		   if(board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS){
			   
			   return true; //Other Diagonal
		   }
		   return false;
	   }
	   
	   
	   //Checks if Circles has Won
	   protected static boolean isCircleWin(){
		   for (int rows = 0; rows < 3 ; rows ++){
			   if(board[rows][0] == CIRCLE && board[rows][1] == CIRCLE && board[rows][2] == CIRCLE){
				   
				   return true; //3 O's in Rows
			   }
		   }
		   for (int columns = 0; columns < 3 ; columns ++){
			   if(board[0][columns] == CIRCLE && board[1][columns] == CIRCLE && board[2][columns] == CIRCLE){
				    
				   return true; // 3 O's in Columns
			   }	   
		   }
		   if(board[0][0] == CIRCLE && board[2][2] == CIRCLE && board[1][1] == CIRCLE){
			  
			   return true; //Principle Diagonal 
		   		}
		   if(board[0][2] == CIRCLE && board[1][1] == CIRCLE && board[2][0] == CIRCLE){
		   		 
		   		return true; //Other Diagonal
		   		}
		   return false;
	   }
	   
	   //Checks if Game is a Draw
	   protected static boolean isDraw(){
		   if(!isCircleWin() && !isCrossWin()){
			   if(board [0][0] != EMPTY && board [0][1] != EMPTY && board [0][2] != EMPTY && board [1][0] != EMPTY && board [1][1] != EMPTY && board [1][2] != EMPTY && board [2][0] != EMPTY && board [2][1] != EMPTY && board [2][2] != EMPTY){
				  
				   return true;   
			   }
		   }		
		   return false;
	   }
	   
}
