package com.web.application.views.registerview;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;
import com.lextalionis.DBManager;
import com.lextalionis.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@PageTitle("LexCharacterCreator")
@Route(value = "/register")
public class RegisterView extends VerticalLayout{
    public RegisterView(){
        setAlignItems(Alignment.CENTER);
        
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
        // Use one column by default
        new FormLayout.ResponsiveStep("0", 1),
        // Use two columns, if layout's width exceeds 500px
        new FormLayout.ResponsiveStep("500px", 2)
        );
        add(formLayout);
        TextField username = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Conferma password");
        Button confirm = new Button("Registrati");
        formLayout.add(username, password, confirmPassword, confirm);
        Label campoVuoto = new Label("Uno dei campi è vuoto");
        Label errPass = new Label("Password diverse");
        Label errUser = new Label("Utente già esistente");
        campoVuoto.setVisible(false);
        errPass.setVisible(false);
        errUser.setVisible(false);
        add(campoVuoto, errPass, errUser);
        confirm.addClickListener(e -> {
            campoVuoto.setVisible(false);
            errPass.setVisible(false);
            errUser.setVisible(false);
            if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                campoVuoto.setVisible(true);
                return;
            }
            if(!password.getValue().equals(confirmPassword.getValue())){
                errPass.setVisible(true);
                return;
            }
            if(DBManager.getInstance().exists(username.getValue())){
                errUser.setVisible(true);
                return;
            }
            User user = new User(username.getValue(), Hashing.sha256().hashString(password.getValue(), StandardCharsets.UTF_8).toString());
            DBManager.getInstance().save(user);
            VaadinSession.getCurrent().setAttribute("user", user);
            UI.getCurrent().getPage().setLocation("/main");
        });
    }
}
