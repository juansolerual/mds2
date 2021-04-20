package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Visualizar_Pantalla_Principal_Usuario_Registrado extends Visualizar_Pantalla {
	public Usuario_registrado _usuario_registrado;
	//public Productos_Usuario _productos_Usuario; 

	public Visualizar_Pantalla_Principal_Usuario_Registrado(VerticalLayout vlayout) {
		super();
		_productos_Usuario = new Productos_Usuario(horizontalLayout, verticalLayout, vlayout, this);
		
		
		horizontalLayout.addComponentAsFirst(_productos_Usuario);
		
	}
	
}