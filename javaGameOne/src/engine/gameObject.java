package engine;

import java.awt.Graphics;


//����ĳ����࣬�������ж���
public abstract class gameObject {

	public int x;
	public int y;
	public abstract void init();
	public abstract void draw(Graphics g);
	public abstract void update();

}
