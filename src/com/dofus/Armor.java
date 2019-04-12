package com.dofus;

public class Armor {
    private String name;
    private int protection;
    private Boolean isRecuperable;
    private int Type;
    

    public Armor(String Name, int protection, Boolean isRecuperable,int Type) {
        this.name = Name;
        this.protection = protection;
        this.isRecuperable = isRecuperable;
        this.Type=Type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public Boolean getIsRecuperable() {
        return isRecuperable;
    }

    public void setIsRecuperable(Boolean isRecuperable) {
        this.isRecuperable = isRecuperable;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public static Boolean isBetter(Armor currentArmor,Armor lootedArmor){
        if (lootedArmor.getIsRecuperable() && currentArmor.getType()==lootedArmor.getType()){
            return currentArmor.getProtection() < lootedArmor.getProtection();
        }
        else
            return false;
    }
}
