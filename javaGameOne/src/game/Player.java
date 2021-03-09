package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import engine.Animation;
import engine.InputMsg;
import engine.gameObject;

public class Player extends gameObject{
	Animation cur;
	static int x=200;
	static int y=650;
	public Player() {
		init();
		}
		@Override
		public void init() {
			
			ArrayList<String> paths = new ArrayList<String>();
			String s = "image/Player1.jpg";
			paths.add(s);
			cur = Animation.createAni(paths, Conf.preUnitDelay);
		}

		@Override
		public void draw(Graphics g) {
			g.drawImage(cur.currentImage(), Player.x, Player.y, null);
		}

		@Override
		public void update() {
			InputMsg inputMsg=InputMsg.createIns();
			if(Conf.isbegin==1)
			{
				if (inputMsg.getStatus(KeyEvent.VK_LEFT)&&Player.x>0||inputMsg.getStatus(KeyEvent.VK_A)&&Player.x>0) {
					
					Player.x-=5;
				}
				if (inputMsg.getStatus(KeyEvent.VK_RIGHT)&&Player.x<600-70||inputMsg.getStatus(KeyEvent.VK_D)&&Player.x<600-70) {
				
					Player.x+=5;
				}
			
			
				if (inputMsg.getStatus(KeyEvent.VK_DOWN)&&Player.y<800-100||inputMsg.getStatus(KeyEvent.VK_S)&&Player.y<800-100) {
					
					Player.y+=5;
				}
				if (inputMsg.getStatus(KeyEvent.VK_UP)&&Player.y>0||inputMsg.getStatus(KeyEvent.VK_W)&&Player.y>0) {
				
					Player.y-=5;
				}

			}
				
			
			
		}
}
