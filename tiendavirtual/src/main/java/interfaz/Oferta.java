package interfaz;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import tiendavirtual.cookiesHelper;
import vistas.VistaOferta;

public class Oferta extends VistaOferta{
	public Ofertas _ofertas;
	public Image avatar;
	public  Div name;
	public Button eliminarOferta;

	public Oferta(basededatos.Oferta oferta) {
		super();
		System.out.println("Oferta creada");
		
		
		Image avatar = new Image();
	    avatar.setWidth("152px");
	    avatar.setHeight("152px");
	    avatar.setSrc(oferta.getUrlImagen());
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "6px")
	      .set("margin", "16px")
	      .set("cursor", "pointer");
	    
	    Div name = new Div();
	    name.add(new Text(oferta.getNombreOferta()));
	    name.getStyle().set("color", "blue");
	    
	    eliminarOferta= new Button("Eliminar oferta");

	    if (cookiesHelper.isAdministrador()) {
		    this.getVerticalLayout().add(avatar,name, eliminarOferta);

	    }else {
		    this.getVerticalLayout().add(avatar,name);
	    }
	 

	    this.getVerticalLayout().setSpacing(false);
	    this.getVerticalLayout().setWidth("95%");
	    this.getVerticalLayout().getStyle().set("margin", "10px").set("border", "2px solid gray").set("border-radius", "25px");;
	}
	
}