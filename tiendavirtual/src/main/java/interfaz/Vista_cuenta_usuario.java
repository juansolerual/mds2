package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.iAdmin;
import vistas.VistaCuentausuario;

public class Vista_cuenta_usuario extends VistaCuentausuario{
	public Usuario_registrado _usuario_registrado;
	public Gestionar_cuenta _gestionar_cuenta;
	public Ver_direccion _ver_direccion;
	public Ver_datos_de_pago _ver_datos_de_pago;
	public VerticalLayout barraIzquierda;
	public VerticalLayout barraDerecha;
	public Image avatar;
	public Label labelTitulo;
	public TextField nombre;
	public TextField apellidos;
	public TextField correoElectronico;
	public PasswordField password;
	public Button direcciones;
	public Button datosDePagoButton;
	public Button centroDeMensajes;
	public Button historialPedidos;
	
	public Button guardarCambios;
	public Button bajaCuenta;
	VaadinSession session = VaadinSession.getCurrent();


	
	public Vista_cuenta_usuario(Cliente cliente) {
		
		super();
		if (cliente == null) {
			return;
		}
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		HorizontalLayout primeraLinea = new HorizontalLayout();
		VerticalLayout segundaLinea = new VerticalLayout();
		HorizontalLayout terceraLinea = new HorizontalLayout();
		avatar = new Image();
		avatar.setWidth("80px");
		avatar.setHeight("80px");
		avatar.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		labelTitulo = new Label("Datos personales");
	    labelTitulo.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");

	    nombre = new TextField("Nombre: ");
	    apellidos = new TextField("Apellidos: ");
	    correoElectronico = new TextField("Correo Electronico: ");
	    password = new PasswordField("Contraseña: ");
	    
	    direcciones = new Button("Direcciones");
	    direcciones.setIcon(new Icon(VaadinIcon.MAP_MARKER));
	    direcciones.setWidth("100%");

	    Dialog dialogDirecciones = new Dialog();
	    
	    direcciones.addClickListener(event -> dialogDirecciones.open());

		HorizontalLayout dialogHorizontal = new HorizontalLayout();
		Label tituloDialog = new Label("Direcciones");
		dialogHorizontal.add(tituloDialog);
		dialogDirecciones.setWidth("800px");
		dialogDirecciones.setHeight("600px");
		
		
		dialogDirecciones.setModal(false);
		dialogDirecciones.setDraggable(true);
		dialogDirecciones.setResizable(true);
		//dialog.add(new Text("Close me with the esc-key or an outside click"));
		TextField direccion = new TextField(cliente.getDireccion());
		direccion.setLabel("Direccion: ");
		direccion.getStyle().set("margin", "20px").set("width", "400px");
		
		

		Button guardar = new Button("Guardar");
		guardar.getStyle().set("margin", "20px");
		
		Button cancelButton = new Button("Cancelar", event -> {
		    dialogDirecciones.close();
		});
		cancelButton.getStyle().set("margin", "20px");

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialogDirecciones, () -> {
		    dialogDirecciones.close();
		}, Key.ESCAPE);
		guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				
				//int result = adm.guardarCategoria(aCategoria);
				dialogDirecciones.close();
				cliente.setDireccion(direccion.getValue());

				
			}
			
		});
		VerticalLayout dialogVertical = new VerticalLayout(direccion);
		HorizontalLayout dialogButtons = new HorizontalLayout(guardar, cancelButton);
		dialogHorizontal.getStyle().set("margin", "20px").set("width", "100%");
		dialogVertical.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageEsc = new Label("o pulsa ESC para salir");

		dialogDirecciones.add(dialogHorizontal, dialogVertical, dialogButtons, mesageEsc);
	    
	    datosDePagoButton = new Button("Datos de pago");
	    datosDePagoButton.setWidth("100%");
	    datosDePagoButton.setIcon(new Icon(VaadinIcon.CREDIT_CARD));
	    Dialog dialogDatosDePago = new Dialog();
	    
	    datosDePagoButton.addClickListener(event -> dialogDatosDePago.open());

		HorizontalLayout dialogHorizontalDatosPago = new HorizontalLayout();
		Label tituloDialogDatosPago = new Label("Datos de Pago:");
		dialogHorizontalDatosPago.add(tituloDialogDatosPago);
		dialogDatosDePago.setWidth("800px");
		dialogDatosDePago.setHeight("600px");
		
		
		dialogDatosDePago.setModal(false);
		dialogDatosDePago.setDraggable(true);
		dialogDatosDePago.setResizable(true);
		//dialog.add(new Text("Close me with the esc-key or an outside click"));
		ComboBox<String> formaDePago = new ComboBox<String>();
		formaDePago.setLabel("Forma de pago" );
		formaDePago.setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");
		formaDePago.setValue(cliente.getFormaDePago());
		formaDePago.getStyle().set("margin", "20px").set("width", "400px");

		TextField datosDePago = new TextField( cliente.getDatosPago());
		datosDePago.setLabel("Datos de pago :");
		datosDePago.getStyle().set("margin", "20px").set("width", "400px");
		
		

		Button guardarDatosPago = new Button("Guardar");
		guardarDatosPago.getStyle().set("margin", "20px");
		
		Button cancelButtonDatosPago = new Button("Cancelar", event -> {
		    dialogDatosDePago.close();
		});
		cancelButtonDatosPago.getStyle().set("margin", "20px");

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialogDatosDePago, () -> {
		    dialogDatosDePago.close();
		}, Key.ESCAPE);
		guardarDatosPago.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				
				//int result = adm.guardarCategoria(aCategoria);
				cliente.setFormaDePago(formaDePago.getValue());
				cliente.setDatosPago(datosDePago.getValue());
				dialogDatosDePago.close();

				
			}
			
		});
		VerticalLayout dialogVerticalDatosPago = new VerticalLayout(formaDePago, datosDePago);
		HorizontalLayout dialogButtonsDatosPago = new HorizontalLayout(guardarDatosPago, cancelButtonDatosPago);
		dialogHorizontalDatosPago.getStyle().set("margin", "20px").set("width", "100%");
		dialogVerticalDatosPago.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageEscDatosPago = new Label("o pulsa ESC para salir");

		dialogDatosDePago.add(dialogHorizontalDatosPago, dialogVerticalDatosPago, dialogButtonsDatosPago, mesageEscDatosPago);
	    
	    centroDeMensajes = new Button("Centro de mensajes");
	    centroDeMensajes.setIcon(new Icon(VaadinIcon.MAILBOX));
	    centroDeMensajes.setWidth("100%");

	    
	    historialPedidos = new Button("Historial de pedidos");
	    historialPedidos.setWidth("100%");
	    historialPedidos.setIcon(new Icon(VaadinIcon.CART));
	    historialPedidos.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				barraDerecha.removeAll();
				Vista_pedidos_cliente _vistaPedidos_cliente = new Vista_pedidos_cliente();
				barraDerecha.add(_vistaPedidos_cliente);
			}
		});
	    
	    guardarCambios = new Button("Guardar cambios");
	    bajaCuenta = new Button("Dar de baja la cuenta");
	    bajaCuenta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				if(adm.eliminarCliente(cliente.getID())) {
					Notification.show("El usuario ha sido borrado con éxito.", 3000, Position.MIDDLE);
			    	VerticalLayout vlayout = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
			    	Cabecera_Usuario _cabecera_Usuario = (Cabecera_Usuario) session.getAttribute("Cabecera_usuario_registrado");
			    	vlayout.removeAll();
			    	vlayout.add(_cabecera_Usuario);

				}else {
					Notification.show("Ha habido un error al eliminar el usuario.", 3000, Position.MIDDLE);
				}
			}
		});
	    
	    primeraLinea.add(avatar, labelTitulo);
	    
	    segundaLinea.add(nombre, apellidos, correoElectronico, password);
	    
	    terceraLinea.add(guardarCambios, bajaCuenta);
	    
		barraIzquierda.add(direcciones, datosDePagoButton, centroDeMensajes, historialPedidos);
		barraDerecha.add(primeraLinea, segundaLinea, terceraLinea);
		
		avatar.setSrc(cliente.getFoto_perfil());
		nombre.setValue(cliente.getNombre());
		apellidos.setValue(cliente.getApellidos());
		correoElectronico.setValue(cliente.getEmail());
		password.setValue(cliente.getPassword());
	}



	public Vista_cuenta_usuario(Administrador administrador) {
		super();
		if (administrador == null) {
			return;
		}
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		HorizontalLayout primeraLinea = new HorizontalLayout();
		VerticalLayout segundaLinea = new VerticalLayout();
		HorizontalLayout terceraLinea = new HorizontalLayout();
		avatar = new Image();
		avatar.setWidth("80px");
		avatar.setHeight("80px");
		avatar.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		labelTitulo = new Label("Datos personales");
	    labelTitulo.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");

	    nombre = new TextField("Nombre: ");
	    apellidos = new TextField("Apellidos: ");
	    correoElectronico = new TextField("Correo Electronico: ");
	    password = new PasswordField("Contraseña: ");
	    
	    direcciones = new Button("Direcciones");
	    direcciones.setIcon(new Icon(VaadinIcon.MAP_MARKER));
	    direcciones.setWidth("100%");
	    direcciones.setEnabled(false);

	    
	    datosDePagoButton = new Button("Datos de pago");
	    datosDePagoButton.setWidth("100%");
	    datosDePagoButton.setIcon(new Icon(VaadinIcon.CREDIT_CARD));
	    datosDePagoButton.setEnabled(false);

	    
	    centroDeMensajes = new Button("Centro de mensajes");
	    centroDeMensajes.setIcon(new Icon(VaadinIcon.MAILBOX));
	    centroDeMensajes.setWidth("100%");
	    centroDeMensajes.setEnabled(false);

	    
	    historialPedidos = new Button("Historial de pedidos");
	    historialPedidos.setWidth("100%");
	    historialPedidos.setIcon(new Icon(VaadinIcon.CART));
	    historialPedidos.setEnabled(false);

	    historialPedidos.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				barraDerecha.removeAll();
				Vista_pedidos_cliente _vistaPedidos_cliente = new Vista_pedidos_cliente();
				barraDerecha.add(_vistaPedidos_cliente);
			}
		});
	    
	    guardarCambios = new Button("Guardar cambios");
	    bajaCuenta = new Button("Dar de baja la cuenta");
	    bajaCuenta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				if(adm.eliminarAdministrador(administrador.getID())) {
					Notification.show("El usuario ha sido borrado con éxito.", 3000, Position.MIDDLE);
			    	VerticalLayout vlayout = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
			    	Cabecera_administrador _cabecera_administrador = (Cabecera_administrador) session.getAttribute("Cabecera_administrador");
			    	vlayout.removeAll();
			    	vlayout.add(_cabecera_administrador);

				}else {
					Notification.show("Ha habido un error al eliminar el usuario.", 3000, Position.MIDDLE);
				}
			}
		});
	    
	    primeraLinea.add(avatar, labelTitulo);
	    
	    segundaLinea.add(nombre, apellidos, correoElectronico, password);
	    
	    terceraLinea.add(guardarCambios, bajaCuenta);
	    
		barraIzquierda.add(direcciones, datosDePagoButton, centroDeMensajes, historialPedidos);
		barraDerecha.add(primeraLinea, segundaLinea, terceraLinea);
		
		avatar.setSrc(administrador.getFoto_perfil());
		nombre.setValue(administrador.getNombre());
		apellidos.setValue(administrador.getApellidos());
		correoElectronico.setValue(administrador.getEmail());
		password.setValue(administrador.getPassword());
	}
}