package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Cliente;
import tiendavirtual.cookiesHelper;

public class Datos_compra {
	public Elementos_comunes_carrito _elementos_comunes_carrito;
	
	public VerticalLayout direccionEnvio;
	public VerticalLayout metodoPago;
	public VerticalLayout totalDinero;
	public VerticalLayout botones;
	
	public Label totalCarritoLabel;
	public Label totalPortes;
	public Label totalImpuestos;
	public Label totalPagar;
	public Label tituloDireccionEnvio;
	
	public Label nombreApellidos;
	public Label calle;
	public Label telefono;
	
	public Button realizarPago;
	public Button terminarPedido;
	
	public Datos_compra() {
		super();
			VaadinSession session = VaadinSession.getCurrent();
			Cliente cliente = (Cliente) session.getAttribute("cliente");
		 	direccionEnvio = new VerticalLayout();
		    direccionEnvio.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
		    tituloDireccionEnvio = new Label();
		    tituloDireccionEnvio.setText("Datos del cliente");
		    tituloDireccionEnvio.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");
		    
		    nombreApellidos = new Label();
		    calle = new Label();
		    telefono = new Label();
		    
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
		    terminarPedido = new Button("Realizar pedido");
		    botones.add(realizarPago, terminarPedido);
		    
		    totalCarritoLabel = new Label();
		    totalPortes = new Label();
		    totalImpuestos = new Label();
		    totalPagar = new Label();

		   

		    totalDinero.add(totalCarritoLabel, totalPortes, totalImpuestos, totalPagar);
		    
	}

	public Datos_compra(Cliente cliente) {
		// TODO Auto-generated constructor stub
		super();
		
	 	direccionEnvio = new VerticalLayout();
	    direccionEnvio.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
	    tituloDireccionEnvio = new Label();
	    tituloDireccionEnvio.setText("Datos del cliente");
	    tituloDireccionEnvio.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");
	    
	    nombreApellidos = new Label();
	    calle = new Label();
	    telefono = new Label();
	    
	  
	    	nombreApellidos.setText(cliente.getNombre() + " " + cliente.getApellidos());
		    calle.setText(cliente.getDireccion());
		    telefono.setText("676546546");
		    
		    direccionEnvio.add(tituloDireccionEnvio, nombreApellidos, calle, telefono);
		    metodoPago = new VerticalLayout();
		    metodoPago.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");
	    
	    totalDinero = new VerticalLayout();
	    totalDinero.getStyle().set("border","1px solid blue").set("margin", "20px").set("width", "100%");

	    botones = new VerticalLayout();
	    
	    realizarPago = new Button("Realizar pago");
	    terminarPedido = new Button("Realizar pedido");
	    botones.add(realizarPago, terminarPedido);
	    
	    totalCarritoLabel = new Label();
	    totalPortes = new Label();
	    totalImpuestos = new Label();
	    totalPagar = new Label();

	   

	    totalDinero.add(totalCarritoLabel, totalPortes, totalImpuestos, totalPagar);
	    
	}
}