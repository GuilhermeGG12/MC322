package src.controller;

import src.input.Command;

public class PlayerController implements Controller {

    private Command command;

    public PlayerController(Command command) {
        this.command = command;
    }


    @Override
    public boolean isSelecting() {
        if(command.isMouseClicked()) {
            System.out.println(String.format("Cliquei na posição: X: %d Y: %d", command.getMousePosition().getX(), command.getMousePosition().getY()));
        }
        command.clearMouseClicked();
        return command.isMouseClicked();
    }
}