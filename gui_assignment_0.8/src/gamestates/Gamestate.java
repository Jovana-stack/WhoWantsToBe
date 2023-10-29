/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamestates;

/**
 *
 * @author jovan
 */
public enum Gamestate {
    // this enum handles witch game state we are in 
    playing, gameover,gamewin,menu,fiftyfifty,continueoption,inputname;
	
	public static Gamestate state = menu; // this is the default game state 
    
}
