package game;

import engine.Director;
import engine.Scene;

public class Mini {
 public static void main(String[] args) {
	 
	 //���������ߣ�����Ĭ�ϸ�ʽ
	Director dt=new Director("first game");
	dt.setSize(Conf.w, Conf.h);
	dt.settimeinterval(Conf.TimeInterval);
	
	//������Ϸ�����������Զ���Ӷ���
	Scene my=new gameScene();
	
	//������������Ϸ����
	dt.runScene(my);
	
}
}
