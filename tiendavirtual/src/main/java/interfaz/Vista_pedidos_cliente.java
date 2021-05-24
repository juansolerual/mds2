package interfaz;

import java.util.ArrayList;
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
import basededatos.iUsuario_registrado;
import tiendavirtual.cookiesHelper;

public class Vista_pedidos_cliente extends VerticalLayout{


	public Vista_pedidos_cliente() {
		super();
		iUsuario_registrado apptrans = new BDPrincipal();
		List<List> listas = apptrans.cargarPedidos(cookiesHelper.cliente.getID());
		List<Enviado> pedidosEnviados = listas.get(0);
		List<Pendiente> pedidosPendientes = listas.get(1);
		List<Entregado> pedidosEntregados = listas.get(2);
		if (pedidosEnviados == null) {
			pedidosEnviados = new ArrayList<Enviado>();
		}
		if (pedidosPendientes == null) {
			pedidosPendientes = new ArrayList<Pendiente>();
		}
		
		if (pedidosEntregados == null) {
			pedidosEntregados = new ArrayList<Entregado>();
		}
		
		
		VerticalLayout scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_pedidos_entregadoss");
		
		for (Enviado enviado : pedidosEnviados) {
			System.out.println(" PEDIDO enviado " + enviado.getID());
			
			Pedido pedido = new Pedido();
			pedido.entregadoPor.setText("Ha sido gestionado por: " + enviado.getMarcado_por().getNombre() + " " + enviado.getMarcado_por().getApellidos());
			pedido.cliente.setText(
					enviado.getRealizado_por().getNombre() + " " + enviado.getRealizado_por().getApellidos());
			pedido.direccion.setText(enviado.getRealizado_por().getDireccion());
			if (enviado.getPagado()) {
				pedido.estadoPedido.setText("Estado del pedido: enviado");
			}
			List<Lineas_de_Pedido> carrito = apptrans.cargarCarrito(enviado.getID());
			pedido.pedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			pedido.numeroArticulos.setText(carrito.size() + "articulos");
			
			pedido.marcarEntregado.setText("Anular pedido");
			
			pedido.verDetalles.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					pedido.verDetalle = new Ver_detalle(enviado);
					pedido.verDetalle.verDetalleDialog.open();
				}
			});
			
			scrollableLayout.add(pedido);
//			pedido.marcarEntregado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
//				
//				@Override
//				public void onComponentEvent(ClickEvent<Button> event) {
//					// TODO Auto-generated method stub
//					if (apptrans.marcarComoEntregado(enviado.getID())) {
//						Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
//						scrollableLayout.remove(pedido);
//
//					}else {
//						Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
//					}
//				}
//			});
		}
		
		for (Entregado entregado : pedidosEntregados) {
			System.out.println(" PEDIDO entregado " + entregado.getID());
			
			Pedido pedido = new Pedido();
			pedido.entregadoPor.setText("Ha sido gestionado por: " + entregado.getMarcado_por().getNombre() + " " + entregado.getMarcado_por().getApellidos());
			pedido.cliente.setText(
					entregado.getRealizado_por().getNombre() + " " + entregado.getRealizado_por().getApellidos());
			pedido.direccion.setText(entregado.getRealizado_por().getDireccion());
			if (entregado.getPagado()) {
				pedido.estadoPedido.setText("Estado del pedido: entregado");
			}
			List<Lineas_de_Pedido> carrito = apptrans.cargarCarrito(entregado.getID());
			pedido.pedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			pedido.numeroArticulos.setText(carrito.size() + "articulos");
			
			pedido.marcarEntregado.setVisible(false);
			
			pedido.verDetalles.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					pedido.verDetalle = new Ver_detalle(entregado);
					pedido.verDetalle.verDetalleDialog.open();
				}
			});
			scrollableLayout.add(pedido);
//			pedido.marcarEntregado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
//				
//				@Override
//				public void onComponentEvent(ClickEvent<Button> event) {
//					// TODO Auto-generated method stub
//					if (apptrans.marcarComoEntregado(enviado.getID())) {
//						Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
//						scrollableLayout.remove(pedido);
//
//					}else {
//						Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
//					}
//				}
//			});
		}
		
		for (Pendiente pendiente : pedidosPendientes) {
			System.out.println(" PEDIDO pendiente " + pendiente.getID());
			
			Pedido pedido = new Pedido();
			pedido.marcarEntregado.setText("Anular pedido");
			pedido.entregadoPor.setText("Ha sido gestionado por: " + pendiente.getMarcado_por().getNombre() + " " + pendiente.getMarcado_por().getApellidos());
			pedido.cliente.setText(
					pendiente.getRealizado_por().getNombre() + " " + pendiente.getRealizado_por().getApellidos());
			pedido.direccion.setText(pendiente.getRealizado_por().getDireccion());
			if (pendiente.getPagado()) {
				pedido.estadoPedido.setText("Estado del pedido: pendiente");
			}
			List<Lineas_de_Pedido> carrito = apptrans.cargarCarrito(pendiente.getID());
			pedido.pedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			pedido.numeroArticulos.setText(carrito.size() + " articulos.");
			pedido.verDetalles.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					pedido.verDetalle = new Ver_detalle(pendiente);
					pedido.verDetalle.verDetalleDialog.open();
				}
			});
			scrollableLayout.add(pedido);
//			pedido.marcarEntregado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
//				
//				@Override
//				public void onComponentEvent(ClickEvent<Button> event) {
//					// TODO Auto-generated method stub
//					if (apptrans.marcarComoEntregado(enviado.getID())) {
//						Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
//						scrollableLayout.remove(pedido);
//
//					}else {
//						Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
//					}
//				}
//			});
		}
		
		  	scrollableLayout.setHeight("100%");
		    scrollableLayout.setWidth("100%");
		    // Set overflow on the y-axis to "auto".
		    // It can be also "scroll", but then you 
		    // have a scroll bar even when one isn't needed.
		    scrollableLayout.getStyle().set("overflow-y", "auto");
		    // Another element to show that it stays in the same place
		    Div staticElement = new Div();
		    staticElement.getStyle().set("color", "#1676f3").set("font-size", "larger").set("font-weight", "bold").set("margin", "20px");
			staticElement.add(new Text("Pedidos realizados"));
			add(staticElement, scrollableLayout);	
			
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
