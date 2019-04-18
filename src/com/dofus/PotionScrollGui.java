package com.dofus;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PotionScrollGui extends JFrame {

	private FighterUser user; // The user
	private JLabel messageLabel; // A message to the user

	// The buttons
	private JButton potion;
	private JButton scroll;
	private JButton back;
	
	private final int WINDOW_WIDTH = 800; // Window width
	private final int WINDOW_HEIGHT = 800; // Window height

	// Constructor
	public PotionScrollGui(FighterUser user) {

		this.user = user;
		// Set the title.
		setTitle("CHOOSE YOUR BONUS");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set Background Image
				try {
				    final Image backgroundImage = javax.imageio.ImageIO.read(new File("src\\com\\dofus\\potion.png"));
				    setContentPane(new JPanel(new BorderLayout()) {
				        @Override public void paintComponent(Graphics g) {
				            g.drawImage(backgroundImage, 0, 0, null);
				        }
				    });
				} catch (IOException e) {
				    System.out.println("The background did not load");
				   
				}
				
		// Add a GridLayout manager to the content pane.
		setLayout(null);
		
		// Build the panel and add it to the frame.
		buildPanel();

		// Display the window.
		setVisible(true);
	}

	private void buildPanel() {
		// Create the button Listener class
		ButtonListener buttonL = new ButtonListener();

		// Create the label, text field, and radio buttons.
		messageLabel = new JLabel("Choose your bonus");
		// Create the buttons
		potion = new JButton("Potion");
		scroll = new JButton("Scroll");
		back = new JButton("Go back to main");
		

		// Bind the buttons with the listener class
		potion.addActionListener(buttonL);
		scroll.addActionListener(buttonL);
		back.addActionListener(buttonL);
		
		// Change the font of the buttons
		Font buttonFont = new Font("SansSerif", Font.PLAIN, 15);
		potion.setFont(buttonFont);
		scroll.setFont(buttonFont);
		back.setFont(buttonFont);
		messageLabel.setFont(new Font("Serif", Font.BOLD, 25));
		
		// Change the color of the buttons
		potion.setBackground(Color.GREEN);
		back.setBackground(Color.RED);
		scroll.setBackground(Color.CYAN);
		messageLabel.setForeground(Color.blue);
		
		
		// Absolute positioning
		messageLabel.setBounds(340, 10, 200, 100);		
		scroll.setBounds(450, 140, 150, 50);
		back.setBounds(350, 200, 150, 50);
		potion.setBounds(250, 140, 150, 50);
		
		

		// Add the components to the main panel.
		
		add(potion);		
		add(scroll);
		add(back);
		add(messageLabel);
		
		

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Test on the button to trigger the right function
			if (e.getSource() == potion) {
				user.utilizePotion();
			}
			if (e.getSource() == scroll) {
				user.utilizeScroll();
			}
			if (e.getSource() == back) {
				dispose();
				new GameGui(user);
			}		

		}

	}



}
