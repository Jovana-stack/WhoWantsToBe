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
import java.io.IOException;

/**
 *
 * @author nicet
 */
public class inputname extends state implements statemethods{

    
    // start button
    // size
    private static int startButtonSizeX = 270;
    private static int startButtonSizeY = 50;
    // postion
    private static int startbuttonY = 464;
    private static int startbuttonX = 900/2-startButtonSizeX/2;
    // text off set
    private static int startTextY = 35;

    private BufferedImage menubackround;
    private boolean startGlow;
    
    
    int charnum;
    Font namefont;
    String name;
    
    public inputname(Game game) throws IOException {
        super(game);
        this.menubackround = game.getMenubackround();
        this.name = "";
        this.charnum = 0; 
        this.namefont = new Font("Serif", Font.BOLD, 40);
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(menubackround, 0, 0, null);
        int xoffset = centertext(g,namefont,name,900);
        
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(startbuttonX, startbuttonY, startButtonSizeX, startButtonSizeY,20,20);
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(startbuttonX, startbuttonY, startButtonSizeX, startButtonSizeY,20,20);
        g2.setColor(Color.BLACK);
        g2.drawString(name, xoffset, startbuttonY+startTextY);
    }
    
    
    public void updatename(char A){
       if(this.charnum >= 8){
       return;
       }
       this.name = this.name+A;
       charnum++;
    }
    
    public void backspace(){
        if(charnum > 0){
        this.name = name.substring(0,charnum-1 );
        charnum--;
        }
    }
    
    public void savename(){
        Gamestate.state = Gamestate.playing;
        
        this.game.getUser().setName(name);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;

		return offset;
	}
    
    
    
    
    
    
    
    
}
