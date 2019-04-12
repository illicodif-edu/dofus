package com.dofus;

public class FighterUser extends Fighter implements ActionListener {
  
  // ArrayList of fighters
  private ArrayList<Fighter> fighters;
  
  public Fighter(Weapon weapon, Armor armor, ArrayList<Treasure> treasures, int hitPoints, ArrayList<Fighters> fighters) {
      super(weapon, armor, null, treasures, hitPoints);
      this.fighters = fighters;
   }
  
  // When we touch a button
  public void actionPerfomed(ActionEvent e){
    
    String actionCommand = e.getActionCommand();
    
    // Test on the button to trigger the right function
    if(actionCommand.equals("utilize")){
      this.utilizeTreasure();
    }
    if(actionCommand.equals("rest")){
      this.rest();
    }
    if(actionCommand.equals("quit")){
      this.quit();
    }
    if(actionCommand.equals("fight")){
      this.rest();
    }
  }
  
  // To use one of the treasure
  public void utilizeTreasure(){
    
    
  }
  
  // To quit
  public void quit(){
    
  }
  
  // To fight
  public void fight(){
    
  }
  
  // To rest
  public void rest(){
    // 50% chances to regain hp
    if(Math.random()<0.5){
      this.setHitPoints(this.getHitPoints+(11 + (int)(Math.random() * ((20 - 11) + 1))));
    }
    
    // 50% to lose HP
    else{
      this.fight();
    }
      
  }
  
  
  
}  
  
