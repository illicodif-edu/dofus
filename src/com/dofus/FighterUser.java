package com.dofus;

public class FighterUser extends Fighter implements ActionListener {
  
  private ArrayList<Fighter> fighters;
  
  public Fighter(Weapon weapon, Armor armor, ArrayList<Treasure> treasures, int hitPoints, ArrayList<Fighters> fighters) {
      super(weapon, armor, null, treasures, hitPoints);
      this.fighters = fighters;
   }
  
  
  public void actionPerfomed(ActionEvent e){
    
    String actionCommand = e.getActionCommand();
    
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
  
  public void utilizeTreasure(){
    
  }
  public void quit(){
    
  }
  
  public void fight(){
    
  }
  
  public void rest(){
    
  }
  
  
  
}  
  
