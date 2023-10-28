/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamestates;

import gui_Assignment.Game;
import static gui_Assignment.Game.framewidth;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import question_code.*;
import java.util.Random;

/**
 *
 * @author jovan
 */
public class fiftyfifty extends state implements statemethods{

	double correctAns;
        private String correctAnsText;
        double wrongAns;
        private String wrongAnsText;
        
	private Question question;       
        private String QuestionText;  
        private String[] lines;
        
        private Font optionfont;
	private Font questionfont;
        private Font skipFont;
        private static int option1X = 25;
	private static int option1Y = 465;

	private static int optionSizeX = 420;
	private static int optionSizeY = 50;

	private static int questionSizeY = 30;
	private static int questionY = 150;

	private static int quitSize = 50;
	private static int lifeLineSizey = 50;
	private static int lifeLineSizex = 80;
        private BufferedImage backRound;
        
        private boolean option0Glow= false;
        private boolean option1Glow= false;
        private boolean skipglow= false;
        private Color buttoncolor;
        Random r;
        
	public fiftyfifty(Game game) {
		super(game);
                this.r = new Random();
                this.optionfont = new Font("Serif", Font.BOLD, 30);
                this.questionfont = new Font("Serif", Font.BOLD, 40);
                this.skipFont = new Font("Serif", Font.BOLD, 35);
                buttoncolor = new Color(6, 52, 125);
                this.backRound = game.getGameDefaultBackRound();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
        public void setQuestion(Question q) {
		this.question = q;
                this.correctAns = q.getCorrectAnswer();
                double randInt;
                randInt = r.nextInt(4);
                
                while (randInt == correctAns){
                    randInt = r.nextInt(4);
                }
                this.wrongAns = randInt;
                this.QuestionText = q.getQuestionText();
                this.correctAnsText = q.getOption((int)correctAns);
                this.wrongAnsText = q.getOption((int) wrongAns);
                this.lines = QuestionText.split("#");
                
                
		
	}

	@Override
	public void draw(Graphics g) {
            Graphics2D g2 = (Graphics2D) g; 
            g2.setStroke(new BasicStroke(2f));
            g2.drawImage(backRound, 0, 0, null);
            int offsetX; 
            // question box
            int oldoffsetx =0;
            int questionSizex;
            int newsizex;
            g2.setFont(questionfont);
            questionSizex = g2.getFontMetrics().stringWidth(lines[0]);
            offsetX = centertext(g2, questionfont, lines[0], framewidth);
            if(lines.length > 1){ // canges x offest and question box size to fit the question by finding the largest line in the qestion 
                for (String line : lines){                            
                    oldoffsetx = offsetX;  // stores the last x offset 
                    newsizex = g2.getFontMetrics().stringWidth(line);
                    offsetX = centertext(g2, questionfont, line, framewidth);                      
                    if(oldoffsetx < offsetX){
                        offsetX = oldoffsetx; 
                    }
                    if(newsizex > questionSizex){
                    questionSizex = newsizex;                            
                    }
                }                      
            }

            g2.setColor(buttoncolor);
            g2.fillRoundRect(offsetX-5, questionY - 50, questionSizex + 10, questionSizeY+lines.length*40,20,20);// question box backround
            g2.setColor(Color.YELLOW);
            g2.drawRoundRect(offsetX-5, questionY - 50, questionSizex + 10, questionSizeY+lines.length*40,20,20);// question box out line
            
            // question text
            g2.setColor(Color.WHITE);
            g2.setFont(questionfont);

            int i =0;
            int lineoffset = 40;
            for (String line : lines){
            offsetX = centertext(g2, questionfont, line, framewidth);
            g2.drawString(line, offsetX, questionY+lineoffset*i);
                i++;
            }
            // option boxes
            g2.setColor(buttoncolor);
            g2.fillRoundRect(option1X, option1Y, optionSizeX, optionSizeY,20,20); // first option
            g2.fillRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY,20,20); // second option
            g2.setColor(Color.YELLOW);
            g2.drawRoundRect(option1X, option1Y, optionSizeX, optionSizeY,20,20); // first option
            g2.drawRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY,20,20); // second option
            
