package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
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
	public Image avatarImage;
	public Categoria(basededatos.Categoria cat) {
		
		System.out.println("Categoria creada");
		avatar = new Div();
		avatar.getStyle().set("margin", "16px");
		avatar.setWidth("152px");
		avatar.setHeight("152px");
		avatarImage = new Image();
		if (cat.getImagen() != null) {
			avatarImage.setSrc(cat.getImagen());
		}else {
			avatarImage.setSrc("https://picsum.photos/200");
		}
	    avatarImage.setWidth("152px");
	    avatarImage.setHeight("152px");
	    avatarImage.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "6px")
	      .set("cursor", "pointer");
	    
	    avatar.add(avatarImage);

	    
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