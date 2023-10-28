/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamestates;

import gui_Assignment.Game;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author jovan
 */
public class continueoption extends state implements statemethods {
    private static final int option1X = 25;
    private static final int option1Y = 465;

    private static int optionSizeX = 420;
    private static int optionSizeY = 70;
    private boolean saveglow;
    private boolean riskglow;
    private Color buttoncolor;
    private BufferedImage backRound;
    Font Moneyfont; 
    Font otherfont;

    public continueoption(Game game) {
        super(game);
        // TODO Auto-generated constructor stub		
        this.Moneyfont = new Font("Monospaced", Font.BOLD, 80);
        this.otherfont = new Font("Serif", Font.BOLD, 40);
        this.buttoncolor = new Color(6, 52, 125);
        this.backRound = game.getGameDefaultBackRound();
    }

    @Override
    public void update() {


    }

    @Override
    public void draw(Graphics g) {
        int offsetx;                
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backRound, 0, 0, null);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(buttoncolor);
        offsetx = centertext(g2,otherfont,"you can save this money",900);
        g2.fillRoundRect(offsetx-5, 110, g2.getFontMetrics().stringWidth("you can save this money")+10, 120,20,20);
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(offsetx-5, 110, g2.getFontMetrics().stringWidth("you can save this money")+10, 120,20,20);
        
        g2.setColor(Color.WHITE);                
        g2.drawString("you can save this money", offsetx, 150);
        offsetx = centertext(g2,otherfont,"or risk it for more",900);
        g2.drawString("or risk it for more", offsetx, 220);

        g2.setColor(Color.YELLOW);
        offsetx = centertext(g2,Moneyfont,"$"+game.getUser().getMoney(),900);
        g2.drawString("$"+game.getUser().getMoney(), offsetx, 300);                

        g2.setColor(buttoncolor);
        g2.fillRoundRect(option1X, option1Y, optionSizeX, optionSizeY,20,20);// frist option
        g2.fillRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY,20,20); // second option
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(option1X, option1Y, optionSizeX, optionSizeY,20,20);
        g2.drawRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY,20,20);

        g2.setColor(Color.WHITE);
        if(this.riskglow){
            g2.setColor(Color.YELLOW);
        }
        offsetx = centertext(g2,otherfont,"risk",optionSizeX);
        g2.drawString("risk", option1X+offsetx+optionSizeX+10, option1Y+45);
        g2.setColor(Color.WHITE);
        if(this.saveglow){
            g2.setColor(Color.YELLOW);
        }        
        offsetx = centertext(g2,otherfont,"save",optionSizeX);
        g2.drawString("save", option1X+offsetx, option1Y+45);
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
        //if option 0 if pressed
        if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                        System.out.println("option 0 was pressed");
                        Gamestate.state = Gamestate.gamewin;
                        return;
                }
        }
        // if option 1 is pressed
        if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                        System.out.println("option 1 was pressed");
                        Gamestate.state = Gamestate.playing;
                        return;

                }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.riskglow = false;
        this.saveglow = false;
        //if option 0 if pressed
        if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                    this.saveglow = true;
                    return;
                }
        }
        // if option 1 is pressed
        if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                    this.riskglow = true;
                    return;

                }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

    }

}