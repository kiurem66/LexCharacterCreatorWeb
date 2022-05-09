package com.web.application.views.charactercreator;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamRegistration;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import com.lextalionis.*;
import com.lextalionis.Character;




@PageTitle("CharacterCreator")
@Route(value = "")
public class CharacterCreatorView extends Div {

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
