package game;

import java.awt.Graphics;
import java.util.ArrayList;

import engine.Animation;
import engine.gameObject;

public class Boom extends gameObject {
	Animation bo;
	private int x;
	 private int y;
	public Boom() {
		init();
		}
		@Override
		public void init() {
			
			ArrayList<String> paths = new ArrayList<String>();
			String s = "image/boom/boom";
			for (int i = 1; i < 6; i++) {
				paths.add(s+i+".jpg");
			}

		 bo = Animation.createAni(paths, 6); 
	
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
			g.drawImage(bo.currentImage(), this.x, this.y, null);
		}

		@Override
		public void update() {
			
		}
}
