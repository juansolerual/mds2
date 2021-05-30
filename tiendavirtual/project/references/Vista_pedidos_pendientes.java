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
import basededatos.Enviado;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.iApp_transportes;
import basededatos.iEncargado_de_compras;
import vistas.VistaPedidospendientes;

public class Vista_pedidos_pendientes extends VistaPedidospendientes{
	private event _ir__a_pagina_principal;
	public App_transportes _app_transportes;
	public Lista_pedidos_pendientes _lista_pedidos_pendientes;
	public VerticalLayout verticalVistaPedidos;
	protected Enviado enviadoTemp;
	protected Pedido pedidoTemp;
	public VerticalLayout scrollableLayout;
	private iApp_transportes apptrans;


	public Vista_pedidos_pendientes() {
		super();
		apptrans = new BDPrincipal();
		List<Enviado> pedidosEnviados = apptrans.cargarPedidosEnviados();
		verticalVistaPedidos = this.getVerticalPendientes().as(VerticalLayout.class);
		
		scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_pedidos_entregadoss");
		
		for (Enviado enviado : pedidosEnviados) {
			System.out.println(" PEDIDO enviado " + enviado.getID());
			
			Pedido pedido = new Pedido();
			pedido.entregadoPor.setText("Ha sido gestionado por: " + enviado.getMarcado_por().getNombre() + " " + enviado.getMarcado_por().getApellidos());
			pedido.cliente.setText(
					enviado.getRealizado_por().getNombre() + " " + enviado.getRealizado_por().getApellidos());
			pedido.direccion.setText(enviado.getRealizado_por().getDireccion());
			if (enviado.getPagado()) {
				pedido.estadoPedido.setText("Estado del pedido: en transito");
			}
			List<Lineas_de_Pedido> carrito = apptrans.cargarCarrito(enviado.getID());
			pedido.pedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			pedido.numeroArticulos.setText(carrito.size() + "articulos");
			scrollableLayout.add(pedido);
			pedido.marcarEntregado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					enviadoTemp = enviado;
					pedidoTemp = pedido;
					marcarComoEntregado();
					
					
				}
			});
			
			pedido.verDetalles.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					enviadoTemp = enviado;
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
			staticElement.add(new Text("Pedidos enviados"));
			verticalVistaPedidos.add(staticElement, scrollableLayout);	
			
	}
	
	protected void marcarComoEntregado() {
		// TODO Auto-generated method stub
		if (apptrans.marcarComoEntregado(enviadoTemp.getID())) {
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
	
	protected void verDetalle() {
		// TODO Auto-generated method stub
		Lista_compras lcTemp = new Lista_compras();
		lcTemp.verDetalle = new Ver_detalle(enviadoTemp);
		lcTemp.verDetalle.verDetalleDialog.open();
	}


	public void Ir__a_pagina_principal() {
		throw new UnsupportedOperationException();
	}
}