/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;

public abstract class Question {
    protected double ca;

    public Question(double ca) {
        this.ca = ca;
    }

    public abstract boolean checkAns(double answer);

    public abstract String getOption(int i);

    public abstract String getQuestionText();

    public double getCorrectAnswer() {
        return ca;
    }
}
