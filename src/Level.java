
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class Level extends JPanel implements KeyListener{
	public static final int SCORE_BAR = 100;
	public File levelFile;
	private int[][] map;
	private LevelControl LevelC;
	int scanInt;
	private Hero h;
	private Emerald e;
	private Nobbin n;
	private Bomb bomb;
	public int a = 9;
	public int b = 7;
	private int score = 0;
	static final int DIRT = 1;
	static final int EMERALD = 2;
	static final int MONSTER = 3;
	static final int Bomb = 4;
	static final int R = 1;
	static final int L = 2;
	static final int U = 3;
	static final int D = 4;
	static final int NONE = 0;
	private int move = 0;
	private int lastkey = 0;
	private int keypressed = 0;
	private boolean firstkey = false;
	
	ArrayList<UpdatedEntity> entities = new ArrayList<UpdatedEntity>();
//	private int bulletmove;
//	private int spacecount = 0;
	
	public Level() {
		
//		String heroLocation = "src/DiggerGame/zb001.gif";
//		try{
//			hero = ImageIO.read(new File(heroLocation));
//		}catch (IOException e){
//			System.out.println("Could not open picture file:" + heroLocation);
//		}
//		this.x = 420;
//		this.y = 640;
		
		this.h.addKeyListener(this);
		this.LevelC = new LevelControl();
		this.levelFile = this.LevelC.levelFiles.get(this.LevelC.current);
		System.out.println(this.levelFile);
		getMap();
	}
	
	
	public void getMap(){
		Scanner scan = null;
		try {
			scan = new Scanner(this.levelFile);
		} catch (FileNotFoundException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		this.map = new int[10][15];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				this.scanInt = scan.nextInt();
				this.map[i][j] = this.scanInt;
				}
			}
		scan.close();
		}

	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				if(this.map[i][j] == DIRT){
					Dirt d = new Dirt(j*60, 100+i*60);
					d.paintComponent(g);
				}
				if(this.map[i][j] == EMERALD){
					this.e = new Emerald(this, j*60, i*60);
//					this.e.paintComponent(g);
				}
				if(this.map[i][j] == MONSTER){
					this.n = new Nobbin(this, j*60, i*60);
//					this.n.paintComponent(g);
				}
				if(this.map[i][j] == Bomb){
					bomb = new Bomb(this, j*60, i*60);
//					bomb.paintComponent(g);
				}
				if(this.map[i][j] == 9){
					this.h = new Hero(this, j*60, i*60);
					this.entities.add(h);
				}
			}
		}
