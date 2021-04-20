package interfaz;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaOferta;

public class Oferta extends VistaOferta{
	public Ofertas _ofertas;

	public Oferta() {
		super();
		System.out.println("Oferta creada");
		Div avatar = new Div();
	    avatar.setWidth("152px");
	    avatar.setHeight("152px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px");
	    Div name = new Div();
	    name.add(new Text("Nombre oferta"));
	    name.getStyle().set("color", "blue");
	    Text title = new Text("Ninja coder");
	    //VerticalLayout vl = new VerticalLayout(avatar, name);
	    //Button anadirCarrito = new Button("Añadir Carrito");
	    //vl.add(anadirCarrito);
	    //Button verDescripcion = new Button("Ver descripción");
	    //vl.add(verDescripcion);
	    //HorizontalLayout hl = new HorizontalLayout(vl);
	    this.getVerticalLayout().add(avatar,name);

	    this.getVerticalLayout().setSpacing(false);
	    this.getVerticalLayout().getStyle().set("border","1px solid blue");
	}
	
}