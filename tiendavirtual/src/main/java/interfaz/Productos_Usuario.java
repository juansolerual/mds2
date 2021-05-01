package interfaz;

import java.sql.Time;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;

import org.orm.PersistentException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Foto;
import basededatos.FotoDAO;
import basededatos.Lineas_de_Pedido;
import basededatos.Pedido;
import basededatos.Producto;
import basededatos.ProductoDAO;
import basededatos.iAdmin;
import basededatos.iUsuario_registrado;
import interfaz.Producto_usuario;
import tiendavirtual.cookiesHelper;
import vistas.VistaProductosusuario;
import vistas.VistaProductousuario;

public class Productos_Usuario extends VistaProductosusuario{
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	public TextField carritoText = new TextField();
	public int carritoInt = 0;
	//public Vector<Producto_usuario> _list_Producto_usuario = new Vector<Producto_usuario>();

	public Productos_Usuario(List<Producto_usuario> list) {
		for (Producto_usuario producto_usuario : list) {
			//this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
	
//	public Productos_Usuario(HorizontalLayout horizontalLayout, VerticalLayout verticalLayout, VerticalLayout vlayout2, Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado) {
//		
//		Productos_Usuario thisProductos = this;
//		//setSizeFull();
//	    // A layout that we want to scroll
//		HorizontalLayout scrollableLayout = new HorizontalLayout();
//	    for(int i = 0; i< 10; i++){
//	      Producto_usuario pu = new Producto_usuario(false);
//	      double start = 0;
//	      double end = 400;
//	      double random = new Random().nextDouble();
//	      double result = start + (random * (end - start));
//	      String temp = result + "€";
//	      pu.getPrecio().setText(temp);
//	      pu.anadirCarrito.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
//			
//			@Override
//			public void onComponentEvent(ClickEvent<Button> event) {
//				// TODO Auto-generated method stub
//				System.out.println("Click en producto con precio.. " + result);
//				//horizontalLayout.add(pu);
//				horizontalLayout.removeAll();
//				verticalLayout.removeAll();
//				Producto productoUsuario = ProductoDAO.createProducto();
//				//basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.createProducto();
//
//				VistaProductousuario vistaProductoUsuario = new VistaProductousuario(productoUsuario, false);
//				verticalLayout.add(vistaProductoUsuario);
//			}
//	      });
//	      scrollableLayout.add(pu);
//	    }
//	    
//	    
//	    // Give the layout a defined height that fits the parent layout
//	    scrollableLayout.setHeight("100%");
//	    scrollableLayout.setWidth(null);
//	    // Set overflow on the y-axis to "auto".
//	    // It can be also "scroll", but then you 
//	    // have a scroll bar even when one isn't needed.
//	    scrollableLayout.getStyle().set("overflow-x", "auto");
//	    // Another element to show that it stays in the same place
//	    Div staticElement = new Div();
//	    staticElement.getStyle().set("margin", "20px");
//	    staticElement.add(new Text("Productos Destacados"));
//	    // Add both the scrollable layout and 
//	    // the static element to the layout
//	    this.getHorizontalProductos().add(staticElement, scrollableLayout);
//	    this.getHorizontalProductos().getStyle().set("border","1px solid blue");
//	    
//	    	
//		}

	

	public Productos_Usuario(String visualizarPantalla) {
		//setSizeFull();
	    // A layout that we want to scroll
		HorizontalLayout scrollableLayout = new HorizontalLayout();
		iUsuario_registrado user = new BDPrincipal();
		List<Producto> productos = user.cargarProductos();
		for (Producto producto : productos) {
	      Producto_usuario pu = new Producto_usuario(false);
	      //double start = 0;
	      //double end = 400;
	      //double random = new Random().nextDouble();
	      //double result = start + (random * (end - start));
	      //String temp = result + "€";
	      pu.getPrecio().setText(Double.valueOf(producto.getPrecio()).toString());
	      pu.getNombreProducto().setText(producto.getNombreProducto());
	      
	      iAdmin adm = new BDPrincipal();

	      List<Foto> fotos = adm.cargarFotos(producto.getID());
	      if (fotos != null) {
	    	  for (Foto foto : fotos) {
	    		  if (foto.getIsPrincipal()) {
			    	  pu.getAvatar().getStyle().set("background", "url("+foto.getURLFoto()+")");
	    		  }
			}
		      
	      }
	      
	      
	      
	      
	      pu.anadirCarrito.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				
				VaadinSession session = VaadinSession.getCurrent();
				
				List<Lineas_de_Pedido> carrito = (List<Lineas_de_Pedido>) session.getAttribute(String.valueOf(cookiesHelper.idUsuario));
				

				if (carrito == null) {
					carrito = new ArrayList<Lineas_de_Pedido>();
				}

				//String tipoUsuario = (String) session.getAttribute("tipoUsuario");
				//Cliente cliente = null;
				//if (tipoUsuario.equals("cliente")) {
				//	cliente = (Cliente) session.getAttribute("cliente");
				//}
				
				//pedido.setRealizado_por(cliente);
				
				Lineas_de_Pedido linea = new Lineas_de_Pedido();
				linea.setDe_un(producto);
				linea.setCantidad(1);
				carrito.add(linea);
				//linea.setPertenecen_a(pedido);
				
				session.setAttribute(String.valueOf(cookiesHelper.idUsuario), carrito);
				carritoInt++;
				carritoText.setValue(carritoInt+"");
				
			}
	      });
	      pu.avatar.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Div> event) {
					System.out.println("Click en producto con precio.. " + pu.getPrecio());
					VaadinSession session = VaadinSession.getCurrent();

			    	VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout) session.getAttribute("verticalLayoutUsuarioNoIdentificado");
			    	VerticalLayout verticalLayoutUsuarioIdentificado = (VerticalLayout) session.getAttribute("verticalLayoutUsuarioIdentificado");
			    	VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
			    	VerticalLayout ultimoEStado = mainView;
			    	session.setAttribute("ultimoEstado", ultimoEStado);
			    	
