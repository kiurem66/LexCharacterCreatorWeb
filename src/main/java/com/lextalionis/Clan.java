package com.lextalionis;

import java.util.ArrayList;

public final class Clan {

    private Clan(){};

    public static class Assamita extends Vampire{
        public Assamita(){
            super();
            addDisciplina(new Disciplina.Oscurazione());
            addDisciplina(new Disciplina.Quietus());
            addDisciplina(new Disciplina.Velocità());
            addInfluenza(new Influenza("Esercito"));
            addInfluenza(new Influenza("Sicurezza"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Assamita AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Club dei Mille Metri", 3));
            list.add(new ProCon("Natural Born Killer", 6));
            list.add(new ProCon("Mentore edotto", 10));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Gusto Magico", -3));
            list.add(new ProCon("Soggiogato", -5));
            return list;
        }
    }

    public static class Baali extends Vampire{
        public Baali(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Daimonion());
            addDisciplina(new Disciplina.Oscurazione());
            addInfluenza(new Influenza("Accademiche"));
            addInfluenza(new Influenza("Occulto"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Baali";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            return list;
        }
    }

    public static class Brujah extends Vampire{
        public Brujah(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Potenza());
            addDisciplina(new Disciplina.Velocità());
            addInfluenza(new Influenza("Crimine"));
            addInfluenza(new Influenza("Politica"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Brujah AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Sguardo dell'ira primordiale", 3));
            list.add(new ProCon("Forza della parola", 4));
            list.add(new ProCon("Terapia d'urto", 5));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Sangue bollente", -3));
            list.add(new ProCon("Blackout totale",-4));
            list.add(new ProCon("Lupo tra le pecore", -4));
            return list;
        }
    }

    public static class CountryGangrel extends Vampire{
        public CountryGangrel(){
            super();
            addDisciplina(new Disciplina.Animalità());
            addDisciplina(new Disciplina.Proteide());
            addDisciplina(new Disciplina.Robustezza());
            addInfluenza(new Influenza("Mentore"));
            addInfluenza(new Influenza("Sicurezza"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Gangrel \'di Campagna\'";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Dono di Proteo", 2));
            list.add(new ProCon("Odore ferale", 2));
            list.add(new ProCon("Erede delle Ahrimane", 3));
            list.add(new ProCon("Irrintracciabile", 3));
            list.add(new ProCon("Tattiche di branco", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Nomadismo incontrollabile", -3));
            list.add(new ProCon("Aerofobico", -4));
            list.add(new ProCon("Orrore metamorfico", -4));
            return list;
        }
    }

    public static class CityGangrel extends Vampire{
        public CityGangrel(){
            super();
            addDisciplina(new Disciplina.Oscurazione());
            addDisciplina(new Disciplina.Proteide());
            addDisciplina(new Disciplina.Velocità());
            addInfluenza(new Influenza("Crimine"));
            addInfluenza(new Influenza("Media"));
            addInfluenza(new Influenza("Medicina"));
        }

        @Override
        public String getClan() {
            return "Gangrel \'di Città\'";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Stalker", 3));
            list.add(new ProCon("Solitaire", 4));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Nido di vespe", -3));
            list.add(new ProCon("Nstura avversa", -3));
            return list;
        }
    }

    public static class BloodBrothers extends Vampire{
        private int number;

        public BloodBrothers(){
            super();
            addDisciplina(new Disciplina.Potenza());
            addDisciplina(new Disciplina.Robustezza());
            addDisciplina(new Disciplina.Sanguinis());
            addInfluenza(new Influenza("Sopravvivenza"));
            number = 2;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getWill(){
            int base = super.getWill();
            return base + number;
        }

        @Override
        public String getClan() {
            return "Gemelli di Sangue";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Ricetta Alternativa", 4));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Catena di comando 1", -3));
            list.add(new ProCon("Catena di comando 2", -6));
            return list;
        }
    }

    public static class Giovanni extends Vampire{
        public Giovanni(){
            super();
            addDisciplina(new Disciplina.Dominazione());
            addDisciplina(new Disciplina.Necromanzia());
            addDisciplina(new Disciplina.Potenza());
            addInfluenza(new Influenza("Medicina"));
            addInfluenza(new Influenza("Occulto"));
            addInfluenza(new Influenza("Risorse"));
        }

        @Override
        public String getClan() {
            return "Giovanni";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Incongruenza del sangue", 2));
            list.add(new ProCon("Bacio dell'approssimarsi", 3));
            list.add(new ProCon("Famiglia minore", 4));
            list.add(new ProCon("Pedigree", 7));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Naive", -3));
            list.add(new ProCon("Legami familiari", -4));
            list.add(new ProCon("Estraneo in casa", -5));
            list.add(new ProCon("Valentiniano", -5));
            return list;
        }
    }

    public static class Lasombra extends Vampire{
        public Lasombra(){
            super();
            addDisciplina(new Disciplina.Dominazione());
            addDisciplina(new Disciplina.Ottenebramento());
            addDisciplina(new Disciplina.Potenza());
            addInfluenza(new Influenza("Clero"));
            addInfluenza(new Influenza("Politica"));
            addInfluenza(new Influenza("Mentore"));
        }

        @Override
        public String getClan() {
            return "Lasombra";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Seguace dell'Abisso", 5));
            list.add(new ProCon("Nemico favorito", 5));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Richiamo di Poseidone", -2));
            list.add(new ProCon("Ira di Vanesio", -2));
            list.add(new ProCon("Ombra indipendente", -3));
            list.add(new ProCon("Paura delle ombre", -3));
            return list;
        }
    }

    public static class Malkavian extends Vampire{
        public Malkavian(){
            super();
            addDisciplina(new Disciplina.Auspex());
            addDisciplina(new Disciplina.Demenza());
            addDisciplina(new Disciplina.Oscurazione());
            addInfluenza(new Influenza("Accademiche"));
            addInfluenza(new Influenza("Media"));
            addInfluenza(new Influenza("Medicina"));
        }

        @Override
        public String getClan() {
            return "Malkavian AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Mentore etereo", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Terapia d'urto", -3));
            list.add(new ProCon("Stigmate di sangue", -3));
            list.add(new ProCon("Follia contagiosa", -3));
            list.add(new ProCon("Occhio del ciclone", -5));
            return list;
        }
    }

    public static class Nosferatu extends Vampire{
        public Nosferatu(){
            super();
            addDisciplina(new Disciplina.Animalità());
            addDisciplina(new Disciplina.Oscurazione());
            addDisciplina(new Disciplina.Potenza());
            addInfluenza(new Influenza("Media"));
            addInfluenza(new Influenza("Sopravvivenza"));
            addInfluenza(new Influenza("Sicurezza"));
        }

        @Override
        public String getClan() {
            return "Nosferatu AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Oblio del sonno", 3));
            list.add(new ProCon("Pelle viscida", 3));
            list.add(new ProCon("Segreto 1", 3));
            list.add(new ProCon("Segreto 2", 7));
            list.add(new ProCon("Segreto 3", 15));
            list.add(new ProCon("Tattica della seppia", 5));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Anosmia", -3));
            list.add(new ProCon("Nidiata rivale", -5));
            list.add(new ProCon("Leatherface", -6));
            list.add(new ProCon("Ultimo superstite", -6));
            return list;
        }
    }

    public static class Pander extends Vampire{
        public Pander(){
            super();
            addDisciplina(new Disciplina.Animalità(true));
            addDisciplina(new Disciplina.Ascendente(true));
            addDisciplina(new Disciplina.Auspex(true));
            addDisciplina(new Disciplina.Dominazione(true));
            addDisciplina(new Disciplina.Oscurazione(true));
            addDisciplina(new Disciplina.Potenza(true));
            addDisciplina(new Disciplina.Robustezza(true));
            addDisciplina(new Disciplina.Velocità(true));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public boolean toChoosInfl() {
            return true;
        }

        @Override
        public String getClan() {
            return "Pander";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Boogeyman", 3));
            list.add(new ProCon("Capitano del popolo", 5));
            list.add(new ProCon("Delirium", 3));
            list.add(new ProCon("Generazione V", 10));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Ignorante", -1));
            list.add(new ProCon("Debolezza di Clan", -3));
            list.add(new ProCon("Invecchiato", -4));
            list.add(new ProCon("Anatema del Legno", -8));
            return list;
        }
    }

    public static class Ravnos extends Vampire{
        //Chi cazzo ha mai giocato un Ravnos? 
        //Ah ok ne ho visto uno giocato
        public Ravnos(){
            super();
            addDisciplina(new Disciplina.Animalità());
            addDisciplina(new Disciplina.Chimerismo());
            addDisciplina(new Disciplina.Robustezza());
            addInfluenza(new Influenza("Crimine"));
            addInfluenza(new Influenza("Occulto"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Ravnos AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Fachiro", 4));
            list.add(new ProCon("Battesimo del fuoco", 4));
            list.add(new ProCon("Destino di Loki", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Realtà menomata", -4));
            list.add(new ProCon("Paria", -6));
            return list;
        }
    }

    public static class Salubre extends Vampire{
        public Salubre(){
            super();
            addDisciplina(new Disciplina.Auspex());
            addDisciplina(new Disciplina.Robustezza());
            addDisciplina(new Disciplina.Valeren());
            addInfluenza(new Influenza("Esercito"));
            addInfluenza(new Influenza("Occulto"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Salubre AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Seconda Vista", 5));
            list.add(new ProCon("Battezzato secondo il Codice", 5));
            list.add(new ProCon("Testamento di Abele", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Malocchio", -2));
            list.add(new ProCon("Flagello dei Demoni", -4));
            return list;
        }
    }

    public static class SetFollower extends Vampire{
        public SetFollower(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Oscurazione());
            addDisciplina(new Disciplina.Serpentis());
            addInfluenza(new Influenza("Alta società"));
            addInfluenza(new Influenza("Clero"));
            addInfluenza(new Influenza("Crimine"));
        }

        @Override
        public String getClan() {
            return "Seguace del Set";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Capelli rossi", 2));
            list.add(new ProCon("Sangue dolce", 3));
            list.add(new ProCon("Vecchia scuola", 4));
            list.add(new ProCon("Corte di Wepwavet", 8));
            list.add(new ProCon("Cuore rimosso", 10));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Occhi del Serpente", -2));
            list.add(new ProCon("Lingua biforcuta", -2));
            return list;
        }
    }

    public static class LightSerpent extends Vampire{
        public LightSerpent(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Oscurazione());
            addDisciplina(new Disciplina.Serpentis());
            addInfluenza(new Influenza("Crimine"));
            addInfluenza(new Influenza("Occulto"));
            addInfluenza(new Influenza("Sopravvivenza"));
        }

        @Override
        public String getClan() {
            return "Serpente della Luce";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Favore dei Loa", 10));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Occhi del Serpente", -2));
            list.add(new ProCon("Lingua biforcuta", -2));
            list.add(new ProCon("Tabù", -4));
            list.add(new ProCon("Debitore", -5));
            return list;
        }
    }

    public static class Toreador extends Vampire{
        public Toreador(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Auspex());
            addDisciplina(new Disciplina.Velocità());
            addInfluenza(new Influenza("Accademiche"));
            addInfluenza(new Influenza("Alta società"));
            addInfluenza(new Influenza("Media"));
        }

        @Override
        public String getClan() {
            return "Toreador AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Colori segreti", 3));
            list.add(new ProCon("Stirpe di Volgirre", 5));
            list.add(new ProCon("Avant-garde", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Dadaista", -3));
            list.add(new ProCon("Perversione estrema", -5));
            list.add(new ProCon("Addicted to the knife", -4));
            return list;
        }
    }

    public static class Tremere extends Vampire{
        public Tremere(){
            super();
            addDisciplina(new Disciplina.Auspex());
            addDisciplina(new Disciplina.Dominazione());
            addDisciplina(new Disciplina.Taumaturgia());
            addInfluenza(new Influenza("Accademiche"));
            addInfluenza(new Influenza("Alta società"));
            addInfluenza(new Influenza("Occulto"));
        }

        @Override
        public String getClan() {
            return "Tremere AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Telyavelico", 4));
            list.add(new ProCon("Topo di biblioteca", 6));
            list.add(new ProCon("Predatore di magia", 10));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Erede di Sangue", -4));
            list.add(new ProCon("Oggettivista", -5));
            list.add(new ProCon("Paradosso vivente", -8));
            return list;
        }
    }

    public static class Tzimisce extends Vampire{
        public Tzimisce(){
            super();
            addDisciplina(new Disciplina.Animalità());
            addDisciplina(new Disciplina.Auspex());
            addDisciplina(new Disciplina.Vicissitudine());
            addInfluenza(new Influenza("Accademiche"));
            addInfluenza(new Influenza("Medicine"));
            addInfluenza(new Influenza("Occulto"));
        }

        @Override
        public String getClan() {
            return "Tzimisce";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Argilla primordiale", 4));
            list.add(new ProCon("Resistenza al dolore", 4));
            list.add(new ProCon("Figlio del dragone", 6));
            list.add(new ProCon("Allevare il Mastino Infernale", 1));
            list.add(new ProCon("Plasmare lo Szlachta", 3));
            list.add(new ProCon("Ricetta del Vozhd Minore", 6));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Ossessione territoriale", -3));
            list.add(new ProCon("Malattia cronica", -5));
            return list;
        }
    }

    public static class Ventrue extends Vampire{
        public Ventrue(){
            super();
            addDisciplina(new Disciplina.Ascendente());
            addDisciplina(new Disciplina.Dominazione());
            addDisciplina(new Disciplina.Robustezza());
            addInfluenza(new Influenza("Esercito"));
            addInfluenza(new Influenza("Politica"));
            addInfluenza(new Influenza("Risorse"));
        }

        @Override
        public String getClan() {
            return "Ventrue AT";
        }

        @Override
        protected ArrayList<ProCon> getClanPro() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Gioco da ragazzi", 3));
            list.add(new ProCon("Fang Real", 3));
            list.add(new ProCon("Portamento Regale", 5));
            return list;
        }

        @Override
        protected ArrayList<ProCon> getClanCon() {
            ArrayList<ProCon> list = new ArrayList<ProCon>();
            list.add(new ProCon("Piatto Preferito", -4));
            list.add(new ProCon("Voto infranto", -4));
            list.add(new ProCon("Ultima Cena", -6));
            return list;
        }
    }


}
