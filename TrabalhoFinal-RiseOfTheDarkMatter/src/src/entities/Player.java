package src.entities;

import src.core.Position;
import src.controller.Controller;
import src.gfx.ImageLoader;

import java.awt.*;

public class Player extends Entity {

    private Controller controller;

    public Player(Controller controller){
        super();
        this.controller = controller;
    }
    @Override
    public void update(){
        position = new Position(position.getX() + 1, position.getY());
        controller.isSelecting();
    }

    @Override
    public Image getSprite(){
        return ImageLoader.loadImage("darkmatter.png");
    }
}
