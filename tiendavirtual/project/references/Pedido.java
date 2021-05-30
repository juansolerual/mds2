package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Pedido extends HorizontalLayout{
	private event _marcar_como_entregado;
	private event _ir__a_pagina_principal;
	public Lista_pedidos_pendientes _lista_pedidos_pendientes;
	public Lista_pedidos_entregados _lista_pedidos_entregados;
	public Ver_detalles _ver_detalles;
	
	public VerticalLayout v1 = new VerticalLayout();  // Cliente y direccion
	public VerticalLayout v2 = new VerticalLayout();  // Pedido y estado
	public VerticalLayout v3 = new VerticalLayout();  
	public VerticalLayout v4 = new VerticalLayout();
	public Label numeroPedido = new Label();
	public Label cliente = new Label();
	public Label direccion = new Label();
	public Label pedido = new Label();
	public Label numeroArticulos = new Label();
	public Label estadoPedido = new Label();
	public Label entregadoPor = new Label();
	public Button marcarEntregado = new Button("Marcar como entregado");
	public Button verDetalles = new Button("Ver detalles");
	protected Ver_detalle verDetalle;


	public Pedido() {
		super();
		setWidth("100%");
		v1.add(numeroPedido,cliente, direccion);
		v1.getStyle().set("border", "1px solid grey").set("border-radius", "25px").set("margin", "20px");
		v2.add(pedido, numeroArticulos, entregadoPor, estadoPedido);
		v2.getStyle().set("border", "1px solid grey").set("border-radius", "25px").set("margin", "20px");
		v3.add(marcarEntregado, verDetalles);
		marcarEntregado.setWidth("70%");
		verDetalles.setWidth("70%");
		v3.getStyle().set("border", "1px solid grey").set("border-radius", "25px").set("margin", "20px").set("justify-content", "center").set("align-items", "center").set("align-content", "center");
		add(v1, v2, v3);
		getStyle().set("border", "1px solid #1676f3").set("border-radius", "25px").set("padding", "20px");
	}

	public void Marcar_como_entregado() {
		throw new UnsupportedOperationException();
	}

	public void Ir__a_pagina_principal() {
		throw new UnsupportedOperationException();
	}
}