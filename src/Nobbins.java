import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author XIWEN LI.
 *         Created May 14, 2015.
 */
public class Nobbins extends JPanel{
	private BufferedImage nobbins;
	private int x;
	private int y;

	public Nobbins(int x,int y){
		this.x = x;
		this.y = y;
		String nobbinsLocation = "src/zb001.gif";
		try{
			nobbins = ImageIO.read(new File(nobbinsLocation));
		}catch (IOException e){
			System.out.println("Could not open picture file:" + nobbinsLocation);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(nobbins,this.x,this.y,null);
	}
	
	public void movement(){
	
	}
	
}