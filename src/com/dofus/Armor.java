package com.dofus;

public class Armor {
    private String name;
    private int protection;
    private Boolean isRecuperable;
    private int Type;//type1 is body armor, type2 is shield armor
    

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
//verifies if the lootedArmor can be taken and if the armors are the same type then checks if its better than the current armor
    public Boolean isBetter(Armor lootedArmor){
        if (lootedArmor.getIsRecuperable() && this.Type==lootedArmor.getType()){
            return this.protection < lootedArmor.getProtection();
        }
        else
            return false;
    }
}
