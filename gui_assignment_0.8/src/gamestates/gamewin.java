/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamestates;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class gamewin extends state implements statemethods{
    
    String testname;
    Font gameEndFont;
    Font gameEndSmallFont;
    Font gameEndMoneyfont;
    private BufferedImage backRound;
    private Color buttoncolor;
    
    

    public gamewin(gui_Assignment.Game game) {
        super(game);		
        this.gameEndSmallFont = new Font("Serif", Font.BOLD, 30);
        this.gameEndFont = new Font("Serif", Font.BOLD, 40);
        this.gameEndMoneyfont = new Font("Monospaced", Font.BOLD, 70);
        this.backRound = game.getGameDefaultBackRound();
        buttoncolor = new Color(6, 52, 125);
        
        
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int questionSizex;
        g2.setStroke(new BasicStroke(2f));
        g2.drawImage(backRound, 0, 0, null);        
        g2.setColor(buttoncolor);
        int offsetX = centertext(g2,gameEndFont,"congrats "+game.user.getName()+" you win",900);
        questionSizex = g2.getFontMetrics().stringWidth("congrats"+game.user.getName()+" you win");
        g2.fillRoundRect(offsetX-7, 220, questionSizex+14, 60, 20, 20);
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(offsetX-7, 220, questionSizex+14, 60, 20, 20);
        g2.setColor(Color.WHITE);
        g2.drawString("congrats "+game.user.getName()+" you win", offsetX, 260);		
        offsetX = centertext(g2,gameEndMoneyfont,"$"+this.game.getUser().getMoney(),900);
        g2.setColor(Color.YELLOW);
        g2.drawString("$"+this.game.getUser().getMoney(), offsetX, 350);
    }

    public int centertext(Graphics g, Font f, String text, int sizeX) {
        g.setFont(f);
        int width = g.getFontMetrics().stringWidth(text);
        int offset = (sizeX - width) / 2;
        return offset;
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