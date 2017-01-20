import javax.swing.JOptionPane;

public class InitialPara extends ticTacToe {

	public static void main(String[] args) {
		new InitialPara();
		

	}
	
//gets initial parameters to start the game
	public InitialPara() {
		
		Object[] options = { "1 Player", "2 Player" };
		Object[] firstPerson = { "You" , "Computer"};
		Object[] Difficulty = { "Easy", "Medium", "Impossible"};
		
		Object noPlayers = JOptionPane.showInputDialog(null,   //choose number of players
				"Choose Number of Players", "Tic Tac Toe",
				JOptionPane.INFORMATION_MESSAGE, null,
				options, options[0]);
		
		if(noPlayers == options[0])playerDecision = 1;
		if(noPlayers == options[1])playerDecision = 2;
		
		
		if(playerDecision == 1){
			
			Object aiLevel = JOptionPane.showInputDialog(null, "Select Difficulty", "Tic Tac Toe",  //select difficulty
					JOptionPane.INFORMATION_MESSAGE,
					null, Difficulty, Difficulty[0]);
			
			if(aiLevel == Difficulty[0])DIFFICULTY = 1;
			if(aiLevel == Difficulty[1])DIFFICULTY = 2;
			if(aiLevel == Difficulty[2])DIFFICULTY = 3;
			
			Object whoFirst = JOptionPane.showInputDialog(null, "Who goes first?", "Tic Tac Toe",  //asks who goes first
			JOptionPane.INFORMATION_MESSAGE,
			null, firstPerson, firstPerson[0]);
			
			if(whoFirst == firstPerson[0]){
				computer = 'O';
				player1 = 'X';
			}
			if(whoFirst == firstPerson[1]){
				computer = 'X';
				player1 = 'O';
			}
		}
		
		//runs game
		ticTacToe.runGame();
		
	}
	
	
}
