package engine;

import java.awt.Graphics;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
//游戏场景--搭载-->所有游戏对象
public class Scene extends JPanel
{
	//allobj,所有游戏对象的集合
	public List<gameObject> allobj=new ArrayList<>();
	
	//添加对象进集合
	public void addGameObject(gameObject gb) {
		allobj.add(gb);
	}
	
	//遍历画出所有对象各自的形状
	public void paint(Graphics g) {
		super.paint(g);
		for (gameObject game : allobj) {
			game.draw(g);
			
			
		}
	}
	
	//遍历运行所有对象各自的方法
	public void updatelogic() {
		for (gameObject game : allobj) {
			game.update();
		}
	}
	
}
