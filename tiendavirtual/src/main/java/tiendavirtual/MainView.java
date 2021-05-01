package tiendavirtual;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Categoria;
import basededatos.Cliente;
import basededatos.Usuario;
import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.iAdmin;
import interfaz.Admin;
import interfaz.Cabecera_Usuario;
import interfaz.Encargado_de_compras;
import interfaz.Iniciar_sesion;
import interfaz.Producto_usuario;
import interfaz.Productos_Usuario;
import interfaz.Usuario_no_identificado;
import interfaz.Usuario_registrado;

import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Tienda Virtual",
        shortName = "Tienda App",
        description = "Tienda Virtual MDS2.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
	
	//Cabecera_Usuario cabeceraUsuario = new Cabecera_Usuario();
	
	Usuario_no_identificado usuarioNoIdentificado = new Usuario_no_identificado();
	Usuario_registrado usuarioRegistrado;
	Encargado_de_compras encargado_de_compras;
	VaadinSession session;
	
	Iniciar_sesion _iniciar_sesion = new Iniciar_sesion();
    iAdmin adm = new BDPrincipal();

	cookiesHelper cookiesH = new cookiesHelper();
	
    public MainView (@Autowired GreetService service) {

       
    	
		
		
//		Cookie[] readCookie = VaadinRequest.getCurrent().getCookies();
//		String usuario = null;
//		int idUsuario = 0;
//		for (Cookie cookie : readCookie) {
//			System.out.println("name" + cookie.getName());
//			System.out.println("value" + cookie.getValue());
//			if (cookie.getName().equals("tipoUsuario")) {
//				usuario = cookie.getValue();
//			}
//			if (cookie.getName().equals("cliente")){
//				idUsuario =  Integer.parseInt(cookie.getValue());
//			}
//			
//		}
    	
    	
    	
    	
    	session = VaadinSession.getCurrent();
    	session.setAttribute("MainView", this);
        session.setAttribute("usuarioNoIdentificado", usuarioNoIdentificado);
        
        //String usuario = (String)session.getAttribute("tipoUsuario");
//        if (usuario != null) {
//        	if (usuario.equals("cliente")) {
//        		if (idUsuario != 0) {
//            		Cliente cliente = adm.cargarCliente(idUsuario);
//    				session.setAttribute("cliente", cliente);
//            	}
//            	usuarioRegistrado = new Usuario_registrado();
//    	    	remove(usuarioNoIdentificado);
//    	    	add(usuarioRegistrado);
//            }else if (usuario.equals("admin")) {
//            	if (idUsuario != 0) {
//            		Administrador administrador = adm.cargarAdministrador(idUsuario);
//    				session.setAttribute("admin", administrador);
//            	}
//            	Admin admin = new Admin();
//    	    	remove(usuarioNoIdentificado);
//    	    	add(admin);
//            }else {
//                add(usuarioNoIdentificado);
//
//            }
//        }else {
//            add(usuarioNoIdentificado);
//
//        }
        
        if (cookiesHelper.isCliente()) {
        	System.out.println("is cliente");
        	usuarioRegistrado = new Usuario_registrado();
	        session.setAttribute("usuarioRegistrado", usuarioRegistrado);
	    	remove(usuarioNoIdentificado);
	    	add(usuarioRegistrado);
        }else if (cookiesHelper.isAdministrador()) {
        	System.out.println("is admin");

        	Admin admin = new Admin();
	        session.setAttribute("adminInterfaz", admin);
	    	remove(usuarioNoIdentificado);
	    	add(admin);
        }else if (cookiesHelper.isEncargadoCompras()) {
        	System.out.println("is encargado");

        	encargado_de_compras = new Encargado_de_compras();
	        session.setAttribute("encargado_de_compras", encargado_de_compras);
	    	remove(usuarioNoIdentificado);
	    	add(encargado_de_compras);
        }else if (cookiesHelper.isNoRegistrado()){
            add(usuarioNoIdentificado);
        }
        
        
       
        
        
        
        

        login();
        
    }
    
    public void login() {
    	
    		usuarioNoIdentificado._iniciar_sesion.getVaadinLoginForm().addLoginListener(e -> {
        	
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
					transportista = trans;
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


						encargado_de_compras = new Encargado_de_compras();
				        session.setAttribute("encargado_de_compras", encargado_de_compras);

		    	    	remove(usuarioNoIdentificado);
		    	    	add(encargado_de_compras);
		    	    	
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


		    	    	usuarioRegistrado = new Usuario_registrado();
				        session.setAttribute("usuarioRegistrado", usuarioRegistrado);

		    	    	remove(usuarioNoIdentificado);
		    	    	add(usuarioRegistrado);
		    	    	
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


		    	    	Admin admin = new Admin();
				        session.setAttribute("adminInterfaz", admin);

		    	    	remove(usuarioNoIdentificado);
		    	    	add(admin);
		    	    	
		    	    	System.out.println("admin");
					}
					
				}
			}
    		
    		
    	    if (e.getUsername().equals("admin")) {
    	    	
    	    	//Administrador ad = new Administrador();
    	    	//remove(cbn);
    	    	//add(ad);
    	    
    	    		
    	    	
    	    	/*ad.ccbn.getSalir().setVisible(true);
    	    	
    	    	ad.ccbn.getSalir().addClickListener(new ComponentEventListener() {
    				@Override
    				public void onComponentEvent(ComponentEvent event) {
    					 
    					cbn.lg = new Login();
    					login();
    					remove(ad);
    					add(cbn);
    					
    				}
    			});*/
    	    	
    	    	
    	    }
    	    else if (e.getUsername().equals("usuario")) {
    	    	
    	    	
    	    	
    	    	
//    	    	usuarioRegistrado = new Usuario_registrado();
//    	    	
//    	    	session.setAttribute("username", "usuario");
//
//    	        session.setAttribute("usuarioRegistrado", usuarioRegistrado);
//
//    	    	remove(usuarioNoIdentificado);
//    	    	add(usuarioRegistrado);
    	    	//vlayout.remove(_iniciar_sesion);
    	    	//vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);
    	    	/*CibernautaRegistrado cr = new CibernautaRegistrado();
    	    	remove(cbn);
    	    	add(cr);
    	    	
    	    	
    	    	
    	    	
    	    	
    	    	
    	    	cr.ccbn.getSalir().setVisible(true);
    	    	cr.ccbn.getSalir().addClickListener(new ComponentEventListener() {
    				@Override
    				public void onComponentEvent(ComponentEvent event) {
    					 
    					cbn.lg = new Login();
    					login();
    					remove(cr);
    					add(cbn);
    					
    				}
    			});
    	    	 
    	    	 */
    	        
    	    } else {
    	    	//Notification.show("Este usuario no esta registrado");
    	    }
    	});
    	
    }
    

}
