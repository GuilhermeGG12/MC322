package src.entities;

import src.core.Position;
import src.gfx.Spritesheet;
import src.controller.Controller;
import src.game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

	private Controller controller;
	public static BufferedImage PECA = Game.spritesheet.getSprite(16, 16, 16, 16);

	public Player(Controller controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void update() {
		position = new Position(position.getX() + 1, position.getY());
		controller.isSelecting();
	}

	@Override
	public BufferedImage getSprite() {
		return PECA;
	}
}
