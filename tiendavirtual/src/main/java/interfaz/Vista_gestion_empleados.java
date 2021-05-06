package interfaz;

import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.BD_Administrador;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.Transportista;
import basededatos.iAdmin;

public class Vista_gestion_empleados extends VerticalLayout {
	public Admin _admin;
	public Lista_empleados _lista_empleados;
	public Dar_alta_empleado _dar_alta_empleado;
	public Button nuevoEmpleado; 
	public HorizontalLayout cabeceraVista;
	public VaadinSession session;

	public Vista_gestion_empleados() {
		super();
    	session = VaadinSession.getCurrent();

		setWidth("100%");
		setHeight("100%");
		_lista_empleados = new Lista_empleados();
		_lista_empleados.setWidth("100%");
		_lista_empleados.setHeight("100%");
		
		
		iAdmin adm = new BDPrincipal();
		
		List<Administrador> administradores = adm.cargarAdministradores();
		// List<Cliente> clientes = adm.cargarClientes();
		List<basededatos.Encargado_compras> encargadosCompras = adm.cargarEncargadosCompras();
		List<basededatos.Transportista> transportistas = adm.cargarTransportistas();
		
		VerticalLayout scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_empleados");
		for (Administrador administrador: administradores) {
			System.out.println("Administrador " + administrador.getNombre());
			Empleado empleado = new Empleado();
			empleado.empleo.setText("Administrador");
			empleado.empleado.setText(administrador.getNombre() + " " + administrador.getApellidos());
			empleado.datosEmpleado.setText("Direccion " + administrador.getDireccion());
			if (administrador.getFoto_perfil() != null) {
			empleado.img.setSrc(administrador.getFoto_perfil());
			}			
			scrollableLayout.add(empleado);
			empleado.eliminarEmpleado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					scrollableLayout.remove(empleado);
					adm.eliminarAdministrador(administrador.getID());

				}
			});
			
			empleado.modificarDatos.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					Vista_gestion_empleados _vista_gestion_empleados = (Vista_gestion_empleados) session.getAttribute("Vista_gestion_empleados");
					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
						
					 verticalLayoutAdmin.remove(_vista_gestion_empleados);
					Registrarse _registrarse = new Registrarse(administrador);
					session.setAttribute("Registrarse", _registrarse);
					verticalLayoutAdmin.add(_registrarse);
				}
			});

			

		}
		for (Encargado_compras encargado: encargadosCompras) {
			System.out.println("Administrador " + encargado.getNombre());
			Empleado empleado = new Empleado();
			empleado.empleo.setText("Encargado de compras");
			empleado.empleado.setText(encargado.getNombre() + " " + encargado.getApellidos());
			empleado.datosEmpleado.setText("Direccion " + encargado.getDireccion());
			if (encargado.getFoto_perfil() != null) {

			empleado.img.setSrc(encargado.getFoto_perfil());
			}			
			scrollableLayout.add(empleado);
			
			empleado.eliminarEmpleado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					scrollableLayout.remove(empleado);
					adm.eliminarEncargadoCompras(encargado.getID());
				}
			});
			
			empleado.modificarDatos.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					Vista_gestion_empleados _vista_gestion_empleados = (Vista_gestion_empleados) session.getAttribute("Vista_gestion_empleados");
					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
						
					 verticalLayoutAdmin.remove(_vista_gestion_empleados);
					Registrarse _registrarse = new Registrarse(encargado);
					session.setAttribute("Registrarse", _registrarse);
					verticalLayoutAdmin.add(_registrarse);
				}
			});

		}
		
		for (Transportista transportista: transportistas) {
			System.out.println("transportista " + transportista.getNombre());
			Empleado empleado = new Empleado();
			empleado.empleo.setText("Transportista");
			empleado.empleado.setText(transportista.getNombre() + " " + transportista.getApellidos());
			empleado.datosEmpleado.setText("Direccion " + transportista.getDireccion());
			if (transportista.getFoto_perfil() != null) {
				empleado.img.setSrc(transportista.getFoto_perfil());
			}
			
			scrollableLayout.add(empleado);
			
			empleado.eliminarEmpleado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					scrollableLayout.remove(empleado);
					adm.eliminarTransportista(transportista.getID());

				}
			});
			
			empleado.modificarDatos.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					Vista_gestion_empleados _vista_gestion_empleados = (Vista_gestion_empleados) session.getAttribute("Vista_gestion_empleados");
					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
						
					 verticalLayoutAdmin.remove(_vista_gestion_empleados);
					Registrarse _registrarse = new Registrarse(transportista);
					session.setAttribute("Registrarse", _registrarse);
					verticalLayoutAdmin.add(_registrarse);
				}
			});

		}
		
		
		
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
	    Div staticElement = new Div();
	    staticElement.getStyle().set("color", "blue").set("font-weight", "bold").set("margin-top", "10px").set("margin-left", "200px");
	    staticElement.add(new Text("Empleados"));
	    
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    _lista_empleados.add(scrollableLayout);
	    _lista_empleados.getStyle().set("border","1px solid blue");
	    
	    cabeceraVista = new HorizontalLayout();
	    nuevoEmpleado = new Button("Nuevo empleado");
	    cabeceraVista.add(nuevoEmpleado, staticElement);
	    
	    add(cabeceraVista, _lista_empleados);
	   
		nuevoEmpleado.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Vista_gestion_empleados _vista_gestion_empleados = (Vista_gestion_empleados) session.getAttribute("Vista_gestion_empleados");
				VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
				
				verticalLayoutAdmin.remove(_vista_gestion_empleados);
				Registrarse _registrarse = new Registrarse(true);
		    	session.setAttribute("Registrarse", _registrarse);

		    	verticalLayoutAdmin.add(_registrarse);


			}
		});
		
		
	    
	    
		
		
	}
	
	
}