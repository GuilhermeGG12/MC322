package src.display;

import src.game.Game;
import src.game.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
	private enum STATE{
		MENU,
		PAUSE,
		GAME
	};
	private STATE State = STATE.MENU;
	
	public void render(Game game, Graphics g) {
		if(State == STATE.GAME) {
			game.getEntity().forEach(entity -> g.drawImage((BufferedImage)entity.getSprite(), entity.getPosition().getX(),
					entity.getPosition().getY(), null));
		}else if(State == STATE.MENU) {
			Menu menu = new Menu();
			menu.render(game, g);
		}
	}
}
