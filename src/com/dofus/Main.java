

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
	
	private FighterUser user;
	private JPanel panel; // A holding panel
	private JLabel messageLabel; // A message to the user
	private JButton rest;
	private JButton quit;
	private JButton potionScroll;
	private JButton fight;
	private final int WINDOW_WIDTH = 800; // Window width
	private final int WINDOW_HEIGHT = 400; // Window height

	public Main(FighterUser user) {
		
		this.user = user;
		// Set the title.
		setTitle("Dofus");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build the panel and add it to the frame.
		buildPanel();

		// Add the panel to the frame's content pane.
		add(panel);

		// Display the window.
		setVisible(true);
	}

	private void buildPanel() {

		ButtonListener buttonL = new ButtonListener();
		// Create the label, text field, and radio buttons.
		messageLabel = new JLabel("Bienvenue dans (presque) Dofus");
		rest = new JButton("Rest");
		quit = new JButton("Quit");
		potionScroll = new JButton("Use a potion or a scoll");
		fight = new JButton("FIGHTT !!");
		rest.addActionListener(buttonL);
		quit.addActionListener(buttonL);
		potionScroll.addActionListener(buttonL);
		fight.addActionListener(buttonL);
		// Create a panel and add the components to it.
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(rest);
		panel.add(quit);
		panel.add(potionScroll);
		panel.add(fight);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Test on the button to trigger the right function
		    if(e.getSource()== potionScroll){
		      user.utilizeTreasure();
		    }
		    if(e.getSource() == rest){
		      user.rest();
		    }
		    if(e.getSource() == quit){
		      user.quit();
		    }
		    if(e.getSource() == fight){
		      user.fight();
		    }

		}

	}

	public static void main(String[] args) {
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		// For a test
		FighterUser user = new FighterUser(null, null, null, null, 0, null);
		new Main(user);
	}

}
