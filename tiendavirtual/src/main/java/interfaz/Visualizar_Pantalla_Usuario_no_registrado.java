package interfaz;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.PendingJavaScriptResult;
import com.vaadin.flow.server.VaadinSession;

public class Visualizar_Pantalla_Usuario_no_registrado extends Visualizar_Pantalla {
	public Usuario_no_identificado _usuario_no_identificado;

	public Visualizar_Pantalla_Usuario_no_registrado(VerticalLayout vlayout) {
		super();
		_productos_Usuario = new Productos_Usuario(horizontalLayout, verticalLayout, vlayout, this);
		horizontalLayout.addComponentAsFirst(_productos_Usuario);
		
		VaadinSession session = VaadinSession.getCurrent();

    	session.setAttribute("Visualizar_Pantalla_Usuario_no_registrado", this);

        

	}
	
	
}