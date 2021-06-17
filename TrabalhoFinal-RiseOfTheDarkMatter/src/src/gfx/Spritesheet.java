package src.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Spritesheet {
	BufferedImage spritesheet;
	
	public Spritesheet(String filepath) {
		
		try {
			spritesheet = ImageIO.read(getClass().getResource(filepath));
		} catch(IOException e){
			System.out.println("N�o foi poss�vel acessar o arquivo do diret�rio " + filepath);
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
