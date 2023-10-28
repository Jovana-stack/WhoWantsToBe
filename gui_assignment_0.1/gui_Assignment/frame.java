package gui_Assignment;

import static gui_Assignment.game.framehight;
import static gui_Assignment.game.framewidth;

import java.awt.*;


import java.awt.event.*;
import javax.swing.*;



public class frame{
	
	JFrame jframe;
	public frame(panel p) {
        jframe = new JFrame();
        jframe.setResizable(false);
        jframe.setTitle("Who Wants to Be a Millionaire");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(p); // Add the panel to the JFrame

        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
	}

	
	
	
	
	
	
	
	

