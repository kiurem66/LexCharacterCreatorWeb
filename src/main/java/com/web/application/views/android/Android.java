package com.web.application.views.android;

import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("assetlinks.json")
@Route(value = "/.well-known/assetlinks.json")
public class Android extends Main{
    public Android(){
        add("Pollo");
        
    }
    
}
