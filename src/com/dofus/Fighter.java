package com.dofus;

import java.util.ArrayList;

public class Fighter {
    private String name;
    private Weapon weapon;
    private Armor[] armors = new Armor[2];
    private ArrayList<Treasure> treasures;
    private int hitPoints;

    public Fighter(Weapon weapon, Armor armor1, Armor armor2, ArrayList<Treasure> treasures, int hitPoints) {
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

    public Armor[] getArmors() {
        return armors;
    }

    public void setArmors(Armor[] armors) {
        this.armors = armors;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }




}
