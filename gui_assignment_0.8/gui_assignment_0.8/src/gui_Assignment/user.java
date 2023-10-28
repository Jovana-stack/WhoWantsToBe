package gui_Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class user {
    private String name;
    private int money;

    public user(String name) {
        this.name = name;
        this.money = 0;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void insertUser(String name, double money) {
        
        String dbUrl = "jdbc:derby://localhost:1527/Question"; // Replace with your database URL


        String insertQuery = "INSERT INTO USERS (name, money) VALUES (?, ?)";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(dbUrl);

            // Create a PreparedStatement to safely execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);    
            preparedStatement.setDouble(2, money);  

           
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User data inserted successfully.");
            } else {
                System.err.println("Failed to insert user data.");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
