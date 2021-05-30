package interfaz;

import javax.servlet.http.Cookie;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import tiendavirtual.cookiesHelper;
import vistas.VistaAdmin;

//import basededatos.iAdmin;

public class Admin extends VistaAdmin{
	
	//public iAdmin _iAdmin;
	public Vista_centro_de_mensajes_administrador _vista_centro_de_mensajes_administrador;
	public Vista_Categoria_Admin _vista_Categoria_Admin;
	public Vista_gestion_empleados _vista_gestion_empleados;
	public Vista_Ofertas_Admin _vista_Ofertas_Admin;
	public Vista_producto_Admin _vista_producto_Admin;
	public Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador;
	public Cabecera_administrador _cabecera_administrador;
	public VerticalLayout vlayout;
	public Vista_cuenta_usuario _vista_cuenta_usuario;

	
	public Admin() {
		super();
		vlayout = this.getVaadinVerticalLayout().as(VerticalLayout.class);
		_cabecera_administrador = new Cabecera_administrador();
		_visualizar_Pantalla_Principal_Administrador = new Visualizar_Pantalla_Principal_Administrador(vlayout);
		vlayout.add(_cabecera_administrador);
		vlayout.add(_visualizar_Pantalla_Principal_Administrador);
		VaadinSession session = VaadinSession.getCurrent();

    	session.setAttribute("verticalLayoutAdmin", vlayout);
    	session.setAttribute("Cabecera_administrador", _cabecera_administrador);


    	session.setAttribute("visualizar_Pantalla_Principal_Administrador", _visualizar_Pantalla_Principal_Administrador);
    	
    	
    	_cabecera_administrador.getCerrarSesion().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				_cabecera_administrador.Cerrar_sesion_administrador();
		    	
		    	

			}
		});
    	
    	_cabecera_administrador.getDivLogo().addClickListener(new ComponentEventListener<ClickEvent<Div>>() {

			@Override
			public void onComponentEvent(ClickEvent<Div> event) {
				// TODO Auto-generated method stub
				vlayout.removeAll();
				vlayout.add(_cabecera_administrador);
				vlayout.add(_visualizar_Pantalla_Principal_Administrador);
			}
			
		});
    	
    	_cabecera_administrador.getVaadinHorizontalLayout().addClickListener(new ComponentEventListener<ClickEvent<HorizontalLayout>>() {

			@Override
			public void onComponentEvent(ClickEvent<HorizontalLayout> event) {
				// TODO Auto-generated method stub
				vlayout.removeAll();
				vlayout.add(_cabecera_administrador);
				vlayout.add(_visualizar_Pantalla_Principal_Administrador);
				
			}
		});
    	
    	_cabecera_administrador.getVaadinButton().setText("Gestor empleados");
    	_cabecera_administrador.getVaadinButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				_vista_gestion_empleados = new Vista_gestion_empleados();
		    	session.setAttribute("Vista_gestion_empleados", _vista_gestion_empleados);

				vlayout.removeAll();
				vlayout.add(_cabecera_administrador);
				vlayout.add(_vista_gestion_empleados);

			}	
		});
    	
    	_cabecera_administrador.getMiCuentaButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {


			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				System.out.println("click ver cuenta");
				vlayout.removeAll();
				_vista_cuenta_usuario = new Vista_cuenta_usuario(cookiesHelper.administrador);
				vlayout.add(_cabecera_administrador);
				vlayout.add(_vista_cuenta_usuario);
			}	
		});
	}
}