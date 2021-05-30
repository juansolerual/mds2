package interfaz;

import java.util.List;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.KeyPressEvent;
import com.vaadin.flow.component.KeyUpEvent;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Lineas_de_Pedido;
import tiendavirtual.LocalStorage;
import tiendavirtual.cookiesHelper;
import vistas.VistaProductousuario;
import vistas.VistaUsuarioregistrado;

//import basededatos.iUsuario_registrado;

public class Usuario_registrado extends VistaUsuarioregistrado{
	//public iUsuario_registrado _iUsuario_registrado;
	public Vista_centro_de_mensajes _vista_centro_de_mensajes;
	public Cabecera_usuario_registrado _cabecera_usuario_registrado;
	public Vista_cuenta_usuario _vista_cuenta_usuario;
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	public Vista_busqueda_de_productos_categorias _vista_busqueda_de_productos_categorias;
	public Vista_carrito_Usuario_registrado _vista_carrito_Usuario_registrado;
	public VerticalLayout vlayout;
	protected Vista_busqueda_de_productos_categorias _vista_busqueda_productos_categorias;

	public Usuario_registrado() {
		super();
		

		
		_cabecera_usuario_registrado = new Cabecera_usuario_registrado();
		
		Div imageDiv = new Div();
		imageDiv.getStyle().set("cursor", "pointer");
		Image img = new Image();
		img.setWidth("40px");
		img.setHeight("40px");
		img.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		imageDiv.add(img);
		
		img.setSrc(cookiesHelper.cliente.getFoto_perfil());
		
		_cabecera_usuario_registrado.getHorizontalIzq().add(imageDiv);
		
		_visualizar_Pantalla_Principal_Usuario_Registrado = new Visualizar_Pantalla_Principal_Usuario_Registrado(vlayout);
		
		vlayout = this.getVerticalLayout().as(VerticalLayout.class);
		vlayout.add(_cabecera_usuario_registrado);
		vlayout.add(_visualizar_Pantalla_Principal_Usuario_Registrado);
		
		VaadinSession session = VaadinSession.getCurrent();

		List<Lineas_de_Pedido> carrito = (List<Lineas_de_Pedido>) session.getAttribute("lineasDePedido");
		if (carrito != null) {
			_cabecera_usuario_registrado.getCarritoButton().setText("Carrito ("+carrito.size()+")");
		}

    	session.setAttribute("Cabecera_usuario_registrado", _cabecera_usuario_registrado);

    	session.setAttribute("verticalLayoutUsuarioIdentificado", vlayout);
    	session.setAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado", _visualizar_Pantalla_Principal_Usuario_Registrado);
		
		_cabecera_usuario_registrado.getBusquedaText().addKeyUpListener(new ComponentEventListener<KeyUpEvent>() {
			
			@Override
			public void onComponentEvent(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println(_cabecera_usuario_registrado.getBusquedaText().getValue());

				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_registrado);				  
				  _vista_busqueda_productos_categorias = new Vista_busqueda_de_productos_categorias(_cabecera_usuario_registrado.getBusquedaText().getValue());
				  
				  vlayout.add(_vista_busqueda_productos_categorias);
			}
		});
		
		_cabecera_usuario_registrado.getDivLogo().addClickListener(new ComponentEventListener<ClickEvent<Div>>() {

			@Override
			public void onComponentEvent(ClickEvent<Div> event) {
				// TODO Auto-generated method stub
				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_registrado);
				vlayout.add(_visualizar_Pantalla_Principal_Usuario_Registrado);
			}
			
		});
		
		_cabecera_usuario_registrado.getHorizontalTitulo().addClickListener(new ComponentEventListener<ClickEvent<HorizontalLayout>>() {

			@Override
			public void onComponentEvent(ClickEvent<HorizontalLayout> event) {
				// TODO Auto-generated method stub
//				vlayout.removeAll();
//				vlayout.add(_cabecera_usuario_no_registrado);
//				_visualizar_Pantalla_Usuario_no_registrado = new Visualizar_Pantalla_Usuario_no_registrado(vlayout);
//				vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);
				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_registrado);
				vlayout.add(_visualizar_Pantalla_Principal_Usuario_Registrado);
				
			}
		});
		
		_cabecera_usuario_registrado.getCarritoButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				System.out.println("click ver carrito");
				vlayout.removeAll();
				
				_vista_carrito_Usuario_registrado = new Vista_carrito_Usuario_registrado();
				vlayout.add(_cabecera_usuario_registrado);
				vlayout.add(_vista_carrito_Usuario_registrado);
				

			}
		});
		
		_cabecera_usuario_registrado.getMicuentaButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				System.out.println("click ver cuenta");
				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_registrado);
				_vista_cuenta_usuario = new Vista_cuenta_usuario(cookiesHelper.cliente);
				
				vlayout.add(_vista_cuenta_usuario);
				

			}
		});
		
		imageDiv.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Div> event) {
				System.out.println("click ver cuenta");
				vlayout.remove(_visualizar_Pantalla_Principal_Usuario_Registrado);
				_vista_cuenta_usuario = new Vista_cuenta_usuario(cookiesHelper.cliente);
				
				vlayout.add(_vista_cuenta_usuario);
				

			}
		});
		
		_visualizar_Pantalla_Principal_Usuario_Registrado._productos_Usuario.carritoText.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChanged(ValueChangeEvent event) {
				// TODO Auto-generated method stub

				System.out.println("El numero en el carrito ha cambiado " + _visualizar_Pantalla_Principal_Usuario_Registrado._productos_Usuario.carritoInt);
				_cabecera_usuario_registrado.getCarritoButton().setText("Carrito ("+_visualizar_Pantalla_Principal_Usuario_Registrado._productos_Usuario.carritoInt+")");
			}
		});
		
//		_visualizar_Pantalla_Principal_Usuario_Registrado._elementos_comunes_pantalla_principal._categorias._vista_busqueda_productos_categorias.carritoText.addValueChangeListener(new ValueChangeListener() {
//			@Override
//			public void valueChanged(ValueChangeEvent event) {
//				// TODO Auto-generated method stub
//
//				System.out.println("El numero en el carrito ha cambiado " + _visualizar_Pantalla_Principal_Usuario_Registrado._elementos_comunes_pantalla_principal._categorias._vista_busqueda_productos_categorias.carritoInt);
//				_cabecera_usuario_registrado.getCarritoButton().setText("Carrito ("+_visualizar_Pantalla_Principal_Usuario_Registrado._elementos_comunes_pantalla_principal._categorias._vista_busqueda_productos_categorias.carritoInt+")");
//			}
//		});
		
		_cabecera_usuario_registrado.getCerrarSesionButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				_cabecera_usuario_registrado.Cerrar_sesion();
		    	
		    	

			}
		});
	}
	
}