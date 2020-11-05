package com.fire.ami.views;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route(value = "accessDenied")
public class DeniedAccessView
        extends VerticalLayout {
    DeniedAccessView() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(String.valueOf(new Label("Access denied!")));
        add(formLayout);
    }
}