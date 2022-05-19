package com.lextalionis;

import java.util.ArrayList;
import java.util.Iterator;

public class ProConSelector {
    private ArrayList<ProCon> proList;
    private ArrayList<ProCon> conList;

    private static class CommonProCons{
        private ArrayList<ProCon> proList;
        private ArrayList<ProCon> conList;
        private static CommonProCons instance;

        private CommonProCons(){
            proList = new ArrayList<ProCon>();
            proList.add(new ProCon("Abile pilota", 1 )); 
            proList.add(new ProCon("Masochismo", 4 ));
            proList.add(new ProCon("Aggancio 1", 1));
            proList.add(new ProCon("Aggancio 2", 2)); 
            proList.add(new ProCon("Aggancio 3", 3));
            proList.add(new ProCon("Tecnico", 4 ));
            proList.add(new ProCon("Al passo coi tempi", 1, true)); 
            proList.add(new ProCon("Fortuna", 5 ));
            proList.add(new ProCon("Atleta", 1 )); 
            proList.add(new ProCon("Fede oscura", 5 ));
            proList.add(new ProCon("Contorsionista", 1 ));
            proList.add(new ProCon("Fiducia in sé stessi 1", 5));
            proList.add(new ProCon("Fiducia in sé stessi 2", 10));
            proList.add(new ProCon("Fiducia in sé stessi 3", 15));
            proList.add(new ProCon("Diurno", 1 )); 
            proList.add(new ProCon("Osso duro", 5 ));
            proList.add(new ProCon("Favore", 1 )); 
            proList.add(new ProCon("Patagia", 5 ));
            proList.add(new ProCon("Linguaggio dei segni", 1 )); 
            proList.add(new ProCon("Taglia enorme", 5 ));
            proList.add(new ProCon("Messaggio in codice", 1 )); 
            proList.add(new ProCon("Memoria fotografica", 6 ));
            proList.add(new ProCon("Parvenza di vita", 1 )); 
            proList.add(new ProCon("Diablerie nascosta", 8 ));
            proList.add(new ProCon("Logica glaciale", 2 )); 
            proList.add(new ProCon("Un tempo fu Ghoul (Potenza)", 8 ));
            proList.add(new ProCon("Un tempo fu Ghoul (Robustezza)", 8 ));
            proList.add(new ProCon("Tranquillità", 2 )); 
            proList.add(new ProCon("Amico del nemico", 10 ));
            proList.add(new ProCon("Affarista azzardato", 3));
            proList.add(new ProCon("Meditazione", 3 )); 
            proList.add(new ProCon("Volontà di ferro", 10 ));
            proList.add(new ProCon("Sesto Senso", 3 )); 
            proList.add(new ProCon("Oggetto", 15 ));
            proList.add(new ProCon("Talento artistico", 3 )); 
            proList.add(new ProCon("Undicesima generazione", 15 ));
            proList.add(new ProCon("Anatema del Magico", 4 )); 
            proList.add(new ProCon("Ordine di S. Biagio", 25));
            proList.add(new ProCon("Esperienza del sopravvissuto", 4 )); 
            proList.add(new ProCon("Rottura del Vincolo", 20 ));
            proList.add(new ProCon("Insegnante", 4 )); 
            proList.add(new ProCon("Invincolabile", 25 ));

            conList = new ArrayList<ProCon>();
            conList.add(new ProCon("Allergia", -1)); 
            conList.add(new ProCon("Preda selettiva", -3));
            conList.add(new ProCon("Daltonico", -1)); 
            conList.add(new ProCon("Maledetto 1", -3));
            conList.add(new ProCon("Maledetto 2", -4));
            conList.add(new ProCon("Maledetto 3", -5));
            conList.add(new ProCon("Ferita permanente", -1)); 
            conList.add(new ProCon("Senza Dio", -3));
            conList.add(new ProCon("Distratto", -1)); 
            conList.add(new ProCon("Sfigurato", -3));
            conList.add(new ProCon("Paura delle croci", -1)); 
            conList.add(new ProCon("Sterile", -3));
            conList.add(new ProCon("Respinto dall’aglio", -1)); 
            conList.add(new ProCon("Ricettacolo spiritico", -3));
            conList.add(new ProCon("Terrore dell’acqua corrente", -1)); 
            conList.add(new ProCon("Rituale dell’invito", -3));
            conList.add(new ProCon("Tic nervoso", -1)); 
            conList.add(new ProCon("Untore", -3));
            conList.add(new ProCon("Visione nichilista", -1)); 
            conList.add(new ProCon("Aura del male", -4));
            conList.add(new ProCon("Confuso", -2)); 
            conList.add(new ProCon("Dipendente", -4));
            conList.add(new ProCon("Eco sovrannaturale", -2));
            conList.add(new ProCon("Eretico", -4));
            conList.add(new ProCon("Estremista", -2)); 
            conList.add(new ProCon("Fallito", -4));
            conList.add(new ProCon("John/Jane Doe", -2)); 
            conList.add(new ProCon("Mostruoso", -4));
            conList.add(new ProCon("Morso lento", -2)); 
            conList.add(new ProCon("Nemico pubblico", -4));
            conList.add(new ProCon("Odio di clan", -2)); 
            conList.add(new ProCon("Preda proibita", -4));
            conList.add(new ProCon("Occhi di brace", -2)); 
            conList.add(new ProCon("Sangue debole", -4));
            conList.add(new ProCon("Pallore cadaverico", -2)); 
            conList.add(new ProCon("Apprendimento difficile", -5));
            conList.add(new ProCon("Refrattario", -2)); 
            conList.add(new ProCon("Aura da diablerista 1", -5));
            conList.add(new ProCon("Aura da diablerista 2", -2));
            conList.add(new ProCon("Riposo profondo", -2)); 
            conList.add(new ProCon("Nemico 1", -5));
            conList.add(new ProCon("Nemico 2", -7));
            conList.add(new ProCon("Nemico 3", -10));
            conList.add(new ProCon("Sangue labile", -2)); 
            conList.add(new ProCon("Novellino", -5));
            conList.add(new ProCon("Scaramantico", -2)); 
            conList.add(new ProCon("Costituzione fragile", -6));
            conList.add(new ProCon("Zanne", -2)); 
            conList.add(new ProCon("Sincerità", -6));
            conList.add(new ProCon("Zoppo", -2)); 
            conList.add(new ProCon("Marchiato", -7));
            conList.add(new ProCon("Bestia atavica", -3)); 
            conList.add(new ProCon("Pinco Pallino", -7));
            conList.add(new ProCon("Codice d’onore", -3)); 
            conList.add(new ProCon("Cieco", -8));
            conList.add(new ProCon("Cospicua consunzione", -3)); 
            conList.add(new ProCon("Riflesso oscuro", -10));
            conList.add(new ProCon("Debito 1", -3));
            conList.add(new ProCon("Debito 2", -4));
            conList.add(new ProCon("Debito 3", -5));   
            conList.add(new ProCon("Giorni contati", -15));
            conList.add(new ProCon("Ira funesta", -3));
        }

