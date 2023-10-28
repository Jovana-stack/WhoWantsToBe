/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;

public class mathquestion extends Question {
    private double x;
    private double y;
    private String op;

    public mathquestion(double x, double y, String op, double ca) {
        super(ca);
        this.x = x;
        this.y = y;
        this.op = op;
    }

    @Override
    public boolean checkAns(double answer) {
        return answer == getCorrectAnswer();
    }

    @Override
    public String getOption(int i) {
        // Since math questions don't have multiple options, you can return an empty string or null.
        return null;
    }

    @Override
    public String getQuestionText() {
        return "What is " + x + " " + op + " " + y + "?";
    }
}
