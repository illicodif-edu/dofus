package com.dofus;

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
		System.out.println("I use the potion");
	}

	//To use treasure=potion
	public void utilizePotion(){
		//30% chance to regain 5-10 hp
		//40% chance to regain 11-20 hp
		//20% chance to regain 21-30 hp
		//10% chance to lose 1-20 hp 
			//test "kill the user" ?
	}
	
	//To use treasure=scroll
	public void utilizeScroll(){
	}
	// To quit
	public void quit() {
		System.out.println("I left the game");
		System.exit(0);
	}

	// To fight
	public void fight() {
		System.out.println("I fight");
	}

	// To rest
	public void rest() {
		System.out.println("I sleep");
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
  
