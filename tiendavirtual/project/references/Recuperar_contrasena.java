package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class Recuperar_contrasena {
	public Iniciar_sesion _iniciar_sesion;
	public Button recuperarContrasenaButton;
	public Dialog recuperarContrasena;

	public Recuperar_contrasena() {
		super();
		recuperarContrasenaButton = new Button("Enviar solicitud de reseteo de contraseña");
		recuperarContrasena = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		Label tituloUploadDialog = new Label("Recuperar contraseña");
		dialogUploadHorizontal.add(tituloUploadDialog);
		recuperarContrasena.setWidth("800px");
		recuperarContrasena.setHeight("600px");
		recuperarContrasena.setCloseOnEsc(true);
		recuperarContrasena.setCloseOnOutsideClick(true);

		//dialogDescripcion.setModal(false);
		recuperarContrasena.setDraggable(true);
		recuperarContrasena.setResizable(true);
		TextArea descripcion = new TextArea("Correo electrónico: ");
		Button closeButton =  new Button("Cerrar");
		VerticalLayout dialogVertical = new VerticalLayout(descripcion);
		HorizontalLayout dialogButtons = new HorizontalLayout(recuperarContrasenaButton, closeButton);
		closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				recuperarContrasena.close();
			}
			
		});
		recuperarContrasena.add(dialogUploadHorizontal,dialogVertical,dialogButtons);
		recuperarContrasenaButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				System.out.println("click ver recuperar contraseña");
				Notification notification = Notification.show("Se ha enviado un correo electrónico para restablecer la contraseña", 3000,
						Position.MIDDLE);
				
			}
		});
    
	}
	
}