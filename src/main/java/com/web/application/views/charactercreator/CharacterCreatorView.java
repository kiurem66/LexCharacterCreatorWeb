package com.web.application.views.charactercreator;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamRegistration;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.lextalionis.Character;
import com.lextalionis.*;


@PageTitle("LexCharacterCreator")
@Route(value = "")
public class CharacterCreatorView extends VerticalLayout {

    private class SkillElement extends FormLayout{
        private Component left;
        private Label name;
        private NumberField level;
        private int type; //0: influenza, 1 disciplina, 2 stile
    
        public SkillElement(Skill skill){

            setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 3)
            );
            this.name = new Label(skill.getName());
            if(skill instanceof Influenza)
                type = 0;
            else if(skill instanceof Disciplina)
                type = 1;
            else
                type = 2;
            if(skill.isClan()){
                Checkbox c = new Checkbox();
                c.addClickListener(e -> {
                    skill.setFirstLevelFree(c.getValue());
                    updateBloodWillPx();
                });
                left = c;
            }else{
                Button delete = new Button("-");
                delete.addClickListener(e -> {
                    switch(type){
                        case 0: character.removeInfl(((Influenza)skill)); break;
                        case 1: character.removeDisc(((Disciplina)skill)); break;
                        case 2: character.removeStil(((Style)skill)); break;
                    }
                    updateSkills();
                    updateBloodWillPx();
                });
                left = delete;
            }
            level  = new NumberField();
            level.setValue(((double)(skill.getLevel())));
            level.setMin(0.0);
            level.setStep(1.0);
            level.setHasControls(true);  
            level.setMax(5);
            if(type==2) level.setMax(3);    
            level.addValueChangeListener(e -> {
                skill.setLevel(level.getValue().intValue());
                updateBloodWillPx();
            }); 

