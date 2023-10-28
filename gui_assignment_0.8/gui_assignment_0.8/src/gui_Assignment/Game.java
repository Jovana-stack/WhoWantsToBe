/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_Assignment;

import java.awt.Graphics;

import gamestates.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        
        private BufferedImage gameDefaultBackRound;
        private BufferedImage menubackround;
        

	private Thread gameThread;

	Game() throws IOException {
                importimages();
                this.continueoption = new continueoption(this);
		this.menu = new menu(this);
		this.playing = new playing(this);
		this.gameover = new gameover(this);
		this.gamewin = new gamewin(this);
                this.fiftyfifty = new fiftyfifty(this);
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
        public fiftyfifty getfiftyfifty(){
            return fiftyfifty;
        }

	public gamewin getGamewin() {
		return gamewin;
	}
        
        public continueoption getcontinueoption(){
            return continueoption;
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
		

		long previousTime = System.nanoTime();

		int frames = 0;
		
		long lastCheck = System.currentTimeMillis();

		
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			

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
				

			}
		}

	}
        
        private void importimages(){
             // imports images on game start and stores them in buffered images
            File menuImageFile = new File("startgame.png");
            File backroundImageFile = new File("gamebackround.png");

            try {
                // Uses ImageIO to read the image into a BufferedImage
                 this.menubackround = ImageIO.read(menuImageFile);
                 this.gameDefaultBackRound = ImageIO.read(backroundImageFile);
            } catch (IOException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        public BufferedImage getMenubackround(){
            return  this.menubackround;
        }
        public BufferedImage getGameDefaultBackRound(){
            return  this.gameDefaultBackRound;
        }

}
