package game;

import engine.Director;
import engine.Scene;

public class Mini {
 public static void main(String[] args) {
	 
	 //创建管理者，设置默认格式
	Director dt=new Director("first game");
	dt.setSize(Conf.w, Conf.h);
	dt.settimeinterval(Conf.TimeInterval);
	
	//创建游戏场景，子类自动添加对象
	Scene my=new gameScene();
	
	//管理者运行游戏场景
	dt.runScene(my);
	
}
}
