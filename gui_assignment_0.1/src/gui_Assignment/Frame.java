package gui_Assignment;

import static gui_Assignment.Game.framehight;
import static gui_Assignment.Game.framewidth;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Frame {

	JFrame jframe;

	public Frame(Panel p) {
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
