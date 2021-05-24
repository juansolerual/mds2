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

import vistas.VistaProductoadmin;

public class Producto_administrador extends HorizontalLayout{
	public Lista_productos_admin _lista_productos_admin;
	//public Agregar_foto _agregar_foto;
	//public Agregar_descripcion _agregar_descripcion;
	//public Editar_precio _editar_precio;
	
	public VerticalLayout v1 = new VerticalLayout();
	public VerticalLayout v2 = new VerticalLayout();
	public VerticalLayout v3 = new VerticalLayout();
	public VerticalLayout v4 = new VerticalLayout();
	public Image img = new Image();
	public Label nombreProducto = new Label("Nombre");
	public Label descripcionProducto = new Label("Descripcion");
	public Button modificarProducto = new Button("Modificar Producto");
	public Button eliminarProducto = new Button("Eliminar Producto");

	public Producto_administrador() {
		
		img.setWidth("100px");
		img.setHeight("100px");
		img.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		v1.add(img);
		v2.add(nombreProducto);
		v3.add(descripcionProducto);
		v4.add(modificarProducto, eliminarProducto);
		add(v1, v2, v3, v4);
		
		setWidth("100%");
		getStyle().set("border","2px solid #1676f3").set("border-radius","25px");
		v2.getStyle().set("border","1px solid blue").set("margin", "20px");
		v3.getStyle().set("border","1px solid blue").set("margin", "20px");
		v4.getStyle().set("margin", "20px");
		
//		System.out.println("Producto admin creado");
//		
//		/*Image image = new Image(null, new ClassResource("/images/button-img.jpg");
//		image.addClickListener(e -> System.out.println("click"));
//		image.addStyleName("my-img-button");
//		
//		*/
//		
//		Div avatar = new Div();
//	    avatar.setWidth("152px");
//	    avatar.setHeight("152px");
//	    avatar.getStyle()
//	      .set("background-color", "gray")
//	      .set("border-radius", "12px")
//	      .set("margin", "16px")
//	      .set("background", "url(https://picsum.photos/200)")
//	      .set("cursor", "pointer");
//	    
//	    avatar.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
//			
//			@Override
//			public void onComponentEvent(ClickEvent<Div> event) {
//				// TODO Auto-generated method stub
//				System.out.println("click product");
//			}
//		});
//	    //Image img = new Image();
//	    //img.setWidth("132px");
//	    //img.setHeight("132px");
//	    //img.getStyle()
//	      //.set("background-color", "gray")
//	      //.set("border-radius", "12px")
//	      //.set("margin", "auto")
//	      //.set("cursor", "pointer");
//	    //img.setSrc("https://picsum.photos/200");
//	    //avatar.add(img);
//	    Div name = new Div();
//	    name.add(new Text("Nombre Producto"));
//	    name.getStyle().set("color", "blue");
//	    Text title = new Text("0,00 euros");
//	    VerticalLayout vlav = new VerticalLayout(avatar);
//	    VerticalLayout vl = new VerticalLayout(name, title);
//	    Button anadirCarrito = new Button("Editar Producto");
//	    vl.add(anadirCarrito);
//	    Button verDescripcion = new Button("Ver descripción");
//	    vl.add(verDescripcion);
//	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
//	    this.getVaadinHorizontalLayout().add(vlav,vl);
//
//	    this.getVaadinHorizontalLayout().setSpacing(false);
//	    this.getVaadinHorizontalLayout().getStyle().set("border","1px solid blue");
	}
	
	public void Guardar_producto() {
		throw new UnsupportedOperationException();
	}
	
	
}