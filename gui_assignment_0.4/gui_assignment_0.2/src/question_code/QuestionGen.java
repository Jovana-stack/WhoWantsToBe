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
import java.util.Scanner;

public class QuestionGen {

    private static final String DB_URL = "jdbc:derby://localhost:1527/Questions";
    private static final String DB_USER = "pdc";
    private static final String DB_PASSWORD = "pdc";

    public static ArrayList<Question> Genquestion() {
        ArrayList<Question> qlist = new ArrayList<>();

        
        
        int I = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT QUESTIONTEXT, OPTIONA, OPTIONB, OPTIONC, OPTIOND, CORRECTANSWER FROM QUESTION";
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
    
    }
}