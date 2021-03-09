package game;

import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet;

import java.net.URI;
import java.net.URL;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class Music extends JFrame{ 
File f;
URI uri;
URL url; 

public Music(){  
	
	

 }
public void eat()
{
	 try {      
	       f = new File("music/1.WAV"); 
	       uri = f.toURI();
	       url = uri.toURL();  //Ω‚Œˆµÿ÷∑
	       AudioClip aau; 
	       aau = Applet.newAudioClip(url);
	       aau.play(); //≤•∑≈
	   } catch (Exception e) 
	   { e.printStackTrace();
	   } 
}
  
 }
