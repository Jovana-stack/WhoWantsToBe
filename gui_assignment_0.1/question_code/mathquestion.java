/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;



/**
 *
 * @author jovana
 */
public class mathquestion extends Question{
    double x;
    double y;
    String op;
  
    public mathquestion (double x, double y,String op,double ca){
        super(ca);
        this.x = x;
        this.y = y;
       
        this.op = op;
    }
   
    @Override 
    public String toString (){
        return this.x + this.op + this.y ;
    }

	@Override
	public String getoption(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getquestion() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
    
    
}
