package gamestates;

import java.awt.Graphics;
import static gui_Assignment.Game.framewidth;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import question_code.Question;
import question_code.*;

public class playing extends state implements statemethods {

	Font optionfont;
	Font questionfont;
	private static int option1X = 25;
	private static int option1Y = 465;

	private static int optionSizeX = 420;
	private static int optionSizeY = 50;

	private static int questionSizeY = 70;
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
		this.questionfont = new Font("Monospaced", Font.BOLD, 50);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		if (QuestionNum % 5 != 0 || QuestionNum == 0) {
			String ans0 = QuestionList.get(QuestionNum).getoption(0);
			String ans1 = QuestionList.get(QuestionNum).getoption(1);
			String ans2 = QuestionList.get(QuestionNum).getoption(2);
			String ans3 = QuestionList.get(QuestionNum).getoption(3);
			String questiontext = QuestionList.get(QuestionNum).getquestion();

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
			offsetX = centertext(g, questionfont, questiontext, framewidth);
			g.setColor(Color.GRAY);
			int questionSizex = g.getFontMetrics().stringWidth(questiontext);
			g.fillRect(offsetX - 5, questionY - 50, questionSizex + 10, questionSizeY);

			// question text
			g.setColor(Color.BLACK);
			g.setFont(questionfont);
			g.drawString(questiontext, offsetX, questionY);

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
		Gamestate.state = Gamestate.continueoption;

	}

	public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;

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
				this.fiftyfiftyUsed = true;
				Gamestate.state = Gamestate.fiftyfifty;

			}
		}
	}

	public void optionpressed(int ans) {
		if (QuestionList.get(QuestionNum).checkAns(ans)) {
			if (QuestionNum + 1 < QuestionList.size()) {
				this.QuestionNum++;
				updatemoney();
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
}
