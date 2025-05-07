/**
 * DrumPanel.java
 * Name: Timothy Jacot 041113276 
 * Course: CST8284 
 * Prof: Leanne Seaward 
 * Date: March 28th 2025 
 * Assignment: Assignment 2 
 * Files list: Drum_Test.java, DrumPanel.java, ToxicDrum.java, FlammableDrum.java, Drum.java
 * Drum Panel class, configuring GUI in this class
 * 
 * @since due March 28th 2025
 * @version java 21.0.4
 * @author Timothy Jacot
 */

package graphicalInterface;

import javax.swing.*;
import java.util.Random;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import domain.Drum;
import domain.FlammableDrum;
import domain.ToxicDrum;

/**
 * This class is the main panel/container object for the application GUI widgets.
 * This is a java Swing application.
 */
public class DrumPanel extends JPanel {

	/** Purpose: Prompts the user to enter the number of drums to create.															*/
	private JLabel drumPrompt;
	/** Purpose: Text field to enter the amount of drums														*/
	private JTextField numberToCreate;
	/** Purpose: Flammable drum radio button																*/
	private JRadioButton flammableDrumType;
	/** Purpose: toxic drum radio button																*/
	private JRadioButton toxicDrumType;
	/** Purpose: Creating Drums based on user input																*/
	private JButton createDrums;
	/** Purpose: Running tests on drums that have been created.																*/
	private JButton runTests;
	/** Purpose: Displays test results															*/
	private JTextArea testResults;
	/** Purpose: status message display											*/
	private JLabel statusField;

	/** List of drums creates.														*/
	List<Drum> listOfDrums = new ArrayList<Drum>();
	
	/** Serial version required. */
	private static final long serialVersionUID = 1L;
	Random random = new Random();
	/**
	 * Create and populate the main drum panel with appropriate GUI widgets.
	 */
	public DrumPanel() {
		initGUI();
	}

	/**
	 * Create and populate the panel with appropriate GUI components.
	 */
	private void initGUI() {
		setToolTipText("When finished with the application click the 'X' on the top bar, right side to close the application");
		setLayout(new FlowLayout());	
		
		JPanel p = new JPanel();

		p.add(createDrumTypePanel());
		p.add(createDrumNumberPanel());
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(p);
		
		box.add(createButtonPanel());

		add(box,TOP_ALIGNMENT);
		add(createResultsPanel(),CENTER_ALIGNMENT);
		statusField = new JLabel("Status field for errors etc.");
		add(statusField,BOTTOM_ALIGNMENT);
	}

	/**
	 * Creating the Results Panel
	 * @return a panel which contains results of input
	 */
	private JPanel createResultsPanel()	{
		JPanel trp = new JPanel();
		testResults = new JTextArea(25, 50);
		testResults.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		testResults.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane sp = new JScrollPane(testResults);
		trp.add(sp);
		return trp;
	}
	
	/**
	 * Create the drum number panel.
	 * @return the panel which has the number input area
	 */
	private JPanel createDrumNumberPanel() {
		drumPrompt = new JLabel("Number of drums to create ");
		drumPrompt.setToolTipText("The number of drums to create");
		numberToCreate = new JTextField(10);
		numberToCreate.setToolTipText("Enter the number of drums to create");
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		numberPanel.add(drumPrompt);
		numberPanel.add(numberToCreate);
		numberPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return numberPanel;
	}

	/**
	 * Create the drum button panel.
	 * 
	 * @return	The panel object containing the buttons.
	 */
	private JPanel createButtonPanel() {
		createDrums = new JButton("Create Drums");
		createDrums.setToolTipText("Click me to create the specified number and type of drums to create");
		createDrums.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{
				String input = numberToCreate.getText();
				if (!input.matches("\\d+")) {
					statusField.setText("Please select a number!");
					return;
				}
				int numberOfDrums = Integer.parseInt(input);
				if (numberOfDrums <= 0) {
					statusField.setText("Please enter a valid number.");
					return;
				}
				for (int i = 0; i < numberOfDrums; i++) {
					if (flammableDrumType.isSelected()) {
						listOfDrums.add(new FlammableDrum(random.nextFloat(10,30), random.nextFloat(5,15)));
					} else if (toxicDrumType.isSelected()) {
						listOfDrums.add(new ToxicDrum(random.nextFloat(10,30), random.nextFloat(5,15)));
					} else {
						statusField.setText("Please select a type of drum.");
						return;
					}
				}				
				/* Get type of drums to create				*/
				if (flammableDrumType.isSelected())	{
					testResults.append("\nCreating " + input + " Flammable Drums");
				}	else if(toxicDrumType.isSelected()) {
					testResults.append("\nCreating " + input + " Toxic Drums");
				}	else	{
					statusField.setText("NO Drum type has been selected");
				}
				statusField.setText(numberOfDrums + " drums created successfully.");
			}});		
		runTests = new JButton("Run Tests");
		runTests.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{
				testResults.setText("");
				
				if (listOfDrums.isEmpty()) {
					statusField.setText("You have not created any drums.");
					return;
				}
				
				
				statusField.setText("Running tests...");
				
				
				for (Drum drum : listOfDrums) {
					testResults.append("\n----------------------------");
					testResults.append("\n" + drum.toString());
					testResults.append("\nCapacity: " + drum.capacity());
				}
				testResults.append("\n\nTests Completed.");
				statusField.setText("Tests have been ran sucessfully.");
			}});

		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(createDrums);
		buttonPanel.add(runTests);
		
		buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Action"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return buttonPanel;
	}

	
	/**
	 * Create the drum creation panel.
	 * 
	 * @return
	 */
	private JPanel createDrumTypePanel() {
		flammableDrumType = new JRadioButton("Flammable Drum");
		toxicDrumType = new JRadioButton("Toxic Drum");
		ButtonGroup group = new ButtonGroup();
		group.add(toxicDrumType);
		group.add(flammableDrumType);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.add(flammableDrumType);
		typePanel.add(toxicDrumType);
		typePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Types of Drums"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		typePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return typePanel;
	}

}
