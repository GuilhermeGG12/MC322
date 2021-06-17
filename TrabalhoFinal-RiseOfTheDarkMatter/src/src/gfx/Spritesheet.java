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
			System.out.println("Não foi possível acessar o arquivo do diretório " + filepath);
		}
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
}
