package gui_Assignment;

import java.awt.Graphics;

import gamestates.*;

public class Game implements Runnable {
	Frame gf;
	Panel gp;
	menu menu;
	playing playing;
	gameover gameover;
	gamewin gamewin;
	continueoption continueoption;
	fiftyfifty fiftyfifty;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	// public final static int UNIT_SIZE = 25;

	public user user;

	public final static int framewidth = 900;
	public final static int framehight = 600;

	private Thread gameThread;

	Game() {
		this.fiftyfifty = new fiftyfifty(this);
		this.continueoption = new continueoption(this);
		this.menu = new menu(this);
		this.playing = new playing(this);
		this.gameover = new gameover(this);
		this.gamewin = new gamewin(this);
		gp = new Panel(this);
		gf = new Frame(gp);
		startGameLoop();

		this.user = new user("tim");// test needs to be removed is temp
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
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

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public void draw(Graphics g) {
		switch (Gamestate.state) {
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
		case continueoption:
			continueoption.draw(g);
			break;
		case fiftyfifty:
			fiftyfifty.draw(g);
			break;
		default:
			System.out.print("lol sucks to suck");
			break;
		}
	}

	public Frame getGf() {
		return gf;
	}

	public Panel getGp() {
		return gp;
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			// if (deltaU >= 1) {
			// update();
			// updates++;
			// deltaU--;
			// }

			if (deltaF >= 1) {

				gp.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				System.out.println(Gamestate.state);
				System.out.println("money: " + user.money);

				frames = 0;
				updates = 0;

			}
		}

	}

}
