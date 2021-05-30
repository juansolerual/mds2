package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Oferta_admin extends HorizontalLayout{
	
	public VerticalLayout v1 = new VerticalLayout();
	public VerticalLayout v2 = new VerticalLayout();
	public VerticalLayout v3 = new VerticalLayout();
	public VerticalLayout v4 = new VerticalLayout();
	public Image img = new Image();
	public Label nombreOferta = new Label();
	public Label descripcionOferta = new Label();
	public Button modificarOferta = new Button("Modificar oferta");
	public Button eliminarOferta = new Button("Eliminar oferta");

	public Oferta_admin() {
		super();
		img.setWidth("100px");
		img.setHeight("100px");
		img.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		v1.add(img);
		v2.add(nombreOferta);
		v3.add(descripcionOferta);
		v4.add(modificarOferta, eliminarOferta);
		add(v1, v2, v3, v4);
		
		setWidth("100%");
		getStyle().set("border","2px solid #1676f3").set("border-radius","25px");
		v2.getStyle().set("border","1px solid blue").set("margin", "20px");
		v3.getStyle().set("border","1px solid blue").set("margin", "20px");
		v4.getStyle().set("margin", "20px");
	}
}
