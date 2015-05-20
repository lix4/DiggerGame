

import java.awt.Container;

import javax.swing.JFrame;


public class DiggerGame extends JFrame{

	private Level level;
	
	public DiggerGame(){
		Container pane = this.getContentPane();
		this.level = new Level();
		this.level.addKeyListener(this.level);
		this.level.setFocusable(true);
		pane.add(this.level);
		this.setSize(920,745);
		this.setTitle("Digger Game");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args){
		DiggerGame Mainframe = new DiggerGame();
		
	
	}
}
