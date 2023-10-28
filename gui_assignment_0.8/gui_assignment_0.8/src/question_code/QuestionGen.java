/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionGen {

    private static final String DB_URL = "jdbc:derby://localhost:1527/Question";
    

    public static ArrayList<Question> Genquestion() {
        ArrayList<Question> qlist = new ArrayList<>();
       
        
        
        
        int I = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL)){
            String query = "SELECT QUESTIONTEXT,OPTIONA, OPTIONB, OPTIONC, OPTIOND,CORRECTANSWER FROM QUESTIONS";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    
                    System.out.println("it: "+I);
                    String questionText = resultSet.getString("QUESTIONTEXT");
                    
                    String ans1 = resultSet.getString("OPTIONA");
                    String ans2 = resultSet.getString("OPTIONB");
                    String ans3 = resultSet.getString("OPTIONC");
                    String ans4 = resultSet.getString("OPTIOND");
                      int correctAnswer = resultSet.getInt("CORRECTANSWER");
                  
                    I++;

                    qlist.add(new triviaquestion(ans1, ans2, ans3, ans4, questionText, correctAnswer-1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qlist;

       


//    public static void main(String[] args) {
//        ArrayList<Question> questions = Genquestion();
//        int batchSize = 4;
//        Scanner scanner = new Scanner(System.in);
//        int score = 0; // Track player's score
//        boolean gameRunning = true; // Flag to control the game loop
//
//        for (int i = 0; i < questions.size() && gameRunning; i += batchSize) {
//            int end = Math.min(i + batchSize, questions.size());
//            ArrayList<Question> batch = new ArrayList<>(questions.subList(i, end));
//
//            for (Question question : batch) {
//                System.out.println(question.getQuestionText());
//                for (int j = 0; j < 4; j++) {
//                    System.out.println((j + 1) + ") " + question.getOption(j));
//                }
//                System.out.print("Enter your answer (1-4): ");
//                int userAnswer = scanner.nextInt();
//
//                if (question.checkAns(userAnswer)) {
//                    System.out.println("Correct!\n");
//                    score++; // Increment the player's score for correct answers
//                } else {
//                    System.out.println("Incorrect. The correct answer is: " + question.getOption(0) + "\n");
//                    gameRunning = false; // Stop the game on an incorrect answer
//                    break;
//                }
//            }
//
//            // Prompt for input to continue
//            if (gameRunning && end < questions.size()) {
//                System.out.print("Press Enter to continue...");
//                scanner.nextLine(); // Consume the newline character
//                scanner.nextLine(); // Wait for user input (Enter key)
//            }
//        }
//
//        // Display the player's final score
//        System.out.println("Your final score: " + score);
//
//        scanner.close();
//    }
//}
    }
}