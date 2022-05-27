package com.web.application.views.mainview;

import com.lextalionis.Character;
import com.lextalionis.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("LexCharacterCreator")
@Route(value = "/main")
public class MainView extends Main{
    private User user;

    public MainView(){
        addClassNames("main-view", "max-w-screen-lg", "mx-auto", "pb-l", "px-l");
        if(VaadinSession.getCurrent().getAttribute("user") == null){
            UI.getCurrent().getPage().setLocation("/");
        }
        VaadinSession.getCurrent().setAttribute("character", null);
        user = (User) VaadinSession.getCurrent().getAttribute("user");
        
        VerticalLayout vLayout = new VerticalLayout();
        Button logout = new Button("Logout");
        vLayout.setAlignItems(Alignment.END);
        vLayout.add(logout);
        logout.addClickListener(e -> {
            VaadinSession.getCurrent().getSession().invalidate();
            UI.getCurrent().getPage().setLocation("/");
        });
        add(vLayout);

        OrderedList imageContainer = new OrderedList();
        imageContainer.addClassNames("gap-m", "grid", "list-none", "m-0", "p-0");
        add(imageContainer);

        if(user.hasNoChara()){
            remove(imageContainer);
            VerticalLayout v = new VerticalLayout();
            add(v);
            v.setAlignItems(Alignment.CENTER);
            H2 h2 = new H2("Non hai ancora personaggi");
            v.add(h2);
            Button edit = new Button("Vai all'editor");
            edit.addClickListener(e -> {
                VaadinSession.getCurrent().setAttribute("character", null);
                UI.getCurrent().getPage().setLocation("/editor");
            });
            v.add(edit);
        }

        for(Character c : user){
            imageContainer.add(new CharacterCard(c));
        }        
        
        HorizontalLayout hl = new HorizontalLayout();
        hl.setAlignItems(Alignment.CENTER);
        Button nuovo = new Button("Crea nuovo personaggio");
        nuovo.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute("character", null);
            UI.getCurrent().getPage().setLocation("/editor");
        });
        hl.add(nuovo);
        imageContainer.add(hl);
    }
}
