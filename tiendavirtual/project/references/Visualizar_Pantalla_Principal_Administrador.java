package interfaz;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import vistas.VistaProductousuario;

public class Visualizar_Pantalla_Principal_Administrador extends Visualizar_Pantalla {
	public Admin _admin;
	public Productos_Administrador _productos_administrador;
	//public Acceder_a_cuenta_admin _acceder_a_cuenta_admin;
	public Visualizar_Pantalla_Principal_Administrador(VerticalLayout vlayout) {
		super();
		VaadinSession session = VaadinSession.getCurrent();

		_productos_administrador = new Productos_Administrador();

		this.horizontalLayout.removeAll();
		
		session.setAttribute("horizontalLayoutAdministrador", horizontalLayout);
		
		//this.horizontalLayout.add(nuevoProducto);
		this.horizontalLayout.add(_productos_administrador);
		this.horizontalLayout.add(_elementos_comunes_pantalla_principal.get_categorias());

	}
	
}