import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class XOButton6 extends JButton implements ActionListener {
		ImageIcon X,O;
		int value = 0;
		
		

		public XOButton6(){
			X = new ImageIcon(this.getClass().getResource("X.png"));
			O = new ImageIcon(this.getClass().getResource("O.png"));
			this.addActionListener(this);
			
			switch(ticTacToe.board [1][2]){
			
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
				if(ticTacToe.currentTurn == ticTacToe.CROSS && ticTacToe.board [1][2] == ticTacToe.EMPTY){
					setIcon(X);
					ticTacToe.currentTurn = ticTacToe.CIRCLE;
					ticTacToe.board [1][2] = ticTacToe.CROSS; 
				
					if(ticTacToe.isCrossWin()){
						Object[] possibleValues = { "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"CROSS WINS", "CROSS WINS",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[0] || selectedValue == null)System.exit(0);
						
					}
					if(ticTacToe.isDraw()){
						Object[] possibleValues = {  "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"DRAW", "DRAW",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[0] || selectedValue == null)System.exit(0);
						
					}
				
				}
				if(ticTacToe.currentTurn == ticTacToe.CIRCLE && ticTacToe.board [1][2] == ticTacToe.EMPTY){
					setIcon(O);
					ticTacToe.currentTurn = ticTacToe.CROSS;
					ticTacToe.board[1][2] = ticTacToe.CIRCLE;
					
					if(ticTacToe.isCircleWin()){
						Object[] possibleValues = {  "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"CIRCLE WINS", "CIRCLE WINS",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[0] || selectedValue == null)System.exit(0);
						
					}
					if(ticTacToe.isDraw()){
						Object[] possibleValues = {  "Close Game"};
						Object selectedValue = JOptionPane.showInputDialog(null,
						"DRAW", "DRAW",
						JOptionPane.INFORMATION_MESSAGE, null,
						possibleValues, possibleValues[0]);
						if(selectedValue == possibleValues[0] || selectedValue == null)System.exit(0);
						
					}
				}
			}
		}
	}
