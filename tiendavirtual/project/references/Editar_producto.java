package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Iterator;

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
import basededatos.Producto;
import basededatos.iAdmin;
import tiendavirtual.Uploader;
import vistas.VistaProductousuario;

public class Editar_producto extends VistaProductousuario{

	public Lista_ofertas _lista_ofertas;
	private String fotoOferta;
	public basededatos.Oferta aOferta;
	public Dialog dialogProducto;
	public Button guardarOferta;
	public TextField nombreProducto;
	public Image imageOfertaNueva;
	public TextField precioOferta;
	public Checkbox porcentajeOferta;
	public DatePicker fechaCaducidad;
	public Checkbox activada;
	
	public Editar_producto(Producto producto, boolean admin) {
		super(producto, admin);
	}

	public Editar_producto(Producto productoTemp) {
		// TODO Auto-generated constructor stub
		super(productoTemp, true);
		
		dialogProducto = new Dialog();
		HorizontalLayout dialogProductoHorizontal = new HorizontalLayout();
		dialogProducto.setCloseOnOutsideClick(true);
		Label tituloProductoDialog = new Label("Nuevo producto");
		
		dialogProductoHorizontal.add(tituloProductoDialog);
		dialogProducto.setWidth("800px");
		dialogProducto.setHeight("600px");
		dialogProducto.setMinHeight("600px");
		dialogProducto.setMinWidth("800px");

		dialogProducto.setModal(false);
		dialogProducto.setDraggable(true);
		dialogProducto.setResizable(true);
		nombreProducto = new TextField("Nombre producto:");
		nombreProducto.getStyle().set("margin", "20px").set("width", "400px");
		
		imageOfertaNueva = new Image();
		imageOfertaNueva.setWidth("150px");
		imageOfertaNueva.setHeight("150px");

		precioOferta = new TextField("Precio:");
		precioOferta.getStyle().set("margin", "20px").set("width", "400px");

		porcentajeOferta = new Checkbox(false);
		porcentajeOferta.setLabel("Si la oferta es un porcentaje, activar.");
		porcentajeOferta.getStyle().set("margin", "20px").set("width", "400px");

		fechaCaducidad = new DatePicker();
		fechaCaducidad.setLabel("Fecha de caducidad de la oferta");
		LocalDate now = LocalDate.now();
		fechaCaducidad.setValue(now);

		activada = new Checkbox(true);
		activada.setLabel("¿Oferta activada?");
		activada.getStyle().set("margin", "20px").set("width", "400px");

		guardarOferta = new Button("Guardar");
		guardarOferta.getStyle().set("margin", "20px");

		Button cancelOfertaButton = new Button("Cancelar", event -> {
			dialogProducto.close();
		});
		cancelOfertaButton.getStyle().set("margin", "20px");
		
//		if (oferta != null) {
//			precioOferta.setValue(String.valueOf(oferta.getPrecioOferta()));
//			nombreProducto.setValue(oferta.getNombreOferta());
//			imageOfertaNueva.setSrc(oferta.getUrlImagen());
//			porcentajeOferta.setEnabled(oferta.getPorcentajeOferta());
//			activada.setEnabled(oferta.getActivada());
//			fechaCaducidad.setValue(LocalDate.parse(oferta.getFechaCaducidadOferta().toString()));
//			aOferta = oferta;
//
//		}

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialogProducto, () -> {
			dialogProducto.close();
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
				aOferta = new basededatos.Oferta();
				aOferta.setNombreOferta(nombreProducto.getValue());
				aOferta.setPrecioOferta(Double.parseDouble(precioOferta.getValue()));
				aOferta.setActivada(activada.getValue());
				aOferta.setFechaCaducidadOferta(java.sql.Date.valueOf(fechaCaducidad.getValue()));
				aOferta.setPorcentajeOferta(porcentajeOferta.getValue());
				aOferta.setUrlImagen(fotoOferta);
				int result = adm.guardarOferta(aOferta);
				if (result != -1) {
					Notification notification = Notification.show("La oferta ha sido creada correctamente", 3000,
							Position.MIDDLE);
					nombreProducto.setValue("");
					precioOferta.setValue("");
					fechaCaducidad.clear();
					porcentajeOferta.setValue(false);
					dialogProducto.close();
					_lista_ofertas._lista_ofertas.add(aOferta);

				} else {
					Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.", 3000,
							Position.TOP_CENTER);
				}
			}

		});
		VerticalLayout dialogOfertaVertical = new VerticalLayout(nombreProducto, precioOferta, porcentajeOferta, uploadOferta, imageOfertaNueva,
				fechaCaducidad, activada);
		HorizontalLayout dialogOfertaButtons = new HorizontalLayout(guardarOferta, cancelOfertaButton);
		dialogProductoHorizontal.getStyle().set("margin", "20px").set("width", "100%");
		dialogOfertaVertical.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageOfertaEsc = new Label("pulsa ESC para salir");

		dialogProducto.add(this);
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
