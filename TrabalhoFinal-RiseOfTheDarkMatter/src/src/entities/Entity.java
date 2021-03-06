package src.entities;

import src.core.Position;
import src.core.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
	protected Position position;
	protected Size size;

	public Entity() {
		position = new Position(50, 50);
		size = new Size(50, 50);
	}

	public abstract void update();

	public abstract BufferedImage getSprite();

	public Position getPosition() {
		return position;
	}

	public Size getSize() {
		return size;
	}
}
