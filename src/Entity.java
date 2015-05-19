import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Entity extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected Point location;
	protected BufferedImage image;
	protected Level level;
	
	public Entity(Level level, int yLocation, int xLocation, String fileLocation)
	{
		this.level = level;
		this.location = new Point(xLocation, yLocation);
		try{
			this.image = ImageIO.read(new File(fileLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + fileLocation);
		} 
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.image, this.location.y, this.location.x + Level.SCORE_BAR, null);
	}
}
