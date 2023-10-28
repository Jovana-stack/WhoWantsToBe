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
public class gameover extends state implements statemethods {
    private BufferedImage backRound;
    private static int startButtonSizeX = 270;
    private static int startButtonSizeY = 50;
    // postion
    private static int startbuttonY = 464;
    private static int startbuttonX = 900/2-startButtonSizeX/2;
    // text off set
    private static int startTextY = 35;
    public gameover(Game game) {
        super(game);
        this.backRound = game.getMenubackround();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g2.drawImage(backRound, 0, 0, null);

        g2.setColor(new Color(6, 52, 125));
        g2.fillRoundRect(startbuttonX, startbuttonY, startButtonSizeX, startButtonSizeY,20,20);
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(startbuttonX, startbuttonY, startButtonSizeX, startButtonSizeY,20,20);
        
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 40));
        int offset = centertext(g2,new Font("Serif", Font.BOLD, 40),"game over",900);
        g2.drawString("game over", offset, startbuttonY + startTextY);    
        
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
    public int centertext(Graphics g, Font f, String text, int sizeX) {
        g.setFont(f);
        int width = g.getFontMetrics().stringWidth(text);
        int offset = (sizeX - width) / 2;
        return offset;
    }

}
