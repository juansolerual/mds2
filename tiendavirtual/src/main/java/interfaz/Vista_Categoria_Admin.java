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
import basededatos.Categoria;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.Lineas_de_Pedido;
import basededatos.Pendiente;
import basededatos.Transportista;
import basededatos.iAdmin;

public class Vista_Categoria_Admin extends VerticalLayout {
	public Admin _admin;
	public Dar_de_alta_categoria _dar_de_alta_categoria;
	public Lista_categorias _lista_categorias;
	public Lista_empleados _lista_empleados;
	public Dar_alta_empleado _dar_alta_empleado;
	public Button nuevaCategoriaButton;
	public HorizontalLayout cabeceraVista;
	public VaadinSession session;
	public basededatos.Categoria categoriaTemp;
	public List<basededatos.Categoria> categorias;
	public Categoria_admin categoriaVistaTemp;
	public VerticalLayout scrollableLayout;
	public iAdmin adm;

	public Vista_Categoria_Admin() {
		super();
		session = VaadinSession.getCurrent();

		setWidth("100%");
		setHeight("100%");
		_lista_categorias = new Lista_categorias();
		_lista_categorias.setWidth("100%");
		_lista_categorias.setHeight("100%");

		adm = new BDPrincipal();

		categorias = adm.cargarCategorias();
		// List<Cliente> clientes = adm.cargarClientes();

		scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_empleados");
		for (basededatos.Categoria categoria : categorias) {

			Categoria_admin cat = new Categoria_admin();

			cat.nombreCategoria.setText(categoria.getNombreCategoria());
			cat.descripcionCategoria.setText(categoria.getDescripcion());
			if (categoria.getImagen() != null) {
				cat.img.setSrc(categoria.getImagen());
			} else {

				cat.img.setSrc("https://picsum.photos/200");
			}

			scrollableLayout.add(cat);
			
			cat.v1.getStyle().set("cursor", "pointer");
			
			cat.v1.addClickListener(new ComponentEventListener<ClickEvent<VerticalLayout>>() {

				@Override
				public void onComponentEvent(ClickEvent<VerticalLayout> event) {
					// TODO Auto-generated method stub
					categoriaTemp = categoria;

					verProductosCategoria();
					
				}
			});
			
			cat.eliminarCategoria.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					categoriaVistaTemp = cat;
					categoriaTemp = categoria;

					eliminarCategoria();
					

				}
			});

			cat.modificarCategoria.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					categoriaTemp = categoria;
					guardarCategoria();
					
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
		staticElement.getStyle().set("color", "#1676f3").set("font-size", "larger").set("font-weight", "bold").set("margin-top", "10px")
				.set("margin-left", "200px");
		staticElement.add(new Text("Categorias"));

		// Add both the scrollable layout and
		// the static element to the layout
		_lista_categorias.add(scrollableLayout);
		_lista_categorias.getStyle().set("border","2px solid #1676f3").set("border-radius","25px");

		cabeceraVista = new HorizontalLayout();
		nuevaCategoriaButton = new Button("Nueva categoria");
		cabeceraVista.add(nuevaCategoriaButton, staticElement);

		add(cabeceraVista, _lista_categorias);

		nuevaCategoriaButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Editar_categoria editarCategoria = new Editar_categoria(null);
				editarCategoria.dialog.open();

			}
		});

	}

	protected void verProductosCategoria() {
		// TODO Auto-generated method stub
		Ver_productos_categoria ver_productos_categoria = new Ver_productos_categoria(categoriaTemp.getNombreCategoria());
		

	}

	protected void eliminarCategoria() {
		// TODO Auto-generated method stub
		this.scrollableLayout.remove(this.categoriaVistaTemp);
		adm.eliminarCategoria(this.categoriaTemp.getID());
	}

	protected void guardarCategoria() {
		// TODO Auto-generated method stub

		Editar_categoria editarCategoria = new Editar_categoria(categoriaTemp);
		editarCategoria.dialog.open();

		editarCategoria.guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				basededatos.Categoria aCategoria = new basededatos.Categoria();
				aCategoria.setNombreCategoria(editarCategoria.nombreCategoria.getValue());
				aCategoria.setDescripcion(editarCategoria.descripcion.getValue());
				aCategoria.setImagen(editarCategoria.fotoCategoria);
				int result = adm.guardarCategoria(aCategoria);
				if (result != -1) {
					Notification notification = Notification
							.show("La categoría ha sido creada correctamente", 3000, Position.MIDDLE);
					editarCategoria.nombreCategoria.setValue("");
					editarCategoria.descripcion.setValue("");
					editarCategoria.fotoCategoria = "";
					editarCategoria.dialog.close();
					categorias.add(aCategoria);

				} else {
					Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.",
							3000, Position.TOP_CENTER);
				}
			}

		});
	}

}