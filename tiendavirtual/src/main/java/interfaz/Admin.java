package interfaz;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import tiendavirtual.cookiesHelper;
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
    	
    	
    	_cabecera_administrador.getCerrarSesion().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				cookiesHelper.encargado_compras = null;
				session.setAttribute("tipoUsuario", "noUser");
				session.setAttribute("admin", null);
				
				Cookie cookiecliente = new Cookie("cliente", "-1");

				Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

				cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
				cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
				cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
				cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
				VaadinService.getCurrentResponse().addCookie(cookiecliente);
				VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
				Admin admin = (Admin) session.getAttribute("adminInterfaz");
				Usuario_no_identificado usuario_no_identificado = (Usuario_no_identificado) session.getAttribute("usuarioNoIdentificado");

		    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
		    	mainView.remove(admin);
		    	mainView.add(usuario_no_identificado);
		    	
		    	

			}
		});

	}
}