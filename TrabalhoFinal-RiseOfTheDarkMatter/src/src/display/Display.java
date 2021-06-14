package src.display;

import src.game.Game;
import src.input.Command;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.*;

public class Display extends JFrame{

    private Canvas canvas;
    private Renderer renderer;

    public Display(int width, int height, Command command){
        setTitle("Rise of The Dark Matter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        canvas.addMouseListener(command);
        canvas.addMouseMotionListener(command);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(Color.PINK);
        g.fillRect(0, 0, getWidth(), getHeight());

        renderer.render(game, g);

        g.dispose();
        bufferStrategy.show();
    }

}
