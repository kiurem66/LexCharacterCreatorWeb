package com.lextalionis;

import java.io.Serializable;

public class ProCon implements Serializable{
    private String nome;
    private int costo;
    private boolean clan;
    boolean toSelect;

    public ProCon(String nome, int costo){
        this(nome, costo, false);
    }

    public ProCon(String nome, int costo, boolean toSelect){
        this.costo = costo;
        this.nome = nome;
        this.clan = false;
        this.toSelect = toSelect;
    }

    public void setClan(boolean clan){
        this.clan = clan;
    }

    public boolean isClan() {
        return clan;
    }

    public String nome() {
        return nome;
    }

    public void addCosto(int toAdd){
        costo += toAdd;
    }

    public int costo() {
        return costo;
    }
}
