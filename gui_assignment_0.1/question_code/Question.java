/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;

/**
 *
 * @author jovan
 */
public abstract class Question {
   
    public double ca;
    
    public Question( double ca){
        
        this.ca = ca;
        
        }
    public boolean checkAns(double answer){
        if (this.ca ==answer){
            
            return true;
        }
            
       return false;
    }
    
    public abstract String getoption(int i);
    public abstract String getquestion();
}
