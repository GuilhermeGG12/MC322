package src.display;

import src.game.Game;

import java.awt.*;

public class Renderer {

    public void render(Game game, Graphics g) {
        game.getEntity().forEach(entity -> g.drawImage(
                entity.getSprite(),
                entity.getPosition().getX(),
                entity.getPosition().getY(),
                null
        ));
    }
}
