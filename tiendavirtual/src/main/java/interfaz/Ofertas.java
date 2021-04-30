package interfaz;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import basededatos.BDPrincipal;
import basededatos.iAdmin;
import interfaz.Oferta;
import vistas.VistaOfertas;

public class Ofertas extends VistaOfertas{
	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	//public Vector<Oferta> _list_Oferta = new Vector<Oferta>();
	
	public Ofertas() {
		HorizontalLayout scrollableLayout = new HorizontalLayout();
		iAdmin adm = new BDPrincipal();

		List<basededatos.Oferta> ofertas = adm.cargarOfertas();
		for (basededatos.Oferta oferta : ofertas) {
			java.util.Date date = oferta.getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultado = datenow.compareTo(date);
			System.out.println(resultado);
			if (oferta.getActivada() && resultado == -1 ) {
				Oferta ofer = new Oferta(oferta);
			    scrollableLayout.add(ofer);
			}
			
			
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