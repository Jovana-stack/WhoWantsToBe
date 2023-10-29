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

    public void insertUser() {
        
        
        // the database connection parameters
        String dbUrl = "jdbc:derby://localhost:1527/Question"; 

        //  SQL query to insert data into the User table
        String insertQuery = "INSERT INTO USERS (name, money) VALUES (?, ?)";

        try {
            // database connection
            Connection connection = DriverManager.getConnection(dbUrl);

            // PreparedStatement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, this.name);    
            preparedStatement.setDouble(2, this.money);  

            // the SQL query to insert the data
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