package interfaz;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import tiendavirtual.cookiesHelper;
import vistas.VistaEncargadodecompras;

//import basededatos.iEncargado_de_compras;



public class Encargado_de_compras extends VistaEncargadodecompras{
	//public iEncargado_de_compras _iEncargado_de_compras;
	
	public Vista_centro_de_mensajes_administrador _vista_centro_de_mensajes_administrador;
	public Vista_Categoria_Admin _vista_Categoria_Admin;
	public Vista_gestion_empleados _vista_gestion_empleados;
	public Vista_Ofertas_Admin _vista_Ofertas_Admin;
	public Vista_producto_Admin _vista_producto_Admin;
	//public Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador;
	public Vista_listado_de_compras _vista_listado_de_compras;
	public Cabecera_encargado_compras _cabecera_encargado_compras;
	public VerticalLayout vlayout;


	public Encargado_de_compras() {
		super();
		vlayout = this.getVerticalLayoutEncargado().as(VerticalLayout.class);
		_cabecera_encargado_compras = new Cabecera_encargado_compras();
		//_visualizar_Pantalla_Principal_Administrador = new Visualizar_Pantalla_Principal_Administrador(vlayout);
		_vista_listado_de_compras = new Vista_listado_de_compras();
		vlayout.add(_cabecera_encargado_compras);
		vlayout.add(_vista_listado_de_compras);
		VaadinSession session = VaadinSession.getCurrent();

		
    	session.setAttribute("verticalLayoutEncargado", vlayout);

    	session.setAttribute("Vista_listado_de_compras", _vista_listado_de_compras);
    	
    	_cabecera_encargado_compras.getCerrarSesion().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				cookiesHelper.encargado_compras = null;
				session.setAttribute("tipoUsuario", "noUser");
				session.setAttribute("encargado", null);
				
				Cookie cookiecliente = new Cookie("cliente", "-1");

				Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

				cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
				cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
				cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
				cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
				VaadinService.getCurrentResponse().addCookie(cookiecliente);
				VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
				Encargado_de_compras encargado_de_compras = (Encargado_de_compras) session.getAttribute("encargado_de_compras");
				Usuario_no_identificado usuario_no_identificado = (Usuario_no_identificado) session.getAttribute("usuarioNoIdentificado");

		    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
		    	mainView.remove(encargado_de_compras);
		    	mainView.add(usuario_no_identificado);
		    	
		    	

			}
		});

	}
	
	
}