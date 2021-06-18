package src;

import src.game.Game;
import src.game.GameLoop;


public class AppROTDM {

	public static void main(String[] args) {
		new Thread(new GameLoop(new Game(16*18*3, 16*17*3))).start();
	}
}
	



