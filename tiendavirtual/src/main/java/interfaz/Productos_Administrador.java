package interfaz;

import java.util.List;
import java.util.Vector;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import interfaz.Producto_admin;
import vistas.VistaProductosadministrador;

public class Productos_Administrador extends VistaProductosadministrador{
	private event _editar_producto_admin;
	public Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador;
	//public Vector<Producto_admin> _list_Producto_admin = new Vector<Producto_admin>();

	public Productos_Administrador(List<Productos_Administrador> list) {
		for (Productos_Administrador producto_administrador : list) {
			//this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
	
	public Productos_Administrador() {
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
	
	public void Editar_producto_admin() {
		throw new UnsupportedOperationException();
	}
	
	
}