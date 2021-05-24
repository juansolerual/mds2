package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
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
import interfaz.Oferta;
import tiendavirtual.Uploader;
import tiendavirtual.cookiesHelper;
import vistas.VistaOfertas;

public class Ofertas extends VistaOfertas{
	public Elementos_comunes_pantalla_principal _elementos_comunes_pantalla_principal;
	//public Vector<Oferta> _list_Oferta = new Vector<Oferta>();
	public String fotoOferta = null;
	public iAdmin adm;
	private HorizontalLayout scrollableLayout;
	private Lista_ofertas ofertas;
	protected basededatos.Oferta ofertaTemp;
	protected Oferta ofertaTempVista;
	public Dialog dialogOferta;
	public Dar_de_alta_oferta dar_de_alta_oferta;
	
	public Ofertas() {
		adm = new BDPrincipal();
		scrollableLayout = new HorizontalLayout();
		ofertas = new Lista_ofertas();
		for (basededatos.Oferta oferta : ofertas._lista_ofertas) {
			java.util.Date date = oferta.getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultado = datenow.compareTo(date);
			System.out.println(resultado);
			if (oferta.getActivada() && resultado == -1 ) {
				Oferta ofer = new Oferta(oferta);
				ofer.eliminarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

					@Override
					public void onComponentEvent(ClickEvent<Button> event) {
						// TODO Auto-generated method stub
						ofertaTemp = oferta;
						ofertaTempVista = ofer;
						eliminarOferta();
					}
				});
			    scrollableLayout.add(ofer);
			}
			
			
	    }
	    // Give the layout a defined height that fits the parent layout
	    scrollableLayout.setHeight("100%");
	    scrollableLayout.setWidth(null);
	    // Set overflow on the y-axis to "auto".
	    // It can be also "scroll", but then you 
	    // have a scroll bar even when one isn't needed.
		scrollableLayout.getStyle().set("overflow-x", "scroll").set("margin-left", "20px").set("margin-right", "20px").set("margin-bottom", "25px");
	    // Another element to show that it stays in the same place
		
		
		Button nuevoOferta = new Button("+");
		nuevoOferta.getElement().getStyle().set("margin-left", "auto");
		nuevoOferta.addClickListener(event -> {
			nuevaOferta();
		});
		
		
		
		nuevoOferta.setVisible(false);
		nuevoOferta.setVisible(cookiesHelper.isAdministrador());
		
		Button editarOfertas = new Button("Editar ofertass");
		editarOfertas.getElement().getStyle().set("margin-left", "auto");
		editarOfertas.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Vista_Ofertas_Admin vista_oferta_admin = new Vista_Ofertas_Admin();
				VaadinSession session = VaadinSession.getCurrent();

				session.setAttribute("vista_oferta_admin", vista_oferta_admin);

				if (cookiesHelper.isCliente()) {
					VerticalLayout verticalLayoutUsuarioIdentificado = (VerticalLayout) session
							.getAttribute("verticalLayoutUsuarioIdentificado");
					Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session
							.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
					verticalLayoutUsuarioIdentificado.remove(visualizar_Pantalla_Principal_Usuario_Registrado);
					verticalLayoutUsuarioIdentificado.add(vista_oferta_admin);
				}

				if (cookiesHelper.isNoRegistrado()) {
					VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout) session
							.getAttribute("verticalLayoutUsuarioNoIdentificado");
					Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado = (Visualizar_Pantalla_Usuario_no_registrado) session
							.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
					verticalLayoutUsuarioNoIdentificado.remove(visualizar_Pantalla_Usuario_no_registrado);
					verticalLayoutUsuarioNoIdentificado.add(vista_oferta_admin);

				}

				if (cookiesHelper.isAdministrador()) {
					VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
					Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session
							.getAttribute("visualizar_Pantalla_Principal_Administrador");
					verticalLayoutAdmin.remove(visualizar_Pantalla_Principal_Administrador);
					verticalLayoutAdmin.add(vista_oferta_admin);
				}
				
			}
		});
		editarOfertas.setVisible(false);
		editarOfertas.setVisible(cookiesHelper.isAdministrador());
		
		
	    Div staticElement = new Div();
		staticElement.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");
	    staticElement.add(new Text("Ofertas"));
	    HorizontalLayout primeraLinea = new HorizontalLayout();
		primeraLinea.setPadding(true);
		primeraLinea.add(staticElement, editarOfertas, nuevoOferta);
		primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalLayout().add(primeraLinea, scrollableLayout);
		this.getHorizontalLayout().getStyle().set("border", "2px solid #1676f3").set("border-radius", "25px");
	}
	private void nuevaOferta() {
		// TODO Auto-generated method stub
		dar_de_alta_oferta = new Dar_de_alta_oferta(ofertas);
		dar_de_alta_oferta.dialogOferta.open();
	}
	protected void eliminarOferta() {
		// TODO Auto-generated method stub
		adm.eliminarOferta(ofertaTemp.getID());
	    scrollableLayout.remove(ofertaTempVista);


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