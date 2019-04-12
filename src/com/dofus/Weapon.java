package com.dofus;

public class Weapon {
  private String Type;
  private int attacksPerTurn;
  private int minDamage;
  private int maxDamage;
  
  public Weapon(String Type, int attacksPerTurn, int minDamage, int maxDamage) {
        this.Type = Type;
        this.attacksPerTurn = attacksPerTurn;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getType() {
        return Type;
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

    public void setType(String Type) {
        this.Type = Type;
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
     if (Type.equals("hands")|| Type.equals("venom")|| Type.equals("claws")|| Type.equals("lightning bolts"))
     {
       return FALSE;
     }
     else
     {
       return TRUE;
     } 
    }

}


