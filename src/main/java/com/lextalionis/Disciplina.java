package com.lextalionis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tipo mutabile che implementa Skill
 * Rappresenta una disciplina di un personaggio
 */
public abstract class Disciplina implements Skill, Iterable<Disciplina.Power>, Cloneable{
    private String name;
    private int level;
    private boolean firstFree;
    private boolean clan;
    private boolean pander;

    public static class Power implements Cloneable, Serializable{
        private String nome;
        private int livello;

        public Power(String nome, int livello){
            this.nome = nome;
            this.livello = livello;
        }

        public String nome() {
            return nome;
        }

        public int livello() {
            return livello;
        }
    }

    private ArrayList<Power> listaPoteri;

    public Disciplina(String name, boolean pander){
        this.name = name;
        this.level  = 0;
        firstFree = false;
        clan = true;
        this.pander = pander;
        listaPoteri = new ArrayList<Power>();
    }

    public Disciplina(String name){
        this(name, false);
    }

    public void setClan(boolean clan) {
        this.clan = clan;
    }

    public boolean isClan() {
        return clan;
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
        if(!clan) return 9;
        if(pander) return 7;
        return 6;
    }

    @Override
    public void setLevel(int lv) {
        this.level = lv;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Disciplina)) return false;
        Disciplina other = (Disciplina)obj;
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

    protected void addPotere(Power p){
        listaPoteri.add(p);
    }

    public Iterator<Power> iterator(){
        return new Iterator<Disciplina.Power>() {
            int i=0;

            @Override
            public boolean hasNext() {
                if(i>=listaPoteri.size()) return false;
                if(listaPoteri.get(i).livello() > level) return false;
                return true;
            }

            @Override
            public Disciplina.Power next() {
                if(!hasNext()) throw new NoSuchElementException();
                return listaPoteri.get(i++);
            }
            
        };
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class Animalita extends Disciplina{
        public Animalita(){
            this(false);
        }

        public Animalita(boolean pander) {
            super("Animalità", pander);
            addPotere(new Power("Sussurri Ferini", 1));
            addPotere(new Power("Richiamo", 2));
            addPotere(new Power("Domare la Bestia", 3));
            addPotere(new Power("Cammino Bestiale", 3));
            addPotere(new Power("Comunione di Spiriti", 4));
            addPotere(new Power("Piaga d'Egitto", 4));
            addPotere(new Power("Estirpare la Bestia", 5));
            addPotere(new Power("Assalto Bestiale", 5));
        }
        
    }

    public static class Ascendente extends Disciplina{
        public Ascendente(){
            this(false);
        }

        public Ascendente(boolean pander) {
            super("Ascendente", pander);
            addPotere(new Power("Magnetismo", 1));
            addPotere(new Power("Sguardo Terrificante", 2));
            addPotere(new Power("Incanto", 3));
            addPotere(new Power("Convocazione", 4));
            addPotere(new Power("Capriccio di Edone'", 4));
            addPotere(new Power("Maestà", 5));
        }
    }

    public static class Auspex extends Disciplina{
        public Auspex(){
            this(false);
        }

        public Auspex(boolean pander) {
            super("Auspex", pander);
            addPotere(new Power("Sensi Acuti", 1));
            addPotere(new Power("Percepire l'aura", 2));
            addPotere(new Power("Tocco dello Spirito", 3));
            addPotere(new Power("Telepatia", 4));
            addPotere(new Power("Viaggio Astrale", 5));
        }
    }

    public static class Chimerismo extends Disciplina{
        public Chimerismo(){
            this(false);
        }

        public Chimerismo(boolean pander) {
            super("Chimerismo", pander);
            addPotere(new Power("Fuoco Fatuo", 1));
            addPotere(new Power("Fata Morgana", 2));
            addPotere(new Power("Oro degli Occhi", 2));
            addPotere(new Power("Apparizione", 3));
            addPotere(new Power("Intelligenza Artefatta", 3));
            addPotere(new Power("Permanenza", 4));
            addPotere(new Power("Orrida Realtà", 5));
            addPotere(new Power("Fata Amria", 5));
        }
    }

    public static class Daimonion extends Disciplina{
        public Daimonion(){
            this(false);
        }

        public Daimonion(boolean pander) {
            super("Daimonion", pander);
            addPotere(new Power("Assaporare il Peccato", 1));
            addPotere(new Power("Terrore Abissale", 2));
            addPotere(new Power("Conflagrazione Infernale", 3));
            addPotere(new Power("Psychomachia", 4));
            addPotere(new Power("Servitore delle Tenebre", 5));
        }
    }

    public static class Demenza extends Disciplina{
        public Demenza(){
            this(false);
        }

        public Demenza(boolean pander) {
            super("Demenza", pander);
            addPotere(new Power("Passione", 1));
            addPotere(new Power("Delirium", 1));
            addPotere(new Power("Ossessione", 2));
            addPotere(new Power("Occhi del Caos", 3));
            addPotere(new Power("Stretta del Dannato", 3));
            addPotere(new Power("Voce della Follia", 4));
            addPotere(new Power("Isteria di Massa", 5));
        }
    }

    public static class Dominazione extends Disciplina{
        public Dominazione(){
            this(false);
        }

        public Dominazione(boolean pander) {
            super("Dominazione", pander);
            addPotere(new Power("Comando Semplice", 1));
            addPotere(new Power("Mesmerizzare", 2));
            addPotere(new Power("Calma Apparente", 3));
            addPotere(new Power("Oblio della Mente", 3));
            addPotere(new Power("Coercizione", 4));
            addPotere(new Power("Tabù", 4));
            addPotere(new Power("Possessione", 5));
        }
    }

    public static class Necromanzia extends Disciplina{
        public Necromanzia(){
            this(false);
        }

        public Necromanzia(boolean pander) {
            super("Necromanzia", pander);
            addPotere(new Power("Visione del Velo", 1));
            addPotere(new Power("Testimonianza Postuma", 1));
            addPotere(new Power("Lingue dei Defunti", 2));
            addPotere(new Power("Morti Inquieti", 3));
            addPotere(new Power("Servo Spettrale", 3));
            addPotere(new Power("Infestazione", 4));
            addPotere(new Power("Orda Barcollante", 4));
            addPotere(new Power("Ex Nihilo", 4));
            addPotere(new Power("Maestria del Sudario", 5));
        }

        @Override
        public String getExcelName() {
            return "Necromanzia:ViaOccidentale";
        }
    }

    public static class Oscurazione extends Disciplina{
        public Oscurazione(){
            this(false);
        }

        public Oscurazione(boolean pander) {
            super("Oscurazione", pander);
            addPotere(new Power("Ammantarsi", 1));
            addPotere(new Power("Tocco Svanitore", 1));
            addPotere(new Power("Presenza Invisibile", 2));
            addPotere(new Power("Maschera dei Mille Volti", 3));
            addPotere(new Power("fantasma nel Sistema", 3));
            addPotere(new Power("Svanire", 4));
            addPotere(new Power("Ammantare le Moltitudini", 5));
            addPotere(new Power("Dono della Maschera", 5));
        }
    }

    public static class Ottenebramento extends Disciplina{
        public Ottenebramento(){
            this(false);
        }

        public Ottenebramento(boolean pander) {
            super("Ottenebramento", pander);
            addPotere(new Power("Gioco d'Ombra", 1));
            addPotere(new Power("Sudario d'Ombra", 2));
            addPotere(new Power("Braccia dell'Abisso", 3));
            addPotere(new Power("Metamorfosi Oscura", 4));
            addPotere(new Power("Divenire Ombra", 5));
        }
    }

    public static class Potenza extends Disciplina{
        public Potenza(){
            this(false);
        }

        public Potenza(boolean pander) {
            super("Potenza", pander);
            addPotere(new Power("Forza Sovraumana", 1));
            addPotere(new Power("Veemenza", 2));
            addPotere(new Power("Brutalità", 3));
            addPotere(new Power("Impatto", 4));
            addPotere(new Power("Rovina di Babele", 5));
        }
    }

    public static class Proteide extends Disciplina{
        public Proteide(){
            this(false);
        }

        public Proteide(boolean pander) {
            super("Proteide", pander);
            addPotere(new Power("Sensi della Bestia", 1));
            addPotere(new Power("Artigli della Bestia", 2));
            addPotere(new Power("Fondersi con la Terra", 3));
            addPotere(new Power("Cuor di leone", 3));
            addPotere(new Power("Trasmutazione", 4));
            addPotere(new Power("Forma di Nebbia", 5));
            addPotere(new Power("Carne di Pietra", 5));
        }
    }

    public static class Quietus extends Disciplina{
        public Quietus(){
            this(false);
        }

        public Quietus(boolean pander) {
            super("Quietus", pander);
            addPotere(new Power("Silenzio di Morte", 1));
            addPotere(new Power("Veleno dello Scorpione", 2));
            addPotere(new Power("Risveglio della Lama", 2));
            addPotere(new Power("Richiamo di Dagon", 3));
            addPotere(new Power("Sudori Freddi", 3));
            addPotere(new Power("Carezza di Baal", 4));
            addPotere(new Power("Sapore di Morte", 5));
            addPotere(new Power("Fragranza Letale", 5));
        }
    }

    public static class Robustezza extends Disciplina{
        public Robustezza(){
            this(false);
        }

        public Robustezza(boolean pander) {
            super("Robustezza", pander);
            addPotere(new Power("Fermezza", 1));
            addPotere(new Power("Vigore", 2));
            addPotere(new Power("Corazza naturale", 3));
            addPotere(new Power("Negare il Flagello", 4));
            addPotere(new Power("Corpo Immortale", 5));
        }
    }

    public static class Sanguinis extends Disciplina{
        public Sanguinis(){
            this(false);
        }

        public Sanguinis(boolean pander) {
            super("Sanguinis", pander);
            addPotere(new Power("Comunione di Sangue", 1));
            addPotere(new Power("Piovra", 2));
            addPotere(new Power("Gestalt", 3));
            addPotere(new Power("Sentiero di Caino", 4));
            addPotere(new Power("Entità Coagulata", 5));
        }
    }

    public static class Serpentis extends Disciplina{
        public Serpentis(){
            this(false);
        }

        public Serpentis(boolean pander) {
            super("Serpentis", pander);
            addPotere(new Power("Sguardo Incantatore", 1));
            addPotere(new Power("Lingua della Serpe", 2));
            addPotere(new Power("Pelle della Vipera", 3));
            addPotere(new Power("Mummificazione", 3));
            addPotere(new Power("Forma del Cobra", 4));
            addPotere(new Power("Simulacro della Bestia Tifonica", 4));
            addPotere(new Power("Estrarre il Cuore", 5));
        }
    }

    public static class Taumaturgia extends Disciplina{
        public Taumaturgia(){
            this(false);
        }

        public Taumaturgia(boolean pander) {
            super("Taumaturgia del Sangue", pander);
            addPotere(new Power("Assaggio del Sangue", 1));
            addPotere(new Power("Furia del Sangue", 2));
            addPotere(new Power("Vigore del Sangue", 3));
            addPotere(new Power("Frusta di Sangue", 3));
            addPotere(new Power("Furto di Vitae", 4));
            addPotere(new Power("Calderone di Sangue", 5));
        }

        @Override
        public String getExcelName() {
            return "Taumaturgia:ViadelSangue";
        }
    }

    public static class Valeren extends Disciplina{
        public Valeren(){
            this(false);
        }

        public Valeren(boolean pander) {
            super("Valeren", pander);
            addPotere(new Power("Percezione Vitale", 1));
            addPotere(new Power("Sentinella Eterna", 1));
            addPotere(new Power("Tocco Anestetico", 2));
            addPotere(new Power("Preveggenza", 2));
            addPotere(new Power("Tocco Ardente", 3));
            addPotere(new Power("Armatura della furia di Cai-", 4));
            addPotere(new Power("Vendetta di Samiel", 5));
        }
    }

    public static class Velocita extends Disciplina{
        public Velocita(){
            this(false);
        }

        public Velocita(boolean pander) {
            super("Velocità", pander);
            addPotere(new Power("Riflessi", 1));
            addPotere(new Power("Destrezza", 2));
            addPotere(new Power("Rapidità", 3));
            addPotere(new Power("Dinamismo", 4));
            addPotere(new Power("Accelerazione", 5));
        }
    }
    
    public static class Vicissitudine extends Disciplina{
        public Vicissitudine(){
            this(false);
        }

        public Vicissitudine(boolean pander) {
            super("Vicissitudine", pander);
            addPotere(new Power("Volto Malleabile", 1));
            addPotere(new Power("Scultura della Carne", 2));
            addPotere(new Power("Scultura delle Ossa", 3));
            addPotere(new Power("Arto Fantasma", 3));
            addPotere(new Power("Forma Terrificante", 4));
            addPotere(new Power("Corpo di Sangue", 5));
            addPotere(new Power("Predatore Chirotteriforme", 5));
        }
    }
}