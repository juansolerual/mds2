package interfaz;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
import tiendavirtual.Uploader;

public class Dar_de_alta_categoria {
	public Vista_Categoria_Admin _vista_Categoria_Admin;
	private String fotoCategoria;
	public Dialog dialog;

	public Dar_de_alta_categoria(HorizontalLayout scrollableLayout) {
		super();
		dialog = new Dialog();
		HorizontalLayout dialogHorizontal = new HorizontalLayout();
		Label tituloDialog = new Label("Nueva categoría");
		dialogHorizontal.add(tituloDialog);
		dialog.setWidth("800px");
		dialog.setHeight("600px");
		dialog.setMinHeight("600px");
		dialog.setMinWidth("800px");

		dialog.setModal(false);
		dialog.setDraggable(true);
		dialog.setResizable(true);
		// dialog.add(new Text("Close me with the esc-key or an outside click"));
		TextField nombreCategoria = new TextField("Nombre categoría:");
		nombreCategoria.getStyle().set("margin", "20px").set("width", "400px");

		TextField descripcion = new TextField("Descripción:");
		descripcion.getStyle().set("margin", "20px").set("width", "400px");

		Image imageCategoriaNueva = new Image();
		imageCategoriaNueva.setWidth("150px");
		imageCategoriaNueva.setHeight("150px");
		
		Button guardar = new Button("Guardar");
		guardar.getStyle().set("margin", "20px");

		Button cancelButton = new Button("Cancelar", event -> {
			dialog.close();
		});
		cancelButton.getStyle().set("margin", "20px");

		// Cancel action on ESC press
		Shortcuts.addShortcutListener(dialog, () -> {
			dialog.close();
		}, Key.ESCAPE);

		MemoryBuffer buffer = new MemoryBuffer();
		Upload upload = new Upload(buffer);
		upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

		Div output = new Div();
		output.setWidth("320px");
		output.setHeight("320px");

		upload.addSucceededListener(event -> {
			Component component = createComponent(event.getMIMEType(), event.getFileName(), buffer.getInputStream());
			File targetFile = new File("src/main/resources/targetFile.tmp");

			try {
				FileUtils.copyInputStreamToFile(buffer.getInputStream(), targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			fotoCategoria = Uploader.upload(targetFile);
			System.out.println(fotoCategoria);
			System.out.println("index of title  " + fotoCategoria.indexOf("title"));
			System.out.println("https://i.imgur.com/" + fotoCategoria.subSequence(15, 22) + ".jpg");
			fotoCategoria = "https://i.imgur.com/" + fotoCategoria.subSequence(15, 22) + ".jpg";
			imageCategoriaNueva.setSrc(fotoCategoria);
			output.removeAll();
			showOutput(event.getFileName(), component, output);
		});

		guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				basededatos.Categoria aCategoria = new basededatos.Categoria();
				aCategoria.setNombreCategoria(nombreCategoria.getValue());
				aCategoria.setDescripcion(descripcion.getValue());
				aCategoria.setImagen(fotoCategoria);
				int result = adm.guardarCategoria(aCategoria);
				scrollableLayout.add(new Categoria(aCategoria));

				if (result != -1) {
					Notification notification = Notification.show("La categoría ha sido creada correctamente", 3000,
							Position.MIDDLE);
					nombreCategoria.setValue("");
					descripcion.setValue("");
					dialog.close();
				} else {
					Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.", 3000,
							Position.TOP_CENTER);
				}
			}

		});
		VerticalLayout dialogVertical = new VerticalLayout(nombreCategoria, descripcion, imageCategoriaNueva, upload);
		HorizontalLayout dialogButtons = new HorizontalLayout(guardar, cancelButton);
		dialogHorizontal.getStyle().set("margin", "20px").set("width", "100%");
		dialogVertical.getStyle().set("margin", "20px").set("width", "100%");
		Label mesageEsc = new Label("o pulsa ESC para salir");

		dialog.add(dialogHorizontal, dialogVertical, dialogButtons, mesageEsc);
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