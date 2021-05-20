package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class Inicio_sesion_con_Facebook {
	public Iniciar_sesion _iniciar_sesion;
	
	public Button iniciarSessionFacebook;

	public Inicio_sesion_con_Facebook() {
		super();
		iniciarSessionFacebook= new Button("Inicio de sesión con FaceBook");
		iniciarSessionFacebook.setIcon(new Icon(VaadinIcon.FACEBOOK));
	}
	
}