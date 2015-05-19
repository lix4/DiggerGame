import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class Level extends JPanel implements KeyListener {
	public static final int SCORE_BAR = 100;
	public File levelFile;
	private int[][] map;
	private LevelControl LevelC;
	int scanInt;
	private Hero h;
	private Emerald e;
	private Nobbin m;
	public int a = 0;
	public int b = 0;
	private int score = 0;
	
	ArrayList<UpdatedEntity> entities = new ArrayList<UpdatedEntity>();

	public Level() {

		//ArrayList<UpdatedEntity> entities = new ArrayList<UpdatedEntity>();
		//this.h = new Hero();
		//this.h.addKeyListener(this);
		this.LevelC = new LevelControl();
		this.levelFile = this.LevelC.levelFiles.get(this.LevelC.current);
		System.out.println(this.levelFile);
		getMap();
		//entities.add(h);
		
		GameThread thread = new GameThread(entities);
		thread.start();
	}

	public void getMap() {
		Scanner scan = null;
		try {
			scan = new Scanner(this.levelFile);
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		this.map = new int[10][15];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				this.scanInt = scan.nextInt();
				this.map[i][j] = this.scanInt;
				if (this.map[i][j] == 3)
				{
					this.entities.add(new Hobbin(this, j * 60, i * 60));
				}
				else if (this.map[i][j] == 4)
				{
					this.entities.add(new Nobbin(this, j * 60, i * 60));
				}
				else if (this.map[i][j] == 9)
				{
					h = new Hero(this, i * 60, j * 60);
					this.h.addKeyListener(this);
					this.entities.add(h);
					reseth();
				}
			}
		}
		scan.close();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (this.map[i][j] == 1) {
					Dirt d = new Dirt(this, j * 60, i * 60);
					d.paintComponent(g);
				}
				if (this.map[i][j] == 2) {
					Dirt d = new Dirt(this, j * 60, i * 60);
					d.paintComponent(g);
					this.e = new Emerald(this, j * 60, i * 60);
					this.e.paintComponent(g);
					this.e.setBackground(new Color(0, 0, 0, 0));
				}
//				if (this.map[i][j] == 3) {
//					this.m = new Nobbin(this, j * 60, i * 60);
//					this.m.paintComponent(g);
//				}
			}
		}
		
		for (UpdatedEntity entity : entities)
		{
			entity.paintComponent(g);
		}
		//h.paintComponent(g);
		// g.drawImage(this.h.hero, this.h.x, this.h.y, null);
	}

	public void reseth() {
		h.location.x = 0;
		h.location.y = 0;
		a = h.location.x / 60;
		b = h.location.y / 60;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (b < 14) {
				if (map[a][b + 1] == 3) {
					reseth();
					repaint();
					return;
				}
				this.h.location.x = this.h.location.x + 60;
				if (map[a][b + 1] == 2) {
					score += 100;
				}
				map[a][b + 1] = 0;
				b++;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (b > 0) {
				if (map[a][b - 1] == 3) {
					reseth();
					repaint();
					return;
				}
				this.h.location.x = this.h.location.x - 60;
				map[a][b - 1] = 0;
				if (map[a][b - 1] == 2) {
					score += 100;
				}
				map[a][b - 1] = 0;
				b--;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (a > 0) {
				if (map[a - 1][b] == 3) {
					reseth();
					repaint();
					return;
				}
				this.h.location.y = this.h.location.y - 60;
				if (map[a - 1][b] == 2) {
					score += 100;
				}
				map[a - 1][b] = 0;
				a--;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (a < 9) {
				if (map[a + 1][b] == 3) {
					reseth();
					repaint();
					return;
				}
				this.h.location.y = this.h.location.y + 60;
				if (map[a + 1][b] == 2) {
					score += 100;
				}
				map[a + 1][b] = 0;
				a++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_U) {
			if (LevelC.current < 2) {
				LevelC.current++;
				this.levelFile = this.LevelC.levelFiles
						.get(this.LevelC.current);
				getMap();
				reseth();
				repaint();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			if (LevelC.current > 0) {
				LevelC.current--;
				this.levelFile = this.LevelC.levelFiles
						.get(this.LevelC.current);
				getMap();
				reseth();
				repaint();
			}
		}

		repaint();
		System.out.println(score);
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
