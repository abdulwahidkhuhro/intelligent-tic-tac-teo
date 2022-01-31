import javax.swing.*;
import java.awt.event.*
public class IntelligentTicTacTeo implements ActionListener{
	private JFrame window = new JFrame();
	private Container container = window.getContainer();
	private JButton buttons[] = new JButton[9];
	
	public IntelligentTicTacTeo(){
		window.setBounds(0,0,600,600);
		window.setLayout(null);
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(i+"");
			buttons[i].setBackground(Color.green);
			buttons[i].setFont("Arial",Font.BOLD,25);
			container.add(buttons[i]);
			buttons[i].addActionListener(this);
		}
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	public static void main(String[] args){
		new IntelligentTicTacTeo();
	}
}