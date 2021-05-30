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

import basededatos.BDPrincipal;
import basededatos.Foto;
import basededatos.Producto;
import basededatos.iAdmin;
import vistas.VistaProductousuario;

public class Vista_producto_Admin extends VerticalLayout {
	
	public Admin _admin;
	public Lista_productos_admin _lista_productos_admin;
	public Button nuevaProductoButton;
	public HorizontalLayout cabeceraVista;
	public VaadinSession session;
	public Producto productoTemp;
	public Producto_administrador productoVistaTemp;
	public VerticalLayout scrollableLayout;
	public iAdmin adm;
	
	public Vista_producto_Admin() {
		super();
		session = VaadinSession.getCurrent();

		setWidth("100%");
		setHeight("100%");
		_lista_productos_admin = new Lista_productos_admin();
		_lista_productos_admin.setWidth("100%");
		_lista_productos_admin.setHeight("100%");

		adm = new BDPrincipal();

		// List<Cliente> clientes = adm.cargarClientes();

		scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_lista_productos");
		for (basededatos.Producto producto : _lista_productos_admin._list_Producto_administrador) {

			Producto_administrador produ = new Producto_administrador();

			produ.nombreProducto.setText("Nombre: " + producto.getNombreProducto());
			produ.descripcionProducto.setText("Descripción: " + producto.getDescripcion());

		      List<Foto> fotos = adm.cargarFotos(producto.getID());
		      if (fotos != null) {
		    	  for (Foto foto : fotos) {
		    		  produ.img.setSrc(foto.getURLFoto());
		    		  if (foto.getIsPrincipal()) {
				    	  produ.img.setSrc(foto.getURLFoto());
				    	  break;
		    		  }
				}
			      
		      }
		      
			

			scrollableLayout.add(produ);
			produ.eliminarProducto.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					productoVistaTemp = produ;
					productoTemp = producto;

					eliminarProducto();
					

				}
			});

			produ.modificarProducto.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					productoTemp = producto;
					guardarProducto();
					
				}
			});

		}

		// for(int i = 0; i< 10; i++){
		// scrollableLayout.add(new Producto_busqueda(false));
		// }
		// Give the layout a defined height that fits the parent layout
		scrollableLayout.setHeight("100%");
		scrollableLayout.setWidth("100%");
		// Set overflow on the y-axis to "auto".
		// It can be also "scroll", but then you
		// have a scroll bar even when one isn't needed.
		scrollableLayout.getStyle().set("overflow-y", "auto");
		// Another element to show that it stays in the same place
		Div staticElement = new Div();
		staticElement.getStyle().set("color", "#1676f3").set("font-size", "1em").set("font-weight", "bold").set("margin-top", "10px")
				.set("margin-left", "200px");
		staticElement.add(new Text("Productos"));

		// Add both the scrollable layout and
		// the static element to the layout
		_lista_productos_admin.add(scrollableLayout);
		_lista_productos_admin.getStyle().set("border","2px solid #1676f3").set("border-radius","25px");

		cabeceraVista = new HorizontalLayout();
		nuevaProductoButton = new Button("Nuevo producto");
		cabeceraVista.add(nuevaProductoButton, staticElement);

		add(cabeceraVista, _lista_productos_admin);

		nuevaProductoButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				nuevoProducto();
				

			}
		});
	}
	
	protected void nuevoProducto() {
		// TODO Auto-generated method stub
		Editar_producto editarProducto = new Editar_producto(null, true);
		VaadinSession session = VaadinSession.getCurrent();

    	VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
    	//Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");
    	session.setAttribute("vistaProductoAdmin", editarProducto);

    	verticalLayoutAdmin.remove(this);
    	verticalLayoutAdmin.add(editarProducto);
	}

	protected void eliminarProducto() {
		// TODO Auto-generated method stub
		this.scrollableLayout.remove(this.productoVistaTemp);
		adm.eliminarOferta(this.productoTemp.getID());
	}

	protected void guardarProducto() {
		// TODO Auto-generated method stub

		Editar_producto editarProducto = new Editar_producto(productoTemp, true);
		VaadinSession session = VaadinSession.getCurrent();

    	VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
    	//Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");
    	session.setAttribute("vistaProductoAdmin", editarProducto);

    	verticalLayoutAdmin.remove(this);
    	verticalLayoutAdmin.add(editarProducto);
	}
	
}
		
	