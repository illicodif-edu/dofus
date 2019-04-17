import java.util.ArrayList;

public class FighterUser extends Fighter {

	// ArrayList of fighters
	private ArrayList<Fighter> fighters;

	public FighterUser(Weapon weapon, Armor armor, Armor armor2, ArrayList<Treasure> treasures, int hitPoints, ArrayList<Fighter> fighters) {
		super(weapon, armor, null, treasures, hitPoints);
		this.fighters = fighters;
	}

	// To use one of the treasure
	public void utilizeTreasure() {
		System.out.println("J'utilise une potion");
	}

	// To quit
	public void quit() {
		System.out.println("Je quitte la partie");
		System.exit(0);
	}

	// To fight
	public void fight() {
		System.out.println("I fight");
	}

	// To rest
	public void rest() {
		System.out.println("Je dors");
		// 50% chances to regain hp
		if (Math.random() < 0.5) {
			this.setHitPoints(this.getHitPoints() + (11 + (int) (Math.random() * ((20 - 11) + 1))));
		}

		// 50% to lose HP
		else {
			this.fight();
		}
	}
}
  
