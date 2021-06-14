package src.game;

import src.controller.PlayerController;
import src.display.Display;
import src.entities.Entity;
import src.entities.Player;
import src.input.Command;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Display display;
	private List<Entity> entity;
	private Command command;

	public Game(int width, int height) {
		Command command = new Command();
		display = new Display(800, 600, command);
		entity = new ArrayList<>();
		entity.add(new Player(new PlayerController(command)));
	}

	public List<Entity> getEntity() {
		return entity;
	}

	public void update() {
		entity.forEach(Entity::update);
	}

	public void render() {
		display.render(this);
	}
}
