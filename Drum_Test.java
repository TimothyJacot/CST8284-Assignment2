/**
 * Drum_Test.java
 * Name: Timothy Jacot 041113276 
 * Course: CST8284 
 * Prof: Leanne Seaward 
 * Date: March 28th 2025 
 * Assignment: Assignment 2 
 * Files list: Drum_Test.java, DrumPanel.java, ToxicDrum.java, FlammableDrum.java, Drum.java
 * Starter code for Drum test class, no modifications needed
 * 
 * @since due March 28th 2025
 * @version java 21.0.4
 * @author Timothy Jacot
 */
package test;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import java.awt.Container;
import java.awt.Dimension;

import graphicalInterface.DrumPanel;

/**
 * Test various types of drums and our Graphical Framework.
 */
public class Drum_Test {

	/**
	 * Main entry point/launcher for this GUI Application test.
	 * @param args	Command line argument list (not used)
	 */
	public static void main(String[] args) {
		initLookAndFeel();

		/*	Schedule a job for the event dispatch thread:
		 * creating and showing this application's GUI.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(new DrumPanel());
			}
		});

    }
	
	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI(JPanel mainPanel) {
		/* Create and set up the window. */
		JFrame frame = new JFrame("Drum Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 350);
		frame.setPreferredSize(new Dimension(575, 600));
		frame.setMaximumSize(new Dimension(575, 600));
		Container c = frame.getContentPane();
		c.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	
	/**
	 * Set the look and feel for this GUI app.
	 */
	private static void initLookAndFeel() {
		try {
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			UIManager.setLookAndFeel(new MetalLookAndFeel());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		
		/* Turn off metal's use bold fonts */
//		UIManager.put("swing.boldMetal", Boolean.FALSE);

	
	}

}
