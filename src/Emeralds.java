import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Emeralds extends JPanel{
	private BufferedImage hero;
	private int x;
	private int y;

	public Emeralds(){
		this.x = x;
		this.y = y;
		String emeraldsLocation = "src/Money_Bag.jpg";
		try{
			hero = ImageIO.read(new File(emeraldsLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + emeraldsLocation);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(hero,this.x,this.y,null);
	}
}