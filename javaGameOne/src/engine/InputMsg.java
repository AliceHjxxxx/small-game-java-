package engine;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class InputMsg {
	private static InputMsg inputmsg;
	Map<Integer, Boolean> keystatus=new HashMap<>();
	
	private InputMsg()
	{
		init();
	}
	public void init() {
		for (int i = 0; i < 127; i++) {
			keystatus.put(i, false);
		}
	}
	//µ¥ÀýÄ£Ê½
	public static InputMsg createIns() {
		if(inputmsg==null)
		{
			inputmsg=new InputMsg();
			
		}
		
		return inputmsg;
		
	}
	public void setStatus(KeyEvent e,boolean status) {
		keystatus.put(e.getKeyCode(), status);
	}
	public boolean getStatus(int key)
	{
		return keystatus.get(key);
	}
}
