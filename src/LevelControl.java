

import java.io.File;
import java.util.ArrayList;

public class LevelControl {
	public ArrayList<File> levelFiles;
	public int current;
	
	public LevelControl(){
		this.current = 0;
		this.levelFiles = new ArrayList<>();
		this.levelFiles.add(new File("Level1.txt"));
		this.levelFiles.add(new File("Level2.txt"));
		this.levelFiles.add(new File("Level3.txt"));
	}
	
	public File reset(){
		return this.levelFiles.get(this.current);
	}
	
	public File next(){
		if(this.current >= this.levelFiles.size()-1){
			return null;
		}
		this.current++;
		return this.levelFiles.get(this.current);
	}
	
	public File previous(){
		if(this.current == 0){
			return null;
		}
		this.current--;
		return this.levelFiles.get(this.current);
	}
}
