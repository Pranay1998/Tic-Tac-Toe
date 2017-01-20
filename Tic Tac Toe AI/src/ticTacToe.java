import java.util.Scanner;
import java.util.Random;



public class ticTacToe {
	
	
		//Constants to represent contents of a cell	
	private static final int EMPTY = 0;
	private static final int CROSS = 1;
	private static final int CIRCLE = 2;

		//2D Array for the Mother Board
	private static final int COLUMNS = 3;
	private static final int ROWS = 3;
	private static int[][] board = new int[ROWS][COLUMNS];



		//Constants to represent game state
	private static final int NO_RESULT = 0;
	private static final int CROSS_WINS = 1;
	private static final int CIRCLE_WINS = 2;
	private static final int DRAW = 3;
	
	protected static int playerDecision; //1 or 2 Players
	
	private static int currentState; // DRAW/WIN/LOSE/ON-GOING
	private static int currentTurn; // Current Players Turn

	private static Scanner input = new Scanner(System.in);	//Scanner for User Input
	
	protected static char player1; //'X'or 'O'
	protected static char computer; //'O' or 'X'
	
	protected static int DIFFICULTY; // 1 - easy, 2 - normal, 3- hard
	
	

	//Program Starts Here
	protected static void runGame() {	
		if(playerDecision == 2){ //1 v 1 
			initGame(); 
			printBoard();
			while(currentState == NO_RESULT){
				playTurn2();
				printBoard();
				if(isDraw())System.out.println("It's a draw, Well Played");
				if(isCrossWin())System.out.println("Cross's Wins!");
				if(isCircleWin())System.out.println("Circle's Wins!");	
			}
		}
		else if (playerDecision == 1){ //1 v computer
			initGame();
			if(player1 == 'X')printBoard();
			while(currentState == NO_RESULT){
				playTurn1();
				printBoard();
				if(isDraw())System.out.println("It's a draw, Well Played");
				if(isCrossWin()){
					if(player1 == 'X')System.out.println("You win!!");
					if(player1 == 'O')System.out.println("The Compupter Wins");
				}
				if(isCircleWin()){
					if(player1 == 'O')System.out.println("You win!!");
					if(player1 == 'X')System.out.println("The Compupter Wins");
				}
			}
		}
	}
	
	
	//randomly guessing computer, game mode - easy
	protected static void dumbComputer(){
		System.out.println("Computer's Turn");
		Random Rand = new Random();
		int g1 = 0;int g2 = 0;
		
		for(boolean isCorrect = false; !isCorrect ; ){
			g1 = Rand.nextInt(3);
			g2 = Rand.nextInt(3);
			if (board[g1][g2] == EMPTY)isCorrect = true;
		}
		if(computer == 'O'){
			board[g1][g2] = CIRCLE;
			currentTurn = CROSS;
		}
		else if (computer == 'X'){
			board[g1][g2] = CROSS;
			currentTurn = CIRCLE;
		}	
	}
	
	//tries to make a line of 3 first,(if not) then tries to block opponents line of 2, (if not) then calls dumb computer
	protected static void semiSmart(){
		boolean isComplete = false;
		if (computer == 'X'){
			if (checkX()){
				System.out.println("Computer's Turn");
				isComplete = true;
				currentTurn = CIRCLE;
			}
			if(!isComplete && blockO()){
				System.out.println("Computer's Turn");
				isComplete = true;
				currentTurn = CIRCLE;
			}
			if(!isComplete)dumbComputer();
			
		}
		else if (computer == 'O'){
			if (checkO()){
				isComplete = true;
				currentTurn = CROSS;
				System.out.println("Computer's Turn");
			}
			if(!isComplete && blockX()){
				isComplete = true;
				currentTurn = CROSS;
				System.out.println("Computer's Turn");
			}
			if(!isComplete)dumbComputer();
			
		}
	
	}
	
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
	
	//1 v 1 takes input and switches turn
	protected static void playTurn2(){
		   
		   switch (currentTurn) {
		   
		   		case CROSS:
		   			System.out.println("It's Cross's Turn, Row(1-3) Column(1-3)");
		   			
		   			int row1 = 0; int column1 = 0;
		   			for(boolean isCorrect = false; !isCorrect ; ){
		   				row1 = input.nextInt();
		   				column1 = input.nextInt();
		   				if(board [row1 - 1] [column1 -1] == EMPTY)isCorrect = true;
		   				else System.err.println("Cell Already Occupied, Try again");
		   			}
		   			board[row1-1][column1-1] = CROSS;
		   			currentTurn = CIRCLE;
		   		break;
		   
		   		case CIRCLE:
		   			System.out.println("It's Circle's Turn, Row(1-3) Column(1-3)");
		   			
		   			int row2 = 0; int column2 = 0;
		   			for(boolean isCorrect = false; !isCorrect ; ){
		   				row2 = input.nextInt();
		   				column2 = input.nextInt();
		   				if(board [row2 - 1] [column2 -1] == EMPTY)isCorrect = true;
		   				else System.err.println("Cell Already Occupied, Try again");
		   			}
		   			board[row2-1][column2-1] = CIRCLE;
		   			currentTurn = CROSS;
		   		break;
		   }
	   }	
	
