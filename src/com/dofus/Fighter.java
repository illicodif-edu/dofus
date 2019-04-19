package com.dofus;

import java.util.ArrayList;

public class Fighter {
    private String name;
    private Weapon weapon;
    private Armor[] armors = new Armor[2];
    private Treasure treasures;
    private int hitPoints;
    
    public Fighter(Weapon weapon, Armor armor1, Armor armor2, Treasure treasures, int hitPoints) {
        this.weapon = weapon;
        this.armors[0] = armor1;
        this.armors[1] = armor2;
        this.treasures = treasures;
        this.hitPoints = hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor[0] getArmors1() {
        return armors[0];
    }
    
    
    public Armor[1] getArmors2() {
        return armors[1];
    }

    public void setArmors1(Armor armors) {
        this.armors[0] = armors;
    }
    
    public void setArmors2(Armor armors) {
        this.armors[1] = armors;
    }

    public Treasure getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure treasures) {
        this.treasures = treasures;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }




}
