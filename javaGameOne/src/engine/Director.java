package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import game.Conf;

//������--����-->��Ϸ����
public class Director {

	public JFrame frame=new JFrame();
	public Scene scene;//�����ں�
	public InputMsg inputmsg;//���̹���
	public int timeinterval;
	
	
	public Director(String title)
	{
		frame.setTitle(title);
		inputmsg=InputMsg.createIns();
		init();
	}
	
	public void settimeinterval(int t)
	{
		this.timeinterval=t;
	}
	
	//��ʼ������
	public void init()
	{
		  frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * frame.setLocationRelativeTo(c);//�������
		 */
		
	}

	public void setSize(int width,int height)
	{
		frame.setSize(width,height);
	}
	
	//��ʼ��   *��Ϸ����* �ļ��̼����¼�
	public void initkeyListener() {
		
		this.scene.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				//�������õ�ǰ����
				
				inputmsg.setStatus(e, true);
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				inputmsg.setStatus(e, false);
	
			}
		});
		this.scene.requestFocus();
		}
	//��ʼ��   *��Ϸ����* ���������¼�
	public void initmousListener() {
		
		this.scene.addMouseListener(new MouseAdapter()  {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					if(Conf.isbegin==1)
					{
						Conf.isbegin=0;
					}
					else
					{
						Conf.isbegin=1;
					}
				}
				if(e.getButton()==MouseEvent.BUTTON3)
				{
					if(Conf.isreplay==1)	
					{
						Conf.isreplay=0;
					}
					else
					{
						Conf.isreplay=1;
					}
				}
				 
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
		});
		this.scene.requestFocus();
		}
	
	//������Ϸ������***����������initkeyListener �Լ�scene�ں˵ķ���***
	public void runScene(Scene scene)
	{
		this.scene=scene;
		frame.add(scene);
		initkeyListener();
		initmousListener();
		  Timer timer=new Timer(); 
		  timer.schedule(new TimerTask() {
			  
			  @Override 
			  public void run() {
				  
				  scene.updatelogic();
				  scene.repaint();
			  } }, 0, this.timeinterval);
		  frame.setVisible(true);
		  
	}

}
