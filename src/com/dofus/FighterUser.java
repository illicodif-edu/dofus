package com.dofus;

public class FighterUser extends Fighter implements ActionListener {
  
  public Fighter(Weapon weapon, Armor armor, ArrayList<Treasure> treasures, int hitPoints) {
      super(weapon, armor, null, treasures, hitPoints);
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
  
