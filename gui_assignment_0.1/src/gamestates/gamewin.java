package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class gamewin extends state implements statemethods{
	
	String testname;
	Font gameEndFont;
	Font gameEndSmallFont;
	Font gameEndMoneyfont;
	
	public gamewin(gui_Assignment.Game game) {
		super(game);
		this.testname = "tim";
		this.gameEndSmallFont = new Font("Monospaced", Font.BOLD, 30);
		this.gameEndFont = new Font("Monospaced", Font.BOLD, 40);
		this.gameEndMoneyfont = new Font("Monospaced", Font.BOLD, 70);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		
		int xoffset = centertext(g,gameEndFont,"congrats "+testname,900);
		g.setColor(Color.BLACK);
		g.drawString("congrats "+testname, xoffset, 290);
		
		xoffset = centertext(g,gameEndMoneyfont,"$"+this.game.getUser().getMoney(),900);
		g.setColor(Color.YELLOW);
		g.drawString("$"+this.game.getUser().getMoney(), xoffset, 350);
		
		
	}
	
	public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;
		

		
		return offset;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
