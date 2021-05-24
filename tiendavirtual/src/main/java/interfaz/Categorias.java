package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import basededatos.BDPrincipal;
import basededatos.iAdmin;
import interfaz.Categoria;
import tiendavirtual.Uploader;
import tiendavirtual.cookiesHelper;
import vistas.VistaCategorias;
import vistas.VistaProductousuario;

public class Categorias extends VistaCategorias {
	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	public String fotoCategoria = "";
	public Vista_busqueda_de_productos_categorias _vista_busqueda_productos_categorias;
	public iAdmin adm;
	public Dar_de_alta_categoria dar_de_alta_categoria;
	protected basededatos.Categoria categoriaTemp;

	// public Vector<Categoria> _list_Categoria = new Vector<Categoria>();

	// public cargarCategorias...

	public Categorias() {
		VaadinSession session = VaadinSession.getCurrent();

		String user = (String) session.getAttribute("username");

		HorizontalLayout scrollableLayout = new HorizontalLayout();
		adm = new BDPrincipal();
		List<basededatos.Categoria> categorias = adm.cargarCategorias();
		if (categorias == null) {
			categorias = new ArrayList<basededatos.Categoria>();
		}
		for (basededatos.Categoria categoria : categorias) {
			Categoria cat = new Categoria(categoria);
			cat.avatar.addClickListener(new ComponentEventListener<ClickEvent<Div>>() {

				@Override
				public void onComponentEvent(ClickEvent<Div> event) {
					// TODO Auto-generated method stub
					categoriaTemp = categoria;
					verCategoria();

				}
			});

			cat.verCategoria.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					categoriaTemp = categoria;

					verCategoria();

					

				}

			});

			cat.eliminarCategoria.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					categoriaTemp = categoria;

					eliminarCategoria();

				}
			});

			scrollableLayout.add(cat);
		}
		// Give the layout a defined height that fits the parent layout
		scrollableLayout.setHeight("100%");
		scrollableLayout.setWidth(null);
		// Set overflow on the y-axis to "auto".
		// It can be also "scroll", but then you
		// have a scroll bar even when one isn't needed.
		scrollableLayout.getStyle().set("overflow-x", "scroll").set("margin-left", "19%").set("margin-right", "20px")
				.set("margin-bottom", "20px");
		// Another element to show that it stays in the same place
		Label staticElement = new Label("Categoria destacados");
		staticElement.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");

		

		Button nuevoCategoria = new Button("+");
		nuevoCategoria.getElement().getStyle().set("margin-left", "auto");
		nuevoCategoria.addClickListener(event -> {
			dar_de_alta_categoria = new Dar_de_alta_categoria(scrollableLayout);
			
			dar_de_alta_categoria.dialog.open();
		});
		
		Button editarCategorias = new Button("Editar Categorias");
		editarCategorias.setVisible(cookiesHelper.isAdministrador());

		editarCategorias.getElement().getStyle().set("margin-left", "auto");
		
		editarCategorias.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Vista_Categoria_Admin vista_categoria_admin = new Vista_Categoria_Admin();
				VaadinSession session = VaadinSession.getCurrent();

				session.setAttribute("_vista_busqueda_productos_categorias", _vista_busqueda_productos_categorias);

				VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
				Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session
						.getAttribute("visualizar_Pantalla_Principal_Administrador");
				verticalLayoutAdmin.remove(visualizar_Pantalla_Principal_Administrador);
				verticalLayoutAdmin.add(vista_categoria_admin);
				
