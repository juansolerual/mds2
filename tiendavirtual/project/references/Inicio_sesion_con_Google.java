package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class Inicio_sesion_con_Google {
	public Iniciar_sesion _iniciar_sesion;
	
	public Button iniciarSessionGoogle;

	public Inicio_sesion_con_Google() {
		super();
		iniciarSessionGoogle= new Button("Inicio de sesión con Google");
		iniciarSessionGoogle.setIcon(new Icon(VaadinIcon.GOOGLE_PLUS));
	}
}