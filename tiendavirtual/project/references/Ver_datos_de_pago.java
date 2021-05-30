package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import basededatos.Cliente;

public class Ver_datos_de_pago {
	public Vista_cuenta_usuario _vista_cuenta_usuario;
	public Dialog dialogDatosDePago;

	public Ver_datos_de_pago(Cliente cliente) {
		super();
		
		    dialogDatosDePago = new Dialog();
			
			HorizontalLayout dialogHorizontalDatosPago = new HorizontalLayout();
			Label tituloDialogDatosPago = new Label("Datos de Pago:");
			dialogHorizontalDatosPago.add(tituloDialogDatosPago);
			dialogDatosDePago.setWidth("800px");
			dialogDatosDePago.setHeight("600px");
			
			
			dialogDatosDePago.setModal(false);
			dialogDatosDePago.setDraggable(true);
			dialogDatosDePago.setResizable(true);
			//dialog.add(new Text("Close me with the esc-key or an outside click"));
			ComboBox<String> formaDePago = new ComboBox<String>();
			formaDePago.setLabel("Forma de pago" );
			formaDePago.setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");
			formaDePago.setValue(cliente.getFormaDePago());
			formaDePago.getStyle().set("margin", "20px").set("width", "400px");

			TextField datosDePago = new TextField("Datos de pago :");
			datosDePago.getStyle().set("margin", "20px").set("width", "400px");
			datosDePago.setValue(cliente.getDatosPago());
			

			Button guardarDatosPago = new Button("Guardar");
			guardarDatosPago.getStyle().set("margin", "20px");
			
			Button cancelButtonDatosPago = new Button("Cancelar", event -> {
			    dialogDatosDePago.close();
			});
			cancelButtonDatosPago.getStyle().set("margin", "20px");

			// Cancel action on ESC press
			Shortcuts.addShortcutListener(dialogDatosDePago, () -> {
			    dialogDatosDePago.close();
			}, Key.ESCAPE);
			guardarDatosPago.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					//int result = adm.guardarCategoria(aCategoria);
					cliente.setFormaDePago(formaDePago.getValue());
					cliente.setDatosPago(datosDePago.getValue());
					dialogDatosDePago.close();

					
				}
				
			});
			VerticalLayout dialogVerticalDatosPago = new VerticalLayout(formaDePago, datosDePago);
			HorizontalLayout dialogButtonsDatosPago = new HorizontalLayout(guardarDatosPago, cancelButtonDatosPago);
			dialogHorizontalDatosPago.getStyle().set("margin", "20px").set("width", "100%");
			dialogVerticalDatosPago.getStyle().set("margin", "20px").set("width", "100%");
			Label mesageEscDatosPago = new Label("o pulsa ESC para salir");

			dialogDatosDePago.add(dialogHorizontalDatosPago, dialogVerticalDatosPago, dialogButtonsDatosPago, mesageEscDatosPago);
	}
	
	public void showDialog(){
		dialogDatosDePago.open();
	}
	
	public void closeDialog() {
		dialogDatosDePago.close();
	}
}