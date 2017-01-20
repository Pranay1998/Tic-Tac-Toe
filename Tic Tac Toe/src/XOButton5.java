import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class XOButton5 extends JButton implements ActionListener {
		ImageIcon X,O;
		int value = 0;
		
		

		public XOButton5(){
			X = new ImageIcon(this.getClass().getResource("X.png"));
			O = new ImageIcon(this.getClass().getResource("O.png"));
			this.addActionListener(this);
			
			switch(ticTacToe.board [1][1]){
			
			case ticTacToe.CROSS :
				setIcon(X);
			case ticTacToe.CIRCLE :
				setIcon(O);
				
			case ticTacToe.EMPTY:	
				break;
		}
		
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(ticTacToe.playerDecision == 2 ){
				if(ticTacToe.currentTurn == ticTacToe.CROSS && ticTacToe.board [1][1] == ticTacToe.EMPTY){
					setIcon(X);
					ticTacToe.currentTurn = ticTacToe.CIRCLE;
					ticTacToe.board [1][1] = ticTacToe.CROSS; 
				
					if(ticTacToe.isCrossWin()){
						Object[] possibleValues = { "New Game", "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"CROSS WINS", "CROSS WINS",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[1] || selectedValue == null)System.exit(0);
						layout.restartGame();
					}
				
				}
				if(ticTacToe.currentTurn == ticTacToe.CIRCLE && ticTacToe.board [1][1] == ticTacToe.EMPTY){
					setIcon(O);
					ticTacToe.currentTurn = ticTacToe.CROSS;
					ticTacToe.board[1][1] = ticTacToe.CIRCLE;
					
					if(ticTacToe.isCircleWin()){
						Object[] possibleValues = { "New Game", "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"CIRCLE WINS", "CIRCLE WINS",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[1] || selectedValue == null)System.exit(0);
						layout.restartGame();
					}
				}
			}
		}
	}
