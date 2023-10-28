/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_Assignment;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import gamestates.Gamestate;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener,MouseMotionListener   {
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
                    case fiftyfifty:
                        panel.getGame().getfiftyfifty().mousePressed(e);
                        break;
                    case continueoption:
                        panel.getGame().getcontinueoption().mousePressed(e);
                        break;
                    default:
                        System.out.print("oh not shit is real");
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

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch(Gamestate.state) {
                    case gameover:
                            panel.getGame().getGameover().mouseMoved(e);
                            break;
                    case gamewin:
                            panel.getGame().getGamewin().mouseMoved(e);
                            break;
                    case menu:
                            panel.getGame().getMenu().mouseMoved(e);
                            break;
                    case playing:
                            panel.getGame().getPlaying().mouseMoved(e);
                            break;
                    case fiftyfifty:
                        panel.getGame().getfiftyfifty().mouseMoved(e);
                        break;
                    case continueoption:
                        panel.getGame().getcontinueoption().mouseMoved(e);
                        break;
                    default:
                        System.out.print("oh not shit is real");
                        break;
		}
    }

}
