package com.lextalionis;

import java.util.ArrayList;

public class Ghoul extends Character{

    @Override
    public boolean isVampire() {
        return false;
    }

    @Override
    public int getWill() {
        return 4+super.getWill();
        //pregi
    }

    @Override
    public int getBlood() {
        return 7;
    }

    @Override
    public boolean toChoosInfl() {
        return true;
    }
    
    @Override
    public String getClan() {
        return "Ghoul";
    }

    @Override
    protected ArrayList<ProCon> getClanPro() {
        ArrayList<ProCon> list = new ArrayList<ProCon>();
        list.add(new ProCon("Aura pallida", 2));
        list.add(new ProCon("Dhampyr", 6));
        list.add(new ProCon("Apprendere", 6));
        return list;
    }

    @Override
    protected ArrayList<ProCon> getClanCon() {
        ArrayList<ProCon> list = new ArrayList<ProCon>();
        list.add(new ProCon("Nemico di famiglia 1", 3));
        list.add(new ProCon("Nemico di famiglia 2", 7));
        list.add(new ProCon("Difetto del padrone", 4));
        list.add(new ProCon("Indipendente", 6));
        return list;
    }
}
