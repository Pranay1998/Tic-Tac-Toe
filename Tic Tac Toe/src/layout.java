import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class layout extends JFrame {
	
	public static int var = 1;
	
	static JPanel p = new JPanel();
	static XOButton1 button1 = new XOButton1();
	static XOButton2 button2 = new XOButton2();
	static XOButton3 button3 = new XOButton3();
	static XOButton4 button4 = new XOButton4();
	static XOButton5 button5 = new XOButton5();
	static XOButton6 button6 = new XOButton6();
	static XOButton7 button7 = new XOButton7();
	static XOButton8 button8 = new XOButton8();
	static XOButton9 button9 = new XOButton9();
	
	
	public  static void main(String args[]){
		
		
		ticTacToe.initGame();
		new layout();
	
	
	}
	
	public static void restartGame(){
		
		ticTacToe.initGame();
		new layout();
	}
	
	//define layout
	public layout(){
		
		
		super("Tic tac Toe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		
			button1 = new XOButton1();
			p.add(button1);
			button2 = new XOButton2();
			p.add(button2);
			button3 = new XOButton3();
			p.add(button3);
			button4 = new XOButton4();
			p.add(button4);
			button5 = new XOButton5();
			p.add(button5);
			button6 = new XOButton6();
			p.add(button6);
			button7 = new XOButton7();
			p.add(button7);
			button8 = new XOButton8();
			p.add(button8);
			button9 = new XOButton9();
			p.add(button9);
			
			add(p);
		
		
		setVisible(true);	
		
	}
	
}

	
	
