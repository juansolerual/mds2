package interfaz;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Lineas_de_Pedido;
import basededatos.Producto;
import basededatos.ProductoDAO;
import basededatos.iUsuario_registrado;
import tiendavirtual.cookiesHelper;
import vistas.VistaBusqueda;

public class Vista_busqueda_de_productos_categorias extends VistaBusqueda {
	private event _filtrar_por_precio;
	private event _filtrar_por_categoria;
	private event _filtrar_por_marca;
	public Usuario_registrado _usuario_registrado;
	public Resultado_de_la_busqueda _resultado_de_la_busqueda;
	public VerticalLayout barraIzquierda;
	public VerticalLayout barraDerecha;
	public Button filtrar_por_precio;
	public Button filtrar_por_categoria;
	public Button filtrar_por_marca;
	public TextField carritoText = new TextField();
	public int carritoInt = 0;

	public Vista_busqueda_de_productos_categorias(String busqueda) {
		super();
		iUsuario_registrado usuario = new BDPrincipal();
		List<Producto> productos = usuario.cargarProductos(busqueda);
		
		for (Producto producto : productos) {
			System.out.println(producto.getNombreProducto());
		}
		
		VaadinSession session = VaadinSession.getCurrent();
		try {
			System.out.println(session.getAttribute("username").toString());
			
			
					/*
			 * VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
			 * Usuario_no_identificado user = (Usuario_no_identificado)
			 * session.getAttribute("usuarioNoIdentificado"); mainView.remove(user);
			 */
			
		} catch(Exception e) {
			// no username is session
			System.out.println(e);
		}
        

		
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		
		VerticalLayout scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_productos");
		for (Producto producto : productos) {
			System.out.println(producto.getNombreProducto());
		    scrollableLayout.add(new Producto_busqueda(false, producto));

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
	    staticElement.getStyle().set("margin", "20px");
	    staticElement.add(new Text("Productos Destacados"));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraDerecha.add(staticElement, scrollableLayout);
	    barraDerecha.getStyle().set("border","1px solid blue");
	    
	    filtrar_por_categoria = new Button("Filtrar por categoria");
	    filtrar_por_precio = new Button("Filtrar por precio");
	    filtrar_por_marca = new Button("Filtrar por marca");
	    
	    
	    
	    barraIzquierda.setHeight("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    barraIzquierda.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	   
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraIzquierda.getStyle().set("border","1px solid blue");
	    barraIzquierda.add(filtrar_por_categoria,filtrar_por_precio, filtrar_por_marca);

	    
		

	}

	public Vista_busqueda_de_productos_categorias(basededatos.Categoria cat) {
		super();
		iUsuario_registrado usuario = new BDPrincipal();
		List<Producto> productos = usuario.cargarProductos();
		VerticalLayout scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_productos");
		
		for (Producto producto : productos) {
			if (producto.getPertenece_a().getNombreCategoria().equals(cat.getNombreCategoria())) {
				System.out.println("Producto ");
				System.out.println("Producto " + producto.getNombreProducto() + " y categoria " + producto.getPertenece_a().getNombreCategoria());
				System.out.println("Categoria buscada " + cat.getNombreCategoria());	
				Producto_busqueda pb = new Producto_busqueda(false, producto);
				
				pb.anadirCarrito.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
						
						@Override
						public void onComponentEvent(ClickEvent<Button> event) {
							// TODO Auto-generated method stub
							
							VaadinSession session = VaadinSession.getCurrent();
							
							List<Lineas_de_Pedido> carrito = new ArrayList<Lineas_de_Pedido>();
							if (cookiesHelper.isNoRegistrado()) {
								carrito = (List<Lineas_de_Pedido>) session.getAttribute("carrito_invitado");

							}else {
								carrito = (List<Lineas_de_Pedido>) session.getAttribute(String.valueOf(cookiesHelper.idUsuario));
							}
							

							if (carrito == null) {
								carrito = new ArrayList<Lineas_de_Pedido>();
							}

							//String tipoUsuario = (String) session.getAttribute("tipoUsuario");
							//Cliente cliente = null;
							//if (tipoUsuario.equals("cliente")) {
							//	cliente = (Cliente) session.getAttribute("cliente");
							//}
							
							//pedido.setRealizado_por(cliente);
							for (Lineas_de_Pedido ldp : carrito) {
								if (ldp.getDe_un().getID() == producto.getID()) {
									ldp.setCantidad(ldp.getCantidad()+1);
									if (cookiesHelper.isNoRegistrado()) {
										session.setAttribute("carrito_invitado", carrito);

									}else {
										session.setAttribute(String.valueOf(cookiesHelper.idUsuario), carrito);

									}						
									return;
								}
							}
							
							Lineas_de_Pedido linea = new Lineas_de_Pedido();
							linea.setDe_un(producto);
							linea.setCantidad(1);
							carrito.add(linea);
							//linea.setPertenecen_a(pedido);
							if (cookiesHelper.isNoRegistrado()) {
								System.out.println("carrito is not registrado");
								session.setAttribute("carrito_invitado", carrito);

							}else {
								System.out.println("carrito is registrado");

								session.setAttribute(String.valueOf(cookiesHelper.idUsuario), carrito);

							}
							carritoInt++;
							carritoText.setValue(carritoInt+"");
							
						}
				      });
			    scrollableLayout.add(pb);
			}
			
		}
		
		VaadinSession session = VaadinSession.getCurrent();
		

		
		barraIzquierda = this.getBarraIzquierda().as(VerticalLayout.class);
		barraDerecha = this.getBarraDerecha().as(VerticalLayout.class);
		barraDerecha.getStyle().set("width", "85%");
		barraIzquierda.getStyle().set("width", "15%");

		
		
		
	    
	    scrollableLayout.setHeight("100%");
	    scrollableLayout.setWidth("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    scrollableLayout.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	    Div staticElement = new Div();
	    staticElement.getStyle().set("margin", "20px");
	    staticElement.add(new Text("Productos de la categoria " + cat.getNombreCategoria()));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraDerecha.add(staticElement, scrollableLayout);
	    barraDerecha.getStyle().set("border","1px solid blue");
	    
	    filtrar_por_categoria = new Button("Filtrar por categoria");
	    filtrar_por_precio = new Button("Filtrar por precio");
	    filtrar_por_marca = new Button("Filtrar por marca");
	    
	    
	    
	    barraIzquierda.setHeight("100%");
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
	    barraIzquierda.getStyle().set("overflow-y", "auto");
	    // Another element to show that it stays in the same place
	   
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    barraIzquierda.getStyle().set("border","1px solid blue");
	    barraIzquierda.add(filtrar_por_precio, filtrar_por_marca);

	    
		

	}
	public void Filtrar_por_precio() {
		throw new UnsupportedOperationException();
	}

	public void Filtrar_por_categoria() {
		throw new UnsupportedOperationException();
	}

	public void Filtrar_por_marca() {
		throw new UnsupportedOperationException();
	}
}