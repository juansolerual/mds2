package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import tiendavirtual.cookiesHelper;

public class Vista_pagina_principal extends HorizontalLayout{
	public App_transportes _app_transportes;
	public Ir_a_pedidos_entregados _ir_a_pedidos_entregados;
	public Ir_a_pedidos_pendientes _ir_a_pedidos_pendientes;
	public Button pedidosEntregadosButton;
	public Button pedidosPendientesButton;
	public Button cerrarSesion;
	public Label usuario;

	
	public Vista_pagina_principal() {
		super();
		pedidosEntregadosButton = new Button("Ver pedidos Entregados");
		pedidosPendientesButton = new Button("Ver pedidos Pendientes");
		cerrarSesion = new Button("Cerrar sesion");
		usuario = new Label();
		usuario.getStyle().set("margin-right", "100px").set("margin-top", "10px").set("font-weight", "bold").set("margin", "20px");
		usuario.setText(cookiesHelper.transportista.getNombre() + " " +cookiesHelper.transportista.getNombre() );
		
		add(usuario, pedidosEntregadosButton, pedidosPendientesButton, cerrarSesion);
		
		
	}
}