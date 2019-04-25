package com.dofus;

import java.util.ArrayList;

import javax.swing.JFrame;


public class FighterUser extends Fighter implements Runnable{

	// ArrayList of fighters
	private ArrayList<Fighter> fighters;
	private GameGui gui;

	private boolean stateRest = false;
	public FighterUser(Weapon weapon, Armor armor, Armor armor2, Treasure treasure, int hitPoints, ArrayList<Fighter> fighters) {
		super("MOI",weapon, armor, armor2, treasure, hitPoints);
		this.fighters = fighters;
	}
	
	public boolean getStateRest() {
		return stateRest;
	}
	public void setStateRest(boolean state){this.stateRest = state;}
	
	//To use treasure=potion
	public void utilizePotion()
	{
		if(this.getTreasures().getNbPotions() >= 1) {
		double RandomNumberGenerator= (Math.random()*((1-0)+1));
		
		//30% chance to regain 5-10 hp
		if (RandomNumberGenerator < 0.3) 
		{
			this.setHitPoints(this.getHitPoints() + (5 + (int) (Math.random() * ((10 - 5) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getHitPoints());
		}
		
		//40% chance to regain 11-20 hp
		else if ((RandomNumberGenerator > 0.3)||(RandomNumberGenerator < 0.7))
		{
			this.setHitPoints(this.getHitPoints() + (11 + (int) (Math.random() * ((20 - 11) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getHitPoints());
		}
		
		//20% chance to regain 21-30 hp
		else if ((RandomNumberGenerator > 0.7)||(RandomNumberGenerator < 0.9))
		{
			this.setHitPoints(this.getHitPoints() + (21 + (int) (Math.random() * ((30 - 21) + 1))));
			System.out.println("You regain HP! Now, you have" + this.getHitPoints());
		}
		
		//10% chance to lose 1-20 hp 
		else
		{
			this.setHitPoints(this.getHitPoints() - (1 + (int) (Math.random() * ((20 - 1) + 1))));
			//test Dead of the User
			this.testDeadUser();
			//if the User is still alive
			System.out.println("You lose HP! Now, you have" + this.getHitPoints());
		}
		
		this.getTreasures().setNbPotions(this.getTreasures().getNbPotions()-1);
		}
		else {
			System.out.println("I don't have any potion");
		}
	}
		
		
	//To use treasure=scroll
	public void utilizeScroll()
	{
		if(this.getTreasures().getScroll() >= 1) {
		int RandomNumberGenerator= (1 + (int) (Math.random()*((3-1)+1)));
		
		//Scroll - Double hit points
		if (RandomNumberGenerator==1)
		{
			System.out.println("Double hit points");
			this.setHitPoints(this.getHitPoints() + this.getHitPoints()*2);
			System.out.println("You gain HP! Now, you have" +this.getHitPoints());
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
		this.getTreasures().setScroll(this.getTreasures().getScroll()-1);
		}
		else {
			System.out.println("I don't have any scroll");
		}
	}
	// To quit
	public void quit() {
		System.out.println("I left the game");
		System.exit(0);
	}
	
	public void testDeadUser(){
		//this function could be replace by isAlive method 
		if (this.getHitPoints()<1)
		{
			System.out.println("You lose HP! Actually, you are dead... Play again");
			this.quit();
		}
	}
	
	public Boolean isAlive(Fighter fighterF){
		if (fighterF.getHitPoints()<1)
		// if HP <1, it is the same as HP of F'<0 (because HP is int, not double and if HP=0, the fighter is also dead)
		{
			return false; 
		}
		else {
			return true;	
		}
	}
	// To fight
	public void run() {
		System.out.println("I fight");
		int amountAttackUser;
		int amountAttackF; //fighter f
		int i=0; // indice for the loop while
		//steps of a turn
		while (i>=0)
		{
		// initialisation of attacks for the turn
		amountAttackF=attackPerTurn(fighters.get(0).getWeapon());
		System.out.println("The monster will fight with "+ amountAttackF+" damages per turn.");
		delay(1); // 1 second of break
		amountAttackUser= this.attackPerTurn(this.getWeapon());
		System.out.println("You will fight with "+ amountAttackUser+"damages per turn.");
		delay(1); // 1 second of break
			if (isAttacksF(fighters.get(0)))
			{
				System.out.println("Lucky ! You can hit the monster!");
				delay(1); // 1 second of break
				//attacksoftheUser
				takesDamagesF(amountAttackUser,fighters.get(0));
				delay(1); // 1 second of break
				System.out.println("The monster takes damages.");
				delay(1); // 1 second of break
				//test alive for the monster
				if (isAlive(fighters.get(0))) //the monster has still hp, he is going to fight in return !
				{
					System.out.println("The monster survives, he is going to fight in return.");
					delay(1); // 1 second of break
					//attacks of the fighter f
					takesDamagesUser(amountAttackF);
					System.out.println("You take damages.");
					delay(1); // 1 second of break
					//test alive for the user
					this.testDeadUser();
					//the User is not dead 
					System.out.println("End of the turn. You have now "+this.getHitPoints());
					delay(1); // 1 second of break
					System.out.println("The monster has now :"+fighters.get(0).getHitPoints());
					delay(1); // 1 second of break
					i=i+1;//number of turns
                    updateScreen();
				}	
				else //the monster has no hp : dead
				{
					System.out.println("The Monster "+fighters.get(0).getName()+" is dead... Good Job ! End of fight.");
					delay(1); // 1 second of break
					System.out.println("You take "+(i+1)+" turns to win.");
					delay(1); // 1 second of break
					//have new Weapon ?
					isBetterWeapon(fighters.get(0).getWeapon(),  this.getWeapon()); //pas sur du tout que cela marche, Ã  vÃ©rifier
					//have new Armor ? 
					isBetterArmor(fighters.get(0).getArmors1(), fighters.get(0).getArmors2(),this.getArmors1(),this.getArmors2());//pas sur Ã  vÃ©rifier
					//new Treasures ? 
					System.out.println("Oh ! I find some treasures !");
					delay(1); // 1 second of break
					this.getTreasures().setNbPotions(this.getTreasures().getNbPotions()+fighters.get(0).getTreasures().getNbPotions());
					System.out.println("Potions :"+this.getTreasures().getNbPotions());
					delay(1); // 1 second of break
					this.getTreasures().setScroll(this.getTreasures().getScroll()+fighters.get(0).getTreasures().getScroll());
					System.out.println("Scroll :"+this.getTreasures().getScroll());
					delay(1); // 1 second of break
					this.getTreasures().setGold(this.getTreasures().getGold()+fighters.get(0).getTreasures().getGold());
					System.out.println("Gold :"+this.getTreasures().getGold());
					delay(1); // 1 second of break
					this.getTreasures().setSilver(this.getTreasures().getSilver()+fighters.get(0).getTreasures().getSilver());
					System.out.println("Silver :"+this.getTreasures().getSilver());
					delay(1); // 1 second of break
					//this is the end of the fight
					i=-1;
					//we delete the fighter who is not alive.
					fighters.remove(0);
					if(fighters.size() == 0) {
						gui.setUserStatusText("You won CONGRATS");
						delay(2);
						this.quit();
						
					}
					if(fighters.get(0).getName() == "Dopple Ganger") {
						fighters.get(0).setArmors1(this.getArmors1());
						fighters.get(0).setArmors2(this.getArmors2());
						fighters.get(0).setWeapon(this.getWeapon());
						fighters.get(0).setTreasures(this.getTreasures());	
						fighters.get(0).setHitPoints(this.getHitPoints());
					}
					
					stateRest =false;
					gui.setState(1);
                    updateScreen();
                    Thread.currentThread().interrupt();
					//return 1;
				}
			}
			else { //The user cannot attacks the fighter. But the fighter can : BOUM !
				if(Math.random()>0.8) {
				//attacks of the fighter f
				takesDamagesUser(amountAttackF);}
				//test alive for the user
				this.testDeadUser();
                updateScreen();
				//the User is not dead 
				i=i+1;//number of turns	
			}
		}
		//return 0;
        gui.setState(0);
        updateScreen();
		Thread.currentThread().interrupt();
	}
	
	//To get the attack of a fighter f (not the user, a monster actually) per turn 
	public int attackPerTurn(Weapon WeaponFighter){
		return (WeaponFighter.getAttacksPerTurn()*(WeaponFighter.getMinDamage() + (int) (Math.random() * ((WeaponFighter.getMaxDamage() - WeaponFighter.getMinDamage()) + 1))));
	}
	
	//to set the new value of hp of a fighter f
	public void takesDamagesF(int hitDamages, Fighter fighterF){
		fighterF.setHitPoints(fighterF.getHitPoints() -hitDamages);
		
	}
	
	// to set the new value of hp of the user 
	public void takesDamagesUser (int hitDamages){
		this.setHitPoints(this.getHitPoints() -hitDamages);
	}
	
	// to test the possibility of attack the fighter f (in function of his armor)
	public Boolean isAttacksF(Fighter fighterF){
		
		int totalArmor=getTotalArmor(fighterF.getArmors1(),fighterF.getArmors2());
		int randomNumber= 1+ (int)(Math.random()*((20-1)+1));
		if (randomNumber>totalArmor)
		{
			
			return true;
		}
		else 
		{
			
			return false;
		}
	}
	//isBetterMethods for Weapon after fight
	public void isBetterWeapon(Weapon WeaponOfMonster, Weapon WeaponOfUser) { // si on met directement les fighters en variable cela peut optimiser le programme
		
		// to get the average of damage of weapons 
		double averageWeaponOfMonster=WeaponOfMonster.getAttacksPerTurn()*(WeaponOfMonster.getMaxDamage()+WeaponOfMonster.getMinDamage())/2;
		double averageWeaponOfUser=WeaponOfUser.getAttacksPerTurn()*(WeaponOfUser.getMaxDamage()+WeaponOfUser.getMinDamage())/2;
		
		//test of weapon : comparaison of averageWeapon and test of the type of weapon (is Recuperable by the user or not)
		if ((averageWeaponOfMonster>averageWeaponOfUser)&&(WeaponOfMonster.isRecuperable()))
		{
			//it is time to change the Weapon of the User by the Weapon of the Monster
			WeaponOfUser.setName(WeaponOfMonster.getName());
			WeaponOfUser.setAttacksPerTurn(WeaponOfMonster.getAttacksPerTurn());
			WeaponOfUser.setMaxDamage(WeaponOfMonster.getMaxDamage());
			WeaponOfUser.setMinDamage(WeaponOfMonster.getMinDamage());
			System.out.println("I change my Weapon. I am stronger now !");
		}
        updateScreen();
	}
	
	//is BetterMethods for Armor after fight 
	public void isBetterArmor(Armor ArmorOfMonster1, Armor ArmorOfMonster2, Armor ArmorOfUser1, Armor ArmorOfUser2 ) {// si on met directement les fighters en variable cela peut optimiser le programme
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
        updateScreen();
	}
	
	// to get the total of the protection of armor
	public int getTotalArmor(Armor armorOfFighter1, Armor armorOfFighter2)
		// armor of fighter 1 must be type1 (where type is an Attribut from Armor Class), armor of fighter 2 must be type2
	{
		return armorOfFighter1.getProtection()+armorOfFighter2.getProtection();
	}
	

					   
	public void delay(int i){ // to make a pause of i seconds
		try {
    			Thread.sleep(i*1000);    //i seconds .
		} 
		catch(InterruptedException ex) {
    			System.out.println("BUG SUR DELAY");;
		}
					   }
	
	public void buyScroll()
	{
	    if (this.getTreasures().getSilver()>=1)
	        {        
	        System.out.println("You just bought a Scroll HOUUUU");
	        this.getTreasures().setScroll(this.getTreasures().getScroll()+1);
	        this.getTreasures().setSilver(this.getTreasures().getSilver()-1);
	        }
	    else     
	        {
	        System.out.println("Sorry, you don't have enough Silver");
	        }
	}


	public void buyPotion()
	{
	    if (this.getTreasures().getGold()>=1)
	        {        
	        System.out.println("You just bought a Potion HOUUUU");
	        this.getTreasures().setNbPotions(this.getTreasures().getNbPotions()+1);
	        this.getTreasures().setGold(this.getTreasures().getGold()-1);
	        }
	    else     
	        {
	        System.out.println("Sorry, you don't have enough Gold");
	        }
	}

    public void setGui(GameGui gui) {
        this.gui = gui;
    }

    public void updateUserStatus(){
        gui.setUserStatusText("<html>User Summary"
                + "<div>Your HP: "+this.getHitPoints()+"<div><br>"
                + "<div>Your armor is: "+this.getArmors1().getName()+" ("+this.getArmors1().getProtection()+")<div><br>"
                + "<div>Your shield (if you have one) is: "+this.getArmors2().getName()+" ("+this.getArmors2().getProtection()+")<div><br>"
                + "<div>Your weapon is: "+this.getWeapon().getName()+" with: "+this.getWeapon().getAttacksPerTurn()+" attack(s) per turn <br> <div>"
                + "<div>and: "+this.getWeapon().getMinDamage()+" of minimum damage and: "+this.getWeapon().getMaxDamage()+" of maxmimum damage<div></html>"
        );
    }

    public void updateMonsterStatus(){
        gui.setMonsterStatus("<html><div style='text-align: right;'>Monster Summary</div><br>"
                + "<div style='text-align: right;'>His name: "+fighters.get(0).getName()+"</div><br>"
                + "<div style='text-align: right;'>His HP: "+fighters.get(0).getHitPoints()+"</div><br>"
                + "<div style='text-align: right;'>Your armor is: "+fighters.get(0).getArmors1().getName()+" ("+fighters.get(0).getArmors1().getProtection()+")</div><br>"
                + "<div style='text-align: right;'>Your shield (if you have one) is: "+fighters.get(0).getArmors2().getName()+" ("+fighters.get(0).getArmors2().getProtection()+")</div><br>"
                + "<div style='text-align: right;'>Your weapon is: "+fighters.get(0).getWeapon().getName()+" with: "+fighters.get(0).getWeapon().getAttacksPerTurn()+" attack(s) per turn <br> </div>"
                + "<div style='text-align: right;'>and: "+fighters.get(0).getWeapon().getMinDamage()+" of minimum damage and: "+fighters.get(0).getWeapon().getMaxDamage()+" of maxmimum damage</div></html>"
        );
    }

    public void updateScreen(){
	    updateUserStatus();
	    updateMonsterStatus();
    }
}
  
