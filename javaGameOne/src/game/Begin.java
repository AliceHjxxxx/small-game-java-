package game;

import java.awt.Graphics;
import java.util.ArrayList;

import engine.Animation;
import engine.gameObject;

public class Begin extends gameObject{
	Animation be;
	private int x;
	 private int y;
	public Begin() {
		init();
		}
		@Override
		public void init() {
			
			ArrayList<String> paths = new ArrayList<String>();
			String s = "begin/begin";
			for (int i = 1; i < 3; i++) {
				paths.add(s+i+".png");
			}

		 be = Animation.createAni(paths, 10); 
	
		}

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
		@Override
		public void draw(Graphics g) {
			this.x=200;
			this.y=300;
			g.drawImage(be.currentImage(), this.x, this.y, null);
		}

		@Override
		public void update() {
			
		
		}
}
