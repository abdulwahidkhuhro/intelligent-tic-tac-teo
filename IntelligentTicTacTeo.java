import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class IntelligentTicTacTeo implements ActionListener{
	private JFrame window = new JFrame();
	private Container container = window.getContentPane();
	private GridLayout grid = new GridLayout(3,3,5,5);
	private JButton[][] buttons = new JButton[3][3];
	private final String o = "O";
	private final String x = "X";
	private boolean playerTurn = true;
	
	public IntelligentTicTacTeo(){
		window.setBounds(0,0,600,600);
		window.setLayout(grid);
		
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons[i].length; j++){
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.green);
				buttons[i][j].setFont(new Font("Arial",Font.BOLD,130));
				container.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
			}
		}
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(buttons[0][0] == e.getSource()){
			playerMove(buttons[0][0]);
			System.out.println("Button : 0");
		}else if(buttons[0][1] == e.getSource()){
			playerMove(buttons[0][1]);
			System.out.println("Button : 1");
		}else if(buttons[0][2] == e.getSource()){
			playerMove(buttons[0][2]);
			System.out.println("Button : 2");
		}else if(buttons[1][0] == e.getSource()){
			playerMove(buttons[1][0]);
			System.out.println("Button : 3");
		}else if(buttons[1][1] == e.getSource()){
			playerMove(buttons[1][1]);
			System.out.println("Button : 4");
		}else if(buttons[1][2] == e.getSource()){
			playerMove(buttons[1][2]);
			System.out.println("Button : 5");
		}else if(buttons[2][0] == e.getSource()){
			playerMove(buttons[2][0]);
			System.out.println("Button : 6");
		}else if(buttons[2][1] == e.getSource()){
			playerMove(buttons[2][1]);
			System.out.println("Button : 7");
		}else if(buttons[2][2] == e.getSource()){
			playerMove(buttons[2][2]);
			System.out.println("Button : 8");
		}
	}
	
	private void playerMove(JButton button){
			button.setLabel("O");
			machineMove(button);
	}
	
	private void machineMove(JButton button){
		int ith = 0, jth = 0;
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons.length; j++){
				if(buttons[i][j] == button){
					ith = i;
					jth = j;
					break;
				}
			}
		}
		
		if(ith == 0 && jth == 0 || ith == 0 && jth == 2 ||ith == 2 && jth == 0 || ith == 2 && jth == 2){
			if(ith == 0 && jth == 0 || ith == 2 && jth == 2){
				if(ith == 0 && jth == 0){
					buttons[2][2].setLabel("X");
				}else{
					buttons[0][0].setLabel("O");
				}
			}else{
				buttons[jth][ith].setLabel("X");
				
			}
		}
	}
	private boolean hasWon(String label){
		if(isMatched(buttons[0][0],buttons[0][1],buttons[0][2],label)){
			return true;
		}else if(isMatched(buttons[1][0],buttons[1][1],buttons[1][2],label)){
			return true;
		}else if(isMatched(buttons[2][0],buttons[2][1],buttons[2][2],label)){
			return true;
		}else if(isMatched(buttons[0][0],buttons[1][0],buttons[2][0],label)){
			return true;
		}else if(isMatched(buttons[0][1],buttons[1][1],buttons[2][1],label)){
			return true;
		}else if(isMatched(buttons[0][2],buttons[1][2],buttons[2][2],label)){
			return true;
		}else if(isMatched(buttons[0][0],buttons[1][1],buttons[2][2],label)){
			return true;
		}else if(isMatched(buttons[0][2],buttons[1][1],buttons[2][0],label)){
			return true;
		}
		return false;
	}
	private boolean isMatched(JButton b1, JButton b2, JButton b3,String label){
		boolean isTrue = b1.getLabel().equals(label) && b2.getLabel().equals(label) && b3.getLabel().equals(label);
		if(isTrue){
			b1.setBackground(Color.red);
			b2.setBackground(Color.red);
			b3.setBackground(Color.red);
		}
		return isTrue;
	}
	public static void main(String[] args){
		new IntelligentTicTacTeo();
	}
}