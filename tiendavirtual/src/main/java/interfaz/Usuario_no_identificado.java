package interfaz;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.KeyUpEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Categoria;
import basededatos.CategoriaDAO;
import basededatos.BDPrincipal;
import basededatos.iAdmin;
import basededatos.iUsuario_no_identificado;
import vistas.VistaUsuarionoidentificado;

//import basededatos.iUsuario_no_identificado;

public class Usuario_no_identificado extends VistaUsuarionoidentificado{
	//public iUsuario_no_identificado _iUsuario_no_identificado;
	public Vista_carrito_Usuario_no_registrado _vista_carrito_Usuario_no_registrado;
	public Visualizar_Pantalla_Usuario_no_registrado _visualizar_Pantalla_Usuario_no_registrado;
	public Vista_busqueda_de_productos_categorias _vista_busqueda_productos_categorias;
	public Registrarse _registrarse;
	public Iniciar_sesion _iniciar_sesion;
	public Cabecera_Usuario_No_Registrado _cabecera_usuario_no_registrado;
	public VerticalLayout vlayout;

	
	
	public Usuario_no_identificado() {
		

		_iniciar_sesion = new Iniciar_sesion();
		_registrarse = new Registrarse();

		_cabecera_usuario_no_registrado = new Cabecera_Usuario_No_Registrado();
		// vlayout.add(_iniciar_sesion);
		
		_visualizar_Pantalla_Usuario_no_registrado = new Visualizar_Pantalla_Usuario_no_registrado(vlayout);
		
		vlayout = this.getVerticalLayout().as(VerticalLayout.class);
		vlayout.add(_cabecera_usuario_no_registrado);
		vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);

		VaadinSession session = VaadinSession.getCurrent();

    	session.setAttribute("verticalLayoutUsuarioNoIdentificado", vlayout);

		_cabecera_usuario_no_registrado.getIniciarSesionButton().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				//layout.remove(ccbn);	
				//layout.remove(lpnr);
				//layout.add(lg);
				System.out.println("click login");
				vlayout.remove(_visualizar_Pantalla_Usuario_no_registrado);
				vlayout.remove(_registrarse);

				vlayout.add(_iniciar_sesion);
				
			}
		});
		
		_cabecera_usuario_no_registrado.getRegistrarseButton().addClickListener(new ComponentEventListener() {
			@Override
			public void onComponentEvent(ComponentEvent event) {
				 
				//layout.remove(ccbn);	
				//layout.remove(lpnr);
				//layout.add(lg);
				System.out.println("click registrarse");
				vlayout.remove(_visualizar_Pantalla_Usuario_no_registrado);
				vlayout.remove(_iniciar_sesion);

				vlayout.add(_registrarse);
				
			}
		});
		
		
		_cabecera_usuario_no_registrado.getBusquedaText().addKeyDownListener(com.vaadin.flow.component.Key.ENTER, (ComponentEventListener<KeyDownEvent>) keyDownEvent -> {
			
			System.out.println(_cabecera_usuario_no_registrado.getBusquedaText().getValue());
			
			
			/*
			 * Visualizar_Pantalla_Usuario_no_registrado visualizar_pantalla =
			 * (Visualizar_Pantalla_Usuario_no_registrado)
			 * session.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
			 * VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout)
			 * session.getAttribute("verticalLayoutUsuarioNoIdentificado");
			 * verticalLayoutUsuarioNoIdentificado.remove(visualizar_pantalla);
			 */
			
			
			  vlayout.remove(_visualizar_Pantalla_Usuario_no_registrado);
			  
			  _vista_busqueda_productos_categorias = new Vista_busqueda_de_productos_categorias(_cabecera_usuario_no_registrado.getBusquedaText().getValue());
			  
			  vlayout.add(_vista_busqueda_productos_categorias);
			 

	    	//adm.nuevo_usuario();
	    	//adm.guardarCategoria(cat);
			
		});

		ComponentEventListener<ClickEvent<Div>> listenerHome = new ComponentEventListener<ClickEvent<Div>>() {

			@Override
			public void onComponentEvent(ClickEvent<Div> event) {
				// TODO Auto-generated method stub
				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_no_registrado);
				_visualizar_Pantalla_Usuario_no_registrado = new Visualizar_Pantalla_Usuario_no_registrado(vlayout);
				vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);

			}
			
		};
		
		_cabecera_usuario_no_registrado.getHorizontalTitulo().addClickListener(new ComponentEventListener<ClickEvent<HorizontalLayout>>() {

			@Override
			public void onComponentEvent(ClickEvent<HorizontalLayout> event) {
				// TODO Auto-generated method stub
				vlayout.removeAll();
				vlayout.add(_cabecera_usuario_no_registrado);
				_visualizar_Pantalla_Usuario_no_registrado = new Visualizar_Pantalla_Usuario_no_registrado(vlayout);
				vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);
			}
		});
		
		_cabecera_usuario_no_registrado.getDivLogo().addClickListener(listenerHome);
		
		//_cabecera_usuario_no_registrado.getBusquedaText()
		
		
		
		
	}
}