//				if (cookiesHelper.isCliente()) {
//					VerticalLayout verticalLayoutUsuarioIdentificado = (VerticalLayout) session
//							.getAttribute("verticalLayoutUsuarioIdentificado");
//					Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session
//							.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
//					verticalLayoutUsuarioIdentificado.remove(visualizar_Pantalla_Principal_Usuario_Registrado);
//					verticalLayoutUsuarioIdentificado.add(vista_categoria_admin);
//				}
//
//				if (cookiesHelper.isNoRegistrado()) {
//					VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout) session
//							.getAttribute("verticalLayoutUsuarioNoIdentificado");
//					Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado = (Visualizar_Pantalla_Usuario_no_registrado) session
//							.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
//					verticalLayoutUsuarioNoIdentificado.remove(visualizar_Pantalla_Usuario_no_registrado);
//					verticalLayoutUsuarioNoIdentificado.add(vista_categoria_admin);
//
//				}
//
//				if (cookiesHelper.isAdministrador()) {
//					
//				}
				
			}
		});

		/*
		 * nuevoCategoria.addClickListener(new
		 * ComponentEventListener<ClickEvent<Button>>() {
		 * 
		 * @Override public void onComponentEvent(ClickEvent<Button> event) { // TODO
		 * Auto-generated method stub HorizontalLayout horizontalLayoutAdministrador =
		 * (HorizontalLayout) session .getAttribute("horizontalLayoutAdministrador");
		 * 
		 * horizontalLayoutAdministrador.removeAll();
		 * 
		 * Visualizar_Pantalla_Principal_Administrador
		 * _visualizar_Pantalla_Principal_Administrador =
		 * (Visualizar_Pantalla_Principal_Administrador) session
		 * .getAttribute("visualizar_Pantalla_Principal_Administrador");
		 * 
		 * VerticalLayout verticalLayoutAdmin = (VerticalLayout)
		 * session.getAttribute("verticalLayoutAdmin");
		 * verticalLayoutAdmin.remove(_visualizar_Pantalla_Principal_Administrador);
		 * 
		 * VistaProductousuario vistaProductoUsuario = new VistaProductousuario(null,
		 * true); verticalLayoutAdmin.add(vistaProductoUsuario); }
		 * 
		 * });
		 */

		
		nuevoCategoria.setVisible(cookiesHelper.isAdministrador());

		HorizontalLayout primeraLinea = new HorizontalLayout();
		primeraLinea.setPadding(true);
		primeraLinea.add(staticElement, editarCategorias, nuevoCategoria);
		primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");

		// Add both the scrollable layout and
		// the static element to the layout
		this.getHorizontalLayout().add(primeraLinea, scrollableLayout);
		this.getHorizontalLayout().getStyle().set("border", "2px solid #1676f3").set("border-radius", "25px")
				.set("margin-left", "2%");

	}

	protected void eliminarCategoria() {
		// TODO Auto-generated method stub
		adm.eliminarCategoria(this.categoriaTemp.getID());
	}

	protected void verCategoria() {
		// TODO Auto-generated method stub
		VaadinSession session = VaadinSession.getCurrent();
		_vista_busqueda_productos_categorias = new Vista_busqueda_de_productos_categorias(this.categoriaTemp);

		session.setAttribute("_vista_busqueda_productos_categorias", _vista_busqueda_productos_categorias);

		if (cookiesHelper.isCliente()) {
			VerticalLayout verticalLayoutUsuarioIdentificado = (VerticalLayout) session
					.getAttribute("verticalLayoutUsuarioIdentificado");
			Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session
					.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
			verticalLayoutUsuarioIdentificado.remove(visualizar_Pantalla_Principal_Usuario_Registrado);
			verticalLayoutUsuarioIdentificado.add(_vista_busqueda_productos_categorias);
		}

		if (cookiesHelper.isNoRegistrado()) {
			VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout) session
					.getAttribute("verticalLayoutUsuarioNoIdentificado");
			Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado = (Visualizar_Pantalla_Usuario_no_registrado) session
					.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
			verticalLayoutUsuarioNoIdentificado.remove(visualizar_Pantalla_Usuario_no_registrado);
			verticalLayoutUsuarioNoIdentificado.add(_vista_busqueda_productos_categorias);

		}

		if (cookiesHelper.isAdministrador()) {
			VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
			Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session
					.getAttribute("visualizar_Pantalla_Principal_Administrador");
			verticalLayoutAdmin.remove(visualizar_Pantalla_Principal_Administrador);
			verticalLayoutAdmin.add(_vista_busqueda_productos_categorias);
		}
	}

	private Component createComponent(String mimeType, String fileName, InputStream stream) {
		if (mimeType.startsWith("text")) {
			return createTextComponent(stream);
		} else if (mimeType.startsWith("image")) {
			Image image = new Image();
			try {

				byte[] bytes = IOUtils.toByteArray(stream);
				image.getElement().setAttribute("src",
						new StreamResource(fileName, () -> new ByteArrayInputStream(bytes)));
				try (ImageInputStream in = ImageIO.createImageInputStream(new ByteArrayInputStream(bytes))) {
					final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
					if (readers.hasNext()) {
						ImageReader reader = readers.next();
						try {
							reader.setInput(in);
							image.setWidth(reader.getWidth(0) + "px");
							image.setHeight(reader.getHeight(0) + "px");
						} finally {
							reader.dispose();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			image.setSizeFull();
			return image;
		}
		Div content = new Div();
		String text = String.format("Mime type: '%s'\nSHA-256 hash: '%s'", mimeType,
				MessageDigestUtil.sha256(stream.toString()));
		content.setText(text);
		return content;

	}

	private Component createTextComponent(InputStream stream) {
		String text;
		try {
			text = IOUtils.toString(stream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			text = "exception reading stream";
		}
		return new Text(text);
	}

	private void showOutput(String text, Component content, HasComponents outputContainer) {
		HtmlComponent p = new HtmlComponent(Tag.P);
		p.setHeight("320px");
		p.setWidth("320px");
		p.getElement().setText(text);
		outputContainer.add(p);
		outputContainer.add(content);
	}

}