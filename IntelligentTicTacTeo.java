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
				buttons[i][j] = new JButton("");
				buttons[i][j].setBackground(Color.green);
				buttons[i][j].setFont(new Font("Arial",Font.BOLD,130));
				container.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
			}
		}
		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		JButton firstPlayer = (JButton) e.getSource();
		if(firstPlayer.getLabel().equals("")){
			firstPlayer.setText("O");
		}
		secondPlayer();
	}
	
	private int[] computerWinCheck(){
		System.out.println("computerWinCheck called");
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][1],"X")){
				if(buttons[i][2].getLabel().isEmpty()){
					return new int[]{i,2};
				}
			}
		}
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][2],"X")){
				if(buttons[i][1].getLabel().isEmpty()){
					return new int[]{i,1};
				}
			}
		}
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][1],buttons[i][2],"X")){
				if(buttons[i][0].getLabel().isEmpty()){
					return new int[]{i,0};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[1][j],"X")){
				if(buttons[2][j].getLabel().isEmpty()){
					return new int[]{2,j};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[2][j],"X")){
				if(buttons[1][j].getLabel().isEmpty()){
					return new int[]{1,j};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[1][j],buttons[2][j],"X")){
				if(buttons[0][j].getLabel().isEmpty()){
					return new int[]{0,j};
				}
			}
		}
		
		if(isDiagonalMatched(buttons[0][0],buttons[1][1],"X")){
			if(buttons[2][2].getLabel().isEmpty()){
				return new int[]{2,2};
			}
			
		}
		if(isDiagonalMatched(buttons[0][0],buttons[2][2],"X")){
			if(buttons[1][1].getLabel().isEmpty()){
				return new int[]{1,1};
			}
		}
		if(isDiagonalMatched(buttons[1][1],buttons[2][2],"X")){
			if(buttons[0][0].getLabel().isEmpty()){
				return new int[]{0,0};
			}
		}
		if(isDiagonalMatched(buttons[0][2],buttons[1][1],"X")){
			if(buttons[2][0].getLabel().isEmpty()){
				return new int[]{2,0};
			}
			
		}
		if(isDiagonalMatched(buttons[0][2],buttons[2][0],"X")){
			if(buttons[1][1].getLabel().isEmpty()){
				return new int[]{1,1};
			}
		}
		if(isDiagonalMatched(buttons[2][0],buttons[1][1],"X")){
			if(buttons[0][2].getLabel().isEmpty()){
				return new int[]{0,2};
			}
		}
		return new int[]{-1,-1};
		
	}
	
	private int[] userWinCheck(){
		System.out.println("userWinCheck called");
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][1],"O")){
				if(buttons[i][2].getLabel().isEmpty()){
					return new int[]{i,2};
				}
			}
		}
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][0],buttons[i][2],"O")){
				if(buttons[i][1].getLabel().isEmpty()){
					return new int[]{i,1};
				}
			}
		}
		
		for(int i = 0; i < buttons.length; i++){
			if(isMatchedInRow(buttons[i][1],buttons[i][2],"O")){
				if(buttons[i][0].getLabel().isEmpty()){
					return new int[]{i,0};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[1][j],"O")){
				if(buttons[2][j].getLabel().isEmpty()){
					return new int[]{2,j};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[0][j],buttons[2][j],"O")){
				if(buttons[1][j].getLabel().isEmpty()){
					return new int[]{1,j};
				}
			}
		}
		
		for(int j = 0; j < buttons.length; j++){
			if(isMatchedInColumn(buttons[1][j],buttons[2][j],"O")){
				if(buttons[0][j].getLabel().isEmpty()){
					return new int[]{0,j};
				}
			}
		}
		
		if(isDiagonalMatched(buttons[0][0],buttons[1][1],"O")){
			if(buttons[2][2].getLabel().isEmpty()){
				return new int[]{2,2};
			}
			
		}
		if(isDiagonalMatched(buttons[0][0],buttons[2][2],"O")){
			if(buttons[1][1].getLabel().isEmpty()){
				return new int[]{1,1};
			}
		}
		if(isDiagonalMatched(buttons[1][1],buttons[2][2],"O")){
			if(buttons[0][0].getLabel().isEmpty()){
				return new int[]{0,0};
			}
		}
		
		if(isDiagonalMatched(buttons[0][2],buttons[1][1],"O")){
			if(buttons[2][0].getLabel().isEmpty()){
				return new int[]{2,0};
			}
			
		}
		if(isDiagonalMatched(buttons[0][2],buttons[2][0],"O")){
			if(buttons[1][1].getLabel().isEmpty()){
				return new int[]{1,1};
			}
		}
		if(isDiagonalMatched(buttons[2][0],buttons[1][1],"O")){
			if(buttons[0][2].getLabel().isEmpty()){
				return new int[]{0,2};
			}
		}
		return new int[]{-1,-1};
		
	}
	
	private boolean isMatchedInRow(JButton b1, JButton b2,String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	private boolean isMatchedInColumn(JButton b1,JButton b2,String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	private boolean isDiagonalMatched(JButton b1, JButton b2, String label){
		return b1.getLabel().equals(label) && b2.getLabel().equals(label);
	}
	
	
	private int[] winPosibilitiesCheck(){
		System.out.println("winPosibilitiesCheck is called");
		if(buttons[0][0].getLabel().isEmpty()){
			return new int[]{0,0};
		}else if(buttons[0][1].getLabel().isEmpty()){
			return new int[]{0,1};
		}else if(buttons[0][2].getLabel().isEmpty()){
			return new int[]{0,2};
		}else if(buttons[1][0].getLabel().isEmpty()){
			return new int[]{1,0};
		}else if(buttons[1][1].getLabel().isEmpty()){
			return new int[]{1,1};
		}else if(buttons[1][2].getLabel().isEmpty()){
			return new int[]{1,2};
		}else if(buttons[2][0].getLabel().isEmpty()){
			return new int[]{2,0};
		}else if(buttons[2][1].getLabel().isEmpty()){
			return new int[]{2,1};
		}else if(buttons[2][2].getLabel().isEmpty()){
			return new int[]{2,2};
		}
		return new int[]{-1,-1};
	}
	
	private void secondPlayer(){
		int[] userWinCheckIndex = userWinCheck();
		int[] computerWinCheckIndex = computerWinCheck();
		
		System.out.println("userWinCheckIndex[0] : "+userWinCheckIndex[0]+" and userWinCheckIndex[1] : "+userWinCheckIndex[1]);
		System.out.println("computerWinCheckIndex[0] : "+computerWinCheckIndex[0]+" and computerWinCheckIndex[1] : "+computerWinCheckIndex[1]);
		
		if(computerWinCheckIndex[0] > -1 && computerWinCheckIndex[1] > -1){
			mark(computerWinCheckIndex);
		}else if(userWinCheckIndex[0] > -1 && userWinCheckIndex[1] > -1){
			mark(userWinCheckIndex);
		}
		else{
			mark(winPosibilitiesCheck());
		}
	}
	
	private void mark(int[] index){
		int i = index[0], j = index[1];
		System.out.println("i : "+i+" and j : "+j);
		if(i >= 0 && j >= 0){
			System.out.println("if in mark");
			if(buttons[i][j].getLabel().equals("")){
				buttons[i][j].setLabel("X");
			}
		}
		
	}
	public static void main(String[] args){
		new IntelligentTicTacTeo();
	}
}