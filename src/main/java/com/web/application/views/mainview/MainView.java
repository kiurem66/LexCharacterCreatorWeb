package com.web.application.views.mainview;

import com.lextalionis.Character;
import com.lextalionis.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;


@PageTitle("LexCharacterCreator")
@Route(value = "/")
public class MainView extends VerticalLayout{
    private User user;

    public MainView(){
        if(VaadinSession.getCurrent().getAttribute("user") == null){
            //UI.getCurrent().getPage().setLocation("/login");
            VaadinSession.getCurrent().setAttribute("user", new User("pippo", ""));
        }
        VaadinSession.getCurrent().setAttribute("character", null);
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        FormLayout charTable = new FormLayout();
        charTable.setResponsiveSteps(new FormLayout.ResponsiveStep("0px", 1), new FormLayout.ResponsiveStep("250px", 3), new FormLayout.ResponsiveStep("500px", 5));
        add(charTable);
        for(Character c : user){
            charTable.add(new CharacterCard(c));
        }
        Button nuovo = new Button("Nuovo");
        nuovo.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute("character", null);
            UI.getCurrent().getPage().setLocation("/editor");
        });
        add(nuovo);
    }
}
