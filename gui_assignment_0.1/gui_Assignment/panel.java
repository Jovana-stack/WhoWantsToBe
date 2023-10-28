package gui_Assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import static gui_Assignment.game.framewidth;
import static gui_Assignment.game.framehight;
import static gui_Assignment.game.UNIT_SIZE;
import javax.swing.JPanel;



public class panel extends JPanel{
	private game game;
	public panel(game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(framewidth,framehight));;
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0;i<framehight/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, framehight);
			g.drawLine(0, i*UNIT_SIZE, framewidth, i*UNIT_SIZE);
		}
		game.draw(g);
		
	}
	
	
}
