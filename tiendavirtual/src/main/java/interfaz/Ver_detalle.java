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

import basededatos.Entregado;
import basededatos.Enviado;
import basededatos.Pendiente;

public class Ver_detalle{
	public Lista_compras _lista_compras;
	public Dialog verDetalleDialog;

	public Ver_detalle(Pendiente pendiente) {
		super();
		verDetalleDialog = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		Label tituloUploadDialog = new Label("Ver detalle pedido");
		dialogUploadHorizontal.add(tituloUploadDialog);
		verDetalleDialog.setWidth("1650px");
		verDetalleDialog.setHeight("1200px");
		verDetalleDialog.setCloseOnEsc(true);
		verDetalleDialog.setCloseOnOutsideClick(true);

		//dialogDescripcion.setModal(false);
		verDetalleDialog.setDraggable(true);
		verDetalleDialog.setResizable(true);
		
		Button closeButton =  new Button("Cerrar");

		Elementos_comunes_carrito elementos = new Elementos_comunes_carrito(pendiente);
		
		VerticalLayout dialogVertical = new VerticalLayout(elementos);
		HorizontalLayout dialogButtons = new HorizontalLayout(closeButton);
		closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				verDetalleDialog.close();
			}
			
		});
		verDetalleDialog.add(dialogUploadHorizontal,dialogVertical,dialogButtons);
		
	}
	
	public Ver_detalle(Enviado enviado) {
		super();
		verDetalleDialog = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		Label tituloUploadDialog = new Label("Ver detalle pedido");
		dialogUploadHorizontal.add(tituloUploadDialog);
		verDetalleDialog.setWidth("1650px");
		verDetalleDialog.setHeight("1200px");
		verDetalleDialog.setCloseOnEsc(true);
		verDetalleDialog.setCloseOnOutsideClick(true);

		//dialogDescripcion.setModal(false);
		verDetalleDialog.setDraggable(true);
		verDetalleDialog.setResizable(true);
		
		Button closeButton =  new Button("Cerrar");

		Elementos_comunes_carrito elementos = new Elementos_comunes_carrito(enviado);
		
		VerticalLayout dialogVertical = new VerticalLayout(elementos);
		HorizontalLayout dialogButtons = new HorizontalLayout(closeButton);
		closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				verDetalleDialog.close();
			}
			
		});
		verDetalleDialog.add(dialogUploadHorizontal,dialogVertical,dialogButtons);
		
	}

	public Ver_detalle(Entregado entregadoTemp) {
		// TODO Auto-generated constructor stub
		super();
		verDetalleDialog = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		Label tituloUploadDialog = new Label("Ver detalle pedido");
		dialogUploadHorizontal.add(tituloUploadDialog);
		verDetalleDialog.setWidth("1650px");
		verDetalleDialog.setHeight("1200px");
		verDetalleDialog.setCloseOnEsc(true);
		verDetalleDialog.setCloseOnOutsideClick(true);

		//dialogDescripcion.setModal(false);
		verDetalleDialog.setDraggable(true);
		verDetalleDialog.setResizable(true);
		
		Button closeButton =  new Button("Cerrar");

		Elementos_comunes_carrito elementos = new Elementos_comunes_carrito(entregadoTemp);
		
		VerticalLayout dialogVertical = new VerticalLayout(elementos);
		HorizontalLayout dialogButtons = new HorizontalLayout(closeButton);
		closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				verDetalleDialog.close();
			}
			
		});
		verDetalleDialog.add(dialogUploadHorizontal,dialogVertical,dialogButtons);
	}
	
}