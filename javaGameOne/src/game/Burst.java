package game;

import java.awt.Graphics;

import java.util.ArrayList;

import engine.Animation;
import engine.gameObject;

public class Burst extends gameObject{
	Animation burst;
	
	public Burst()
	{
		init();
	}
	public void init() {
		ArrayList<String> paths = new ArrayList<String>();
		String s = "image/burst/burst";
		for (int i = 0; i < 6; i++) {
			paths.add(s+i+".jpg");
		}

	 burst = Animation.createAni(paths, 3); 
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(burst.currentImage(), this.x,this.y, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
}
