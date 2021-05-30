package interfaz;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import vistas.VistaCabecerausuario;

public class Cabecera_Usuario extends VistaCabecerausuario{
	public Cabecera_Usuario() {
		this.getCarritoButton().setIcon(new Icon(VaadinIcon.CART));
		
	}
}
