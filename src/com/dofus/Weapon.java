package com.dofus;

public class Weapon {
  private String Name;
  private int attacksPerTurn;
  private int minDamage;
  private int maxDamage;
  
  
  public Weapon(String Name, int attacksPerTurn, int minDamage, int maxDamage, ) {
        this.Name = Name;
        this.attacksPerTurn = attacksPerTurn;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return Name;
    }

    public int getAttacksPerTurn() {
        return attacksPerTurn;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAttacksPerTurn(int attacksPerTurn) {
        this.attacksPerTurn = attacksPerTurn;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
    
    public boolean isRecuperable() {
//this method tests if the user can or cannot take weapons of the monster after winning the fight
     return !(Name.equals("hands")|| Name.equals("venom")|| Name.equals("claws")|| Name.equals("lightning bolts")); 
//if the weapon is hands,or venom, or claws, or lightning blots, then the user cannot take weapons
    }


}


