package interfaz;


import javax.servlet.http.Cookie;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import vistas.VistaApptransportes;

//import basededatos.iApp_transportes;

public class App_transportes extends VistaApptransportes{
	//public iApp_transportes _iApp_transportes;
	public Vista_pedidos_entregados _vista_pedidos_entregados;
	public Vista_pagina_principal _vista_pagina_principal;
	public Vista_pedidos_pendientes _vista_pedidos_pendientes;
	public VaadinSession session;
	public VerticalLayout horizontalLayoutVistaApp;
	public HorizontalLayout cabeceraAppTransportes;
	

	public App_transportes() {
		super();
    	session = VaadinSession.getCurrent();

		cabeceraAppTransportes = new HorizontalLayout();
		Label tituloPagina = new Label();
		tituloPagina.setText("App Transportes");
		tituloPagina.getStyle().set("color", "black").set("font-weight", "bold").set("margin", "20px");
		cabeceraAppTransportes.add(tituloPagina);
		_vista_pagina_principal = new Vista_pagina_principal();
    	session.setAttribute("Vista_pagina_principal_app_transportes", _vista_pagina_principal);

    	horizontalLayoutVistaApp = this.getHorizontalAppTransportes().as(VerticalLayout.class);
    	horizontalLayoutVistaApp.add(cabeceraAppTransportes, _vista_pagina_principal);
		
		_vista_pagina_principal.pedidosEntregadosButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				horizontalLayoutVistaApp.removeAll();
				horizontalLayoutVistaApp.add(cabeceraAppTransportes, _vista_pagina_principal);
				_vista_pedidos_entregados = new Vista_pedidos_entregados();
				horizontalLayoutVistaApp.add(_vista_pedidos_entregados);
				
				
			}
		});
		
		_vista_pagina_principal.pedidosPendientesButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				horizontalLayoutVistaApp.removeAll();
				horizontalLayoutVistaApp.add(cabeceraAppTransportes, _vista_pagina_principal);
				_vista_pedidos_pendientes = new Vista_pedidos_pendientes();
				horizontalLayoutVistaApp.add(_vista_pedidos_pendientes);
				
				
			}
		});
		
		_vista_pagina_principal.cerrarSesion.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
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
				App_transportes app_transportes = (App_transportes) session.getAttribute("app_transportes");
				Usuario_no_identificado usuario_no_identificado = new Usuario_no_identificado();

		    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
		    	mainView.remove(app_transportes);
		    	mainView.add(usuario_no_identificado);
				
				
			}
		});
		
	}
	
}