        public static ArrayList<ProCon> getPros(){
            if(instance == null){
                instance = new CommonProCons();
            }
            return instance.proList;
        }

        public static ArrayList<ProCon> getCons(){
            if(instance == null){
                instance = new CommonProCons();
            }
            return instance.conList;
        }
    }

    public ProConSelector(Character c){
        proList = new ArrayList<ProCon>();
        conList = new ArrayList<ProCon>();
    }



    public Iterator<ProCon> proIterator(){
        return new Iterator<ProCon>() {
            int i=0;
            int cnum = CommonProCons.getPros().size();

            @Override
            public boolean hasNext() {
                if(i < cnum){
                    return true;
                }
                return (i-cnum) < proList.size(); 
            }

            @Override
            public ProCon next() {
                if(i< cnum) return CommonProCons.getPros().get(i++);
                return proList.get(i-cnum);
            }
            
        };
    }

    public Iterator<ProCon> conIterator(){
        return new Iterator<ProCon>() {
            int i=0;
            int cnum = CommonProCons.getCons().size();

            @Override
            public boolean hasNext() {
                if(i < cnum){
                    return true;
                }
                return (i-cnum) < conList.size(); 
            }

            @Override
            public ProCon next() {
                if(i< cnum) return CommonProCons.getCons().get(i++);
                return conList.get(i-cnum);
            }
            
        };
    }
    
}
