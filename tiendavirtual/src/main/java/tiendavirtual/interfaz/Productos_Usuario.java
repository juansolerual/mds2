package tiendavirtual.interfaz;

import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

// import java.util.Vector;

import tiendavirtual.interfaz.Producto_usuario;
import vistas.VistaProductosusuario;

public class Productos_Usuario extends VistaProductosusuario{
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	//public Vector<Producto_usuario> _list_Producto_usuario = new Vector<Producto_usuario>();

	public Productos_Usuario(List<Producto_usuario> list) {
		for (Producto_usuario producto_usuario : list) {
			//this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
	
	public Productos_Usuario() {
		//setSizeFull();
	    // A layout that we want to scroll
		HorizontalLayout scrollableLayout = new HorizontalLayout();
	    for(int i = 0; i< 100; i++){
	      scrollableLayout.add(new Producto_usuario());
	    }
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayout.setHeight("100%");
	    scrollableLayout.setWidth(null);
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayout.getStyle().set("overflow-x", "auto");
	    // Another element to show that it stays in the same place
	    Div staticElement = new Div();
	    staticElement.getStyle().set("margin", "20px");
	    staticElement.add(new Text("Productos Destacados"));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalProductos().add(staticElement, scrollableLayout);
	    this.getHorizontalProductos().getStyle().set("border","1px solid blue");

	}
	
	
}