package interfaz;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaVisualizarpantalla;

public class Visualizar_Pantalla extends VistaVisualizarpantalla{

	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	//public Productos_Administrador _productos_administrador;
	public Productos_Usuario _productos_Usuario;
	public HorizontalLayout horizontalLayout;
	public VerticalLayout verticalLayout;
	
	public Visualizar_Pantalla() {
		super();
		horizontalLayout = this.getHorizontalSplit().as(HorizontalLayout.class);
		verticalLayout = this.getVerticualLayout();

		
		_elementos_comunes_pantalla_principal = new Elementos_comunes_pantalla_principal();
		
		horizontalLayout.add(_elementos_comunes_pantalla_principal.get_categorias());
		verticalLayout.add(_elementos_comunes_pantalla_principal.get_ofertas());
		
	} 

}
