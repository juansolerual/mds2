package interfaz;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Lineas_de_Pedido;
import basededatos.Pedido;
import basededatos.Pendiente;
import basededatos.Producto;
import basededatos.iAdmin;
import basededatos.iUsuario_registrado;
import tiendavirtual.cookiesHelper;
import vistas.VistaElementoscomunescarrito;

public class Elementos_comunes_carrito extends VistaElementoscomunescarrito{
	public Lista_elementos_carrito _lista_elementos_carrito;
	public Datos_compra _datos_compra;
	public double totalCarrito;
	
	public VerticalLayout direccionEnvio;
	public VerticalLayout metodoPago;
	public VerticalLayout totalDinero;
	public VerticalLayout botones;
	
	public Label totalCarritoLabel;
	public Label totalPortes;
	public Label totalImpuestos;
	public Label totalPagar;
	public Label estadoPedido;
	public List<Lineas_de_Pedido> carrito;
	public Button realizarPago;
	public Button terminarPedido;
	
	public Elementos_comunes_carrito() {
		super();
		iUsuario_registrado usr = new BDPrincipal();
		iAdmin admin = new BDPrincipal();
		VaadinSession session = VaadinSession.getCurrent();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		Pendiente pedido = new Pendiente();
		pedido.setFechaPedido(new java.util.Date());
		pedido.setHoraPedido(new Time(new java.util.Date().getTime()));
		pedido.setRealizado_por(cliente);
		pedido.setMarcado_por(admin.cargarEncargadoCompras(3));
		if (cookiesHelper.isNoRegistrado()) {
			carrito = (List<Lineas_de_Pedido>) session.getAttribute("carrito_invitado");

		}else {
			carrito = (List<Lineas_de_Pedido>) session.getAttribute(String.valueOf(cookiesHelper.idUsuario));
		}
		
//		Pedido pedido = (Pedido)session.getAttribute("pedidoCarrito");
//		pedido.
//		
		VerticalLayout scrollableLayout = new VerticalLayout();
		VerticalLayout barraIzquierda = new VerticalLayout();
		VerticalLayout barraDerecha = new VerticalLayout();
		HorizontalLayout barraInferiorDerecha = new HorizontalLayout();
		barraInferiorDerecha.getStyle().set("border","1px solid blue").set("margin", "20px").set("padding-left", "20px");
		barraInferiorDerecha.setWidth("95%");
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");
	    barraDerecha.getStyle().set("border","1px solid blue").set("margin", "20px");
	    barraIzquierda.getStyle().set("border","1px solid blue").set("margin", "20px");
	    
		scrollableLayout.setId("verticalLayout_carrito");
		
		if (carrito == null) {
			carrito = new ArrayList<Lineas_de_Pedido>();
		}
		
		
		for (Lineas_de_Pedido ldp: carrito) {
			ldp.setPertenecen_a(pedido);
			System.out.println("Producto " + ldp.getDe_un().getNombreProducto() + " cantidad " + ldp.getCantidad());
		    Producto_Carrito puc = new Producto_Carrito(ldp);
		    puc.precio.addValueChangeListener(new ValueChangeListener() {
				@Override
				public void valueChanged(ValueChangeEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Cambio el precio " + puc.precio.getValue());
					ldp.setCantidad(Integer.parseInt(puc.placeholderSelect.getValue()));
					session.setAttribute("lineasDePedido", carrito);

					calcularTotal(carrito);
					actualizarLineas();
				}
			});
		    
		    puc.eliminarLinea.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					carrito.remove(ldp);
					session.setAttribute("lineasDePedido", carrito);

					scrollableLayout.remove(puc);

					calcularTotal(carrito);
					actualizarLineas();
				}
			});
		    
		    // totalCarrito+= puc.precioLinea;
			scrollableLayout.add(puc);
			
		}
		calcularTotal(carrito);
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
	    Div tituloCarritoUsuario = new Div();
	    tituloCarritoUsuario.getStyle().set("margin", "20px");
	    tituloCarritoUsuario.add(new Text("Carrito de usuario"));
	    tituloCarritoUsuario.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");

	    TextField estadoPedido = new TextField("Estado del Pedido");
	    estadoPedido.setReadOnly(true);
	    estadoPedido.getStyle().set("margin", "20px");
	    estadoPedido.setValue("Pedido creado");
	    
	    if (pedido.getPagado()) {
		    estadoPedido.setValue("Pedido pagado");
	    }
	    // if (pedido.)  FALTA PONER SI HA SIDO ENVIADO...ETc
	    
	    
	    
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraIzquierda.add(tituloCarritoUsuario, estadoPedido);
	    barraDerecha.add(scrollableLayout, barraInferiorDerecha);
	    this.getVaadinHorizontalLayout().add(barraIzquierda, barraDerecha);
	    
	    direccionEnvio = new VerticalLayout();
	    direccionEnvio.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
	    Label tituloDireccionEnvio = new Label();
	    tituloDireccionEnvio.setText("Datos del cliente");
	    tituloDireccionEnvio.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");
	    
	    Label nombreApellidos = new Label();
	    Label calle = new Label();
	    Label telefono = new Label();
	    
	    if (cookiesHelper.isNoRegistrado()) {
	    	nombreApellidos.setText("USUARIO NO REGISTRADO");
		    calle.setText("- - - - - - -");
		    telefono.setText("- - - - - - - ");
		    
		    direccionEnvio.add(tituloDireccionEnvio, nombreApellidos, calle, telefono);
		    metodoPago = new VerticalLayout();
		    metodoPago.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
	    }else {
	    	nombreApellidos.setText(cliente.getNombre() + " " + cliente.getApellidos());
		    calle.setText(cliente.getDireccion());
		    telefono.setText("676546546");
		    
		    direccionEnvio.add(tituloDireccionEnvio, nombreApellidos, calle, telefono);
		    metodoPago = new VerticalLayout();
		    metodoPago.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
	    }
	    

	    totalDinero = new VerticalLayout();
	    totalDinero.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");

	    botones = new VerticalLayout();
	    
	    realizarPago = new Button("Realizar pago");
	    realizarPago.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Notification.show("Ha sido marcado como pagado.", 3000, Position.MIDDLE);
				estadoPedido.setValue("Pedido Pagado");
				pedido.setPagado(true);
			}
		});
	    terminarPedido = new Button("Realizar pedido");
	    terminarPedido.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				
				if (!pedido.getPagado()) {
					Notification.show("Debe pagar el pedido primero.", 3000, Position.MIDDLE);
					return;
				}
				
				
				
				if (usr.realizarPedido(pedido)) {
					Notification.show("El pedido se ha realizado correctamente.", 3000, Position.MIDDLE);
				}else {
					Notification.show("Ha habido un error realizando el pedido.", 3000, Position.MIDDLE);

				}
				//carrito = new ArrayList<Lineas_de_Pedido>();
				carrito.removeAll(carrito);
				scrollableLayout.removeAll();
				session.setAttribute(String.valueOf(cookiesHelper.idUsuario), carrito);

			}
		});
	    
	    botones.add(realizarPago, terminarPedido);
	    
	    totalCarritoLabel = new Label();
	    totalPortes = new Label();
	    totalImpuestos = new Label();
	    totalPagar = new Label();

	    totalCarritoLabel.setText("Total pedido : " + this.totalCarrito + "€");
	    totalPortes.setText("Total portes : " + "5€");
	    double totalImpuestosDouble = this.totalCarrito * 0.21;
	    totalImpuestos.setText("Total impuestos : " + totalImpuestosDouble + "€");
	    double totalPagarDouble = this.totalCarrito+5+totalImpuestosDouble;
	    totalPagar.setText("Total a pagar : " + totalPagarDouble + "€");

	    totalDinero.add(totalCarritoLabel, totalPortes, totalImpuestos, totalPagar);
		
		barraInferiorDerecha.add(direccionEnvio, metodoPago, totalDinero, botones);
		
	}


	protected void calcularTotal(List<Lineas_de_Pedido> carrito) {
		
		totalCarrito = 0;
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
		
	} 
	
	public void actualizarLineas() {
		
	    totalDinero.removeAll();
	    
	    
	    
	    totalCarritoLabel = new Label();
	    totalPortes = new Label();
	    totalImpuestos = new Label();
	    totalPagar = new Label();

	    totalCarritoLabel.setText("Total pedido : " + this.totalCarrito + "€");
	    totalPortes.setText("Total portes : " + "5€");
	    double totalImpuestosDouble = this.totalCarrito * 0.21;
	    totalImpuestos.setText("Total impuestos : " + totalImpuestosDouble + "€");
	    double totalPagarDouble = this.totalCarrito+5+totalImpuestosDouble;
	    totalPagar.setText("Total a pagar : " + totalPagarDouble + "€");
	    totalDinero.add(totalCarritoLabel, totalPortes, totalImpuestos, totalPagar);
	  


	}
}