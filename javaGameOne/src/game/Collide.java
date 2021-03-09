package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import engine.gameObject;

public class Collide extends gameObject{
	private Random r=new Random();
	Music music=new Music();
	Burst bu=new Burst();
	Begin be=new Begin();
	BufferedImage over;
	BufferedImage life;
	BufferedImage overbg;
	BufferedImage begin;
	BufferedImage begin1;
	public Collide()
	{
		init();
	}
	ArrayList<hotDog> bars=new ArrayList<>();
	ArrayList<Boom> bss=new ArrayList<>();
	ArrayList<beginHotdog> bhds=new ArrayList<>();
	ArrayList<beginHotdog> bhds2=new ArrayList<>();
	
	@Override
	public void init() {
		over=GameUtil.createImage("image/gameover2.png");
		overbg=GameUtil.createImage("image/gobg.png");
		begin=GameUtil.createImage("image/begin.png");
		begin1=GameUtil.createImage("image/begin1.jpg");
		life=GameUtil.createImage("image/life.jpg");
		for (int i = 0; i < 20; i++) {
				hotDog bar=new hotDog();
				bar.setX(r.nextInt(600));
				bar.setY(r.nextInt(700)-600);
				bars.add(bar);
		}
		
		  for (int i = 0; i <100; i++) {
			  Boom bs=new Boom();
			  bs.setX(r.nextInt(600));
			  bs.setY(r.nextInt(800)-900); 
			  bss.add(bs); 
		  }
		  for (int i = 0; i < 10; i++) {
			  beginHotdog bhd=new beginHotdog();
			  bhd.setX(80*i);
			  bhd.setY(400);
			  bhds.add(bhd);
		}
		  for (int i = 0; i < 10; i++) {
			  beginHotdog bhd=new beginHotdog();
			  bhd.setX(80*i);
			  bhd.setY(550);
			  bhds2.add(bhd);
		}
		 
		
	}

	private int score=0;
	@Override
	
