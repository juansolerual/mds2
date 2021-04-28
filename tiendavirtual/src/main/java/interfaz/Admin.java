package interfaz;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import vistas.VistaAdmin;

//import basededatos.iAdmin;

public class Admin extends VistaAdmin{
	
	//public iAdmin _iAdmin;
	public Vista_centro_de_mensajes_administrador _vista_centro_de_mensajes_administrador;
	public Vista_Categoria_Admin _vista_Categoria_Admin;
	public Vista_gestion_empleados _vista_gestion_empleados;
	public Vista_Ofertas_Admin _vista_Ofertas_Admin;
	public Vista_producto_Admin _vista_producto_Admin;
	public Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador;
	public Cabecera_administrador _cabecera_administrador;
	public VerticalLayout vlayout;

	
	public Admin() {
		super();
		vlayout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		_cabecera_administrador = new Cabecera_administrador();
		_visualizar_Pantalla_Principal_Administrador = new Visualizar_Pantalla_Principal_Administrador(vlayout);
		vlayout.add(_cabecera_administrador);
		vlayout.add(_visualizar_Pantalla_Principal_Administrador);
		VaadinSession session = VaadinSession.getCurrent();

    	session.setAttribute("verticalLayoutAdmin", vlayout);

    	session.setAttribute("visualizar_Pantalla_Principal_Administrador", _visualizar_Pantalla_Principal_Administrador);


	}
}