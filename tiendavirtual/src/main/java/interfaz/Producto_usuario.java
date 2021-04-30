package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaProductolista;
import vistas.VistaProductousuario;

public class Producto_usuario extends VistaProductolista{
	private event _anadir_al_carrito;
	public Productos_Usuario _productos_Usuario;
	public Button anadirCarrito;
	public Button verDescripcion;
	public Button editarProducto;
	public Text precio;
	public Text nombreProducto;
	public Div avatar;

	

	public Div getAvatar() {
		return avatar;
	}

	public void setAvatar(Div avatar) {
		this.avatar = avatar;
	}

	public Text getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(Text nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Button getAnadirCarrito() {
		return anadirCarrito;
	}

	public void setAnadirCarrito(Button anadirCarrito) {
		this.anadirCarrito = anadirCarrito;
		
	}

	public Text getPrecio() {
		return precio;
	}

	public void setPrecio(Text precio) {
		this.precio = precio;
	}

	public void Anadir_al_carrito() {
		throw new UnsupportedOperationException();
	}

	public Producto_usuario(boolean admin) {
		System.out.println("Producto creado");
		
		/*Image image = new Image(null, new ClassResource("/images/button-img.jpg");
		image.addClickListener(e -> System.out.println("click"));
		image.addStyleName("my-img-button");
		
		*/
		
		avatar = new Div();
	    avatar.setWidth("152px");
	    avatar.setHeight("152px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px")
	      .set("background", "url(https://picsum.photos/200)")
	      .set("cursor", "pointer");
	    
	   
	    
	    
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
	    nombreProducto = new Text("Nombre");
	    name.add(nombreProducto);
	    name.getStyle().set("color", "blue");
	    precio = new Text("0,00 euros");
	    VerticalLayout vlav = new VerticalLayout(avatar);
	    VerticalLayout vl = new VerticalLayout(name, precio);
	    if (admin) {
	    	editarProducto = new Button("Editar producto");
		    vl.add(editarProducto);
	    }else {
	    	anadirCarrito = new Button("Añadir Carrito");
		    vl.add(anadirCarrito);
	    }
	    
	    verDescripcion = new Button("Ver descripción");
	    vl.add(verDescripcion);
	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
	    this.getVaadinHorizontalLayout().add(vlav,vl);

	    this.getVaadinHorizontalLayout().setSpacing(false);
	    this.getVaadinHorizontalLayout().getStyle().set("border","1px solid blue");
	}

	
}