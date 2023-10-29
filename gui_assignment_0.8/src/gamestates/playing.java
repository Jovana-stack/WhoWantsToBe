package gamestates;

import java.awt.Graphics;
import static gui_Assignment.Game.framewidth;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import question_code.*;

public class playing extends state implements statemethods {

    Font optionfont;
    Font questionfont;
    Font skipFont;
    private static final int option1X = 25;
    private static final int option1Y = 465;

    private static final int optionSizeX = 420;
    private static final int optionSizeY = 50;

    private static final int questionSizeY = 30;
    private static final int questionY = 150;

    private static final int quitSize = 50;
    private static final int lifeLineSizey = 50;
    private static final int lifeLineSizex = 80;

    private boolean skipUsed = false;
    private boolean fiftyfiftyUsed = false;

    private boolean option0Glow= false;
    private boolean option1Glow= false;
    private boolean option2Glow= false;
    private boolean option3Glow= false;

    private boolean skipglow= false;
    private boolean fiftyfiftyglow= false;

    private String ans0;
    private String ans1;
    private String ans2;
    private String ans3;
    private String questiontext;
    private String[] lines;
    private BufferedImage backRound;

    private Color buttoncolor;
    ArrayList<Question> QuestionList;
    public int QuestionNum;

    public playing(gui_Assignment.Game game) {
            super(game);
            this.backRound = game.getGameDefaultBackRound();
            this.QuestionList = QuestionGen.Genquestion();
            this.QuestionNum = 0;
            this.optionfont = new Font("Serif", Font.BOLD, 30);
            this.questionfont = new Font("Serif", Font.BOLD, 40);
            this.skipFont = new Font("Serif", Font.BOLD, 35);
            nextquestion();
            buttoncolor = new Color(6, 52, 125);

    }


