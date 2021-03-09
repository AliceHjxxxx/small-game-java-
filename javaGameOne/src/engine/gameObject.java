package engine;

import java.awt.Graphics;


//对象的抽象类，代表所有对象
public abstract class gameObject {

	public int x;
	public int y;
	public abstract void init();
	public abstract void draw(Graphics g);
	public abstract void update();

}