	//画飞行道具
	public void draw(Graphics g) {
		//游戏开始前画面
	
		if(Conf.isbegin==0&&Conf.isreplay==0)
		{

			g.drawImage(overbg, 0, 0, null);
			g.drawImage(begin, 0, -180,500,700, null);
			//封面热狗移动
			for (int i = 0; i < bhds.size(); i++) {
				g.drawImage(bhds.get(i).bar.currentImage(), bhds.get(i).getX(), bhds.get(i).getY(),50,30, null);
			}
			for (int i = 0; i < bhds2.size(); i++) {
				g.drawImage(bhds2.get(i).bar.currentImage(), bhds2.get(i).getX(), bhds2.get(i).getY(),50,30, null);
			}
			
			//play
			g.drawImage(be.be.currentImage(), 200, 450, null);
			
			//历史最高分
			g.setColor(Color.gray);
			g.setFont(new Font("",Font.BOLD,20));
			g.drawString("历史最高："+Conf.HightestScore, 220, 600);
			g.setColor(Color.green);
			g.setFont(new Font("",Font.BOLD,35));
			g.drawString("单击左键开始", 160, 700);
		
		}
		else if(Conf.isbegin==1||Conf.isreplay==0)
		{
			
			
			//游戏开始后画面
			if(Conf.life>0)
			{
				for (int i = 0; i < bars.size(); i++) {
					g.drawImage(bars.get(i).bar.currentImage(), bars.get(i).getX(), bars.get(i).getY(),41,69, null);
				}
				
				
				  for (int i = 0; i < bss.size(); i++) {
				  g.drawImage(bss.get(i).bo.currentImage(), bss.get(i).getX(),
				  bss.get(i).getY(),70,70, null); }
				  
				  //炸弹效果
				  if(bur>0)
					{

							  g.drawImage(bu.burst.currentImage(),xb,yb,100,100,null);
							  bur--;
					}
				 
				//进行时的分数和生命值
				  
				g.setColor(Color.gray);
				g.setFont(new Font("",Font.BOLD,20));
				g.drawString("生命：", 10, 50);
				for (int i = 0; i < Conf.life; i++) {
					g.drawImage(life, i*30, 50,35,35, null);
				}
				g.drawString("  得分："+score, 330, 50);
			
			}
			
			//游戏结束界面
			else
			{
				
				g.drawImage(overbg, 0, 0, null);
				g.drawImage(over, 50, 150,500,500,null);
				g.setColor(Color.gray);
				g.setFont(new Font("",Font.BOLD,20));
				g.drawString("本次 得分："+score, 200, 300);
				if(score>Conf.HightestScore)
				{
					Conf.HightestScore=score;
				}
				g.drawString("历史最高："+Conf.HightestScore, 200, 350);
				g.setColor(Color.green);
				g.setFont(new Font("",Font.BOLD,35));
				g.drawString("单击右键重玩", 160, 650);
			
			}
		}
		//重玩，重置常量
		else if(Conf.isbegin==1||Conf.isreplay==1)
		{
			Conf.isbegin=0;
			Conf.isreplay=0;
		}
		

		
	}
	
	
	int xb;
	int yb;
	int bur=-1;
	@Override
	//热狗移动
	public void update() {
		
		//判断游戏开始
		  if(Conf.isbegin==1) 
		  {
			//判断生命
				if(Conf.life>0)
				{
					xb=Player.x;
					yb=Player.y;
						
					//难度随着分数增加
						Conf.level=score/10;
					//遍历炸弹坐标,移动并进行碰撞操作
					for (int i = 0; i <Conf.level; i++) {
						Boom boom=bss.get(i);
						if(boom.getY()<900)
						{
							boom.setY(boom.getY()+3);
							if((boom.getX()>xb-20&&boom.getX()<xb+60) && (boom.getY()+70>yb+60&&boom.getY()+50<yb+93)) {
								boom.setY(-100);
								boom.setX(r.nextInt(600));
								Conf.life--;
								bur=10;
							}
						}
						else
						{
							bur=0;
							boom.setY(-100);
							boom.setX(r.nextInt(600));
						}
					}
					
					//遍历热狗坐标,移动并进行碰撞操作
					for (int i = 0; i < bars.size(); i++) 
					{
						hotDog b=bars.get(i);
						//循环出现
						if(b.getY()<900)
						{
							b.setY(b.getY()+3);
							
						
							if((b.getX()>xb-20&&b.getX()<xb+60) && (b.getY()+93>yb+60&&b.getY()+69<yb+93)) {
								//发出吃的声音
								music.eat();
								b.setY(-100);
								b.setX(r.nextInt(600));
								score++;
							}
						}
						else
						{
							b.setY(-100);
							b.setX(r.nextInt(600));
							
						}
					
					}
				}
				else
				{
					if(Conf.isreplay==1)
					{
						Conf.life=10;
						Conf.level=1;
						score=0;
						Player.x=200;
						Player.y=650;
						for (int i = 0; i < bss.size(); i++) {
							Boom boom=bss.get(i);
									boom.setY(r.nextInt(800)-900);
									boom.setX(r.nextInt(600));
						}
					}

				}
			  
		  }
		  //判断游戏结束
		  else if(Conf.isbegin==0)
		  {
			  	//封面热狗移动
				for (int i = 0; i < bhds.size(); i++) {
					beginHotdog bh=bhds.get(i);
					if(bh.getX()<700)
					{
						bh.setX(bh.getX()+3);

					}
					else
					{
						bh.setX(-100);
					}
				}
				for (int i = 0; i < bhds2.size(); i++) {
					beginHotdog bh=bhds2.get(i);
					if(bh.getX()>-100)
					{
						bh.setX(bh.getX()-3);

					}
					else
					{
						bh.setX(700);
					}
				}
		 }
		
		
		
	}

}
