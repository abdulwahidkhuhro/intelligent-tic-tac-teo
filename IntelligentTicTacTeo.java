import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class IntelligentTicTacTeo implements ActionListener{
	private JFrame window = new JFrame();
	private Container container = window.getContentPane();
	private GridLayout grid = new GridLayout(3,3,5,5);
	private JButton[][] buttons = new JButton[3][3];
	//For Computer X and for Player O
	private final String _O = "O";
	private final String _X = "X";
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
		machineMove();
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
	
	private int{} computerWinCheck(){
		for(int i = 0,; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][1],buttons[i][2],"X")){
				return new int[]{i,0};
			}
		}
		
		for(int i = 0,j = 0; i < button.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][2],"X")){
				return new int[]{i,1};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[1][j],"X")){
				return new int[]{2,j};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[2][j],"X")){
				return new int[]{1,j};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[1][j],buttons[2][j],"X")){
				return new int[]{0,j};
			}
		}
		
		if(isDiagonalMatched(buttons[0][0],buttons[1][1],"X")){
			return new int[]{2,2};
		}
		if(isDiagonalMatched(buttons[0][0],buttons[2][2],"X")){
			return new int[]{1,1}
		}
		if(isDiagonalMatched(button[1][1],buttons[2][2],"X")){
			return new int[]{0,0};
		}
		return new int[]{-1,-1};
		
	}
	
	private boolean isMatchedInRow(Button b1, Button b2,String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	private boolean isMatchedInColumn(Button b1,Button b2,String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	private boolean isDiagonalMatched(Button b1, Button b2, String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	private int userWinCheck(){
		for(int i = 0,; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][1],buttons[i][2],"O")){
				return new int[]{i,0};
			}
		}
		
		for(int i = 0,j = 0; i < button.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][2],"O")){
				return new int[]{i,1};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[1][j],"O")){
				return new int[]{2,j};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[2][j],"O")){
				return new int[]{1,j};
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[1][j],buttons[2][j],"O")){
				return new int[]{0,j};
			}
		}
		
		if(isDiagonalMatched(buttons[0][0],buttons[1][1],"O")){
			return new int[]{2,2};
		}
		if(isDiagonalMatched(buttons[0][0],buttons[2][2],"O")){
			return new int[]{1,1}
		}
		if(isDiagonalMatched(button[1][1],buttons[2][2],"O")){
			return new int[]{0,0};
		}
		return new int[]{-1,-1};
		
	}
	
	private int winPosibilitiesCheck(){
		
	}
	
	private void secondPlayer(){
		
	}
	
	private void mark(int[] index){
		int i = index[0], j = index[1];
		if(i >= 0 && j >= 0){
			if(playerTurn){
				if(!buttons[i][j].getLabel().isEmpty()){
					button[i][j].setLabel("X");
				}
				playerTurn = false;
			}else{
				
			}
		}
		
	}
	public static void main(String[] args){
		new IntelligentTicTacTeo();
	}
}