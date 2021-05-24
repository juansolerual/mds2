package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import basededatos.Cliente;

public class Ver_direccion {
	public Vista_cuenta_usuario _vista_cuenta_usuario;
	public Dialog dialogDirecciones;

	public Ver_direccion(Cliente cliente) {
		super();
		  dialogDirecciones = new Dialog();
		    
		   

			HorizontalLayout dialogHorizontal = new HorizontalLayout();
			Label tituloDialog = new Label("Direcciones");
			dialogHorizontal.add(tituloDialog);
			dialogDirecciones.setWidth("800px");
			dialogDirecciones.setHeight("600px");
			
			
			dialogDirecciones.setModal(false);
			dialogDirecciones.setDraggable(true);
			dialogDirecciones.setResizable(true);
			//dialog.add(new Text("Close me with the esc-key or an outside click"));
			TextField direccion = new TextField(cliente.getDireccion());
			direccion.setLabel("Direccion: ");
			direccion.getStyle().set("margin", "20px").set("width", "400px");
			Button guardar = new Button("Guardar");
			guardar.getStyle().set("margin", "20px");
			
			Button cancelButton = new Button("Cancelar", event -> {
			    dialogDirecciones.close();
			});
			cancelButton.getStyle().set("margin", "20px");

			// Cancel action on ESC press
			Shortcuts.addShortcutListener(dialogDirecciones, () -> {
			    dialogDirecciones.close();
			}, Key.ESCAPE);
			guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					//int result = adm.guardarCategoria(aCategoria);
					dialogDirecciones.close();
					cliente.setDireccion(direccion.getValue());

					
				}
				
			});
			VerticalLayout dialogVertical = new VerticalLayout(direccion);
			HorizontalLayout dialogButtons = new HorizontalLayout(guardar, cancelButton);
			dialogHorizontal.getStyle().set("margin", "20px").set("width", "100%");
			dialogVertical.getStyle().set("margin", "20px").set("width", "100%");
			Label mesageEsc = new Label("o pulsa ESC para salir");

			dialogDirecciones.add(dialogHorizontal, dialogVertical, dialogButtons, mesageEsc);
	}

	

	public void showDialog() {
		// TODO Auto-generated method stub
		dialogDirecciones.open();
		
	}
	
}