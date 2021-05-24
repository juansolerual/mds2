package interfaz;

import com.vaadin.flow.component.AbstractField.ComponentValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

import basededatos.Lineas_de_Pedido;
import vistas.VistaProductocarrito;

public class Producto_Carrito extends VistaProductocarrito{
	public Lista_elementos_carrito _lista_elementos_carrito;
	public Seleccionar_cantidad _seleccionar_cantidad;
	//public Text precio;
	public Button eliminarLinea;
	public Button editarProducto;
	public Div avatar;
	public Div name;
	public TextField precio;
	public double precioLinea;
	public  Select<String> placeholderSelect;

	public Producto_Carrito(Lineas_de_Pedido lineaDePedido) {
		super();

		if (lineaDePedido == null) {
			return;
		}
		
		
		avatar = new Div();
	    avatar.setWidth("120px");
	    avatar.setHeight("120px");
	    avatar.getStyle()
	      .set("background-color", "gray")
	      .set("border-radius", "12px")
	      .set("margin", "16px")
	      .set("background", "url(https://picsum.photos/200)")
	      .set("cursor", "pointer");
	    
	    name = new Div();
	    name.add(lineaDePedido.getDe_un().getNombreProducto());
	    name.getStyle().set("color", "blue").set("margin", "16px");
	    precio = new TextField();
	    precio.setReadOnly(true);
	    java.util.Date date = lineaDePedido.getDe_un().getAplica_oferta().getFechaCaducidadOferta();
		java.util.Date datenow = new java.util.Date();
		int resultado = datenow.compareTo(date);
		precioLinea = 0;
		if (lineaDePedido.getDe_un().getAplica_oferta().getActivada() && resultado == -1) {
			if (lineaDePedido.getDe_un().getAplica_oferta().getPorcentajeOferta()) {
				precioLinea = (lineaDePedido.getDe_un().getPrecio()
						- (lineaDePedido.getDe_un().getPrecio() * (lineaDePedido.getDe_un().getAplica_oferta().getPrecioOferta() / 100)))*lineaDePedido.getCantidad();
			} else {
				precioLinea = (lineaDePedido.getDe_un().getAplica_oferta().getPrecioOferta())*lineaDePedido.getCantidad();
			}
		}else {
			precioLinea = lineaDePedido.getDe_un().getPrecio() * lineaDePedido.getCantidad();
		}
		
	
		precio.setValue(String.valueOf(precioLinea) + " euros");
	    precio.getStyle().set("color", "blue").set("margin", "16px");
	    
	    VerticalLayout vlav = new VerticalLayout();
	    vlav.add(avatar,name, precio);

	    vlav.setWidth("10%");
	    vlav.setHeight("100%");
	    
	    VerticalLayout vlayoutDescripcion = new VerticalLayout();
	    vlayoutDescripcion.getStyle().set("overflow-y", "auto");

	    vlayoutDescripcion.setWidth("70%");
	    vlayoutDescripcion.setHeight(null);
	    Label tituloDescripcion = new Label();
	    tituloDescripcion.setText("Descripción:");
	    tituloDescripcion.getStyle().set("font-size", "1em").set("font-weight", "bold").set("text-decoration", "underline").set("color", "blue");
	    
	    Div descripcion = new Div();
	    //descripcion.add(new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
	    descripcion.add(lineaDePedido.getDe_un().getDescripcion());
	    descripcion.getStyle().set("color", "black").set("margin", "16px");
	    
	    
	    vlayoutDescripcion.add(tituloDescripcion, descripcion);
	    
	    VerticalLayout vl = new VerticalLayout();
	    vl.setWidth("20%");
	    eliminarLinea = new Button("Eliminar linea");
	    vl.add(eliminarLinea);

	    
	    
	    placeholderSelect = new Select<>();
	    placeholderSelect.setItems("1", "2", "3", "4", "5", "6", "7", "8");
	    placeholderSelect.setPlaceholder("Cantidad");
	    placeholderSelect.setValue(lineaDePedido.getCantidad()+"");
	    placeholderSelect.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChanged(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Cambio la cantidad " + placeholderSelect.getValue());
				lineaDePedido.setCantidad(Integer.parseInt(placeholderSelect.getValue()));
				
				if (lineaDePedido.getDe_un().getAplica_oferta().getActivada() && resultado == -1) {
					if (lineaDePedido.getDe_un().getAplica_oferta().getPorcentajeOferta()) {
						precioLinea = (lineaDePedido.getDe_un().getPrecio()
								- (lineaDePedido.getDe_un().getPrecio() * (lineaDePedido.getDe_un().getAplica_oferta().getPrecioOferta() / 100)))*lineaDePedido.getCantidad();
					} else {
						precioLinea = (lineaDePedido.getDe_un().getAplica_oferta().getPrecioOferta())*lineaDePedido.getCantidad();
					}
				}else {
					precioLinea = lineaDePedido.getDe_un().getPrecio() * lineaDePedido.getCantidad();
				}
				
				
				precio.setValue(String.valueOf(precioLinea) + " euros");
				
			}
		});

	    
	    //Button verDescripcion = new Button("Ver descripción");
	    //vl.add(verDescripcion);
	    vl.add(placeholderSelect);
	    vl.setAlignItems(Alignment.START);
	    //HorizontalLayout hl = new HorizontalLayout(avatar, vl);
	    this.getVaadinHorizontalLayout().add(vlav,vlayoutDescripcion,vl);
	    //this.getVaadinHorizontalLayout().setVerticalComponentAlignment(Alignment.END, vl);

	    this.getVaadinHorizontalLayout().setSpacing(false);
	    this.getVaadinHorizontalLayout().getStyle().set("border", "1px solid #1676f3").set("border-radius", "25px").set("padding", "20px");
	}
	
}