package src.input;

import src.core.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.event.MouseInputListener;

public class Command implements MouseInputListener, MouseMotionListener {

	private Position mousePosition;
	private boolean mouseClicked;
	private boolean mousePressed;

	public Command() {
		mousePosition = new Position(0, 0);
	}

	public Position getMousePosition() {
		return mousePosition;
	}

	public void clearMouseClicked() {
		mouseClicked = false;
	}

	public boolean isMouseClicked() {
		return mouseClicked;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseClicked = true;
		mousePressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousePressed = true;
		mousePosition = new Position(e.getPoint().getX(), e.getPoint().getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition = new Position(e.getPoint().getX(), e.getPoint().getY());
	}
}
