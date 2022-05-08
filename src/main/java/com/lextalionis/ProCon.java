package com.lextalionis;

public class ProCon{
    private String nome;
    private int costo;
    private boolean clan;

    public ProCon(String nome, int costo){
        this.costo = costo;
        this.nome = nome;
        this.clan = false;
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

    public int costo() {
        return costo;
    }
}
