

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Nobbins extends JPanel{
	private BufferedImage nobbins;
	public int x;
	public int y;

	public Nobbins(int x,int y){
		this.x = x;
		this.y = y;
		String nobbinsLocation = "src/DiggerGame/monster.jpg";
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
}