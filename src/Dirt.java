

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Dirt extends JPanel{
	private BufferedImage dirt;
	private int x;
	private int y;
	
	public Dirt(int x, int y){
		this.x = x;
		this.y = y;
		String dirtLocation = "src/dirt.jpg";
		try {                
		     	this.dirt = ImageIO.read(new File(dirtLocation));
		    } catch (IOException e) {
		    	System.out.println("Could not open picture file: " + dirtLocation);
		    }
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.dirt,this.x,this.y,null);
	}

}
