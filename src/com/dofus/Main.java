
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame {
	

	private FighterUser user; // The user
	private JLabel messageLabel; // A message to the user
	
	//The buttons
	private JButton rest;
	private JButton quit;
	private JButton potionScroll;
	private JButton fight;
	
	private final int WINDOW_WIDTH = 800; // Window width
	private final int WINDOW_HEIGHT = 400; // Window height
	
	// Constructor
	public Main(FighterUser user) {
		
		this.user = user;
		// Set the title.
		setTitle("Dofus");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(6, 1));
		
		// Build the panel and add it to the frame.
		buildPanel();
		

		// Display the window.
		setVisible(true);
	}

	private void buildPanel() {
		// Create the button Listener class
		ButtonListener buttonL = new ButtonListener();
		
		// Create the label, text field, and radio buttons.
		messageLabel = new JLabel("Bienvenue dans (presque) Dofus");
		
		// Create the buttons
		rest = new JButton("Rest");
		quit = new JButton("Quit");
		potionScroll = new JButton("Use a potion or a scoll");
		fight = new JButton("FIGHTT !!");
		
		// Bind the buttons with the listener class
		rest.addActionListener(buttonL);
		quit.addActionListener(buttonL);
		potionScroll.addActionListener(buttonL);
		fight.addActionListener(buttonL);
		
		// Add the components to it.
		add(messageLabel);
		add(rest);
		add(quit);
		add(potionScroll);
		add(fight);
		
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
