package com.lextalionis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author kyuRAM
 * 
 * Rappresenta la scheda di un personaggio di LexTallionis
 */
public abstract class Character{    
    private String name;
    private int px;
    private String sentiero;
    private String fazione;

    protected HashSet<Disciplina> setDiscipline = new HashSet<Disciplina>();
    protected HashSet<Influenza> setInfluenze = new HashSet<Influenza>();
    protected HashSet<Style> setStili = new HashSet<Style>();
    protected ArrayList<ProCon> setProCon = new ArrayList<ProCon>();

    public Character(){
        name = "";
        px  = 30;
        sentiero = "";
        fazione = "";
    }

    public Character(Character character){
        this.name = character.name;
        this.px = character.px;
        this.sentiero = character.sentiero;
        this.fazione = character.fazione;
        this.setStili = character.setStili;
    }

    public int getPx() {
        return px;
    }

    public String getName() {
        return name;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFazione() {
        return fazione;
    }

    public String getSentiero() {
        return sentiero;
    }

    public void setFazione(String fazione) {
        this.fazione = fazione;
    }

    public void setSentiero(String sentiero) {
        this.sentiero = sentiero;
    }

    public void addDisciplina(Disciplina d){
        setDiscipline.add(d);
    }

    public void addInfluenza(Influenza i){
        setInfluenze.add(i);
    }

    public void addStile(Style s){
        setStili.add(s);
    }

    public Iterator<Disciplina> discIterator(){
        return setDiscipline.iterator();
    }

    public Iterator<Influenza> inflIterator(){
        return setInfluenze.iterator();
    }

    public Iterator<Style> sIterator(){
        return setStili.iterator();
    }

    public Iterator<ProCon> pIterator(){
        return setProCon.iterator();
    }

    public Disciplina searchDisc(String nome){
        for(Disciplina d : setDiscipline){
            if(d.getName().equals(nome)){
                return d;
            }
        }
        throw new NoSuchElementException("Disciplina non presente");
    }

    public ProCon searchProCon(String nome){
        for(ProCon p: setProCon){
            if(p.nome().equals(nome)){
                return p;
            }
        }
        throw new NoSuchElementException("Pregio/difetto non presente");
    }

    public Style searchStyle(String nome){
        for(Style s: setStili){
            if(s.getName().equals(nome)){
                return s;
            }
        }
        throw new NoSuchElementException("Pregio/difetto non presente");
    }

    public boolean isInDisc(String nome){
        for (Disciplina d : setDiscipline) {
            if(d.getName().equals(nome)) return true;
        }
        return false;
    }

    public Influenza searchInfl(String nome){
        for(Influenza i : setInfluenze){
            if(i.getName().equals(nome)){
                return i;
            }
        }
        throw new NoSuchElementException("Influenza non presente");
    }

    public boolean isInInfl(String nome){
        for(Influenza i : setInfluenze){
            if(i.getName().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public void addProCon(ProCon p){
        setProCon.add(p);
    }

    public void removeProCon(ProCon p){
        setProCon.remove(p);
    }

    public int getRemainingPx(){
        int pxSpesi = 0;
        Iterator<Disciplina> itD = discIterator();
        while(itD.hasNext()){
            pxSpesi += itD.next().costCalc();
        }
        Iterator<Influenza> itI = inflIterator();
        while(itI.hasNext()){
            pxSpesi += itI.next().costCalc();
        }
        for(ProCon p : setProCon){
            pxSpesi += p.costo();
        }
        for(Style s : setStili){
            pxSpesi += s.costCalc();
        }
        return getPx() - pxSpesi;
    }

    public boolean isVampire(){return false;}

    public int getBlood(){
        int c = 0;
        for(ProCon p : setProCon){
            if(p.nome().equals("Taglia enorme")){
                c+=2;
            }
        }
        int robu = 0;
        if(isInDisc("Robustezza")){
            switch(searchDisc("Robustezza").getLevel()){
                case 1: robu = 5; break;
                case 2: robu = 10; break;
                case 3: robu = 15; break;
                case 4: robu = 25; break;
                case 5: robu = 35; break;
                default: robu = 0; break;
            }
        }
        int vici = 0;
        if(isInDisc("Vicissitudine")){
            vici = searchDisc("Vicissitudine").getLevel()*2;
            if(vici == 2) vici = 0;
        }
        return robu+vici+c;
    }

    public void removeDisc(Disciplina d){
        if(!d.isClan()){
            setDiscipline.remove(d);
        }
    }

    public void removeInfl(Influenza i){
        if(!i.isClan()){
            setInfluenze.remove(i);
        }
    }

    public void removeStil(Style s){
        setStili.remove(s);
    }

    public int getWill(){
        int c = 0;
        for(ProCon p : setProCon){
            if(p.nome().startsWith("Fiducia in sé stessi")){
                c+=1;
            }
        }
        return c;
    }

    public abstract boolean toChoosInfl();

    public abstract String getClan();

    protected abstract ArrayList<ProCon> getClanPro();
    protected abstract ArrayList<ProCon> getClanCon();

    public Iterator<ProCon> clanProIterator(){
        return getClanPro().iterator();
    }
    
    public Iterator<ProCon> clanConIterator(){
        return getClanCon().iterator();
    }

}