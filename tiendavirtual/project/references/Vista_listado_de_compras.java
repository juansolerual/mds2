package interfaz;

import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Entregado;
import basededatos.Enviado;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.Producto;
import basededatos.iEncargado_de_compras;
import basededatos.iUsuario_registrado;
import vistas.VistaListadodecompras;

public class Vista_listado_de_compras extends VistaListadodecompras{
	public Encargado_de_compras _encargado_de_compras;
	public Lista_compras _lista_compras;
	//public Filtrar_resultados _filtrar_resultados;
	public Cabecera_encargado_compras _cabecera_encargado_compras;
	public VerticalLayout barraIzquierda;
	public VerticalLayout barraDerecha;
	public Button filtrar_por_enviados;
	public Button filtrar_por_pendientes;
	public Button filtrar_por_entregados;
	protected Pendiente pendienteTemp;
	public iEncargado_de_compras usuario;
	public VerticalLayout scrollableLayoutPendientes;
	protected Lista_compras lcTemp;
	private VerticalLayout scrollableLayoutEntregados;
	protected Entregado entregadoTemp;

	//private int totalCarrito = 0;
	
	public Vista_listado_de_compras() {
		super();
		usuario = new BDPrincipal();
		List<basededatos.Pendiente> pendientes = usuario.cargarPedidosPendientes();
		List<basededatos.Entregado> entregados = usuario.cargarPedidosEntregados();
		List<basededatos.Enviado> enviados = usuario.cargarPedidosEnviados();
		

		
		//basededatos.Pedido pend = new basededatos.Pendiente();
		
		
		
		
		
		

		
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		
		scrollableLayoutPendientes = new VerticalLayout();
		scrollableLayoutPendientes.setId("verticalLayout_productos_pendientes");
		for (Pendiente pendiente : pendientes) {
			Lista_compras lc = new Lista_compras();
			lc.pedido.setText("Pedido: " + pendiente.getID());
			lc.cliente.setText("Cliente : " + pendiente.getRealizado_por().getNombre() + " " + pendiente.getRealizado_por().getApellidos());
			lc.direccion.setText("Direccion : " + pendiente.getRealizado_por().getDireccion());
			lc.estadoPedido.setText("Pedido pendiente de envío");
			List<Lineas_de_Pedido> carrito = usuario.cargarCarrito(pendiente.getID());
			lc.totalPedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			scrollableLayoutPendientes.add(lc);
			
			lc.marcarComoEnviado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					pendienteTemp = pendiente;
					lcTemp = lc;
					marcarComoEnviado();
					
					
					

				}
			});
			
			
			
			lc.verDetalleButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					pendienteTemp = pendiente;
					lcTemp = lc;
					verDetalle();
					
					

				}
			});

		}
	    //for(int i = 0; i< 10; i++){
	    //  scrollableLayout.add(new Producto_busqueda(false));
	    //}
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayoutPendientes.setHeight("100%");
	    scrollableLayoutPendientes.setWidth("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayoutPendientes.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	    Div tituloPendientes = new Div();
	    tituloPendientes.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");
	    tituloPendientes.add(new Text("Pedidos pendientes"));
	    
	    
	    VerticalLayout scrollableLayoutEnviados = new VerticalLayout();
		scrollableLayoutEnviados.setId("verticalLayout_productos_enviados");
		for (Enviado enviado : enviados) {
			Lista_compras lc = new Lista_compras();
			lc.pedido.setText("Pedido: " + enviado.getID());
			lc.cliente.setText("Cliente : " + enviado.getRealizado_por().getNombre() + " " + enviado.getRealizado_por().getApellidos());
			lc.direccion.setText("Direccion : " + enviado.getRealizado_por().getDireccion());
			lc.estadoPedido.setText("Pedido enviado");
			List<Lineas_de_Pedido> carrito = usuario.cargarCarrito(enviado.getID());
			lc.totalPedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			scrollableLayoutEnviados.add(lc);
			
			lc.marcarComoEnviado.setVisible(false);
			
			
			lc.verDetalleButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					lc.verDetalle = new Ver_detalle(enviado);
					lc.verDetalle.verDetalleDialog.open();
					

				}
			});

		}
	    //for(int i = 0; i< 10; i++){
	    //  scrollableLayout.add(new Producto_busqueda(false));
	    //}
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayoutEnviados.setHeight("100%");
	    scrollableLayoutEnviados.setWidth("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayoutEnviados.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	    Div tituloEnviados = new Div();
	    tituloEnviados.getStyle().set("margin", "20px");
	    tituloEnviados.add(new Text("Pedidos enviados"));
	    tituloEnviados.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");
	    
	    
		
		scrollableLayoutEntregados = new VerticalLayout();
		scrollableLayoutEntregados.setId("verticalLayout_productos_entregados");
		for (Entregado entregado : entregados) {
			Lista_compras lc = new Lista_compras();
			lc.pedido.setText("Pedido: " + entregado.getID());
			lc.cliente.setText("Cliente : " + entregado.getRealizado_por().getNombre() + " " + entregado.getRealizado_por().getApellidos());
			lc.direccion.setText("Direccion : " + entregado.getRealizado_por().getDireccion());
			lc.estadoPedido.setText("Pedido entregado");
			List<Lineas_de_Pedido> carrito = usuario.cargarCarrito(entregado.getID());
			lc.totalPedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			scrollableLayoutEntregados.add(lc);
			
			lc.marcarComoEnviado.setVisible(false);
			
			
			
			lc.verDetalleButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					entregadoTemp = entregado;
					lcTemp = lc;
					verDetalle();
					
					

				}
			});

		}
	    //for(int i = 0; i< 10; i++){
	    //  scrollableLayout.add(new Producto_busqueda(false));
	    //}
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayoutPendientes.setHeight("100%");
	    scrollableLayoutPendientes.setWidth("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayoutPendientes.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	    Div tituloEntregados = new Div();
	    tituloEntregados.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");
	    tituloEntregados.add(new Text("Pedidos entregados"));
	    

	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraDerecha.add(tituloPendientes, scrollableLayoutPendientes, tituloEnviados, scrollableLayoutEnviados, tituloEntregados, scrollableLayoutEntregados);
	    barraDerecha.getStyle().set("border","2px solid #1676f3").set("border-radius","25px");
	    
	    
	   
		filtrar_por_enviados = new Button("Filtrar por enviados");
		filtrar_por_pendientes = new Button("Filtrar por pendientes");
		filtrar_por_entregados = new Button("Filtrar por entregados");
	    
		filtrar_por_pendientes.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				scrollableLayoutEnviados.removeAll();
				scrollableLayoutEntregados.removeAll();

			}
		});
		
		filtrar_por_enviados.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				scrollableLayoutPendientes.removeAll();
				scrollableLayoutEntregados.removeAll();
			}
		});
		
		filtrar_por_entregados.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				scrollableLayoutPendientes.removeAll();
				scrollableLayoutEnviados.removeAll();


			}
		});
	    
	    
	    
	    barraIzquierda.setHeight("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    barraIzquierda.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	   
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraIzquierda.getStyle().set("border","2px solid #1676f3").set("border-radius","25px");
	    barraIzquierda.add(filtrar_por_enviados,filtrar_por_pendientes, filtrar_por_entregados);

	    
	}
	
	protected void verDetalle() {
		// TODO Auto-generated method stub
		lcTemp.verDetalle = new Ver_detalle(pendienteTemp);
		lcTemp.verDetalle.verDetalleDialog.open();
	}

	protected void marcarComoEnviado() {
		// TODO Auto-generated method stub
		if (usuario.Marcar_como_enviado(pendienteTemp.getID())) {
			Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
			scrollableLayoutPendientes.remove(lcTemp);

		}else {
			Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
		}
	}

	protected int calcularTotal(List<Lineas_de_Pedido> carrito) {
		
		int totalCarrito  = 0;
		System.out.println("Actuiawlizar precio ");
		for (Lineas_de_Pedido ldp: carrito) {
			System.out.println("Precio sin descuento linea 1 " + ldp.getDe_un().getPrecio());
			java.util.Date date = ldp.getDe_un().getAplica_oferta().getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultado = datenow.compareTo(date);
			double precioLinea = 0;
			if (ldp.getDe_un().getAplica_oferta().getActivada() && resultado == -1) {
				if (ldp.getDe_un().getAplica_oferta().getPorcentajeOferta()) {
					precioLinea = (ldp.getDe_un().getPrecio()
							- (ldp.getDe_un().getPrecio() * (ldp.getDe_un().getAplica_oferta().getPrecioOferta() / 100)));
					System.out.println("Precio con porcentaje " + precioLinea);
				} else {
					precioLinea = (ldp.getDe_un().getAplica_oferta().getPrecioOferta());
					System.out.println("Precio sin porcentaje " + precioLinea);

				}
			}else {
				precioLinea = ldp.getDe_un().getPrecio();
				System.out.println("Precio final " + precioLinea);

			}
			System.out.println("Precio final aplicado " + precioLinea);
			totalCarrito += (precioLinea * ldp.getCantidad());
		}
		return totalCarrito;
		
	} 
	
	
}