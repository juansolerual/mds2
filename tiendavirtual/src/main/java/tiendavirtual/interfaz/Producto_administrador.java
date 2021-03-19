package tiendavirtual.interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaProductoadmin;

public class Producto_administrador extends VistaProductoadmin{
	public Lista_productos_admin _lista_productos_admin;
	public Agregar_foto _agregar_foto;
	public Agregar_descripcion _agregar_descripcion;
	public Editar_precio _editar_precio;

	public Producto_administrador() {
		System.out.println("Producto admin creado");
		
		/*Image image = new Image(null, new ClassResource("/images/button-img.jpg");
		image.addClickListener(e -> System.out.println("click"));
		image.addStyleName("my-img-button");
		
		*/
		
		Div avatar = new Div();
	    avatar.setWidth("152px");
	    avatar.setHeight("152px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px")
	      .set("background", "url(https://picsum.photos/200)")
	      .set("cursor", "pointer");
	    
	    avatar.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Div> event) {
				// TODO Auto-generated method stub
				System.out.println("click product");
			}
		});
	    //Image img = new Image();
	    //img.setWidth("132px");
	    //img.setHeight("132px");
	    //img.getStyle()
	      //.set("background-color", "gray")
	      //.set("border-radius", "12px")
	      //.set("margin", "auto")
	      //.set("cursor", "pointer");
	    //img.setSrc("https://picsum.photos/200");
	    //avatar.add(img);
	    Div name = new Div();
	    name.add(new Text("Nombre Producto"));
	    name.getStyle().set("color", "blue");
	    Text title = new Text("0,00 euros");
	    VerticalLayout vlav = new VerticalLayout(avatar);
	    VerticalLayout vl = new VerticalLayout(name, title);
	    Button anadirCarrito = new Button("Editar Producto");
	    vl.add(anadirCarrito);
	    Button verDescripcion = new Button("Ver descripción");
	    vl.add(verDescripcion);
	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
	    this.getVaadinHorizontalLayout().add(vlav,vl);

	    this.getVaadinHorizontalLayout().setSpacing(false);
	    this.getVaadinHorizontalLayout().getStyle().set("border","1px solid blue");
	}
	
	public void Guardar_producto() {
		throw new UnsupportedOperationException();
	}
	
	
}