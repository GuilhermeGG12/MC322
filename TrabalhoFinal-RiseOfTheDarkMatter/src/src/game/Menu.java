package src.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH + 50, Game.WIDTH, 200, 50);
	public Rectangle creditsButton = new Rectangle(Game.WIDTH + 50, Game.WIDTH + 32*3, 200, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH + 50, Game.WIDTH + 32*6, 200, 50);
	
	public void render(Game game, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font font1 = new Font("arial", Font.BOLD, 50);
		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Rise Of The Dark Matter", (game.WIDTH)/2, (game.HEIGHT)/2);
		
		Font font2 = new Font("arial", Font.BOLD, 30);
		g.setFont(font2);
		g.drawString("New Game", playButton.x + 30, playButton.y + 35);
		g2d.draw(playButton);
		g.drawString("Credits", creditsButton.x + 50, creditsButton.y + 35);
		g2d.draw(creditsButton);
		g.drawString("Quit Game", quitButton.x + 30, quitButton.y + 35);
		g2d.draw(quitButton);
	}
}
