package interfaz;

import java.util.Vector;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import interfaz.Oferta;
import vistas.VistaOfertas;

public class Ofertas extends VistaOfertas{
	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	//public Vector<Oferta> _list_Oferta = new Vector<Oferta>();
	
	public Ofertas() {
		HorizontalLayout scrollableLayout = new HorizontalLayout();
	    for(int i = 0; i< 50; i++){
	      scrollableLayout.add(new Oferta());
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
	    staticElement.add(new Text("Ofertas"));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalLayout().add(staticElement, scrollableLayout);
	    this.getHorizontalLayout().getStyle().set("border","1px solid blue");
	}
}