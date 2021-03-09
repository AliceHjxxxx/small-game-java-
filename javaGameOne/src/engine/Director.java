package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import game.Conf;

//管理者--管理-->游戏场景
public class Director {

	public JFrame frame=new JFrame();
	public Scene scene;//引擎内核
	public InputMsg inputmsg;//键盘管理
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
	
	//初始化窗体
	public void init()
	{
		  frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * frame.setLocationRelativeTo(c);//窗体居中
		 */
		
	}

	public void setSize(int width,int height)
	{
		frame.setSize(width,height);
	}
	
	//初始化   *游戏场景* 的键盘监听事件
	public void initkeyListener() {
		
		this.scene.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				//可以启用当前按键
				
				inputmsg.setStatus(e, true);
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				inputmsg.setStatus(e, false);
	
			}
		});
		this.scene.requestFocus();
		}
	//初始化   *游戏场景* 的鼠标监听事件
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
	
	//运行游戏场景，***在这里运行initkeyListener 以及scene内核的方法***
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
