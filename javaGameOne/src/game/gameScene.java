package game;

import engine.Scene;

@SuppressWarnings("serial")
//添加游戏对象进游戏场景
public class gameScene extends Scene {

	public gameScene() {
		init();
	}

	// 在这里添加对象
	public void init() {
		// 添加游戏对象

		BackGround bg = new BackGround();
		this.addGameObject(bg);
		 
		Player p = new Player(); this.addGameObject(p);

		 Collide c=new Collide(); this.addGameObject(c); 
		  

		 

	}
}
