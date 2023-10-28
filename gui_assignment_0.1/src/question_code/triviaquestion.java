/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question_code;



/**
 *
 * @author nicet
 */
public class triviaquestion extends Question{
    public String[] a;
    public String Quest;
    
    public triviaquestion(String ans1,String ans2, String ans3, String ans4, String Quest, int ca){
        super(ca);
        
        this.a = new String[4];
        this.a[0]=ans1;
        this.a[1]=ans2;
        this.a[2]=ans3;
        this.a[3]=ans4;
        this.Quest = Quest;
        }
    
    
    public String getoption(int i) {
    	
    	return a[i];
    }
      
    public String toString(){
    return this.Quest+"\n"+"1)"+this.a[0]+"\n"+"2)"+this.a[1]+"\n"+"3)"+this.a[2]+"\n"+"4)"+this.a[3];
    }


	@Override
	public String getquestion() {
		return this.Quest;
	}
}
