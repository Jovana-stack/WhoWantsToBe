package gui_Assignment;

import java.awt.Graphics;

import gamestates.*;

public class game {
	frame gf;
	panel gp;
	menu menu;
	playing playing;
	gameover gameover;
	gamewin gamewin;
	public final static int UNIT_SIZE = 100;
	
	public final static int framewidth = UNIT_SIZE * 9;
	public final static int framehight = UNIT_SIZE * 5;

	game() {
		gp = new panel(this);
		gf = new frame(gp);
		
		this.playing = new playing(this);
		this.menu = new menu(this);
		this.gameover = new gameover(this);
		this.gamewin = new gamewin(this);
		
	}

	public menu getMenu() {
		return menu;
	}

	public playing getPlaying() {
		return playing;
	}

	public gameover getGameover() {
		return gameover;
	}

	public gamewin getGamewin() {
		return gamewin;
	}

	public void draw(Graphics g) {
		switch (gamesate.state) {
		case gameover:
			gameover.draw(g);
			break;
		case gamewin:
			gamewin.draw(g);
			break;
		case menu:
			menu.draw(g);
			break;
		case playing:
			playing.draw(g);
			break;
		default:
			break;

		}

	}

	public void update() {
		// TODO Auto-generated method stub

	}

}
