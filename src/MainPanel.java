import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author XIWEN LI
 *         Created May 5, 2015.
 */
public class MainPanel extends JPanel{
	private int x;
	private int y;
	private Hero hero;
	private Emeralds emeralds;
	private int count;
	
	public MainPanel(){
		hero = new Hero(50,50);
		add(hero);

	}
	
	
	
//	public void EatHelper(){
//		int minXh = hero.getMinX();
//		int minYh = hero.getMinY();
//		int widthh
//		int heighth= 
//		int minXe = emeralds.getMinX();
//		int minYe = emeralds.getMinY();
//		Rectangle r = new Rectangle(e.X,e.Y,e.Width,e.Height);
//		Rectangle p = new Rectangle(player.X,player.Y,player.Width,player.Height);
//		
//		if (){
//			
//			count = count + 100;
//		}
//	}
//	

}