	//switches turns between computer and player
	protected static void playTurn1(){
		switch (currentTurn) {
		
		case CROSS:
			if(computer == 'X'){
				if(DIFFICULTY == 1)dumbComputer();
				
				if(DIFFICULTY == 2){
					semiSmart();
				
				}
			}
			else if(player1 == 'X') {
				System.out.println("Players's Turn("+ player1 + "), Row(1-3) Column(1-3)");
	   			
	   			int row1 = 0; int column1 = 0;
	   			for(boolean isCorrect = false; !isCorrect ; ){
	   				row1 = input.nextInt();
	   				column1 = input.nextInt();
	   				if(board [row1 - 1] [column1 -1] == EMPTY)isCorrect = true;
	   				else System.err.println("Cell Already Occupied, Try again");
	   			}
	   			board[row1-1][column1-1] = CROSS;
	   			currentTurn = CIRCLE;
			}
			break;
				
			
		case CIRCLE:
			if(computer == 'O'){
				if(DIFFICULTY == 1)dumbComputer();
				if(DIFFICULTY == 2)semiSmart();
			}
			else if(player1 == 'O'){
				System.out.println("It's Circle's Turn, Row(1-3) Column(1-3)");
	   			
	   			int row2 = 0; int column2 = 0;
	   			for(boolean isCorrect = false; !isCorrect ; ){
	   				row2 = input.nextInt();
	   				column2 = input.nextInt();
	   				if(board [row2 - 1] [column2 -1] == EMPTY)isCorrect = true;
	   				else System.err.println("Cell Already Occupied, Try again");
	   			}
	   			board[row2-1][column2-1] = CIRCLE;
	   			currentTurn = CROSS;
	   		break;
			}
		
		
		}
	}

    //Initialize Game board	
	protected static void initGame(){
		for(int i = 0; i < ROWS ; i++){
			for(int j = 0; j < COLUMNS ; j++ ){board[i][j] = EMPTY;}
				
		}
		currentState = NO_RESULT;
		currentTurn = CROSS;
	
	}

	//Print Cells	
	protected static void printCell(int toPrint){
		if(toPrint == CROSS){System.out.print(" X " );return;}
		if(toPrint == CIRCLE){System.out.print(" O ");return;}
		if(toPrint == EMPTY){System.out.print("   ");return;}
	}
	//Print a Vertical Line
	protected static void printVertLine(){
		System.out.print("|");
	}
	//Print a Horizontal Line
	protected static void printHoriLine(){
		System.out.println("-----------");
		
	}
	
	 //Print Game Board
	   protected static void printBoard() {
	      printCell(board[0][0]);
	      printVertLine();
	      printCell(board[0][1]);
	      printVertLine();
	      printCell(board[0][2]);
	      System.out.println();
	      printHoriLine();
	      printCell(board[1][0]);
	      printVertLine();
	      printCell(board[1][1]);
	      printVertLine();
	      printCell(board[1][2]);
	      System.out.println();
	      printHoriLine();
	      printCell(board[2][0]);
	      printVertLine();
	      printCell(board[2][1]);
	      printVertLine();
	      printCell(board[2][2]);
	      for(int i = 0; i < 2 ; i++)System.out.println();
	   }
	   
	   //Checks if Cross has Won
	   protected static boolean isCrossWin(){
		   for (int rows = 0; rows < 3 ; rows ++){
			   if(board[rows][0] == CROSS && board[rows][1] == CROSS && board[rows][2] == CROSS){
				   currentState = CROSS_WINS;
				   return true; //3 X's in Rows
			   }
		   }
		   for (int columns = 0; columns < 3 ; columns ++){
			   if(board[0][columns] == CROSS && board[1][columns] == CROSS && board[2][columns] == CROSS){
				   currentState = CROSS_WINS; 
				   return true; // 3 O's in Columns
			   }
		   }
		   if(board[0][0] == CROSS && board[2][2] == CROSS && board[1][1] == CROSS){
			   currentState = CROSS_WINS;
			   return true; //Principle Diagonal 
		   }
		   if(board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS){
			   currentState = CROSS_WINS;
			   return true; //Other Diagonal
		   }
		   return false;
	   }
	   
	   
	   //Checks if Circles has Won
	   protected static boolean isCircleWin(){
		   for (int rows = 0; rows < 3 ; rows ++){
			   if(board[rows][0] == CIRCLE && board[rows][1] == CIRCLE && board[rows][2] == CIRCLE){
				   currentState = CIRCLE_WINS; 
				   return true; //3 O's in Rows
			   }
		   }
		   for (int columns = 0; columns < 3 ; columns ++){
			   if(board[0][columns] == CIRCLE && board[1][columns] == CIRCLE && board[2][columns] == CIRCLE){
				   currentState = CIRCLE_WINS; 
				   return true; // 3 O's in Columns
			   }	   
		   }
		   if(board[0][0] == CIRCLE && board[2][2] == CIRCLE && board[1][1] == CIRCLE){
			   currentState = CIRCLE_WINS; 
			   return true; //Principle Diagonal 
		   		}
		   if(board[0][2] == CIRCLE && board[1][1] == CIRCLE && board[2][0] == CIRCLE){
		   		currentState = CIRCLE_WINS; 
		   		return true; //Other Diagonal
		   		}
		   return false;
	   }
	   
	   //Checks if Game is a Draw
	   protected static boolean isDraw(){
		   if(!isCircleWin() && !isCrossWin()){
			   if(board [0][0] != EMPTY && board [0][1] != EMPTY && board [0][2] != EMPTY && board [1][0] != EMPTY && board [1][1] != EMPTY && board [1][2] != EMPTY && board [2][0] != EMPTY && board [2][1] != EMPTY && board [2][2] != EMPTY){
				   currentState = DRAW;
				   return true;   
			   }
		   }		
		   return false;
	   }
	   
}
