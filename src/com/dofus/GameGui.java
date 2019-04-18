
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

		// Display the window.
		setVisible(true);
	}

	private void buildPanel() {
		// Create the button Listener class
		ButtonListener buttonL = new ButtonListener();

		// Create the label, text field, and radio buttons.
		messageLabel = new JLabel("<html><div>Bienvenue dans (presque) Dofus</div></html>");
		messageLabel.setFont(new Font("Serif", Font.BOLD, 19));
		
		
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
		quit.setBounds(450, 200, 150, 50);
		potionScroll.setBounds(450, 140, 150, 50);
		rest.setBounds(250, 200, 150, 50);
		fight.setBounds(250, 140, 150, 50);

		// Add the components to the main panel.

		add(quit);
		add(rest);
		add(potionScroll);
		add(fight);
		add(messageLabel);

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Test on the button to trigger the right function
			if (e.getSource() == potionScroll) {
				dispose();
				new PotionScrollGUI(user);
			}
			if (e.getSource() == rest) {
				user.rest();
			}
			if (e.getSource() == quit) {
				user.quit();
			}
			if (e.getSource() == fight) {
				user.fight();
			}

		}

	}


}
