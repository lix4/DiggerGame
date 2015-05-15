import java.awt.Container;

import javax.swing.JFrame;


public class DiggerGame extends JFrame{

	private MainPanel mainPanel;
	
	
	public DiggerGame(){
		Container pane = this.getContentPane();
		mainPanel = new MainPanel();
		mainPanel.setFocusable(true);
		pane.add(mainPanel);
		this.setSize(900, 900);
		this.setTitle("Digger Game");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args){
		DiggerGame Mainframe = new DiggerGame();
	}
}
