package com.dofus;



public class Treasure {
  // Attributs
  private int nbPotions, scroll;
  private double gold, silver;
        
   // Constructor
   public Treasure(int nbPotions, int scroll, double gold, double silver) {
     this.nbPotions = nbPotions;
     this.scroll = scroll;
     this.gold = gold;
     this.silver = silver;
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
     
     public double getSilver() {
         return silver;
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
     
     public void setSilver(double silver) {
         this.silver = silver;
     }
}
