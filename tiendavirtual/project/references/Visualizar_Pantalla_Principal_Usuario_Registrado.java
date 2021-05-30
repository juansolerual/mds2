package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Visualizar_Pantalla_Principal_Usuario_Registrado extends Visualizar_Pantalla {
	public Usuario_registrado _usuario_registrado;
	//public Productos_Usuario _productos_Usuario; 

	public Visualizar_Pantalla_Principal_Usuario_Registrado(VerticalLayout vlayout) {
		super();
		_productos_Usuario = new Productos_Usuario("Visualizar_Pantalla_Principal_Usuario_Registrado");
		String widthProductos = _productos_Usuario.getHorizontalProductos().getWidth();
		String widthHeight= _productos_Usuario.getHorizontalProductos().getHeight();

		
		_elementos_comunes_pantalla_principal._categorias.getHorizontalLayout().setWidth(widthProductos);
		_elementos_comunes_pantalla_principal._categorias.getHorizontalLayout().setHeight(widthHeight);

		horizontalLayout.addComponentAsFirst(_productos_Usuario);
		
	}
	
}