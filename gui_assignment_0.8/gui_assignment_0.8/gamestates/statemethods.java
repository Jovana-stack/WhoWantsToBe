package gamestates;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface statemethods {
	public void update();
	public void draw(Graphics g);
	public void mousePressed(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void mouseReleased(MouseEvent e);

}
