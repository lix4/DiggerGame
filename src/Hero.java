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
 * @author XIWEN LI.
 *         Created May 5, 2015.
 */
public class Hero extends JPanel implements KeyListener{
	private BufferedImage hero;
//	private BufferedImage FireBall;
	private int x;
	private int y;
	private boolean moveUp;
	private boolean moveDown;
	private boolean moveLeft;
	private boolean moveRight;
	private Bullet bullet;

	public Hero(int x,int y){
		moveRight = true;
		moveLeft = true;
		moveDown = true;
		moveUp = true;
		
		this.x = x;
		this.y = y;
		String heroLocation = "src/zb001.gif";
		try{
			hero = ImageIO.read(new File(heroLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + heroLocation);
		}
		this.addKeyListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(hero,this.x,this.y,null);
		g.drawImage(bullet.Bullet,this.x,this.y,null);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			x = x + 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			x = x - 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			y = y - 60;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			y = y + 60;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			bullet = new Bullet(this.x,this.y);
			if (!moveUp){
				while (bullet.x <= 400){
					bullet.x = bullet.x + 120;
					repaint();
				}
			}
			else if (!moveLeft){
				while (bullet.x >= 0){
					bullet.x = bullet.x - 120;
					repaint();
				}
			}
			else if (!moveUp){
				while (bullet.y >= 0){
					bullet.y = bullet.y - 120;
					repaint();
				}	
			}
			else if (!moveDown){
				while (bullet.x <= 400){
					bullet.y = bullet.y + 120;
					repaint();
				}	
			}
		}
		repaint();
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			moveRight = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			moveLeft = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			moveUp = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			moveDown = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub.
		
		
	}

	
//	public void fireWeapon(){
//		bullet = new Bullet(this.x,this.y);
//	}

	

}
