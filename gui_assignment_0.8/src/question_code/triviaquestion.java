/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;

public class triviaquestion extends Question {
    private String[] options;
    private String questionText;

    public triviaquestion(String ans1, String ans2, String ans3, String ans4, String questionText, int correctAnswer) {
        super(correctAnswer);
        options = new String[]{ans1, ans2, ans3, ans4};
        this.questionText = questionText;
    }

    @Override
    public boolean checkAns(double answer) {
        return ((int) answer) == (int) getCorrectAnswer();
    }

    @Override
    public String getOption(int i) {
        if (i >= 0 && i < options.length) {
            return options[i];
        }
        return null;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }
}
