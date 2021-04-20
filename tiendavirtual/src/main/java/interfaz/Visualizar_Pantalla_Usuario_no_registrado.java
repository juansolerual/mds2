package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Visualizar_Pantalla_Usuario_no_registrado extends Visualizar_Pantalla {
	public Usuario_no_identificado _usuario_no_identificado;

	public Visualizar_Pantalla_Usuario_no_registrado(VerticalLayout vlayout) {
		super();
		_productos_Usuario = new Productos_Usuario(horizontalLayout, vlayout, this);
		horizontalLayout.addComponentAsFirst(_productos_Usuario);

	}
	
	
}