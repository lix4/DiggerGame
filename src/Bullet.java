import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * TODO Put here a description of what this class does.
 *
 * @author XIWEN LI.
 *         Created May 14, 2015.
 */
public class Bullet {
	public BufferedImage Bullet;
	public int x;
	public int y;
	
	public Bullet(int x, int y){
		this.x = x;
		this.y = y;
		String bulletLocation = "src/Money_Bag.jpg;";
		try{
			Bullet = ImageIO.read(new File(bulletLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + bulletLocation);
		}
	} 
}