            add(left);
            add(name);
            add(level);
        }
    }
    
    private class ProConElement extends FormLayout{
        Label name;
        Label cost;
        Button left;
        Label type;

        public ProConElement(ProCon proCon){
            setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 4)
            );
            name = new Label(proCon.nome());
            left = new Button("-");
            left.addClickListener(e -> {
                character.removeProCon(proCon);
                updateBloodWillPx();
                updateSkills();
            });
            int c = proCon.costo();
            type = new Label("pre");    
            if(c < 0){
                type = new Label("dif");
                c = -c;
            }
            cost = new Label(Integer.toString(c));
            add(left);
            add(name);
            add(type);
            add(cost);
        }
    }
    
    private Character character;
    private Select<String> gen;
    private NumberField px;
    private Label pxrim;
    private Label bloodWill;
    private VerticalLayout disc;
    private VerticalLayout infl;
    private VerticalLayout stili;
    private VerticalLayout proCon;
    private FormLayout formLayout;

    InputStream Filefactory(){
        ByteArrayInputStream bis = null;
        try {
            bis = new ByteArrayInputStream(XLS.export(character).toByteArray());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bis;
    }

    
    
    
    public CharacterCreatorView(){
        formLayout = new FormLayout();
        VerticalLayout ver = new VerticalLayout();
        ver.setAlignItems(Alignment.CENTER);
        H2 title = new H2("Lextalionis Character Creator");
        ver.add(title);
        add(ver);

        formLayout.setResponsiveSteps(
            // Use one column by default
            new FormLayout.ResponsiveStep("0", 1),
            // Use two columns, if layout's width exceeds 500px
            new FormLayout.ResponsiveStep("500px", 3)
        );
        add(formLayout);

        character = new Clan.Assamita();
        
        TextField name = new TextField("Nome");
        name.addValueChangeListener(e -> {
            character.setName(name.getValue());
        });
        formLayout.add(name);

        TextField path = new TextField("Sentiero");
        path.addValueChangeListener(e -> {
            character.setSentiero(path.getValue());
        });
        formLayout.add(path);

        TextField faz = new TextField("Fazione");
        faz.addValueChangeListener(e -> {
            character.setFazione(faz.getValue());
        });
        formLayout.add(faz);

        ArrayList<String> list = new ArrayList<String>();
        Iterator<String> it = ClanSelector.iterator();
        while(it.hasNext()){
            list.add(it.next());
        }

        Select<String> clan = new Select<String>();
        clan.setLabel("Clan");
        clan.setItems(list);
        clan.setValue("Assamita");
        clan.addValueChangeListener(e -> {
            //salvataggio dati da tenere
            int genNum = 0;
            if(character.isVampire()){
                genNum = ((Vampire)character).getGen();
            }

            //cambio pg
            int v = ClanSelector.get(clan.getValue()); 
            character = ClanSelector.charSel(v);           

            //aggiornamento valori
            if(character.isVampire()){
                gen.setVisible(true);
                if(genNum != 0){
                    ((Vampire)character).setGen(genNum);
                }
            }else{
                gen.setVisible(false);
            }
            character.setName(name.getValue());
            character.setSentiero(path.getValue());
            character.setPx(px.getValue().intValue());
            if(character.toChoosInfl()){
                chooseInfl(true);
            }
            updateSkills();
            updateBloodWillPx();
        });
        formLayout.add(clan);

        List<String> g = Arrays.asList("10", "11", "12", "13", "14", "15");
        gen = new Select<String>();
        gen.setLabel("Generazione");
        gen.setItems(g);
        gen.setValue("13");

        gen.addValueChangeListener(e -> {
            if(character.isVampire()){
                ((Vampire)character).setGen(Integer.valueOf(gen.getValue()));
            }
            updateBloodWillPx();
        });
        formLayout.add(gen);

        px = new NumberField("PX");
        px.setValue(30.0);
        px.setStep(1.0);
        px.setHasControls(true);
        px.setMin(1);
        px.setMax(1000);
        px.addValueChangeListener(e -> {
            character.setPx(px.getValue().intValue());
            updateBloodWillPx();
        });
        formLayout.add(px);
        
        FormLayout skillLayout = new FormLayout();
        skillLayout.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("500px", 2),
            new FormLayout.ResponsiveStep("750px", 4)
        );

        VerticalLayout discWrap = new VerticalLayout();
        discWrap.add(new Label("Discipline"));
        disc = new VerticalLayout();
        discWrap.add(disc);
        Button addDisc = new Button("Aggiungi Disciplina");
        addDisc.addClickListener(e -> {
            String[] discipline = {"Animalità", "Ascendente", "Auspex", "Chimerismo", "Daimonion", "Demenza",
                        "Dominazione", "Necromanzia", "Ottenebramento", "Potenza", "Proteide",
                        "Quietus", "Robustezza", "Sanguinis", "Serpentis", "Taumaturgia",
                        "Valeren", "Velocità", "Vicissitudine"};
            Dialog dialog = new Dialog();
            dialog.add("Scegliere disciplina");
            Select<String> select = new Select<String>();
            select.setItems(discipline);
            Button confirm = new Button("Conferma");
            confirm.addClickListener(ev -> {
                Disciplina d =null;
                switch(select.getValue()){
                    case "Animalità": d = new Disciplina.Animalità(); break;
                    case "Ascendente": d = new Disciplina.Ascendente(); break;
                    case "Auspex": d = new Disciplina.Auspex(); break;
                    case "Chimerismo": d = new Disciplina.Chimerismo(); break;
                    case "Daimonion": d = new Disciplina.Daimonion(); break;
                    case "Demenza": d = new Disciplina.Demenza(); break;
                    case "Dominazione": d = new Disciplina.Dominazione(); break;
                    case "Necromanzia": d = new Disciplina.Necromanzia(); break;
                    case "Ottenebramento": d = new Disciplina.Ottenebramento(); break;
                    case "Potenza": d = new Disciplina.Potenza(); break;
                    case "Proteide": d = new Disciplina.Proteide(); break;
                    case "Quietus": d = new Disciplina.Quietus(); break;
                    case "Robustezza": d = new Disciplina.Robustezza(); break;
                    case "Sanguinis": d = new Disciplina.Sanguinis(); break;
                    case "Serpentis": d = new Disciplina.Serpentis(); break;
                    case "Taumaturgia": d = new Disciplina.Taumaturgia(); break;
                    case "Valeren": d = new Disciplina.Valeren(); break;
                    case "Velocità": d = new Disciplina.Velocità(); break;
                    case "Vicissitudine": d = new Disciplina.Vicissitudine(); break;
                }
                d.setClan(false);
                character.addDisciplina(d);
                updateSkills();
                dialog.close();
            });
            dialog.add(select);
            dialog.add(confirm);
            dialog.open();
        });
        discWrap.add(addDisc);
        skillLayout.add(discWrap);

        VerticalLayout inflWrap = new VerticalLayout();
        inflWrap.add(new Label("Influenze"));
        infl = new VerticalLayout();
        inflWrap.add(infl);
        Button addInfl = new Button("Aggiungi Influenza");
        addInfl.addClickListener(e -> {
            chooseInfl(false);
        });
        inflWrap.add(addInfl);
        skillLayout.add(inflWrap);

        VerticalLayout stilWrap = new VerticalLayout();
        stilWrap.add(new Label("Stili"));
        stili = new VerticalLayout();
        stilWrap.add(stili);
        Button addStili = new Button("Aggiungi Stile");
        addStili.addClickListener(e -> {
            String[] slist = {"Coltelli", "Duellista", "Armi da Lancio", "Desperado", "Stile Cinematografico"
                        ,"Arti Marziali", "Combattimento Acrobatico", "Gioco Sporco", "Rissa da Strda"};
            Dialog dialog = new Dialog();
            dialog.add("Scegliere Stile");
            Select<String> select = new Select<String>();
            select.setItems(slist);
            Button confirm = new Button("Conferma");
            confirm.addClickListener(ev -> {
                Style s = null;
                switch(select.getValue()){
                    case "Coltelli": s = new Style.Coltelli(); break;
                    case "Duellista": s = new Style.Duellista(); break;
                    case "Armi da Lancio": s = new Style.Lancio(); break;
                    case "Desperado": s = new Style.Desperado(); break;
                    case "Stile Cinematografico": s = new Style.Cinematografico(); break;
                    case "Arti Marziali": s = new Style.Marziali(); break;
                    case "Combattimento Acrobatico": s = new Style.Acrobatico(); break;
                    case "Gioco Sporco": s = new Style.Sporco(); break;
                    case "Rissa da Strda": s = new Style.Strada(); break;
                }
                character.addStile(s);
                updateSkills();
                updateBloodWillPx();
                dialog.close();
            });
            dialog.add(select);
            dialog.add(confirm);
            dialog.open();
        });
        stilWrap.add(addStili);
        skillLayout.add(stilWrap);

        VerticalLayout proConWrap = new VerticalLayout();
        proConWrap.add(new Label("Pregi/Difetti"));
        proCon = new VerticalLayout();
        proConWrap.add(proCon);
        Button addPro = new Button("Aggiungi Pregio");
        addPro.addClickListener(e -> {
            chooseProcon(true);
        });
        proConWrap.add(addPro);
        Button addCon = new Button("Aggiungi Difetto");
        addCon.addClickListener(e -> {
            chooseProcon(false);
        });
        proConWrap.add(addCon);
        skillLayout.add(proConWrap);

        updateSkills();
        add(skillLayout);

        pxrim = new Label("PX: 30");
        bloodWill = new Label("Sangue: 10 Will: 7");
        add(pxrim);
        add(bloodWill);

        Button b = new Button("Salva");
        b.addClickListener(e -> {
            StreamResource sr = new StreamResource("Scheda.xlsx", () -> Filefactory());
            StreamRegistration registration = VaadinSession.getCurrent().getResourceRegistry().registerResource(sr);
            UI.getCurrent().getPage().setLocation(registration.getResourceUri());
        });
        add(b);

        
        
    }

    private void chooseProcon(boolean pro){
        String text = "Nome Difetto";
        if(pro){
            text = "Nome pregio";
        }
        Dialog dialog = new Dialog();
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2));
        TextField textField = new TextField(text);
        formLayout.add(textField);
        NumberField cost = new NumberField();
        cost.setLabel("Costo");
        cost.setMin(0.0);
        cost.setMax(100.0);
        cost.setStep(1.0);
        cost.setHasControls(true);
        formLayout.add(cost);
        Button confirm = new Button("Conferma");
        confirm.addClickListener(e -> {
            int costo = cost.getValue().intValue();
            if(!pro) costo = -costo;
            ProCon p = new ProCon(textField.getValue(), costo);
            character.addProCon(p);
            updateBloodWillPx();
            updateSkills();
            dialog.close();
        });
        formLayout.add(confirm, 2);
        dialog.add(formLayout);
        dialog.open();
    }
    
    private void chooseInfl(boolean clan){
        String[] list = {"Accademiche", "Alta Società", "Clero", "Crimine", "Esercito",
                        "Ghoul", "Medicina", "Media", "Mentore", "Occulto", "Politica",
                        "Risorse", "Sicurezza", "Sopravvivenza"};
        Dialog dialog = new Dialog();
        dialog.add("Scegliere influenza");
        Select<String> select = new Select<String>();
        select.setItems(list);
        Button confirm = new Button("Conferma");
        confirm.addClickListener(ev -> {
            Influenza i = new Influenza(select.getValue());
            i.setClan(clan);
            character.addInfluenza(i);
            updateSkills();
            dialog.close();
        });
        dialog.add(select);
        dialog.add(confirm);
        dialog.open();
    }

    private void updateBloodWillPx(){
        pxrim.setText("PX: " + character.getRemainingPx());
        bloodWill.setText("Sangue: " + character.getBlood() + " Will: " + character.getWill());
    }

    private void updateSkills(){
        disc.removeAll();
        Iterator<Disciplina> itDisc = character.discIterator();
        while(itDisc.hasNext()){
            disc.add(new SkillElement(itDisc.next()));
        }

        infl.removeAll();
        Iterator<Influenza> itInfl = character.inflIterator();
        while(itInfl.hasNext()){
            infl.add(new SkillElement(itInfl.next()));
        }

        stili.removeAll();
        Iterator<Style> sIterator = character.sIterator();
        while(sIterator.hasNext()){
            stili.add(new SkillElement(sIterator.next()));
        }

        proCon.removeAll();
        Iterator<ProCon> pIterator = character.pIterator();
        while(pIterator.hasNext()){
            proCon.add(new ProConElement(pIterator.next()));
        }
    }
}
