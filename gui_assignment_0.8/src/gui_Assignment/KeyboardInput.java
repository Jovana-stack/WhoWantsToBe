/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_Assignment;

/**
 *
 * @author nicet
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import gamestates.Gamestate;


public class KeyboardInput  implements KeyListener {
    
    
    private Panel panel;
    
    
    public KeyboardInput(Panel panel) {
        this.panel = panel;
    }

   

    @Override
    public void keyTyped(KeyEvent e) {
        // Invoked when a key is typed (pressed and released).
        
        
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Gamestate.state == Gamestate.inputname){
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                this.panel.getGame().getinputname().backspace();
                return;
            }
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.panel.getGame().getinputname().savename();
                return;
            }

            char keyChar = e.getKeyChar();
            System.out.println(keyChar);
            this.panel.getGame().getinputname().updatename(keyChar);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
