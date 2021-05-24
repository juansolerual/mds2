package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

import basededatos.Producto;

public class Ver_descripcion_producto_admin {
	public Producto_admin _producto_admin;
	public Dialog dialogDescripcion;

	public Ver_descripcion_producto_admin(Producto producto) {
		super();
		Dialog dialogDescripcion = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		Label tituloUploadDialog = new Label("Descripción del producto " + producto.getNombreProducto());
		dialogUploadHorizontal.add(tituloUploadDialog);
		dialogDescripcion.setWidth("800px");
		dialogDescripcion.setHeight("600px");
		dialogDescripcion.setCloseOnEsc(true);
		dialogDescripcion.setCloseOnOutsideClick(true);

		// dialogDescripcion.setModal(false);
		dialogDescripcion.setDraggable(true);
		dialogDescripcion.setResizable(true);
		TextArea descripcion = new TextArea("Descripción");
		descripcion.setValue(producto.getDescripcion());
		Button closeButton = new Button("Cerrar");
		VerticalLayout dialogVertical = new VerticalLayout(descripcion);
		HorizontalLayout dialogButtons = new HorizontalLayout(closeButton);
		closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				dialogDescripcion.close();
			}

		});
		dialogDescripcion.add(dialogUploadHorizontal, dialogVertical, dialogButtons);
		dialogDescripcion.open();
	}

}