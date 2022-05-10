package com.web.application.views.charactercreator;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
        
        private Skill skill;
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
            level.setValue(0.0);
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
    

    private Character character;
    private Select<String> gen;
    private NumberField px;
    private Label pxrim;
    private Label bloodWill;
    private VerticalLayout disc;
    private VerticalLayout infl;
    
    InputStream Filefactory(){
        ByteArrayInputStream bis = null;
        try {
            bis = new ByteArrayInputStream(XLS.export(character).toByteArray());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bis;
    }

    FormLayout formLayout = new FormLayout();
    
    
    public CharacterCreatorView(){
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

        });
        discWrap.add(addDisc);
        skillLayout.add(discWrap);

        VerticalLayout inflWrap = new VerticalLayout();
        inflWrap.add(new Label("Influenze"));
        infl = new VerticalLayout();
        inflWrap.add(infl);
        Button addInfl = new Button("Aggiungi Influenza");
        addInfl.addClickListener(e -> {

        });
        inflWrap.add(addInfl);
        skillLayout.add(inflWrap);

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
    }
}
