package com.fire.ami.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.UIScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@UIScope
@Push
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@PWA(name = "Dia Admin", shortName = "Dia Admin", startPath = "admin/index")
@Route(value = "index")
public class IndexView extends AppLayout {
    private static final Logger logger = LoggerFactory.getLogger(IndexView.class);

    public IndexView() {

//        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
//
//        logger.debug("userName: {}", authentication.getName());

        //authentication.getPrincipal().getAttributes().get("email");
        //authentication.getPrincipal().getAttributes().get("name");

        Image img = new Image("/images/fire.png", "fire.com Logo");
        img.setHeight("24px");
        addToNavbar(new DrawerToggle(), img);

        Tab trustedCasTab = new Tab();
        RouterLink trustedCasLink = new RouterLink(null, JobsView.class);
        trustedCasLink.add("Jobs");
        trustedCasTab.add(trustedCasLink);

//        Tab tppDetailsTab = new Tab();
//        RouterLink tppDetailsLink= new RouterLink(null, TppDetailsView.class);
//        tppDetailsLink.add("TPPs");
//        tppDetailsTab.add(tppDetailsLink);
//
//        Tab consentDetailsTab = new Tab();
//        RouterLink consentDetailsLink= new RouterLink(null, ConsentDetailsView.class);
//        consentDetailsLink.add("Consents");
//        consentDetailsTab.add(consentDetailsLink);
//
//        Tab logTab = new Tab();
//        RouterLink logLink = new RouterLink(null, LogView.class);
//        logLink.add("Logs");
//        logTab.add(logLink);

        Tabs tabs = new Tabs(trustedCasTab);//, tppDetailsTab, consentDetailsTab, logTab);

        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
    }
}
