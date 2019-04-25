package com.dofus;


import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	private JLabel monsterStatus = new JLabel();
	private JLabel alertBox = new JLabel();
	private JLabel myDamage = new JLabel();
	private JLabel monsterDamage= new JLabel();
	private JLabel userFace = new JLabel();

	

	// The buttons
	private JButton rest;
	private JButton quit;
	private JButton potionScroll;
	private JButton fight;

	private final int WINDOW_WIDTH = 1000; // Window width
	private final int WINDOW_HEIGHT = 900; // Window height


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
		messageLabel = new JLabel("<html><div style='text-align: right;'>Dofus</div></html>");
		messageLabel.setFont(new Font("Georgia", Font.BOLD, 19));
		
		userStatus.setText("<html>User Summary"
					+ "<div>Your HP: "+user.getHitPoints()+"<div><br>"
					+ "<div>Your armor is: "+user.getArmors1().getName()+" ("+user.getArmors1().getProtection()+")<div><br>"
					+ "<div>Your shield (if you have one) is: "+user.getArmors2().getName()+" ("+user.getArmors2().getProtection()+")<div><br>"
					+ "<div>Your weapon is: "+user.getWeapon().getName()+" with: "+user.getWeapon().getAttacksPerTurn()+" attack(s) per turn <br> <div>"
					+ "<div>and: "+user.getWeapon().getMinDamage()+" of minimum damage and: "+user.getWeapon().getMaxDamage()+" of maxmimum damage<div><br>"
                    + "<div>Your have: "+user.getTreasures().getNbPotions()+" potions, "+user.getTreasures().getScroll()+" scroll, "+user.getTreasures().getGold()+" gold, "+user.getTreasures().getSilver()+" silver."+"<div></html>"
        );
		userStatus.setFont(new Font("Georgia", Font.BOLD, 19));
		userStatus.setForeground(Color.red);


        monsterStatus.setFont(new Font("Georgia", Font.BOLD, 19));
        monsterStatus.setForeground(Color.red);


		alertBox.setFont(new Font("Georgia", Font.BOLD, 19));
		alertBox.setForeground(Color.white);

        monsterDamage.setText("<html><div>The monster will fight with 0 damages per turn.</div></html>");
		monsterDamage.setFont(new Font("Georgia", Font.BOLD, 19));
		monsterDamage.setForeground(Color.white);
		monsterDamage.setHorizontalAlignment(SwingConstants.RIGHT);

		myDamage.setText("<html><div>You will fight with 0 damages per turn</div></html>");
		myDamage.setFont(new Font("Georgia", Font.BOLD, 19));
		myDamage.setForeground(Color.white);
		
		
		// Create the buttons
		rest = new JButton("Rest");
		quit = new JButton("Quit");
		potionScroll = new JButton("Use a potion/scoll");
		fight = new JButton("FIGHTT !!");
		
		// Change the font of the buttons
		Font buttonFont = new Font("Georgia", Font.PLAIN, 15);
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

		
		messageLabel.setBounds(440, 20, 150, 50);
		userStatus.setBounds(10,0,440,400);
		monsterStatus.setBounds(520,0,460,400);
		quit.setBounds(550, 500, 150, 50);
		potionScroll.setBounds(550, 440, 150, 50);
		rest.setBounds(350, 500, 150, 50);
		fight.setBounds(350, 440, 150, 50);
        myDamage.setBounds(10, 720, 490, 70);
        alertBox.setBounds(50, 560, 900, 50);
        monsterDamage.setBounds(500, 720, 490, 70);
        userFace.setBounds(10, 450, 230, 300);
        ImageIcon iconFace = new ImageIcon("src\\com\\dofus\\art_cra.png");
        userFace.setIcon(iconFace);


		// Add the components to the main panel.

		add(quit);
		add(rest);
		add(potionScroll);
		add(fight);
		add(messageLabel);
		add(userStatus);
		add(monsterStatus);
		add(myDamage);
		add(alertBox);
		add(monsterDamage);
		add(userFace);

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			

			// Test on the button to trigger the right function
			if (e.getSource() == potionScroll) {
                if(user.isShop()) {
                    dispose();
                    new PotionScrollGui(user);
                }
			}
			if (e.getSource() == rest) {
				if(user.getStateRest() == false) {

                    alertBox.setText("I sleep");
                    // 50% chances to regain hp
                    if (Math.random() < 0.5) {
                        playSound("src\\com\\dofus\\baillement.wav");
                        int point = (11 + (int) (Math.random() * ((20 - 11) + 1)));
                        user.setHitPoints(user.getHitPoints() + point);
                        alertBox.setText("I sleep, I regain "+point+" HP");
                        alertBox.setHorizontalAlignment(SwingConstants.CENTER);
                        userStatus.setText("<html>User Summary"
                                + "<div>Your HP: "+user.getHitPoints()+"<div><br>"
                                + "<div>Your armor is: "+user.getArmors1().getName()+" ("+user.getArmors1().getProtection()+")<div><br>"
                                + "<div>Your shield (if you have one) is: "+user.getArmors2().getName()+" ("+user.getArmors2().getProtection()+")<div><br>"
                                + "<div>Your weapon is: "+user.getWeapon().getName()+" with: "+user.getWeapon().getAttacksPerTurn()+" attack(s) per turn <br> <div>"
                                + "<div>and: "+user.getWeapon().getMinDamage()+" of minimum damage and: "+user.getWeapon().getMaxDamage()+" of maxmimum damage<div><br>"
                                + "<div>Your have: "+user.getTreasures().getNbPotions()+" potions, "+user.getTreasures().getScroll()+" scroll, "+user.getTreasures().getGold()+" gold, "+user.getTreasures().getSilver()+" silver."+"<div></html>"
                        );
                    }

                    // 50% to fight
                    else {
                        playSound("src\\com\\dofus\\bruitepee.wav");
                        Thread t = new Thread(user);
                        user.setStateRest(true);
                        user.setShop(false);
                        t.start();

                    }
                    user.setStateRest(true);
                }
				
			}
			if (e.getSource() == quit) {
				user.quit();
			}
			if (e.getSource() == fight) {
				playSound("src\\com\\dofus\\bruitepee.wav");
                Thread t = new Thread(user);
                user.setShop(false);
                user.setStateRest(true);
                t.start();
			}

		}

	}

    public void setUserStatusText(String text) {
        userStatus.setText(text);
    }

    public void setMonsterStatus(String text) {
        monsterStatus.setText(text);
        monsterStatus.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    public void setMyDamage(String text){
	    myDamage.setText(text);
        myDamage.setVerticalAlignment(SwingConstants.CENTER);

    }

    public void setMonsterDamage(String text){
        monsterDamage.setText(text);
        monsterDamage.setHorizontalAlignment(SwingConstants.CENTER);
        monsterDamage.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setAlertBox(String text) {
        alertBox.setText(text);
        alertBox.setHorizontalAlignment(SwingConstants.CENTER);
    }



    
    static public void playSound(String relativePath) {
    	String soundName = relativePath;    
    	AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
	    	clip.open(audioInputStream);
	    	clip.start();
		} catch (Exception e) {
			System.out.println("Sound did not load");
		}
    	
    }
}
