package tiendavirtual.interfaz;

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
	
	
	public Categoria() {
		System.out.println("Categoria creada");
		Div avatar = new Div();
	    avatar.setWidth("98px");
	    avatar.setHeight("98px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("background", "url(https://picsum.photos/200)")
	      .set("margin", "6px");
	      
	    avatar.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Div> event) {
					// TODO Auto-generated method stub
					System.out.println("click product");
				}
			});
	    Div name = new Div();
	    name.add(new Text("Nombre categoria"));
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