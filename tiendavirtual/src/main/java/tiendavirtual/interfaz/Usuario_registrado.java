package tiendavirtual.interfaz;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.KeyPressEvent;
import com.vaadin.flow.component.KeyUpEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import vistas.VistaUsuarioregistrado;

//import basededatos.iUsuario_registrado;

public class Usuario_registrado extends VistaUsuarioregistrado{
	//public iUsuario_registrado _iUsuario_registrado;
	public Vista_centro_de_mensajes _vista_centro_de_mensajes;
	public Cabecera_usuario_registrado _cabecera_usuario_registrado;
	public Vista_cuenta_usuario _vista_cuenta_usuario;
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	public Vista_busqueda_de_productos_categorias _vista_busqueda_de_productos_categorias;
	public VerticalLayout vlayout;

	
	public Usuario_registrado() {
		super();
		_cabecera_usuario_registrado = new Cabecera_usuario_registrado();
		_visualizar_Pantalla_Principal_Usuario_Registrado = new Visualizar_Pantalla_Principal_Usuario_Registrado();
		
		vlayout = this.getVerticalLayout().as(VerticalLayout.class);
		vlayout.add(_cabecera_usuario_registrado);
		vlayout.add(_visualizar_Pantalla_Principal_Usuario_Registrado);
		
		_cabecera_usuario_registrado.getBusquedaText().addKeyUpListener(new ComponentEventListener<KeyUpEvent>() {
			
			@Override
			public void onComponentEvent(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println(_cabecera_usuario_registrado.getBusquedaText().getValue());

			}
		});
		
	}
	
}