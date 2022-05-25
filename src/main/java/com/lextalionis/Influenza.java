package com.lextalionis;

/**
 * Tipo mutabile che implementa Skill
 * Rappresenta un'influenza di un personaggio
 */
public class Influenza implements Skill, Cloneable{
    private String name;
    private int level;
    private boolean firstFree;
    private boolean clan;

    public Influenza(String name){
        this.name = name;
        this.level = 0;
        firstFree = false;
        clan = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getBaseCost() {
        return 3;
    }

    @Override
    public void setLevel(int lv) {
        this.level = lv;
    }    

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Influenza)) return false;
        Influenza other = (Influenza)obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean isFirstLevelFree() {
        return firstFree;
    }

    public void setFirstLevelFree(boolean firstFree) {
        this.firstFree = firstFree;
    }

    @Override
    public boolean isClan() {
        return clan;
    }

    public void setClan(boolean clan) {
        this.clan = clan;
    }

    @Override
    public int costCalc() {
        int cost = 0;
        for(int i=1; i<=getLevel(); i++){
            if(i==1 && isFirstLevelFree()) continue;
            cost += i*getBaseCost();
            if(!clan) cost++;
        }
        return cost;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}