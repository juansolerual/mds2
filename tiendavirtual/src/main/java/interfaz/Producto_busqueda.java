package interfaz;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

import basededatos.Producto;
import vistas.VistaProductolista;

public class Producto_busqueda extends VistaProductolista{
	private event _anadir;
	public Resultado_de_la_busqueda _resultado_de_la_busqueda;
	public Seleccionar_cantidad _seleccionar_cantidad;
	//public Text precio;
	public Button anadirCarrito;
	public Button editarProducto;
	private  Select<String> placeholderSelect;
	//public TextField descripcion;

	public void Anadir() {
		throw new UnsupportedOperationException();
	}

	public Producto_busqueda(boolean admin, Producto producto) {
		super();

		if (producto == null) {
			return;
		}
		
		
		Div avatar = new Div();
	    avatar.setWidth("120px");
	    avatar.setHeight("120px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px")
	      .set("background", "url(https://picsum.photos/200)")
	      .set("cursor", "pointer");
	    
	    Div name = new Div();
	    name.add(producto.getNombreProducto());
	    name.getStyle().set("color", "blue").set("margin", "16px");
	    Div precio = new Div();
	    precio.add(new Text(producto.getPrecio()+" euros"));
	    precio.getStyle().set("color", "blue").set("margin", "16px");
	    
	    VerticalLayout vlav = new VerticalLayout();
	    vlav.add(avatar,name, precio);

	    vlav.setWidth("10%");
	    vlav.setHeight("100%");
	    
	    VerticalLayout vlayoutDescripcion = new VerticalLayout();
	    vlayoutDescripcion.getStyle().set("overflow-y", "auto");

	    vlayoutDescripcion.setWidth("70%");
	    vlayoutDescripcion.setHeight(null);
	    Div descripcion = new Div();
	    //descripcion.add(new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
	    descripcion.add(producto.getDescripcion());
	    descripcion.getStyle().set("color", "blue").set("margin", "16px");
	    
	    
	    vlayoutDescripcion.add(descripcion);
	    
	    VerticalLayout vl = new VerticalLayout();
	    vl.setWidth("20%");

	    if (admin) {
	    	editarProducto = new Button("Editar producto");
		    vl.add(editarProducto);
	    }else {
	    	anadirCarrito = new Button("Añadir Carrito");
		    vl.add(anadirCarrito);
	    }
	    
	    placeholderSelect = new Select<>();
	    placeholderSelect.setItems("1", "2", "3", "4", "5", "6", "7", "8");
	    placeholderSelect.setPlaceholder("Cantidad");

	    
	    //Button verDescripcion = new Button("Ver descripción");
	    //vl.add(verDescripcion);
	    vl.add(placeholderSelect);
	    vl.setAlignItems(Alignment.START);
	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
	    this.getVaadinHorizontalLayout().add(vlav,vlayoutDescripcion,vl);
	    //this.getVaadinHorizontalLayout().setVerticalComponentAlignment(Alignment.END, vl);

	    this.getVaadinHorizontalLayout().setSpacing(false);
	    this.getVaadinHorizontalLayout().getStyle().set("border","1px solid blue");
	}
}