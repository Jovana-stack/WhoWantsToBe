package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import static gui_Assignment.game.framewidth;
import static gui_Assignment.game.framehight;
import static gui_Assignment.game.UNIT_SIZE;
public class menu extends state implements statemethods {
	
	private static int startButtonSizeX = 500;
	private static int startButtonSizey = 500;
	public menu(gui_Assignment.game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(UNIT_SIZE, UNIT_SIZE*3, UNIT_SIZE*3, UNIT_SIZE*1);
		g.fillRect(UNIT_SIZE, UNIT_SIZE*3, UNIT_SIZE*3, UNIT_SIZE*1);
		g.drawString("test", UNIT_SIZE, UNIT_SIZE*3);
		//g.fillRect((gui_Assignment.game.framewidth-startButtonSizeX)/2, (gui_Assignment.game.framehight - startButtonSizey)/2, startButtonSizeX, startButtonSizey);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
