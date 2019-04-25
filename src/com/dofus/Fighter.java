package com.dofus;

import java.util.ArrayList;

public class Fighter {
    private String name;
    private Weapon weapon;
    private Armor[] armors = new Armor[2];
    private Treasure treasures;
    private int hitPoints;
    private String path;
    
    public Fighter(String name,Weapon weapon, Armor armor1, Armor armor2, Treasure treasures, int hitPoints, String path) {
        this.weapon = weapon;
        this.name = name;
        this.armors[0] = armor1;
        this.armors[1] = armor2;
        this.treasures = treasures;
        this.hitPoints = hitPoints;
        this.path = path;
    }
    
    public String getName() {
    	return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmors1() {
        return armors[0];
    }
    
    
    public Armor getArmors2() {
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


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
