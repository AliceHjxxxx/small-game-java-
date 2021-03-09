package game;

import java.awt.Graphics;
import java.util.ArrayList;


import engine.Animation;
import engine.gameObject;

public class hotDog extends gameObject {

	Animation bar;
	private int movey;
	private int x;
	private int y;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMovey() {
		return movey;
	}

	public void setMovey(int movey) {
		this.movey = movey;
	}

	public hotDog()
	{
		init();
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		ArrayList<String> paths=new ArrayList<String>();
		String s="image/hotdog.jpg";
		paths.add(s);
		this.bar=Animation.createAni(paths, Conf.preUnitDelay);
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(bar.currentImage(), this.x, this.y, null);

		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
