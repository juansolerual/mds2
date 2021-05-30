package interfaz;

import java.util.List;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.iAdmin;
import tiendavirtual.cookiesHelper;
import vistas.VistaIniciarsesion;

public class Iniciar_sesion extends VistaIniciarsesion{
	
	VaadinSession session = VaadinSession.getCurrent();
    iAdmin adm = new BDPrincipal();
	Usuario_no_identificado usuarioNoIdentificado;
	Usuario_registrado usuarioRegistrado;
	Encargado_de_compras encargado_de_compras;
	App_transportes app_transportes;
	cookiesHelper cookiesH;
	
	public Iniciar_sesion() {
			super();
			
			_recuperar_contrasena = new Recuperar_contrasena();
			_inicio_sesion_con_Facebook = new Inicio_sesion_con_Facebook();
			_inicio_sesion_con_Google = new Inicio_sesion_con_Google();
			getVaadinVerticalLayout().as(VerticalLayout.class).add(_inicio_sesion_con_Facebook.iniciarSessionFacebook);
			getVaadinVerticalLayout().as(VerticalLayout.class).add(_inicio_sesion_con_Google.iniciarSessionGoogle);
			
			
			getVaadinLoginForm().addForgotPasswordListener(e -> {
				_recuperar_contrasena.recuperarContrasena.open();
			});
			

			getVaadinLoginForm().addLoginListener(e -> {
	        	
	        	//cbn.layout.remove(cbn.lg);
	        	//cbn.layout.add(cbn.ccbn);
	    		basededatos.Transportista transportista = null;
	    		Administrador administrador = null;
	    		Cliente cliente = null;
	        	basededatos.Encargado_compras encargadoCompras = null;
	        	
	    		List<Administrador> administradores = adm.cargarAdministradores();
	    		List<Cliente> clientes = adm.cargarClientes();
	    		List<basededatos.Encargado_compras> encargadosCompras = adm.cargarEncargadosCompras();
	    		List<basededatos.Transportista> transportistas = adm.cargarTransportistas();
	    		
	    		
	    		for (basededatos.Transportista trans : transportistas) {
					if (trans.getEmail().equals(e.getUsername())) {
						if (trans.getPassword().equals(e.getPassword())) {
							transportista = trans;
							session.setAttribute("tipoUsuario", "encargado");
							session.setAttribute("transportista", trans);
							
							Cookie cookiecliente = new Cookie("cliente", String.valueOf(trans.getID()));

							Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "transportista");

							cookiecliente.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
							cookieTipoUsuario.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
							VaadinService.getCurrentResponse().addCookie(cookiecliente);
							VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					    	cookiesH = new cookiesHelper();
					    	cookiesH.transportista = trans;

							app_transportes = new App_transportes();
					        session.setAttribute("app_transportes", app_transportes);
					    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");

					    	mainView.removeAll();
					    	mainView.add(app_transportes);
			    	    	
			    	    	System.out.println("app transportes");
						}
					}
				}
	    		
	    		for (basededatos.Encargado_compras encargado : encargadosCompras) {
					if (encargado.getEmail().equals(e.getUsername())) {
						if (encargado.getPassword().equals(e.getPassword())) {
							encargadoCompras = encargado;
							session.setAttribute("tipoUsuario", "encargado");
							session.setAttribute("encargado", encargado);
							
							Cookie cookiecliente = new Cookie("cliente", String.valueOf(encargado.getID()));

							Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "encargado");

							cookiecliente.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
							cookieTipoUsuario.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
							VaadinService.getCurrentResponse().addCookie(cookiecliente);
							VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
					    	cookiesH = new cookiesHelper();
					    	cookiesH.encargado_compras = encargado;

							encargado_de_compras = new Encargado_de_compras();
					        session.setAttribute("encargado_de_compras", encargado_de_compras);

					        mainView.removeAll();
					        mainView.add(encargado_de_compras);
			    	    	
			    	    	System.out.println("encargado");
						}
						
					}
				}
	    		
	    		for (basededatos.Cliente client : clientes) {
					if (client.getEmail().equals(e.getUsername())) {
						if (client.getPassword().equals(e.getPassword())) {
							cliente = client;						
							session.setAttribute("tipoUsuario", "cliente");
							session.setAttribute("cliente", cliente);
							
							Cookie cookiecliente = new Cookie("cliente", String.valueOf(cliente.getID()));

							Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "cliente");

							cookiecliente.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
							cookieTipoUsuario.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
							VaadinService.getCurrentResponse().addCookie(cookiecliente);
							VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
					    	cookiesH = new cookiesHelper();
					    	cookiesH.cliente = client;
					    	session.setAttribute(String.valueOf(cookiesHelper.idUsuario), session.getAttribute("carrito_invitado"));
					    	

			    	    	usuarioRegistrado = new Usuario_registrado();
					        session.setAttribute("usuarioRegistrado", usuarioRegistrado);

					        mainView.removeAll();
					        mainView.add(usuarioRegistrado);
			    	    	
			    	    	System.out.println("cliente");
						}
						
					}
				}
	    		
	    		for (basededatos.Administrador adminis : administradores) {
					if (adminis.getEmail().equals(e.getUsername())) {
						if (adminis.getPassword().equals(e.getPassword())) {
							administrador = adminis;
							session.setAttribute("tipoUsuario", "admin");
							session.setAttribute("admin", administrador);
							
							Cookie cookiecliente = new Cookie("cliente", String.valueOf(administrador.getID()));

							Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "admin");

							cookiecliente.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
							cookieTipoUsuario.setMaxAge(60 * 60 * 24 * 7 * 52); // define after how many *seconds* the cookie should expire
							cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
							VaadinService.getCurrentResponse().addCookie(cookiecliente);
							VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
					    	cookiesH = new cookiesHelper();
					    	cookiesH.administrador = adminis;

			    	    	Admin admin = new Admin();
					        session.setAttribute("adminInterfaz", admin);

					        mainView.removeAll();
					        mainView.add(admin);
			    	    	
			    	    	System.out.println("admin");
						}
						
					}
				}
	    		System.out.println("Final login");

			});
	    		

			
	}

	public Usuario_no_identificado _usuario_no_identificado;
	public Recuperar_contrasena _recuperar_contrasena;
	public Inicio_sesion_con_Google _inicio_sesion_con_Google;
	public Inicio_sesion_con_Facebook _inicio_sesion_con_Facebook;

	public void Validar_inicio_sesion() {
		throw new UnsupportedOperationException();
	}
	
	
}