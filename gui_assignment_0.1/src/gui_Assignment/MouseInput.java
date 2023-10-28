package gui_Assignment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import gamestates.Gamestate;

public class MouseInput implements MouseListener   {
	private Panel panel;
	
	public MouseInput(Panel panel){
		this.panel = panel;
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(Gamestate.state) {
		case gameover:
			panel.getGame().getGameover().mousePressed(e);
			break;
		case gamewin:
			panel.getGame().getGamewin().mousePressed(e);
			break;
		case menu:
			panel.getGame().getMenu().mousePressed(e);
			break;
		case playing:
			panel.getGame().getPlaying().mousePressed(e);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
