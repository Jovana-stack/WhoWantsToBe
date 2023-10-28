package gamestates;

import java.awt.Graphics;
import static gui_Assignment.Game.framewidth;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import question_code.*;

public class playing extends state implements statemethods {

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

	private boolean skipUsed = false;
	private boolean fiftyfiftyUsed = false;

	ArrayList<Question> QuestionList;
	public int QuestionNum;

	public playing(gui_Assignment.Game game) {
		super(game);
		this.QuestionList = QuestionGen.Genquestion();
		this.QuestionNum = 0;
		this.optionfont = new Font("Monospaced", Font.BOLD, 30);
		this.questionfont = new Font("Monospaced", Font.BOLD, 30);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		
			String ans0 = QuestionList.get(QuestionNum).getOption(0);
			String ans1 = QuestionList.get(QuestionNum).getOption(1);
			String ans2 = QuestionList.get(QuestionNum).getOption(2);
			String ans3 = QuestionList.get(QuestionNum).getOption(3);
			String questiontext = QuestionList.get(QuestionNum).getQuestionText();
                        

			// option boxes
			g.setColor(Color.GRAY);
			g.fillRect(option1X, option1Y, optionSizeX, optionSizeY); // first option
			g.fillRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY); // second option
			g.fillRect(option1X, option1Y + 60, optionSizeX, optionSizeY); // third option
			g.fillRect(option1X + optionSizeX + 10, option1Y + 60, optionSizeX, optionSizeY); // forth option

			// _option_
			// option text
			int offsetX;
			g.setColor(Color.BLACK);
			g.setFont(optionfont);
			// option0
			offsetX = centertext(g, optionfont, ans0, optionSizeX);
			g.drawString(ans0, option1X + offsetX, option1Y + 35);
			// option1
			offsetX = centertext(g, optionfont, ans1, optionSizeX);
			g.drawString(ans1, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
			// option2
			offsetX = centertext(g, optionfont, ans2, optionSizeX);
			g.drawString(ans2, option1X + offsetX, option1Y + 60 + 35);
			// option3
			offsetX = centertext(g, optionfont, ans3, optionSizeX);
			g.drawString(ans3, option1X + optionSizeX + 10 + offsetX, option1Y + 60 + 35);

			// _question_
                        
			// question box
                        int oldoffsetx =0;
                        int questionSizex;
                        int newsizex;
                        String[] lines = questiontext.split("#");
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
                        
			

			// _other buttons_
			// skip
			if (!skipUsed) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 360, lifeLineSizex, lifeLineSizey);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Monospaced", Font.BOLD, 30));
				g.drawString("skip", 0 + 5, 360 + lifeLineSizey - 10);
			}
			// 50:50
			if (!fiftyfiftyUsed) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 300, lifeLineSizex, lifeLineSizey);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Monospaced", Font.BOLD, 30));
				g.drawString("1/2", 0 + 5, 300 + lifeLineSizey - 10);
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

		// if option 0 if pressed
		if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
			if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
				System.out.println("option 0 was pressed");
				optionpressed(0);
				return;
			}
		}
		// if option 1 is pressed
		if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
			if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
				System.out.println("option 1 was pressed");
				optionpressed(1);
				return;

			}
		}
		// if option 2 if pressed
		if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
			if (e.getY() < optionSizeY + option1Y + 60 && e.getY() > option1Y + 60) {
				System.out.println("option 2 was pressed");
				optionpressed(2);
				return;
			}
		}
		// if option 3 is pressed
		if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
			if (e.getY() < optionSizeY + option1Y + 60 && e.getY() > option1Y + 60) {
				System.out.println("option 3 was pressed");
				optionpressed(3);
				return;
			}
		}

		// if skip is pressed
		if (e.getX() < lifeLineSizex && e.getX() > 0) {
			if (e.getY() < lifeLineSizey + 360 && e.getY() > 360) {
				this.skipUsed = true;
				this.QuestionNum++;

			}
		}
		// if fiftyfifty is pressed
		if (e.getX() < lifeLineSizex && e.getX() > 0) {
			if (e.getY() < lifeLineSizey + 300 && e.getY() > 300) {
                            
                                game.getfiftyfifty().setQuestion(QuestionList.get(QuestionNum));
				this.fiftyfiftyUsed = true;
				Gamestate.state = Gamestate.fiftyfifty;

			}
		}
	// if quit is pressed
			if (e.getX() < lifeLineSizex && e.getX() > 0) {
				if (e.getY() < lifeLineSizey && e.getY() > 0) {
					Gamestate.state = Gamestate.gameover;

				}
			}
		}
	public void optionpressed(int ans) {
            
            
		if (QuestionList.get(QuestionNum).checkAns(ans)) {
                   
			if (QuestionNum + 1 < QuestionList.size()) {
				this.QuestionNum++;
				updatemoney();
				if (QuestionNum % 5 == 0 && QuestionNum != 0) {
					Gamestate.state = Gamestate.continueoption;
				}
				return;
			}
			this.game.getUser().setMoney(1000000);
			Gamestate.state = Gamestate.gamewin;
			return;
		}
		System.out.println("game lost");
		Gamestate.state = Gamestate.gameover;
		return;
	}

	public void updatemoney() {
		if (this.QuestionNum == 1) {
			this.game.getUser().setMoney(100);
			return;
		}
		if (this.QuestionNum < 5) {
			int oldmoney = this.game.getUser().getMoney();
			this.game.getUser().setMoney(oldmoney + 100);
			return;
		}
		if (this.QuestionNum == 5) {
			this.game.getUser().setMoney(1000);
			return;
		}
		if (this.QuestionNum < 10) {
			int oldmoney = this.game.getUser().getMoney();
			this.game.getUser().setMoney(oldmoney + 1000);
			return;
		}
		if (this.QuestionNum == 10) {
			this.game.getUser().setMoney(10000);
			return;
		}
		int oldmoney = this.game.getUser().getMoney();
		this.game.getUser().setMoney(oldmoney + 10000);
		return;
	}

	public int getQuestionNum() {
		return QuestionNum;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Your mouseMoved logic here
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Your mouseReleased logic here
	}
        
        public boolean getskipUsed(){
        return skipUsed;
        }
}
