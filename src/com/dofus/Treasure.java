package com.dofus;

public class Treasure {
  // Attributs
  private int nbPotions, scroll;
  private double gold;
        
   // Constructor
   public Treasure(int nbPotions, int scroll, double gold) {
     this.nbPotions = nbPotions;
     this.scroll = scroll;
     this.gold = gold;
   }
   public int getNbPotions() {
        return nbPotions;
     }

    public int getScroll() {
         return scroll;
     }

     public double getGold() {
         return gold;
     }

     public void setNbPotions(int nbPotions) {
         this.nbPotions = nbPotions;
     }

     public void setScroll(int scroll) {
         this.scroll = scroll;
     }

     public void setGold(double gold) {
         this.gold = gold;
     }
}
