package interfaz;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import tiendavirtual.cookiesHelper;
import vistas.VistaCabeceraadministrador;

public class Cabecera_administrador extends VistaCabeceraadministrador{
	public Admin _admin;
	//public Barra_busqueda_administrador _barra_busqueda_administrador;

	public void Cerrar_sesion_administrador() {
		VaadinSession session = VaadinSession.getCurrent();

		cookiesHelper.administrador = null;
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
		Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
    	mainView.remove(admin);
    	mainView.add(usuario_no_identificado);
	}
}