package com.lextalionis;

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
            return "Assamita";
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
    }

    public static class Ravnos extends Vampire{
        //Chi cazzo ha mai giocato un Ravnos?
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
    }


}
