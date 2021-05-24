package interfaz;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Categoria_admin extends HorizontalLayout{
	private event _eliminar_categoria;
	public Lista_categorias _lista_categorias;
	public Ver_productos_categoria _ver_productos_categoria;
	public Editar_categoria _editar_categoria;
	
	public VerticalLayout v1 = new VerticalLayout();
	public VerticalLayout v2 = new VerticalLayout();
	public VerticalLayout v3 = new VerticalLayout();
	public VerticalLayout v4 = new VerticalLayout();
	public Image img = new Image();
	public Label nombreCategoria = new Label();
	public Label descripcionCategoria = new Label();
	public Button modificarCategoria = new Button("Modificar categoria");
	public Button eliminarCategoria = new Button("Eliminar categoria");
	
	public basededatos.Categoria categoria;

	public Categoria_admin() {
		super();
		img.setWidth("100px");
		img.setHeight("100px");
		img.getStyle().set("border-radius", "150px").set("border", "10px solid #666");
		v1.add(img);
		v2.add(nombreCategoria);
		v3.add(descripcionCategoria);
		v4.add(modificarCategoria, eliminarCategoria);
		add(v1, v2, v3, v4);
		
		setWidth("100%");
		getStyle().set("border","2px solid #1676f3").set("border-radius","25px");
		v2.getStyle().set("border","1px solid blue").set("margin", "20px");
		v3.getStyle().set("border","1px solid blue").set("margin", "20px");
		v4.getStyle().set("margin", "20px");
	}

	public void Eliminar_categoria() {
		
	}
}