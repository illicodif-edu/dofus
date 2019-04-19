package com.dofus;

import java.util.ArrayList;


public class FighterUser extends Fighter {

	// ArrayList of fighters
	private ArrayList<Fighter> fighters;

	public FighterUser(Weapon weapon, Armor armor, Armor armor2, ArrayList<Treasure> treasures, int hitPoints, ArrayList<Fighter> fighters) {
		super(weapon, armor, armor2, treasures, hitPoints);
		this.fighters = fighters;
	}
	
	//To use treasure=potion
	public void utilizePotion()
	{
		double RandomNumberGenerator= (Math.random()*((1-0)+1));
		
		//30% chance to regain 5-10 hp
		if (RandomNumberGenerator < 0.3) 
		{
			this.setHitPoints(this.getHitPoints() + (5 + (int) (Math.random() * ((10 - 5) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints());
		}
		
		//40% chance to regain 11-20 hp
		else if ((RandomNumberGenerator > 0.3)||(RandomNumberGenerator < 0.7))
		{
			this.setHitPoints(this.getHitPoints() + (11 + (int) (Math.random() * ((20 - 11) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints());
		}
		
		//20% chance to regain 21-30 hp
		else if ((RandomNumberGenerator > 0.7)||(RandomNumberGenerator < 0.9))
		{
			this.setHitPoints(this.getHitPoints() + (21 + (int) (Math.random() * ((30 - 21) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getPoints());
		}
		
		//10% chance to lose 1-20 hp 
		else (RandomNumberGenerator > 0.9)
		{
			this.setHitPoints(this.getHitPoints() - (1 + (int) (Math.random() * ((20 - 1) + 1))));
			//test Dead of the User
			this.testDead();
			//if the User is stil alive
			System.out.println("You lose HP! Now, you have" + this.getPoints());
		}
		treasures.setNbPotions(getNbPotions-1);
	}
	
	public void testDead(){
		if (this.getHitPoints()<1)
		{
			System.out.println("You lose HP! Actually, you are dead... Play again");
			this.quit();
		}
	}
	
	//To use treasure=scroll
	public void utilizeScroll()
	{
		int RandomNumberGenerator= (1 + (int) (Math.random()*((3-1)+1)));
		
		//Scroll - Double hit points
		if (RandomNumberGenerator==1)
		{
			System.out.println("Double hit points");
			this.setHitPoints(this.getHitPoints + this.getHitPoints()*2);
			System.out.println("You gain HP! Now, you have" +this.getPoints());
		}
		
		//Scroll - Nothing
		if (RandomNumberGenerator==2)
		{
			System.out.println("Nothing happens...");
		}
		
		//Scroll - Kill the user
		if (RandomNumberGenerator==3)
		{
			System.out.println("Actually, you are dead... Play again");
			this.quit();
		}
		treasures.setScroll(getScroll-1);
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
	
	//isBetterMethods for Weapon after fight
	public void isBetterWeapon(Weapon WeaponOfMonster, Weapon WeaponOfUser) {
		
		// to get the average of damage of weapons 
		averageWeaponOfMonster=WeaponOfMonster.getAttacksPerTurn()*(WeaponOfMonster.getMaxDamage()+WeaponOfMonster.getMinDamage())/2;
		averageWeaponOfUser=WeaponOfUser.getAttacksPerTurn()*(WeaponOfUser.getMaxDamage()+WeaponOfUser.getMinDamage())/2;
		
		//test of weapon : comparaison of averageWeapon and test of the type of weapon (is Recuperable by the user or not)
		if ((averageWeaponOfMonster>averageWeaponOfUser)&&(WeaponOfMonster.isRecuperable()))
		{
			//it is time to change the Weapon of the User by the Weapon of the Monster
			WeaponOfUser.seName(WeaponOfMonster.getName());
			WeaponOfUser.setAttacksPerTurn(WeaponOfMonster.getAttacksPerTurn());
			WeaponOfUser.setMaxDamage(WeaponOfMonster.getMaxDamage());
			WeaponOfUser.setMinDamage(WeaponOfMonster.getMinDamage());
			System.out.println("I change my Weapon. I am stronger now !");
		}
	}
	
	//is BetterMethods for Armor after fight 
	public void isBetterArmor(Armor ArmorOfMonster1, Armor ArmorOfMonster2, Armor ArmorOfUser1, Armor ArmorOfUser2 ) {
		// Armor Of Monster 1 and Armor Of User 1 must be type1 (where type is an Attribut from Armor Class)
		// Armor Of Monster 2 and Armor Of User 2 must be type2 (where type is an Attribut from Armor Class)
		
	//test Armor Type 1 : if protection is better + is Recuperable (TRUE)	
		if ((ArmorOfMonster1.getProtection()>ArmorOfUser1.getProtection())&&(ArmorOfMonster1.getIsRecuperable()))
		{
			ArmorOfUser1.setName(ArmorOfMonster1.getName());
			ArmorOfUser1.setProtection(ArmorOfMonster1.getProtection());
			System.out.println("I change my Armor. I am safe now, I hope... !");
		}
	//test Armor Type 2 : if protection is better + is Recuperable (TRUE)	
		if ((ArmorOfMonster2.getProtection()>ArmorOfUser2.getProtection())&&(ArmorOfMonster2.getIsRecuperable()))
		{
			ArmorOfUser2.setName(ArmorOfMonster2.getName());
			ArmorOfUser2.setProtection(ArmorOfMonster2.getProtection());
			System.out.println("I change my Armor. I am safe now, I hope... !");
		}
	}
	
	// to get the total of the protection of armor
	public int getTotalArmor(Armor armorOfFighter1, Armor armorOfFighter2)
		// armor of fighter 1 must be type1 (where type is an Attribut from Armor Class), armor of fighter 2 must be type2
	{
		return armorOfFighter1.getProtection()+armorOfFighter2.getProtection();
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
  
