package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;



import engine.gameObject;




public class BackGround extends gameObject{
	BufferedImage image;
	public BackGround() {
		this.y=-100;
		this.x=-400;
		init();
	}
	


	@Override
	public void init() {
		// TODO Auto-generated method stub
		image=GameUtil.createImage(Conf.bg);
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(image, this.x,this.y, null);
	
		
	}

	@Override
	public void update() {
		
		this.x=-Player.x;
		
		if(Player.y>600&&Player.y<900)
		{
			this.y=-Player.y+600;
		}
		
		
		 
		
	}
}