			    	VistaProductousuario vistaProductoUsuario = new VistaProductousuario(producto, false);
			    	session.setAttribute("vistaProductoUsuario", vistaProductoUsuario);
			    	
			    	if (visualizarPantalla.equals("Visualizar_Pantalla_Principal_Usuario_Registrado")) {
			    		
			    		Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
			    		verticalLayoutUsuarioIdentificado.remove(visualizar_Pantalla_Principal_Usuario_Registrado);
			    		verticalLayoutUsuarioIdentificado.add(vistaProductoUsuario);

			    		
			    	}
			    	
			    	if (visualizarPantalla.equals("Visualizar_Pantalla_Usuario_no_registrado")) {
			    		Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado = (Visualizar_Pantalla_Usuario_no_registrado) session.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
				    	verticalLayoutUsuarioNoIdentificado.remove(visualizar_Pantalla_Usuario_no_registrado);
						verticalLayoutUsuarioNoIdentificado.add(vistaProductoUsuario);

			    	}
			    	
			        
			    	
					

				}
			});
	      Dialog dialogDescripcion = new Dialog();
			HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
			Label tituloUploadDialog = new Label("Descripción del producto " + producto.getNombreProducto());
			dialogUploadHorizontal.add(tituloUploadDialog);
			dialogDescripcion.setWidth("800px");
			dialogDescripcion.setHeight("600px");
			dialogDescripcion.setCloseOnEsc(true);
			dialogDescripcion.setCloseOnOutsideClick(true);

			//dialogDescripcion.setModal(false);
			dialogDescripcion.setDraggable(true);
			dialogDescripcion.setResizable(true);
			TextArea descripcion = new TextArea("Descripción");
			descripcion.setValue(producto.getDescripcion());
			Button closeButton =  new Button("Cerrar");
			VerticalLayout dialogVertical = new VerticalLayout(descripcion);
			HorizontalLayout dialogButtons = new HorizontalLayout(closeButton);
			closeButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					dialogDescripcion.close();
				}
				
			});
			dialogDescripcion.add(dialogUploadHorizontal,dialogVertical,dialogButtons);
	      pu.verDescripcion.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					System.out.println("click ver descripcion");
					dialogDescripcion.open();
					
				}
			});
	      scrollableLayout.add(pu);
	    }
	    
	    
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayout.setHeight("100%");
	    scrollableLayout.setWidth(null);
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
		scrollableLayout.getStyle().set("overflow-x", "auto").set("margin-left", "20px").set("margin-right", "20px");
	    // Another element to show that it stays in the same place
		Label staticElement = new Label("Productos destacados");
		staticElement.getStyle().set("color", "blue").set("font-weight", "bold").set("margin", "20px");
		
		HorizontalLayout primeraLinea = new HorizontalLayout();
		primeraLinea.setPadding(true);
		primeraLinea.add(staticElement);
		primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalProductos().add(primeraLinea, scrollableLayout);
		this.getHorizontalProductos().getStyle().set("border", "2px solid blue").set("border-radius", "25px");

	};

	}

	
	
	
