/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamestates;

import gui_Assignment.Game;
import static gui_Assignment.Game.framewidth;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import question_code.*;
import java.util.Random;

/**
 *
 * @author jovan
 */
public class fiftyfifty extends state implements statemethods{

	double correctAns;
        String correctAnsText;
        double wrongAns;
        String wrongAnsText;
        
	Question question;       
        String QuestionText;   
        Font optionfont;
	Font questionfont;
        
        private static int option1X = 25;
	private static int option1Y = 465;

	private static int optionSizeX = 420;
	private static int optionSizeY = 50;

	private static int questionSizeY = 30;
	private static int questionY = 150;

	private static int quitSize = 50;
	private static int lifeLineSizey = 50;
	private static int lifeLineSizex = 80;
        
        Random r;
        
	public fiftyfifty(Game game) {
		super(game);
                this.r = new Random();
                this.optionfont = new Font("Monospaced", Font.BOLD, 30);
		this.questionfont = new Font("Monospaced", Font.BOLD, 30);
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
                
                
                
		
	}

	@Override
	public void draw(Graphics g) {
		
            int offsetX; 
            // question box
            int oldoffsetx =0;
            int questionSizex;
            int newsizex;
            String[] lines = QuestionText.split("#");
            questionSizex = g.getFontMetrics().stringWidth(lines[0]);
            offsetX = centertext(g, questionfont, lines[0], framewidth);

            for (String line : lines){                            
                oldoffsetx = offsetX;  
                newsizex = g.getFontMetrics().stringWidth(line);
                offsetX = centertext(g, questionfont, line, framewidth);
                System.out.println(questionSizex);
                if(oldoffsetx < offsetX){
                    offsetX = oldoffsetx; 
                }
                if(newsizex > questionSizex){
                questionSizex = newsizex;

                }
            }                      

            g.setColor(Color.GRAY);

            g.fillRect(offsetX-5, questionY - 50, questionSizex + 10, questionSizeY+lines.length*40);

            // question text
            g.setColor(Color.BLACK);
            g.setFont(questionfont);


            int i =0;
            int lineoffset = 40;
            for (String line : lines){
            offsetX = centertext(g, questionfont, line, framewidth);
            g.drawString(line, offsetX, questionY+lineoffset*i);
                i++;
            }
            // option boxes
			g.setColor(Color.GRAY);
			g.fillRect(option1X, option1Y, optionSizeX, optionSizeY); // first option
			g.fillRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY); // second option
			
            g.setColor(Color.BLACK);
            g.setFont(optionfont);
            // option0
            if(correctAns < wrongAns){
		offsetX = centertext(g, optionfont, correctAnsText, optionSizeX);
		g.drawString(correctAnsText, option1X + offsetX, option1Y + 35);
		// option1
		offsetX = centertext(g, optionfont, wrongAnsText, optionSizeX);
		g.drawString(wrongAnsText, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
            }else{
                offsetX = centertext(g, optionfont, wrongAnsText, optionSizeX);
		g.drawString(wrongAnsText, option1X + offsetX, option1Y + 35);
		// option1
		offsetX = centertext(g, optionfont, correctAnsText, optionSizeX);
		g.drawString(correctAnsText, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
            }
                        
                        
            // _other buttons_
            // skip
            if (!game.getPlaying().getskipUsed()) {
                g.setColor(Color.GRAY);
                g.fillRect(0, 360, lifeLineSizex, lifeLineSizey);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monospaced", Font.BOLD, 30));
                g.drawString("skip", 0 + 5, 360 + lifeLineSizey - 10);
            }
			
            // quit
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, quitSize, quitSize);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.BOLD, 50));
            g.drawString("X", 0 + 10, quitSize - 10);
            return;	
	}
        
        public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
                
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;
                System.out.println(text+" offset: "+offset);
		return offset;
	}
        
        

	@Override
	public void mousePressed(MouseEvent e) {
		if(correctAns < wrongAns){
                    // if option 0 if pressed
                    if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                            if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                                    System.out.println("option 0 was pressed");
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
                                    System.out.println("option 1 was pressed");
                                    Gamestate.state = Gamestate.playing;
                                    game.getPlaying().optionpressed((int)correctAns);
                                    return;
                            }
                    }
                
                
                
                
                
                
                }
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
