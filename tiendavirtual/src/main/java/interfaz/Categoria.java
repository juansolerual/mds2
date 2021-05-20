package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import tiendavirtual.cookiesHelper;
import vistas.VistaCategoria;

public class Categoria extends VistaCategoria{
	public Categorias _categorias;
	public Div avatar;
	public Div name;
	public Button verCategoria;
	public Button eliminarCategoria;
	public Categoria(basededatos.Categoria cat) {
		
		System.out.println("Categoria creada");
		avatar = new Div();
	    avatar.setWidth("100px");
	    avatar.setHeight("100px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("background", "url("+cat.getImagen()+")")
	      .set("margin", "6px")
	      .set("cursor", "pointer");

	    
	    name = new Div();
	    name.add(new Text(cat.getNombreCategoria()));
	    name.getStyle().set("color", "blue");
	    
	    verCategoria = new Button("Ver categoría");
	    eliminarCategoria = new Button("Eliminar categoria");

	    if (cookiesHelper.isAdministrador()) {
		    this.getVerticalLayout().add(avatar,name, verCategoria, eliminarCategoria);

	    }else {
		    this.getVerticalLayout().add(avatar,name, verCategoria);
	    }
	    
	    

	    this.getVerticalLayout().setSpacing(false);
	    this.getVerticalLayout().setWidth("95%");
	    this.getVerticalLayout().getStyle().set("margin", "10px").set("border", "2px solid gray").set("border-radius", "25px");;
	}
}