package game;

import engine.Scene;

@SuppressWarnings("serial")
//�����Ϸ�������Ϸ����
public class gameScene extends Scene {

	public gameScene() {
		init();
	}

	// ��������Ӷ���
	public void init() {
		// �����Ϸ����

		BackGround bg = new BackGround();
		this.addGameObject(bg);
		 
		Player p = new Player(); this.addGameObject(p);

		 Collide c=new Collide(); this.addGameObject(c); 
		  

		 

	}
}
