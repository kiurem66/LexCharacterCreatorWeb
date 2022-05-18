package com.lextalionis;

import java.util.Iterator;

public abstract class Style implements Skill, Iterable<String>{
    private int level;
    private String nomi[] = new String[3];

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int lv) {
        this.level = lv;
    }

    @Override
    public int getBaseCost() {
        return 3;
    }

    @Override
    public int costCalc() {
        switch(level){
            case 1: return 3;
            case 2: return 8;
            case 3: return 15;
            default: return 0;
        }
    }

    @Override
    public boolean isFirstLevelFree() {
        return false;
    }

    @Override
    public void setFirstLevelFree(boolean free) {}

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Style)) return false;
        return ((Style)obj).getName().equals(getName());
    
    }

    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int i=0;
            @Override
            public boolean hasNext() {
                if(i>=3) return false;
                if(i >= level) return false;
                return true;
            }

            @Override
            public String next() {
                return nomi[i++];
            }
            
        };
    }

    public void setName(String n, int i){
        nomi[i] = n;
    }
    
    public static class Coltelli extends Style{
        public Coltelli(){
            setLevel(1);
            setName("Benvenuto del Brigante", 0);
            setName("Tagliagole", 1);
            setName("Signore dei Pugnali", 2);
        }
        
        @Override
        public String getName() {
            return "Coltelli";
        }
    }

    public static class Duellista extends Style{
        public Duellista(){
            setLevel(1);
            setName("Guardia", 0);
            setName("Cappa e Spada", 1);
            setName("Colpo da Maestro", 2);
        }
        
        @Override
        public String getName() {
            return "Duellista";
        }
    }

    public static class Lancio extends Style{
        public Lancio(){
            setName("Sibilo Mortale", 0);
            setName("Questione di Riflessi", 1);
            setName("Ninjutsu", 2);
        }
        
        @Override
        public String getName() {
            return "Armi da lancio";
        }

        @Override
        public String getExcelName() {
            return "ArmidaLancio";
        }
    }

    public static class Desperado extends Style{
        public Desperado(){
            setLevel(1);
            setName("Estrazione rapida", 0);
            setName("Bang Bang Bang", 1);
            setName("Gun Fighter", 2);
        }
        
        @Override
        public String getName() {
            return "Desperado";
        }
    }

    public static class Cinematografico extends Style{
        public Cinematografico(){
            setLevel(1);
            setName("Carambola", 0);
            setName("Colpo di Fortuna", 1);
            setName("Bullet Time", 2);
        }
        
        @Override
        public String getName() {
            return "Stile cinematografico";
        }

        @Override
        public String getExcelName() {
            return "StileCinematografico";
        }
    }

    public static class Marziali extends Style{
        public Marziali(){
            setLevel(1);
            setName("Sbilanciare", 0);
            setName("Disarmare", 1);
            setName("Contromossa", 2);
        }
        
        @Override
        public String getName() {
            return "Arti Marziali";
        }

        @Override
        public String getExcelName() {
            return "ArtiMarziali";
        }
    }

    public static class Acrobatico extends Style{
        public Acrobatico(){
            setLevel(1);
            setName("Atleta", 0);
            setName("Parkour", 1);
            setName("Wardancer", 2);
        }
        
        @Override
        public String getName() {
            return "Combattimento Acrobatico";
        }

        @Override
        public String getExcelName() {
            return "CombattimentoAcrobatico";
        }
    }

    public static class Sporco extends Style{
        public Sporco(){
            setLevel(1);
            setName("Fumo negli Occhi", 0);
            setName("Bottigliata", 1);
            setName("Scudo Umano", 2);
        }
        
        @Override
        public String getName() {
            return "Gioco Sporco";
        }

        @Override
        public String getExcelName() {
            return "GiocoSporco";
        }
    }

    public static class Libre extends Style{
        public Libre(){
            setLevel(1);
            setName("Bruiser Special", 0);
            setName("Spezzaschiena", 1);
            setName("Sottomissione", 2);
        }
        
        @Override
        public String getName() {
            return "Lucha Libre";
        }

        @Override
        public String getExcelName() {
            return "LuchaLibre";
        }
    }

    public static class Strada extends Style{
        public Strada(){
            setLevel(1);
            setName("Stile del Carcerato", 0);
            setName("Uno Due", 1);
            setName("Timbratura", 2);
        }
        
        @Override
        public String getName() {
            return "Rissa da Strada";
        }

        @Override
        public String getExcelName() {
            return "RissadaStrada";
        }
    }

}
