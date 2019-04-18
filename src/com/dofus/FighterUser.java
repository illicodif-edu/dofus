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
	public void utilizePotion()
	{
		double RandomNumberGenerator= (Math.random()*((1-0)+1));
		
		//30% chance to regain 5-10 hp
		if (RandomNumberGenerator < 0.3) 
		{
			this.setHitPoints(this.getHitPoints() + (5 + (int) (Math.random() * ((10 - 5) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints);
		}
		
		//40% chance to regain 11-20 hp
		else if ((RandomNumberGenerator > 0.3)||(RandomNumberGenerator < 0.7))
		{
			this.setHitPoints(this.getHitPoints() + (11 + (int) (Math.random() * ((20 - 11) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints);
		}
		
		//20% chance to regain 21-30 hp
		else if ((RandomNumberGenerator > 0.7)||(RandomNumberGenerator < 0.9))
		{
			this.setHitPoints(this.getHitPoints() + (21 + (int) (Math.random() * ((30 - 21) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints);
		}
		
		//10% chance to lose 1-20 hp 
		else (RandomNumberGenerator > 0.9)
		{
			this.setHitPoints(this.getHitPoints() - (1 + (int) (Math.random() * ((20 - 1) + 1))));
			//test Dead of the User
			this.testDead();
			//if the User is stil alive
			System.out.println("You lose HP! Now, you have" + this.getPoints);
		}
	}
	
	public void testDead(){
		if (this.getHitPoints()<0)
		{
			System.out.println("You lose HP! Actually, you are dead... Play again");
			this.quit();
		}
	}
	
	//To use treasure=scroll
	public void utilizeScroll()
	{
		
		
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
  
