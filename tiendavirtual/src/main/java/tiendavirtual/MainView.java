package tiendavirtual;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
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

import tiendavirtual.interfaz.Cabecera_Usuario;
import tiendavirtual.interfaz.Iniciar_sesion;
import tiendavirtual.interfaz.Producto_usuario;
import tiendavirtual.interfaz.Productos_Usuario;
import tiendavirtual.interfaz.Usuario_no_identificado;
import tiendavirtual.interfaz.Usuario_registrado;

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
	
	Iniciar_sesion _iniciar_sesion = new Iniciar_sesion();

	
	
    public MainView (@Autowired GreetService service) {

       
    		
    	
    	add(usuarioNoIdentificado);
        
        login();
        
    }
    
    public void login() {
    	
    		usuarioNoIdentificado._iniciar_sesion.getVaadinLoginForm().addLoginListener(e -> {
        	
        	//cbn.layout.remove(cbn.lg);
        	//cbn.layout.add(cbn.ccbn);
        	
        	
        	
        	
        	
    	    if (e.getUsername().equals("admin")) {
    	    	
    	    	//Administrador ad = new Administrador();
    	    	//remove(cbn);
    	    	//add(ad);
    	    	
    	    	System.out.println("admin");
    	    		
    	    	
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
    	    	
    	    	usuarioRegistrado = new Usuario_registrado();
    	    	remove(usuarioNoIdentificado);
    	    	add(usuarioRegistrado);
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
