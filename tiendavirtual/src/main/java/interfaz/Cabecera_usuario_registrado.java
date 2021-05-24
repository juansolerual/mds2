package interfaz;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import tiendavirtual.cookiesHelper;

public class Cabecera_usuario_registrado extends Cabecera_Usuario{
	private event _cerrar_sesion;
	public Usuario_registrado _usuario_registrado;
	//public Barra_busqueda_usuario_registrado _barra_busqueda_usuario_registrado;
	//public Boton_acceder_mi_cuenta _boton_acceder_mi_cuenta;

	public void Cerrar_sesion() {
		System.out.println("Cerrar sesion cabecera usuario registrado");
		cookiesHelper.cliente = null;
		VaadinSession session = VaadinSession.getCurrent();
		session.setAttribute("tipoUsuario", "noUser");
		session.setAttribute("cliente", null);
		
		
		Cookie cookiecliente = new Cookie("cliente", "-1");

		Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

		cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
		cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
		cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
		cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
		VaadinService.getCurrentResponse().addCookie(cookiecliente);
		VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
		Usuario_registrado usuarioRegistrado = (Usuario_registrado) session.getAttribute("usuarioRegistrado");
		Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
    	mainView.remove(usuarioRegistrado);
    	mainView.add(usuario_no_identificado);
    	
	}
	public Cabecera_usuario_registrado() {
		super();
		this.getIniciarSesionButton().setVisible(false);
		this.getRegistrarseButton().setVisible(false);
		
	}
}