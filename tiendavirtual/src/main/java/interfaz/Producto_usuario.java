package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
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
	public Label precio;
	public Label precioRebajado;
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

	public Label getPrecio() {
		return precio;
	}

	public void setPrecio(Label precio) {
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
	      .set("margin-left", "10px")
	      .set("margin-top", "10px")
	      .set("margin-bottom", "10px")
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
	    Div precioDiv = new Div();
	    precio = new Label("Precio: 0,00 euros");
	    //precio.getStyle().set("float", "left").set("width", "50%");
	    precioRebajado = new Label(" 0,00 euros");
	    precioDiv.add(precio);
	    precioDiv.add(precioRebajado);
	    precioRebajado.getStyle().set("color", "blue").set("font-weight", "bold");
	    //.set("text-align", "left").set("width","50%")
	    //.set("float", "right");
	    
	    VerticalLayout vl = new VerticalLayout(name, precio, precioRebajado);
	    vl.getStyle().set("margin-right", "10px")
	      .set("margin-top", "10px")
	      .set("margin-bottom", "10px");
	    
	    if (admin) {
	    	editarProducto = new Button("Editar producto");
	    	editarProducto.getStyle().set("margin-top", "52px");
		    vl.add(editarProducto);
	    }else {
	    	anadirCarrito = new Button("Añadir Carrito");
	    	anadirCarrito.getStyle().set("margin-top", "52px");
		    vl.add(anadirCarrito);
	    }
	    
	    verDescripcion = new Button("Ver descripción");
	    VerticalLayout vlav = new VerticalLayout(avatar,verDescripcion);

	    //vl.add();
	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
	    this.getVaadinHorizontalLayout().add(vlav,vl);

	    this.getVaadinHorizontalLayout().setSpacing(false);
	    this.getVaadinHorizontalLayout().getStyle().set("border", "2px solid gray").set("border-radius", "25px");
	}

	
}