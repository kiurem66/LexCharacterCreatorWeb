package com.web.application.views.charactercreator;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamRegistration;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.lextalionis.*;
import com.lextalionis.Character;




@PageTitle("CharacterCreator")
@Route(value = "")
public class CharacterCreatorView extends VerticalLayout {

    Character c;
    
    InputStream Filefactory(){
        ByteArrayInputStream bis = null;
        try {
            bis = new ByteArrayInputStream(XLS.export(c).toByteArray());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bis;
    }

    
    public CharacterCreatorView(){
        c = new Clan.Assamita();
        c.setName("Pippo");
        
        Button b = new Button("Salva");
        b.addClickListener(e -> {
            StreamResource sr = new StreamResource("Scheda.xlsx", () -> Filefactory());
            StreamRegistration registration = VaadinSession.getCurrent().getResourceRegistry().registerResource(sr);
            UI.getCurrent().getPage().setLocation(registration.getResourceUri());
        });
        add(b);
    }
    
}
