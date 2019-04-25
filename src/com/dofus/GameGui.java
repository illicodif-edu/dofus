package com.dofus;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameGui extends JFrame {

	private FighterUser user; // The user
	private JLabel messageLabel; // Add a message
	private JLabel userStatus = new JLabel();
	private JLabel monsterStatus = new JLabel("<html>Monster Summary</html>");
	private int state;

	

	// The buttons
	private JButton rest;
	private JButton quit;
	private JButton potionScroll;
	private JButton fight;

	private final int WINDOW_WIDTH = 800; // Window width
	private final int WINDOW_HEIGHT = 800; // Window height


	public GameGui(FighterUser user) {

		this.user = user;
		// Set the title.
		setTitle("Dofus");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		// Set Background Image
		try {
		    final Image backgroundImage = javax.imageio.ImageIO.read(new File("src\\com\\dofus\\dofus.png"));
		    setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, null);
		        }
		    });
		} catch (IOException e) {
		    System.out.println("The background did not load");
		   
		}

		
		setLayout(null);
				
		// Build the panel and add it to the frame.
		buildPanel();

        //add the gui to the user
        user.setGui(this);

		// Display the window.
		setVisible(true);
	}

	private void buildPanel() {


		// Create the button Listener class
		ButtonListener buttonL = new ButtonListener();

		// Create the label, text field, and buttons.
		messageLabel = new JLabel("<html><div>Bienvenue dans (presque) Dofus</div></html>");
		messageLabel.setFont(new Font("Serif", Font.BOLD, 19));
		
		userStatus.setText("<html>User Summary"
					+ "<div>Your HP: "+user.getHitPoints()+"<div><br>"
					+ "<div>Your armor is: "+user.getArmors1().getName()+" ("+user.getArmors1().getProtection()+")<div><br>"
					+ "<div>Your shield (if you have one) is: "+user.getArmors2().getName()+" ("+user.getArmors2().getProtection()+")<div><br>"
					+ "<div>Your weapon is: "+user.getWeapon().getName()+" with: "+user.getWeapon().getAttacksPerTurn()+" attack(s) per turn <br> <div>"
					+ "<div>and: "+user.getWeapon().getMinDamage()+" of minimum damage and: "+user.getWeapon().getMaxDamage()+" of maxmimum damage<div></html>"
				);
		userStatus.setFont(new Font("Serif", Font.BOLD, 19));
		userStatus.setForeground(Color.red);


        monsterStatus.setFont(new Font("Serif", Font.BOLD, 19));
        monsterStatus.setForeground(Color.red);
		
		
		// Create the buttons
		rest = new JButton("Rest");
		quit = new JButton("Quit");
		potionScroll = new JButton("Use a potion/scoll");
		fight = new JButton("FIGHTT !!");
		
		// Change the font of the buttons
		Font buttonFont = new Font("SansSerif", Font.PLAIN, 15);
		rest.setFont(buttonFont);
		quit.setFont(buttonFont);
		potionScroll.setFont(buttonFont);
		fight.setFont(buttonFont);
		
		// Change the color of the buttons
		rest.setBackground(Color.GREEN);
		quit.setBackground(Color.RED);
		potionScroll.setBackground(Color.CYAN);
		fight.setBackground(Color.LIGHT_GRAY);

		// Bind the buttons with the listener class
		rest.addActionListener(buttonL);
		quit.addActionListener(buttonL);
		potionScroll.addActionListener(buttonL);
		fight.addActionListener(buttonL);

		
		messageLabel.setBounds(340, 10, 150, 50);
		userStatus.setBounds(10,0,400,300);
		monsterStatus.setBounds(0,500,400,300);
		quit.setBounds(450, 400, 150, 50);
		potionScroll.setBounds(450, 340, 150, 50);
		rest.setBounds(250, 400, 150, 50);
		fight.setBounds(250, 340, 150, 50);

		// Add the components to the main panel.

		add(quit);
		add(rest);
		add(potionScroll);
		add(fight);
		add(messageLabel);
		add(userStatus);
		add(monsterStatus);

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			

			// Test on the button to trigger the right function
			if (e.getSource() == potionScroll) {
				dispose();
				new PotionScrollGui(user);
			}
			if (e.getSource() == rest) {
				if(user.getStateRest() == false) {

                    System.out.println("I sleep");
                    // 50% chances to regain hp
                    if (Math.random() < 0.5) {
                        user.setHitPoints(user.getHitPoints() + (11 + (int) (Math.random() * ((20 - 11) + 1))));

                    }

                    // 50% to fight
                    else {
                        //this.fight();
                        Thread t = new Thread(user);
                        t.start();
                    }
                    user.setStateRest(true);
                }
				
			}
			if (e.getSource() == quit) {
				user.quit();
			}
			if (e.getSource() == fight) {
				//state = user.fight();
                Thread t = new Thread(user);
                t.start();
			}

		}

	}

    public void setUserStatusText(String text) {
        userStatus.setText(text);
    }

    public void setMonsterStatus(String text) {
        monsterStatus.setText(text);
    }


    public void setState(int state) {
        this.state = state;
    }
}
