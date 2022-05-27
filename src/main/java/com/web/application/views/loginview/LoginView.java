package com.web.application.views.loginview;

import java.nio.charset.StandardCharsets;


import com.google.common.hash.Hashing;
import com.lextalionis.DBManager;
import com.lextalionis.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("LexCharacterCreator")
@Route(value = "/")
public class LoginView extends VerticalLayout{
    public LoginView(){
        setAlignItems(Alignment.CENTER);
        LoginForm loginForm = new LoginForm();
        add(loginForm);

        loginForm.addLoginListener((event) -> {
            if(!DBManager.getInstance().exists(event.getUsername())){
                loginForm.setError(true);
                loginForm.setEnabled(true);
                return;
            }
            User u = DBManager.getInstance().load(event.getUsername());
            String hash = Hashing.sha256().hashString(event.getPassword(), StandardCharsets.UTF_8).toString();
            if(u.getHashedPassword().equals(hash)){
                VaadinSession.getCurrent().setAttribute("user", u);
                UI.getCurrent().getPage().setLocation("/main");
            }
            loginForm.setError(true);
        });

        Button button = new Button("Registrati");
        button.addClickListener(e -> {
            UI.getCurrent().getPage().setLocation("/register");
        });
        add(button);


        
        Button edit = new Button("Vai all'editor");
        edit.addClickListener(e -> {
            VaadinSession.getCurrent().setAttribute("character", null);
            UI.getCurrent().getPage().setLocation("/editor");
        });
        add(edit);
    }
}
