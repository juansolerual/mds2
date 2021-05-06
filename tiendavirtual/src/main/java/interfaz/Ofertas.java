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
	
	public Ofertas() {
		HorizontalLayout scrollableLayout = new HorizontalLayout();
		iAdmin adm = new BDPrincipal();

		List<basededatos.Oferta> ofertas = adm.cargarOfertas();
		for (basededatos.Oferta oferta : ofertas) {
			java.util.Date date = oferta.getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultado = datenow.compareTo(date);
			System.out.println(resultado);
			if (oferta.getActivada() && resultado == -1 ) {
				Oferta ofer = new Oferta(oferta);
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
		
		Dialog dialogOferta = new Dialog();
		HorizontalLayout dialogOfertaHorizontal = new HorizontalLayout();
		dialogOferta.setCloseOnOutsideClick(true);
		Label tituloOfertaDialog = new Label("Nueva oferta");
		dialogOfertaHorizontal.add(tituloOfertaDialog);
		dialogOferta.setWidth("800px");
		dialogOferta.setHeight("600px");
		dialogOferta.setMinHeight("600px");
		dialogOferta.setMinWidth("800px");

		dialogOferta.setModal(false);
		dialogOferta.setDraggable(true);
		dialogOferta.setResizable(true);
		// dialog.add(new Text("Close me with the esc-key or an outside click"));
		TextField nombreOferta = new TextField("Nombre oferta:");
		nombreOferta.getStyle().set("margin", "20px").set("width", "400px");
		
		Image imageOfertaNueva = new Image();
		imageOfertaNueva.setWidth("150px");
		imageOfertaNueva.setHeight("150px");

		TextField precioOferta = new TextField("Precio:");
		precioOferta.getStyle().set("margin", "20px").set("width", "400px");

		Checkbox porcentajeOferta = new Checkbox(false);
		porcentajeOferta.setLabel("Si la oferta es un porcentaje, activar.");
		porcentajeOferta.getStyle().set("margin", "20px").set("width", "400px");

		DatePicker fechaCaducidad = new DatePicker();
		fechaCaducidad.setLabel("Fecha de caducidad de la oferta");
		LocalDate now = LocalDate.now();
		fechaCaducidad.setValue(now);

		Checkbox activada = new Checkbox(true);
		activada.setLabel("¿Oferta activada?");
		activada.getStyle().set("margin", "20px").set("width", "400px");

		Button guardarOferta = new Button("Guardar");
		guardarOferta.getStyle().set("margin", "20px");

		Button cancelOfertaButton = new Button("Cancelar", event -> {
			dialogOferta.close();
		});
		cancelOfertaButton.getStyle().set("margin", "20px");

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialogOferta, () -> {
			dialogOferta.close();
		}, Key.ESCAPE);
		
		MemoryBuffer bufferOferta = new MemoryBuffer();
		Upload uploadOferta = new Upload(bufferOferta);
		uploadOferta.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

		
		
		uploadOferta.addSucceededListener(event -> {
			Component component = createComponent(event.getMIMEType(), event.getFileName(), bufferOferta.getInputStream());
			File targetFile = new File("src/main/resources/targetFile.tmp");

			try {
				FileUtils.copyInputStreamToFile(bufferOferta.getInputStream(), targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fotoOferta = Uploader.upload(targetFile);
			System.out.println(fotoOferta);
			System.out.println("index of title  " + fotoOferta.indexOf("title"));
			System.out.println("https://i.imgur.com/" + fotoOferta.subSequence(15, 22) + ".jpg");
			fotoOferta = "https://i.imgur.com/" + fotoOferta.subSequence(15, 22) + ".jpg";
			imageOfertaNueva.setSrc(fotoOferta);
			//output.removeAll();
			//showOutput(event.getFileName(), component, output);
		});

		guardarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				
				if (fotoOferta == null) {
					Notification notification = Notification.show("Debe seleccionar una foto para la oferta.", 3000,Position.MIDDLE);
					return;
				}
				iAdmin adm = new BDPrincipal();
				basededatos.Oferta aOferta = new basededatos.Oferta();
				aOferta.setNombreOferta(nombreOferta.getValue());
				aOferta.setPrecioOferta(Double.parseDouble(precioOferta.getValue()));
				aOferta.setActivada(activada.getValue());
				aOferta.setFechaCaducidadOferta(java.sql.Date.valueOf(fechaCaducidad.getValue()));
				aOferta.setPorcentajeOferta(porcentajeOferta.getValue());
				aOferta.setUrlImagen(fotoOferta);
				int result = adm.guardarOferta(aOferta);
				if (result != -1) {
					Notification notification = Notification.show("La oferta ha sido creada correctamente", 3000,
							Position.MIDDLE);
					nombreOferta.setValue("");
					precioOferta.setValue("");
					fechaCaducidad.clear();
					porcentajeOferta.setValue(false);
					dialogOferta.close();
					ofertas.add(aOferta);

				} else {
					Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.", 3000,
							Position.TOP_CENTER);
				}
			}

		});
		VerticalLayout dialogOfertaVertical = new VerticalLayout(nombreOferta, precioOferta, porcentajeOferta, uploadOferta, imageOfertaNueva,
				fechaCaducidad, activada);
		HorizontalLayout dialogOfertaButtons = new HorizontalLayout(guardarOferta, cancelOfertaButton);
		dialogOfertaHorizontal.getStyle().set("margin", "20px").set("width", "100%");
		dialogOfertaVertical.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageOfertaEsc = new Label("pulsa ESC para salir");

		dialogOferta.add(dialogOfertaHorizontal, dialogOfertaVertical, dialogOfertaButtons, mesageOfertaEsc);

		Button nuevoOferta = new Button("+");
		nuevoOferta.getElement().getStyle().set("margin-left", "auto");
		nuevoOferta.addClickListener(event -> dialogOferta.open());
		nuevoOferta.setVisible(false);
		nuevoOferta.setVisible(cookiesHelper.isAdministrador());
		
		
		
	    Div staticElement = new Div();
		staticElement.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin", "20px");
	    staticElement.add(new Text("Ofertas"));
	    HorizontalLayout primeraLinea = new HorizontalLayout();
		primeraLinea.setPadding(true);
		primeraLinea.add(staticElement, nuevoOferta);
		primeraLinea.getStyle().set("width", "100%").set("margin-left", "20px").set("margin-right", "20px");
	    // Add both the scrollable layout and 
	    // the static element to the layout
	    this.getHorizontalLayout().add(primeraLinea, scrollableLayout);
		this.getHorizontalLayout().getStyle().set("border", "2px solid #1676f3").set("border-radius", "25px");
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