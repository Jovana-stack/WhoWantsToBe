package gui_Assignment;

import java.io.FileWriter;
import java.io.IOException;

public class user {

    private String name;
    private double money;
    private int userNumber;

    public user() {
        this.money = 0.0;
         this.userNumber = 1; // Initialize user number to 1
        generateName();
        
    }

    private void generateName() {
        this.name = "user" + userNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void saveUserDataToFile() {
        try {
            FileWriter writer = new FileWriter("user_data.txt", true); 
           
            writer.write(name + " " + money + System.lineSeparator());

            writer.close();

            System.out.println("User data saved to user_data.txt");
        } catch (IOException e) {
            System.err.println("Error saving user data to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Creating a user
        user myUser = new user();
        myUser.setName("user1");
        myUser.setMoney(100);    

       
        myUser.saveUserDataToFile();

      
    }
}
