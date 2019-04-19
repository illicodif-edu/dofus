package com.dofus;

import java.util.ArrayList;

public class Main{
	public static void main(String args[]) {
		
		// initialisation of the Weapon of the user at the beginning
		Weapon swortStartUser= new Weapon("sword",2,1,8);
		
		Weapon dagger = new Weapon("dagger",3,1,4);
		Weapon venom = new Weapon("venom",1,4,20);
		Weapon hands = new Weapon("hands",4,1,8);
		Weapon swordBerserker = new Weapon("sword",4,1,8);
		Weapon superSword = new Weapon("super sword",4,2,8);
		Weapon claws = new Weapon("claws",2,11,20);
		Weapon dopplegangerWeaponInit = new Weapon("NULL",1,0,0);
		Weapon lightningBolts= new Weapon("lighting bolts", 1,21,40);
		
		//Armor(String Name, int protection, Boolean isRecuperable,int Type)
	
		Armor leatherArmor = new Armor("Leather Armor",10,true,1);
		Armor noShield = new Armor("no Shield",0,false,2);
		Armor chainMail = new Armor("Chain Mail",12,true,1);
		Armor hide = new Armor("Hide",14,false,1);
		Armor skin = new Armor("Skin",10,false,1);
		Armor shield = new Armor("Shield",2,true,2);
		Armor ninjaChainMail = new Armor("Ninja Chain Mail",14,true,1);
		Armor scales = new Armor("Scales",14,false,1);
		Armor heavyShield = new Armor("Heavy Shield",4,true,2);
		Armor magicAura = new Armor("Magic Aura",15,false,1);
		
		Fighter orc = new Fighter(dagger, chainMail, null, new Treasure(1, 0, 1,0), 22);
		Fighter nestOfSnakes = new Fighter(venom, null, null, new Treasure(1, 0, 0,0), 12);
		Fighter troll = new Fighter(hands, hide, null, new Treasure(2, 0, 1, 1), 35);
		Fighter berserker = new Fighter(swordBerserker, skin, shield, new Treasure(1, 0, 0, 1), 28);
		Fighter ninja = new Fighter(superSword, chainMail, null, new Treasure(2, 1, 0, 0), 40);
		Fighter dragon = new Fighter(claws, skin, null, new Treasure(0, 1, 0, 3), 25);
		Fighter doppleganger = new Fighter(null, null, heavyShield, null, 0);
		Fighter wizard = new Fighter(lightningBolts, magicAura, null, new Treasure(0, 0, 3, 0), 150);
		
		ArrayList<Fighter> fighters = new ArrayList<Fighter>();
		
		fighters.add(orc);
		fighters.add(nestOfSnakes);
		fighters.add(troll);
		fighters.add(berserker);
		fighters.add(ninja);
		fighters.add(dragon);
		fighters.add(doppleganger);
		fighters.add(wizard);
		
		
		FighterUser user = new FighterUser(swortStartUser, leatherArmor, noShield, new Treasure(2, 1, 0, 0), 50, fighters);
		new GameGui(user);
		
	}
}
