package interfaz;

import java.util.EventListener;
import java.util.List;
import java.util.Random;

import org.orm.PersistentException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.Foto;
import basededatos.FotoDAO;
import basededatos.Producto;
import basededatos.ProductoDAO;
import basededatos.iUsuario_registrado;
import interfaz.Producto_usuario;
import vistas.VistaProductosusuario;
import vistas.VistaProductousuario;

public class Productos_Usuario extends VistaProductosusuario{
	public Visualizar_Pantalla_Principal_Usuario_Registrado _visualizar_Pantalla_Principal_Usuario_Registrado;
	//public Vector<Producto_usuario> _list_Producto_usuario = new Vector<Producto_usuario>();

	public Productos_Usuario(List<Producto_usuario> list) {
		for (Producto_usuario producto_usuario : list) {
			//this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
	
	public Productos_Usuario(HorizontalLayout horizontalLayout, VerticalLayout verticalLayout, VerticalLayout vlayout2, Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado) {
		
		Productos_Usuario thisProductos = this;
		//setSizeFull();
	    // A layout that we want to scroll
		HorizontalLayout scrollableLayout = new HorizontalLayout();
	    for(int i = 0; i< 10; i++){
	      Producto_usuario pu = new Producto_usuario(false);
	      double start = 0;
	      double end = 400;
	      double random = new Random().nextDouble();
	      double result = start + (random * (end - start));
	      String temp = result + "€";
	      pu.getPrecio().setText(temp);
	      pu.anadirCarrito.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				System.out.println("Click en producto con precio.. " + result);
				//horizontalLayout.add(pu);
				horizontalLayout.removeAll();
				verticalLayout.removeAll();
				Producto productoUsuario = ProductoDAO.createProducto();
				//basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.createProducto();

				VistaProductousuario vistaProductoUsuario = new VistaProductousuario(productoUsuario, false);
				verticalLayout.add(vistaProductoUsuario);
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
	    scrollableLayout.getStyle().set("overflow-x", "auto");
	    // Another element to show that it stays in the same place
	    Div staticElement = new Div();
	    staticElement.getStyle().set("margin", "20px");
	    staticElement.add(new Text("Productos Destacados"));
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalProductos().add(staticElement, scrollableLayout);
	    this.getHorizontalProductos().getStyle().set("border","1px solid blue");
	    
	    	
		}

	

	public Productos_Usuario(HorizontalLayout horizontalLayout, VerticalLayout verticalLayout, VerticalLayout vlayout,
			Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado) {
		Productos_Usuario thisProductos = this;
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
	      
	      Foto foto = null;
		try {
			foto = FotoDAO.loadFotoByQuery("Foto.ProductoID='"+producto.getID()+"'", null);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      if (foto != null) {
	    	  pu.getAvatar().getStyle().set("background", "url("+foto.getURLFoto()+")");
	      }
	      
	      
	      pu.anadirCarrito.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
			
			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				System.out.println("Click en producto con precio.. " + pu.getPrecio());
				//horizontalLayout.add(pu);
				horizontalLayout.removeAll();
				verticalLayout.removeAll();
//				Producto productoUsuario = new Producto();
//				productoUsuario.setDescripcion("prueba");
//				productoUsuario.setPrecio(22.2);
//				productoUsuario.setNombreProducto("nombre");
				//basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.createProducto();
			
				VistaProductousuario vistaProductoUsuario = new VistaProductousuario(producto, false);
				verticalLayout.add(vistaProductoUsuario);
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

	
	
	
