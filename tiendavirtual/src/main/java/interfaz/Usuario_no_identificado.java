package interfaz;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.KeyUpEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
	public Registrarse _registrarse;
	public Iniciar_sesion _iniciar_sesion;
	public Cabecera_Usuario_No_Registrado _cabecera_usuario_no_registrado;
	public VerticalLayout vlayout;
	iUsuario_no_identificado adm = new BDPrincipal();

	
	
	public Usuario_no_identificado() {
		

		_iniciar_sesion = new Iniciar_sesion();
		_registrarse = new Registrarse();

		_cabecera_usuario_no_registrado = new Cabecera_Usuario_No_Registrado();
		// vlayout.add(_iniciar_sesion);
		
		_visualizar_Pantalla_Usuario_no_registrado = new Visualizar_Pantalla_Usuario_no_registrado(vlayout);
		
		vlayout = this.getVerticalLayout().as(VerticalLayout.class);
		vlayout.add(_cabecera_usuario_no_registrado);
		
		vlayout.add(_visualizar_Pantalla_Usuario_no_registrado);
		
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
	    	
	    	adm.nuevo_usuario();
	    	//adm.guardarCategoria(cat);
		});

		
		//_cabecera_usuario_no_registrado.getBusquedaText()
		
		
		
		
	}
}