
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author XIWEN LI
 *         Created May 5, 2015.
 */
public class MainPanel extends JPanel implements KeyListener{
	private int x;
	private int y;
	private Level level;
	private BufferedImage hero;
	private BufferedImage emeralds;
	
	public MainPanel(int x, int y){
//		this.level = new Level();
//		this.addKeyListener(this.level);
//		add(this.level);
		this.x = x;
		this.y = y;
		String heroLocation = "src/DiggerGame/Money_Bag.jpg";
		try {                
		     	this.hero = ImageIO.read(new File(heroLocation));
		    } catch (IOException e) {
		    	System.out.println("Could not open picture file: " + heroLocation);
		    }
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.hero,this.x,this.y,null);

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			this.x = this.x + 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			this.x = this.x - 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			this.y = this.y - 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			this.y = this.y + 60;
		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub.
	
	}

	

}
