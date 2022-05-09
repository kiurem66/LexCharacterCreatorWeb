package com.web.application.views.charactercreator;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamRegistration;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import com.lextalionis.Character;
import com.lextalionis.*;


@PageTitle("CharacterCreator")
@Route(value = "")
public class CharacterCreatorView extends Div {

    Character character;
    
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
        character = new Clan.Assamita();
        
        TextField name = new TextField("Nome");
        name.addValueChangeListener(e -> {
            character.setName(name.getValue());
        });
        add(name);

        ArrayList<String> list = new ArrayList<String>();
        Iterator<String> it = ClanSelector.iterator();
        while(it.hasNext()){
            list.add(it.next());
        }

        ComboBox<String> clan = new ComboBox<String>("Clan");
        clan.setItems(list);
        clan.addValueChangeListener(e -> {
            //salvataggio dati da tenere
            String nome = character.getName();

            //cambio pg
            int v = ClanSelector.get(clan.getValue()); 
            character = ClanSelector.charSel(v);           

            //aggiornamento valori
            character.setName(nome);
        });
        add(clan);

        Button b = new Button("Salva");
        b.addClickListener(e -> {
            StreamResource sr = new StreamResource("Scheda.xlsx", () -> Filefactory());
            StreamRegistration registration = VaadinSession.getCurrent().getResourceRegistry().registerResource(sr);
            UI.getCurrent().getPage().setLocation(registration.getResourceUri());
        });
        add(b);
    }
    
}
