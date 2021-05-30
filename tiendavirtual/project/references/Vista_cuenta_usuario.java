package interfaz;

import javax.servlet.http.Cookie;

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
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.iAdmin;
import basededatos.iUsuario_registrado;
import tiendavirtual.cookiesHelper;
import vistas.VistaCuentausuario;

public class Vista_cuenta_usuario extends VistaCuentausuario{
	public Usuario_registrado _usuario_registrado;
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
	public Button centroDeMensajes;
	public Button historialPedidos;
	public Button datosDePagoButton;

	public Button guardarCambios;
	public Button bajaCuenta;
	VaadinSession session = VaadinSession.getCurrent();

	public Cliente cliente;

	
	public Vista_cuenta_usuario(Cliente aCliente) {
		
		super();
		
		if (aCliente == null) {
			System.out.println("Cliente is null");
			return;
		}
		cliente = aCliente;
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
	    direcciones.addClickListener(event -> {
			_ver_direccion = new Ver_direccion(aCliente);

			_ver_direccion.showDialog();
	    });
	  
		
		
		datosDePagoButton = new Button("Datos de pago");
	    datosDePagoButton.setWidth("100%");
	    datosDePagoButton.setIcon(new Icon(VaadinIcon.CREDIT_CARD));
	    datosDePagoButton.addClickListener(event -> {
			_ver_datos_de_pago = new Ver_datos_de_pago(aCliente);

			_ver_datos_de_pago.showDialog();
	    });
		

		
	    
	   
	    
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
	    guardarCambios.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				
				
				guardarCambiosUsuario();
				
			
			}
	    });
	    bajaCuenta = new Button("Dar de baja la cuenta");
	    bajaCuenta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				bajaCuentaUsuario();
				
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



	protected void bajaCuentaUsuario() {
		// TODO Auto-generated method stub
		iAdmin adm = new BDPrincipal();
		if(adm.eliminarCliente(cliente.getID())) {
			Notification.show("El usuario ha sido borrado con éxito.", 3000, Position.MIDDLE);
			cookiesHelper.cliente = null;
			VaadinSession session = VaadinSession.getCurrent();
			session.setAttribute("tipoUsuario", "noUser");
			session.setAttribute("cliente", null);
			
			
			Cookie cookiecliente = new Cookie("cliente", "-1");

			Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

			cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
			cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
			cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
			cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
			VaadinService.getCurrentResponse().addCookie(cookiecliente);
			VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
			Usuario_registrado usuarioRegistrado = (Usuario_registrado) session.getAttribute("usuarioRegistrado");
			Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

	    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
	    	mainView.remove(usuarioRegistrado);
	    	mainView.add(usuario_no_identificado);
	    	
//	    	VerticalLayout vlayout = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
//	    	Cabecera_Usuario _cabecera_Usuario = (Cabecera_Usuario) session.getAttribute("Cabecera_usuario_registrado");
//	    	vlayout.removeAll();
//	    	vlayout.add(_cabecera_Usuario);

		}else {
			Notification.show("Ha habido un error al eliminar el usuario.", 3000, Position.MIDDLE);
		}
	}



	protected void guardarCambiosUsuario() {
		// TODO Auto-generated method stub
		cliente.setApellidos(apellidos.getValue());
		cliente.setNombre(nombre.getValue());
		cliente.setEmail(correoElectronico.getValue());
		cliente.setPassword(password.getValue());
		
		iUsuario_registrado adm = new BDPrincipal();
		
		if((adm.guardarCambiosUsuario(cliente))) {
			Notification.show("El usuario ha actualizado con éxito.", 3000, Position.MIDDLE);
			VerticalLayout vlayout = null;
			if (cookiesHelper.isAdministrador()) {
				vlayout = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
				Cabecera_administrador _cabecera_administrador = (Cabecera_administrador) session.getAttribute("Cabecera_administrador");
				Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");
				
				vlayout.removeAll();
		    	vlayout.add(_cabecera_administrador);
		    	vlayout.add(_visualizar_Pantalla_Principal_Administrador);
			}else if (cookiesHelper.isCliente()) {
				vlayout = (VerticalLayout) session.getAttribute("verticalLayoutUsuarioIdentificado");
				Cabecera_Usuario _cabecera_Usuario = (Cabecera_Usuario) session.getAttribute("Cabecera_usuario_registrado");
				Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
				vlayout.removeAll();
		    	vlayout.add(_cabecera_Usuario);
		    	vlayout.add(_visualizar_Pantalla_Principal_Usuario_Registrado);
			}
	    	
	    	

		}else {
			Notification.show("Ha habido un error al actualizar el usuario.", 3000, Position.MIDDLE);
		}
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
	    labelTitulo.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "#1676f3");

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
					cookiesHelper.administrador = null;
					VaadinSession session = VaadinSession.getCurrent();
					session.setAttribute("tipoUsuario", "noUser");
					session.setAttribute("cliente", null);
					
					
					Cookie cookiecliente = new Cookie("cliente", "-1");

					Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

					cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
					cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
					cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
					cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
					VaadinService.getCurrentResponse().addCookie(cookiecliente);
					VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

			    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
			    	mainView.removeAll();
			    	mainView.add(usuario_no_identificado);
			    	
			    	

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



	public Vista_cuenta_usuario(Encargado_compras encargado_compras) {
		// TODO Auto-generated constructor stub
		super();
		if (encargado_compras == null) {
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
	    labelTitulo.getStyle().set("font-size", "2em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "#1676f3");

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
				if(adm.eliminarEncargadoCompras(encargado_compras.getID())) {
					Notification.show("El usuario ha sido borrado con éxito.", 3000, Position.MIDDLE);
					cookiesHelper.encargado_compras = null;
					VaadinSession session = VaadinSession.getCurrent();
					session.setAttribute("tipoUsuario", "noUser");
					session.setAttribute("cliente", null);
					
					
					Cookie cookiecliente = new Cookie("cliente", "-1");

					Cookie cookieTipoUsuario= new Cookie("tipoUsuario", "");

					cookiecliente.setMaxAge(60); // define after how many *seconds* the cookie should expire
					cookiecliente.setPath("/"); // single slash means the cookie is set for your whole application.
					cookieTipoUsuario.setMaxAge(60); // define after how many *seconds* the cookie should expire
					cookieTipoUsuario.setPath("/"); // single slash means the cookie is set for your whole application.
					VaadinService.getCurrentResponse().addCookie(cookiecliente);
					VaadinService.getCurrentResponse().addCookie(cookieTipoUsuario);
					Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

			    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
			    	mainView.removeAll();
			    	mainView.add(usuario_no_identificado);

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
		
		avatar.setSrc(encargado_compras.getFoto_perfil());
		nombre.setValue(encargado_compras.getNombre());
		apellidos.setValue(encargado_compras.getApellidos());
		correoElectronico.setValue(encargado_compras.getEmail());
		password.setValue(encargado_compras.getPassword());
	}
}