    private void nextquestion(){
        this.ans0 = QuestionList.get(QuestionNum).getOption(0);
        this.ans1 = QuestionList.get(QuestionNum).getOption(1);
        this.ans2 = QuestionList.get(QuestionNum).getOption(2);
        this.ans3 = QuestionList.get(QuestionNum).getOption(3);
        this.questiontext = QuestionList.get(QuestionNum).getQuestionText();
        this.lines = questiontext.split("#");


    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // backround
        g2.drawImage(backRound, 0, 0, null);


        // option boxes
        
        g2.setColor(buttoncolor);
        g2.fillRoundRect(option1X, option1Y, optionSizeX, optionSizeY, 20, 20);// first option
        g2.fillRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY, 20, 20);// second option
        g2.fillRoundRect(option1X, option1Y+60, optionSizeX, optionSizeY, 20, 20);// third option
        g2.fillRoundRect(option1X + optionSizeX + 10, option1Y+60, optionSizeX, optionSizeY, 20, 20);// forth option
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.YELLOW);
        g2.drawRoundRect(option1X, option1Y, optionSizeX, optionSizeY, 20, 20);
        g2.drawRoundRect(option1X + optionSizeX + 10, option1Y, optionSizeX, optionSizeY, 20, 20);
        g2.drawRoundRect(option1X, option1Y+60, optionSizeX, optionSizeY, 20, 20);
        g2.drawRoundRect(option1X + optionSizeX + 10, option1Y+60, optionSizeX, optionSizeY, 20, 20);

        // _option_
        // option text
        int offsetX;


        g2.setColor(Color.WHITE);
        g2.setFont(optionfont);
        // option0
        if(this.option0Glow){
            g2.setColor(Color.YELLOW);
        }
        offsetX = centertext(g2, optionfont, ans0, optionSizeX);
        g2.drawString(ans0, option1X + offsetX, option1Y + 35);
        // option1
        g2.setColor(Color.WHITE);
        if(this.option1Glow){
            g2.setColor(Color.YELLOW);
        }
        offsetX = centertext(g2, optionfont, ans1, optionSizeX);
        g2.drawString(ans1, option1X + optionSizeX + 10 + offsetX, option1Y + 35);
        // option2
        g2.setColor(Color.WHITE);
        if(this.option2Glow){
            g2.setColor(Color.YELLOW);
        }
        offsetX = centertext(g2, optionfont, ans2, optionSizeX);
        g2.drawString(ans2, option1X + offsetX, option1Y + 60 + 35);
        // option3
        g2.setColor(Color.WHITE);
        if(this.option3Glow){
            g2.setColor(Color.YELLOW);
        }
        offsetX = centertext(g2, optionfont, ans3, optionSizeX);
        g2.drawString(ans3, option1X + optionSizeX + 10 + offsetX, option1Y + 60 + 35);

        // _question_

        // question box
        int oldoffsetx =0;
        int questionSizex;
        int newsizex;
        g2.setFont(questionfont);
        questionSizex = g2.getFontMetrics().stringWidth(lines[0]);
        offsetX = centertext(g2, questionfont, lines[0], framewidth);
        if(lines.length > 1){ // canges x offest and question box size to fit the question by finding the largest line in the qestion 
            for (String line : lines){                            
                oldoffsetx = offsetX;  // stores the last x off 
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
        

        int i =0;
        int lineoffset = 40;
        for (String line : lines){
        offsetX = centertext(g2, questionfont, line, framewidth);
        g2.drawString(line, offsetX, questionY+lineoffset*i);
            i++;
        }
        
        // _other buttons_
        // skip
        if (!skipUsed) {// draws the skip button if the skip has not bean used
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
        // 50:50
        if (!fiftyfiftyUsed) { // draws the fiftyfifty button if it has not bean used
            g2.setColor(buttoncolor);    
            g2.fillRoundRect(0, 300, lifeLineSizex, lifeLineSizey,10,10);
                
            g2.setColor(Color.YELLOW);
            g2.drawRoundRect(0, 300, lifeLineSizex, lifeLineSizey,10,10);
            
            g2.setColor(Color.WHITE);
            if(this.fiftyfiftyglow){
            g2.setColor(Color.YELLOW);
            }
            g2.setFont(new Font("Monospaced", Font.BOLD, 25));
            g2.drawString("50:50", 0 + 2, 300 + lifeLineSizey - 20);
        }
//        // quit
//        g2.setColor(Color.GRAY);
//        g2.fillRect(0, 0, quitSize, quitSize);
//        g2.setColor(Color.BLACK);
//        g2.setFont(new Font("Monospaced", Font.BOLD, 50));
//        g2.drawString("X", 0 + 10, quitSize - 10);
        return;


    }

    public int centertext(Graphics g, Font f, String text, int sizeX) {
            g.setFont(f);

            int width = g.getFontMetrics().stringWidth(text);
            int offset = (sizeX - width) / 2;

            return offset;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // checks where the mouse is when it clicks and if it is clicking on any buttons

        // if option 0 if pressed
        if (e.getX() < option1X + optionSizeX && e.getX() > option1X) { // checks if the mouse  has the same x as the button
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) { // checks if the mouse  has the same y as the button
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
                if (QuestionNum + 1 < QuestionList.size()) {// checks if their are still questions
                        this.QuestionNum++;
                        updatemoney();
                        if (QuestionNum % 5 == 0 && QuestionNum != 0) {
                               Gamestate.state = Gamestate.continueoption;
                        }
                        nextquestion();
                        return;
                }
                this.game.getUser().setMoney(1000000);
                this.game.user.insertUser();
                Gamestate.state = Gamestate.gamewin;
                return;
        }
        System.out.println("game lost");
        this.game.user.insertUser();
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
        this.option0Glow = false;    
        this.option1Glow = false;
        this.option2Glow = false;
        this.option3Glow = false;
        this.fiftyfiftyglow = false;
        this.skipglow = false;
        // if option 0 is hoverd over
        if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                    this.option0Glow = true;
                    return;
                }
        }
        // if option 1 is hoverd over
        if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                if (e.getY() < optionSizeY + option1Y && e.getY() > option1Y) {
                    this.option1Glow = true;
                    return;

                }
        }
        // if option 2 is hoverd over
        if (e.getX() < option1X + optionSizeX && e.getX() > option1X) {
                if (e.getY() < optionSizeY + option1Y + 60 && e.getY() > option1Y + 60) {
                    this.option2Glow = true;
                    return;
                }
        }
        // if option 3 is hoverd over
        if (e.getX() < option1X + optionSizeX + optionSizeX + 10 && e.getX() > option1X + optionSizeX + 10) {
                if (e.getY() < optionSizeY + option1Y + 60 && e.getY() > option1Y + 60) {
                    this.option3Glow = true;
                    return;
                }
        }

        // if skip is hoverd over
        if (e.getX() < lifeLineSizex && e.getX() > 0) {
                if (e.getY() < lifeLineSizey + 360 && e.getY() > 360) {
                    this.skipglow = true;
                    return;
                }
        }
        // if fiftyfifty is hoverd over
        if (e.getX() < lifeLineSizex && e.getX() > 0) {
                if (e.getY() < lifeLineSizey + 300 && e.getY() > 300) {
                    this.fiftyfiftyglow = true;
                }
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
            // Your mouseReleased logic here
    }

    public boolean getskipUsed(){
        return skipUsed;
    }
}