            g2.setColor(Color.WHITE);
            g2.setFont(optionfont);
            
            if(correctAns < wrongAns){ // this makes sure that the correct ans and wrong ans are dispayed in the right order 
                
                // option0
                g2.setColor(Color.WHITE);
                if(this.option0Glow){
                    g2.setColor(Color.YELLOW);
                }
		offsetX = centertext(g2, optionfont, correctAnsText, optionSizeX);
		g2.drawString(correctAnsText, option1X + offsetX, option1Y + 35);
		// option1                
                g2.setColor(Color.WHITE);
                if(this.option1Glow){
                    g2.setColor(Color.YELLOW);
                }		                
		offsetX = centertext(g2, optionfont, wrongAnsText, optionSizeX);
		g2.drawString(wrongAnsText, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
            }else{
                
                // option0
                g2.setColor(Color.WHITE);
                if(this.option0Glow){
                    g2.setColor(Color.YELLOW);
                }		                
                offsetX = centertext(g2, optionfont, wrongAnsText, optionSizeX);
		g2.drawString(wrongAnsText, option1X + offsetX, option1Y + 35);
                
                // option1
                g2.setColor(Color.WHITE);
                if(this.option1Glow){
                    g2.setColor(Color.YELLOW);
                }               		
		offsetX = centertext(g2, optionfont, correctAnsText, optionSizeX);
		g2.drawString(correctAnsText, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
            }
                        
                        
            // _other buttons_
            // skip
            if (!this.game.getPlaying().getskipUsed()) {// draws the skip button if the skip has not bean used
                g2.setColor(buttoncolor);
                
                g2.fillRoundRect(0, 360, lifeLineSizex, lifeLineSizey,10,10);
                
                g2.setColor(Color.YELLOW);
                g2.drawRoundRect(0, 360, lifeLineSizex, lifeLineSizey,10,10);
                g2.setColor(Color.WHITE);
                if(this.skipglow){
                g2.setColor(Color.YELLOW);
                }
                offsetX = centertext(g2,skipFont,"skip",lifeLineSizex);
                g2.setFont(skipFont);
                g2.drawString("skip", offsetX, 360 + lifeLineSizey - 10);
            }
			
//            // quit
//            g2.setColor(Color.GRAY);
//            g2.fillRect(0, 0, quitSize, quitSize);
//            g2.setColor(Color.BLACK);
//            g2.setFont(new Font("Monospaced", Font.BOLD, 50));
//            g2.drawString("X", 0 + 10, quitSize - 10);
//            return;	
	}
        
        public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
                
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;
                
		return offset;
	}
        
        

	@Override
	public void mousePressed(MouseEvent e) {
		if(correctAns < wrongAns){// check whitch way the options are beening displayed 
                    // if option 0 if pressed
                    if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                            if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                                    System.out.println("option 0 was pressed__correct");
                                    Gamestate.state = Gamestate.playing;                                    
                                    game.getPlaying().optionpressed((int)correctAns);                                    
                                    return;
                            }
                    }
                    // if option 1 is pressed
                    if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                            if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                                    System.out.println("option 1 was pressed");
                                    Gamestate.state = Gamestate.playing;
                                    game.getPlaying().optionpressed((int)wrongAns);
                                    return;
                            }
                    }
                }else{
                
                 // if option 0 if pressed
                    if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                            if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                                    System.out.println("option 0 was pressed");
                                    Gamestate.state = Gamestate.playing;
                                    game.getPlaying().optionpressed((int)wrongAns);
                                    return;
                            }
                    }
                    // if option 1 is pressed
                    if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                            if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                                    System.out.println("option 1 was pressed__correct");
                                    
                                    Gamestate.state = Gamestate.playing;
                                    game.getPlaying().optionpressed((int)correctAns);
                                    return;
                            }
                    }
                
                
                
                
                
                
                }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
            
            this.option0Glow = false;
            this.option1Glow = false;
            // TODO Auto-generated method stub
            // if option 0 if pressed
            if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                    if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                            this.option0Glow = true;                              
                            return;
                    }
            }
            // if option 1 is pressed
            if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                    if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                            this.option1Glow = true;
                            return;
                    }
            }      
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
