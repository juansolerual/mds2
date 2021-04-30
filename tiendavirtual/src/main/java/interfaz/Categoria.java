package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaCategoria;

public class Categoria extends VistaCategoria{
	public Categorias _categorias;
	public Div avatar;
	public Div name;
	public Categoria(basededatos.Categoria cat) {
		
		System.out.println("Categoria creada");
		avatar = new Div();
	    avatar.setWidth("98px");
	    avatar.setHeight("98px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("background", "url("+cat.getImagen()+")")
	      .set("margin", "6px")
	      .set("cursor", "pointer");

	    
	    name = new Div();
	    name.add(new Text(cat.getNombreCategoria()));
	    name.getStyle().set("color", "blue");
	    
	    this.getVerticalLayout().add(avatar,name);

	    this.getVerticalLayout().setSpacing(false);
	    this.getVerticalLayout().getStyle().set("border","1px solid blue");
	}
}