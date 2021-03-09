package engine;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.GameUtil;

public  class Animation {
private ArrayList<BufferedImage> images=new ArrayList<>();
private int preUnitDelay;
ArrayList<String> paths=new ArrayList<String>();

public static Animation createAni(ArrayList<String> paths,int preUnitDelay)
{
	Animation ani=new Animation();
	ani.initAni(paths, preUnitDelay);
	return ani;
}
private void initAni(ArrayList<String> paths,int preUnitDelay) {
	this.paths=paths;
	this.preUnitDelay=preUnitDelay;
	for (String path : paths) {
		images.add(GameUtil.createImage(path));
		
	}
}
private int currentIdex=0;
public BufferedImage currentImage()
{
	BufferedImage image=images.get(currentIdex);
	step();
	return image;
}
private int i=0;
private void step() {
	
	currentIdex=++i/preUnitDelay%images.size();
	
}

}
