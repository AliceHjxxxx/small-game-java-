package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameUtil {
	static BufferedImage image;

	private GameUtil() {
	}

	public static BufferedImage createImage(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;

	}

}
