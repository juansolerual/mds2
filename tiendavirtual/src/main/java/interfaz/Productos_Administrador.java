package interfaz;

import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.orm.PersistentException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.History;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.Foto;
import basededatos.FotoDAO;
import basededatos.Producto;
import basededatos.ProductoDAO;
import basededatos.iAdmin;
import basededatos.iUsuario_registrado;
import interfaz.Producto_admin;
import vistas.VistaProductosadministrador;
import vistas.VistaProductousuario;

public class Productos_Administrador extends VistaProductosadministrador{
	private event _editar_producto_admin;
	public Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador;
	public VaadinSession session = VaadinSession.getCurrent();

	//public Vector<Producto_admin> _list_Producto_admin = new Vector<Producto_admin>();

	public Productos_Administrador(List<Producto_usuario> list) {
		for (Producto_usuario producto_administrador : list) {
			//this.getVaadinHorizontalLayout().add(new Producto_usuario());
		}
		
		
	}
	
//	public Productos_Administrador() {
//		//setSizeFull();
//	    // A layout that we want to scroll
//		HorizontalLayout scrollableLayout = new HorizontalLayout();
//	    for(int i = 0; i< 100; i++){
//	      scrollableLayout.add(new Producto_usuario(true));
//	    }
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
//	    Div nuevoProducto = new Div();
//	    nuevoProducto.getStyle().set("margin", "20px");
//	    nuevoProducto.add(new Text("Producto nuevo"));
//	    //Button nuevoProducto = new Button("Producto nuevo");
//		nuevoProducto.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {
//
//			@Override
//			public void onComponentEvent(ClickEvent<Div> event) {
//				// TODO Auto-generated method stub
//				HorizontalLayout horizontalLayoutAdministrador =
//						  (HorizontalLayout)
//						  session.getAttribute("horizontalLayoutAdministrador");
//				
//				horizontalLayoutAdministrador.removeAll();
//				
//				Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador =
//				  (Visualizar_Pantalla_Principal_Administrador)
//				  session.getAttribute("visualizar_Pantalla_Principal_Administrador");
//				
//				  VerticalLayout verticalLayoutAdmin = (VerticalLayout)
//				  session.getAttribute("verticalLayoutAdmin");
//				  verticalLayoutAdmin.remove(_visualizar_Pantalla_Principal_Administrador);
//				 
//				VistaProductousuario vistaProductoUsuario = new VistaProductousuario(null, true);
//				verticalLayoutAdmin.add(vistaProductoUsuario);
//			}
//			
//		});
//
//	    // Add both the scrollable layout and 
//	    // the static element to the layout
//	    this.getHorizontalProductos().add(staticElement, nuevoProducto, scrollableLayout);
//	    this.getHorizontalProductos().getStyle().set("border","1px solid blue");
//
//	}
	
	public Productos_Administrador() {
		// TODO Auto-generated constructor stub
		//setSizeFull();
	    // A layout that we want to scroll
		HorizontalLayout scrollableLayout = new HorizontalLayout();
		iAdmin user = new BDPrincipal();
		List<Producto> productos = user.cargarProductos();
		for (Producto producto : productos) {
	    	 Producto_usuario pu = new Producto_usuario(true);
		      //double start = 0;
		      //double end = 400;
		      //double random = new Random().nextDouble();
		      //double result = start + (random * (end - start));
		      //String temp = result + "€";
		      pu.getPrecio().setText(Double.valueOf(producto.getPrecio()).toString());
		      pu.getNombreProducto().setText(producto.getNombreProducto());
		      List<Foto> fotos = user.cargarFotos(producto.getID());
		      if (fotos != null) {
		    	  for (Foto foto : fotos) {
		    		  if (foto.getIsPrincipal()) {
				    	  pu.getAvatar().getStyle().set("background", "url("+foto.getURLFoto()+")");
		    		  }
				}
			      
		      }
		      
			      
		      pu.editarProducto.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
				
				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					VistaProductousuario vistaProductoUsuario = new VistaProductousuario(producto, true);
					
					System.out.println("Click administrador en producto con precio.. " + pu.getPrecio());
					VaadinSession session = VaadinSession.getCurrent();

			    	VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
			    	Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");
			    	session.setAttribute("vistaProductoUsuario", vistaProductoUsuario);

			    	verticalLayoutAdmin.remove(visualizar_Pantalla_Principal_Administrador);
			    	verticalLayoutAdmin.add(vistaProductoUsuario);
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
	    
	    HorizontalLayout primeraLinea = new HorizontalLayout();
	    primeraLinea.setPadding(true);

	   
	    // expands the empty space left of button two
	    
	    
//	    Div staticElement = new Div();
//	    //staticElement.getStyle().set("margin", "20px");
//	    staticElement.add(new Text("Productos Destacados"));
//	    staticElement.getStyle().set("color", "blue").set("font-weight", "bold");
	    
	    Label staticElement = new Label("Productos destacados");
	    staticElement.getStyle().set("color", "blue").set("font-weight", "bold").set("margin", "20px");
	    
	    Button nuevoProducto = new Button("+");
	    nuevoProducto.getElement().getStyle().set("margin-left", "auto");
		nuevoProducto.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
//				HorizontalLayout horizontalLayoutAdministrador =
//						  (HorizontalLayout)
//						  session.getAttribute("horizontalLayoutAdministrador");
//				
//				horizontalLayoutAdministrador.removeAll();
				
				Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador =
				  (Visualizar_Pantalla_Principal_Administrador)
				  session.getAttribute("visualizar_Pantalla_Principal_Administrador");
				
				  VerticalLayout verticalLayoutAdmin = (VerticalLayout)
				  session.getAttribute("verticalLayoutAdmin");
				  verticalLayoutAdmin.remove(_visualizar_Pantalla_Principal_Administrador);
				 
				VistaProductousuario vistaProductoUsuario = new VistaProductousuario(null, true);
				verticalLayoutAdmin.add(vistaProductoUsuario);
			}
			
		});
	    
	    
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    primeraLinea.add(staticElement, nuevoProducto);
	    primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");

	    this.getHorizontalProductos().add(primeraLinea, scrollableLayout);
	    this.getHorizontalProductos().getStyle().set("border","2px solid blue").set("border-radius","25px");
	}

	public void Editar_producto_admin() {
		throw new UnsupportedOperationException();
	}
	
	
}