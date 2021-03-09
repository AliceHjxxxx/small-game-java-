package engine;

import java.awt.Graphics;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
//��Ϸ����--����-->������Ϸ����
public class Scene extends JPanel
{
	//allobj,������Ϸ����ļ���
	public List<gameObject> allobj=new ArrayList<>();
	
	//��Ӷ��������
	public void addGameObject(gameObject gb) {
		allobj.add(gb);
	}
	
	//�����������ж�����Ե���״
	public void paint(Graphics g) {
		super.paint(g);
		for (gameObject game : allobj) {
			game.draw(g);
			
			
		}
	}
	
	//�����������ж�����Եķ���
	public void updatelogic() {
		for (gameObject game : allobj) {
			game.update();
		}
	}
	
}
