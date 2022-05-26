package com.web.application.views.mainview;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.server.VaadinSession;
import com.lextalionis.Character;

public class CharacterCard extends ListItem {

    private Character character;

    public CharacterCard(Character character) {
        this.character = character;

        addClassNames("bg-contrast-5", "flex", "flex-col", "items-start", "p-m", "rounded-l");

        

        Span header = new Span();
        header.addClassNames("text-xl", "font-semibold");
        header.setText(character.getName());

        Span subtitle = new Span();
        subtitle.addClassNames("text-s", "text-secondary");
        subtitle.setText(character.getClan());

        Paragraph description = new Paragraph(
                character.getDescription());
        description.addClassName("my-m");
        FormLayout formLayout = new FormLayout();
        //formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0px", 2));
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0px", 1));
        //Button view = new Button("Visualizza");
        Button edit = new Button("Modifica");
        edit.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute("character", character);
            UI.getCurrent().getPage().setLocation("/editor");
        });
        //formLayout.add(view);
        formLayout.add(edit);
        add(header, subtitle, description, formLayout);

    }

    public Character getCharacter() {
        return character;
    }
}
