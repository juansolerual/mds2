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
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.Producto;
import basededatos.iEncargado_de_compras;
import basededatos.iUsuario_registrado;
import vistas.VistaListadodecompras;

public class Vista_listado_de_compras extends VistaListadodecompras{
	public Encargado_de_compras _encargado_de_compras;
	public Lista_compras _lista_compras;
	public Filtrar_resultados _filtrar_resultados;
	public Cabecera_encargado_compras _cabecera_encargado_compras;
	public VerticalLayout barraIzquierda;
	public VerticalLayout barraDerecha;
	public Button filtrar_por_enviados;
	public Button filtrar_por_pendientes;
	public Button filtrar_por_anulados;

	//private int totalCarrito = 0;
	
	public Vista_listado_de_compras() {
		super();
		iEncargado_de_compras usuario = new BDPrincipal();
		List<basededatos.Pendiente> pendientes = usuario.cargarPedidosPendientes();
		List<basededatos.Entregado> entregados = usuario.cargarPedidosEntregados();
		List<basededatos.Enviado> enviados = usuario.cargarPedidosEnviados();
		

		
		//basededatos.Pedido pend = new basededatos.Pendiente();
		
		
		
		for (Pendiente pendiente : pendientes) {
			System.out.println("Fecha pedido " + pendiente.getFechaPedido());
			
		}
		
		
		
		

		
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		
		VerticalLayout scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_productos");
		for (Pendiente pendiente : pendientes) {
			Lista_compras lc = new Lista_compras();
			lc.pedido.setText("Pedido: " + pendiente.getID());
			lc.cliente.setText("Cliente : " + pendiente.getRealizado_por().getNombre() + " " + pendiente.getRealizado_por().getApellidos());
			lc.direccion.setText("Direccion : " + pendiente.getRealizado_por().getDireccion());
			lc.estadoPedido.setText("Pedido pendiente de envío");
			List<Lineas_de_Pedido> carrito = usuario.cargarCarrito(pendiente.getID());
			lc.totalPedido.setText("Total pedido: " + this.calcularTotal(carrito) + "€");
			scrollableLayout.add(lc);
			
			lc.marcarComoEnviado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					
					if (usuario.Marcar_como_enviado(pendiente.getID())) {
						Notification.show("Ha sido marcado como enviado con exito.", 3000, Position.MIDDLE);
						scrollableLayout.remove(lc);

					}else {
						Notification.show("Ha habido un error al marcarlo como enviado.", 3000, Position.MIDDLE);
					}
					

				}
			});

		}
	    //for(int i = 0; i< 10; i++){
	    //  scrollableLayout.add(new Producto_busqueda(false));
	    //}
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayout.setHeight("100%");
	    scrollableLayout.setWidth("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayout.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	    Div staticElement = new Div();
	    staticElement.getStyle().set("margin", "20px");
	    staticElement.add(new Text("Pedidos pendientes"));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraDerecha.add(staticElement, scrollableLayout);
	    barraDerecha.getStyle().set("border","1px solid blue");
	    
	    
	   
		filtrar_por_enviados = new Button("Filtrar por enviados");
		filtrar_por_pendientes = new Button("Filtrar por pendientes");
		filtrar_por_anulados = new Button("Filtrar por marca");
	    
	    
	    
	    barraIzquierda.setHeight("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    barraIzquierda.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	   
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraIzquierda.getStyle().set("border","1px solid blue");
	    barraIzquierda.add(filtrar_por_enviados,filtrar_por_pendientes);

	    
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