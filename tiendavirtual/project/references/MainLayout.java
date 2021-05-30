package tiendavirtual;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import interfaz.Usuario_no_identificado;
import interfaz.Usuario_registrado;

@PWA(name = "Tienda Virtual",
shortName = "Tienda App",
description = "Tienda Virtual MDS2.",
enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css") 
public final class MainLayout extends AppLayout{

	public MainLayout() {
		super();
		createHeader();
        createDrawer();

	       
	}

	//RouterLink aboutLink = new RouterLink(null, Usuario_no_identificado.class);
	private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo); 

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER); 
        header.setWidth("100%");
        header.addClassName("header");


        addToNavbar(header); 

    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", MainView.class); 
        //RouterLink usuario = new RouterLink("userRegistrado", Usuario_registrado.class); 
        //RouterLink usuario_no_identificado = new RouterLink("usuarioNoIdentificado", Usuario_no_identificado.class); 
        

        listLink.setHighlightCondition(HighlightConditions.sameLocation()); 

        addToDrawer(new VerticalLayout(listLink)); 
        //addToDrawer(new VerticalLayout(usuario)); 
    }
}