//		if(spacecount != 0){
//			g.drawImage(this.bullet.Bullet,this.bullet.x,this.bullet.y,null);
//		}
	}
	
	
	public void reseth(){
		this.h.x = 420;
		this.h.y = 640;
		this.a = 9;
		this.b = 7;
		this.move = 0;
	}
	
	
	public void finishmoving(){
		
		if(this.lastkey == R){
			if(this.move % 60 != 0){
				if(this.keypressed != L){
					if(this.move % 60 != 0){
						if(this.h.x < 840){
							this.h.x += 5;
							this.move += 5;
							this.lastkey = R;
						}
					}
					else{
						this.move = 0;
						this.lastkey = this.keypressed;
					}
				}
				else{
					this.move = this.move % 60;
					if(this.move != 0){
						this.h.x -= 5;
						this.move -= 5;
						this.lastkey = R;
					}
					else{
						this.lastkey = L;
						this.b --;
						System.out.println("b--, b = " + this.b);
//						return;
					}
				}
			}
			else{
				this.lastkey = this.keypressed;
			}
		}
		
		
		if(this.lastkey == L){
			if(this.move % 60 != 0){
				if(this.keypressed != R){
					if(this.move % 60 != 0){
						if(this.h.x > 0){
							this.h.x -= 5;
							this.move += 5;
							this.lastkey = L;
						}
					}
					else{
						this.move = 0;
						this.lastkey = this.keypressed;
					}
				}
				else{
					this.move = this.move % 60;
					if(this.move != 0){
						this.h.x += 5;
						this.move -= 5;
						this.lastkey = L;
					}
					else{
						
						this.b ++;
						System.out.println("b++" + this.b);
						this.lastkey = R;
//						return;
					}
				}
			}
			else{
				this.lastkey = this.keypressed;
			}
		}
		
		
		if(this.lastkey == U){
			if(this.move % 60 != 0){
				if(this.keypressed != D){
					if(this.move % 60 != 0){
						if(this.h.y > 0){
							this.h.y -= 5;
							this.move += 5;
							this.lastkey = U;
						}
					}
					else{
						this.move = 0;
						this.lastkey = this.keypressed;
					}
				}
				else{
					this.move = this.move % 60;
					if(this.move != 0){
						this.h.y += 5;
						this.move -= 5;
						this.lastkey = U;
					}
					else{
						this.lastkey = D;
						this.a ++;
						System.out.println("a++" + this.a);
//						return;
					}
				}
			}
			else{
				this.lastkey = this.keypressed;
			}
		}
		
		
		if(this.lastkey == D){
			if(this.move % 60 != 0){
				if(this.keypressed != U){
					if(this.move % 60 != 0){
						if(this.h.y < 700){
							this.h.y += 5;
							this.move += 5;
							this.lastkey = D;
						}
					}
					else{
						this.move = 0;
						this.lastkey = this.keypressed;
					}
				}
				else{
					this.move = this.move % 60;
					if(this.move != 0){
						this.h.y -= 5;
						this.move -= 5;
						this.lastkey = D;
					}
					else{
						this.lastkey = U;
						this.a --;
						System.out.println("a--" + this.a);
//						return;
					}
				}
			}
			else{
				this.lastkey = this.keypressed;
			}
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("Right");
			if(this.firstkey == false){
				this.lastkey = R;
				this.firstkey = true;
			}
			this.keypressed = R;
			if(this.lastkey != R){
				finishmoving();
			}
			else if(this.lastkey == R){
				if(this.h.x < 840){
					this.h.x = this.h.x + 5;
				}
				if(this.b < 14){	
					this.move += 5;
					if(this.map[this.a][this.b+1] == MONSTER){
						reseth();
						repaint();
						return;
					}
					if(this.move % 60 == 5){
						if(this.map[this.a][this.b+1] == EMERALD){
							this.score += 100;
						}
						this.map[this.a][this.b+1] = 0;
						this.b++;
					}
				}
				this.lastkey = R;
			}
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("Left");
			if(this.firstkey == false){
				this.lastkey = L;
				this.firstkey = true;
			}
			this.keypressed = L;
			if(this.lastkey != L){
				finishmoving();
			}
			else if(this.lastkey == L){
				if(this.h.x > 0){
					this.h.x = this.h.x - 5;
				}
				if(this.b > 0){
					this.move += 5;
//					if(this.map[this.a][this.b-1] == MONSTER){
//						reseth();
//						repaint();
//						return;
//					}
					if(this.move % 60 == 5){
						if(this.map[this.a][this.b-1] == MONSTER){
							reseth();
							repaint();
							return;
						}
						else{
							if(this.map[this.a][this.b-1] == EMERALD){
								this.score += 100;
							}
							this.map[this.a][this.b-1] = 0;
							this.b--;
						}
					}
				}
				this.lastkey = L;
			}
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			System.out.println("Up");
			if(this.firstkey == false){
				this.lastkey = U;
				this.firstkey = true;
			}
			this.keypressed = U;
			if(this.lastkey != U){
				finishmoving();
			}
			else if(this.lastkey == U){
				if(this.h.y > 100){
					this.h.y = this.h.y - 5;
				}
				if(this.a > 0){
					this.move += 5;
					if(this.map[this.a-1][this.b] == MONSTER){
						reseth();
						repaint();
						return;
					}
					if(this.move % 60 == 5){
						if(this.map[this.a-1][this.b] == EMERALD){
							this.score += 100;
						}
						this.map[this.a-1][this.b] = 0;
						this.a--;
					}
				}
				this.lastkey = U;
			}
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("Down");
			if(this.firstkey == false){
				this.lastkey = D;
				this.firstkey = true;
			}
			this.keypressed = D;
			if(this.lastkey !=D){
				finishmoving();
			}
			else if(this.lastkey == D){
				if(this.a < 9){
					this.move += 5;
					if(this.map[this.a+1][this.b] == MONSTER){
						reseth();
						repaint();
						return;
					}
					this.h.y = this.h.y + 5;
					if(this.move % 60 == 5){
						if(this.map[this.a+1][this.b] == EMERALD){
							this.score += 100;
						}
						this.map[this.a+1][this.b] = 0;
						this.a++;
					}
				}
				this.lastkey = D;
			}
		}
		
		
		if (e.getKeyCode() == KeyEvent.VK_U){
			if(this.LevelC.current < 2){
				this.lastkey = 0;
				this.keypressed = 0;
				this.firstkey = false;
				this.LevelC.current++;
				this.levelFile = this.LevelC.levelFiles.get(this.LevelC.current);
				getMap();
				reseth();
				repaint();
			}
		}
		
		
		else if (e.getKeyCode() == KeyEvent.VK_D){
			if(this.LevelC.current > 0){
				this.lastkey = 0;
				this.keypressed = 0;
				this.firstkey = false;
				this.LevelC.current--;
				this.levelFile = this.LevelC.levelFiles.get(this.LevelC.current);
				getMap();
				reseth();
				repaint();
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			if(this.lastkey == R){
				this.map[this.a][this.b-1] = 4;
			}
			else if(this.lastkey == L){
				this.map[this.a][this.b+1] = 4;
			}
			else if(this.lastkey == U){
				this.map[this.a+1][this.b] = 4;
			}
			else if(this.lastkey == D){
				this.map[this.a-1][this.b] = 4;
			}
			repaint();
//			spacecount ++;
//			this.bullet = new Bullet();
//			if (this.bulletmove == R){
//				System.out.println("move right");
//				while (this.bullet.x < 840){
//					this.bullet.x = this.bullet.x + 20;
//					repaint();
//				}
//			}
//			else if (this.bulletmove == L){
//				System.out.println("move left");
//				while (this.bullet.x > 0){
//					this.bullet.x = this.bullet.x - 20;
//					repaint();
//				}
//			}
//			else if (this.bulletmove == U){
//				System.out.println("move up");
//				while (this.bullet.y > 100){
//					this.bullet.y = this.bullet.y - 60;
//					repaint();
//				}	
//			}
//			else if (this.bulletmove == D){
//				System.out.println("move down");
//				while (this.bullet.y < 640){
//					this.bullet.y = this.bullet.y + 20;
//					repaint();
//				}	
//			}
		}

		
		repaint();
		System.out.println("move = " + this.move);
		System.out.println("a = "+ this.a + " b = "+ this.b);
		System.out.println("x = "+ this.h.x + " y = "+ this.h.y);
		System.out.println("lastkey = " + this.lastkey);
		System.out.println(this.map[a][b]);
		System.out.println();
		
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
