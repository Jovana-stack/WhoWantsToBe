package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import gui_Assignment.Game;

import static gui_Assignment.Game.framewidth;
import static gui_Assignment.Game.framehight;

//import static gui_Assignment.game.UNIT_SIZE;
public class menu extends state implements statemethods {

	// start button
	// size
	private static int startButtonSizeX = 200;
	private static int startButtonSizeY = 50;
	// postion
	private static int startbuttonY = 425;
	private static int startbuttonX = 350;
	// text off set
	private static int startTextY = 35;
	private static int startTextX = 40;

	public menu(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(startbuttonX, startbuttonY, startButtonSizeX, startButtonSizeY);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.BOLD, 40));
		g.drawString("start", startbuttonX + startTextX, startbuttonY + startTextY);
		// g.fillRect((gui_Assignment.game.framewidth-startButtonSizeX)/2,
		// (gui_Assignment.game.framehight - startButtonSizey)/2, startButtonSizeX,
		// startButtonSizey);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getX() < startButtonSizeX + startbuttonX && e.getX() > startbuttonX) {
			if (e.getY() < startButtonSizeY + startbuttonY && e.getY() > startbuttonY) {
				Gamestate.state = Gamestate.playing;
				
			}
		}

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
