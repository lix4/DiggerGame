import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author lix4.
 *         Created May 14, 2015.
 */
public class Hobbins extends JPanel{
	private BufferedImage hobbins;
	private int x;
	private int y;

	public Hobbins(int x,int y){
		this.x = x;
		this.y = y;
		String hobbinsLocation = "src/zb001.gif";
		try{
			hobbins = ImageIO.read(new File(hobbinsLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + hobbinsLocation);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(hobbins,this.x,this.y,null);
	}
	
	public void movement(){
		
	}
}