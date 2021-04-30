package interfaz;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaOferta;

public class Oferta extends VistaOferta{
	public Ofertas _ofertas;
	public Div avatar;
	public  Div name;

	public Oferta(basededatos.Oferta oferta) {
		super();
		System.out.println("Oferta creada");
		Div avatar = new Div();
	    avatar.setWidth("152px");
	    avatar.setHeight("152px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px")
	     // .set("background", "url("+oferta.getImagen()+")")
	      .set("cursor", "pointer");
	    
	    Div name = new Div();
	    name.add(new Text(oferta.getNombreOferta()));
	    name.getStyle().set("color", "blue");
	 
	    this.getVerticalLayout().add(avatar,name);

	    this.getVerticalLayout().setSpacing(false);
	    this.getVerticalLayout().getStyle().set("border","1px solid blue");
	}
	
}