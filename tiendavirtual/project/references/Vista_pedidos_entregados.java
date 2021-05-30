package interfaz;

import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Entregado;
import basededatos.Lineas_de_Pedido;
import basededatos.iApp_transportes;
import basededatos.iEncargado_de_compras;
import basededatos.iUsuario_registrado;
import vistas.VistaPedidosentregados;

public class Vista_pedidos_entregados extends VistaPedidosentregados {
	private event _ir__a_pagina_principal;
	public App_transportes _app_transportes;
	public Lista_pedidos_entregados _lista_pedidos_entregados;
	public VerticalLayout verticalVistaPedidos;
	protected Entregado entregadoTemp;
	protected Pedido pedidoTemp;
	private iApp_transportes apptrans;
	private VerticalLayout scrollableLayout;

	public Vista_pedidos_entregados() {
		super();
		apptrans = new BDPrincipal();
		List<Entregado> pedidosEntregados = apptrans.cargarPedidosEntregados();
		verticalVistaPedidos = this.getVerticalPedidosEntregados().as(VerticalLayout.class);
		
		scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_pedidos_entregadoss");
		
		for (Entregado entregado : pedidosEntregados) {
			Pedido pedido = new Pedido();
			pedido.marcarEntregado.setVisible(true);
			pedido.marcarEntregado.setText("Desmarcar como entregado");
			pedido.numeroPedido.setText("Numero de pedido " + entregado.getID());
			pedido.numeroPedido.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "#1676f3");
			pedido.cliente.setText(
					entregado.getRealizado_por().getNombre() + " " + entregado.getRealizado_por().getApellidos());
			pedido.direccion.setText(entregado.getRealizado_por().getDireccion());
			if (entregado.getPagado()) {
				pedido.estadoPedido.setText("Estado del pedido: Entregado");
			}
			List<Lineas_de_Pedido> carrito = apptrans.cargarCarrito(entregado.getID());
			pedido.pedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			pedido.numeroArticulos.setText("Número de articulos: " + carrito.size());
			pedido.entregadoPor.setText("Transportista: " + entregado.getGestionado_por().getNombre() + " " + entregado.getGestionado_por().getNombre());
			scrollableLayout.add(pedido);
			pedido.marcarEntregado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					entregadoTemp = entregado;
					pedidoTemp = pedido;
					desmarcarComoEntregado();
					
					
				}
			});
			
			pedido.verDetalles.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					entregadoTemp = entregado;
					pedidoTemp = pedido;
					verDetalle();
					
					
				}
			});
			
			
		}
		
		  scrollableLayout.setHeight("100%");
		    scrollableLayout.setWidth("100%");
		    // Set overflow on the y-axis to "auto".
		    // It can be also "scroll", but then you 
		    // have a scroll bar even when one isn't needed.
		    scrollableLayout.getStyle().set("overflow-y", "auto");
		    // Another element to show that it stays in the same place
		    Div staticElement = new Div();
		    staticElement.getStyle().set("margin", "20px");
			staticElement.add(new Text("Pedidos entregados"));
			verticalVistaPedidos.add(staticElement ,scrollableLayout);

	}

	protected void verDetalle() {
		// TODO Auto-generated method stub
		Lista_compras lcTemp = new Lista_compras();
		lcTemp.verDetalle = new Ver_detalle(entregadoTemp);
		lcTemp.verDetalle.verDetalleDialog.open();
	}


	protected void desmarcarComoEntregado() {
		// TODO Auto-generated method stub
		if (apptrans.desmarcarComoEntregado(entregadoTemp.getID())) {
			Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
			scrollableLayout.remove(pedidoTemp);

		}else {
			Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
		}
	}

	protected int calcularTotal(List<Lineas_de_Pedido> carrito) {

		int totalCarrito = 0;
		System.out.println("Actuiawlizar precio ");
		for (Lineas_de_Pedido ldp : carrito) {
			System.out.println("Precio sin descuento linea 1 " + ldp.getDe_un().getPrecio());
			java.util.Date date = ldp.getDe_un().getAplica_oferta().getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultado = datenow.compareTo(date);
			double precioLinea = 0;
			if (ldp.getDe_un().getAplica_oferta().getActivada() && resultado == -1) {
				if (ldp.getDe_un().getAplica_oferta().getPorcentajeOferta()) {
					precioLinea = (ldp.getDe_un().getPrecio() - (ldp.getDe_un().getPrecio()
							* (ldp.getDe_un().getAplica_oferta().getPrecioOferta() / 100)));
					System.out.println("Precio con porcentaje " + precioLinea);
				} else {
					precioLinea = (ldp.getDe_un().getAplica_oferta().getPrecioOferta());
					System.out.println("Precio sin porcentaje " + precioLinea);

				}
			} else {
				precioLinea = ldp.getDe_un().getPrecio();
				System.out.println("Precio final " + precioLinea);

			}
			System.out.println("Precio final aplicado " + precioLinea);
			totalCarrito += (precioLinea * ldp.getCantidad());
		}
		return totalCarrito;

	}

	public void Ir__a_pagina_principal() {
		throw new UnsupportedOperationException();
	}
}