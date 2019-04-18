import java.util.ArrayList;

public class Main{
	public static void main(String args[]) {
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		// For a test
		FighterUser user = new FighterUser(null, null, null, null, 0, null);
		new GameGui(user);
		
	}
}
