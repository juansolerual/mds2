package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;

public class Vista_carrito_Usuario_registrado extends Elementos_comunes_carrito {


	public Usuario_registrado _usuario_registrado;

	public void Realizar_pago() {
		estadoPedido.setValue("Pedido Pagado");
		pedido.setPagado(true);
	}
	
	public Vista_carrito_Usuario_registrado() {
		super();
	}

}