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
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.Transportista;
import basededatos.iAdmin;
import basededatos.iUsuario_no_identificado;
import tiendavirtual.Uploader;
import vistas.VistaRegistrarse;

public class Dar_alta_empleado extends VistaRegistrarse {

	public String fotoPerfil = "";
	public VaadinSession session;
	public Cliente cliente;
	public iUsuario_no_identificado usr;
	public Vista_gestion_empleados _vista_gestion_empleados;

	public Dar_alta_empleado() {
		super();
		getFormaDePago().setVisible(false);
		getNumeroTarjeta().setVisible(false);

		session = VaadinSession.getCurrent();

		iAdmin adm = new BDPrincipal();
		getFormaDePago().setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");

		getTipoUsuario().setItems("Administrador", "Encargado de compras", "Transportista");

		MemoryBuffer buffer = new MemoryBuffer();
		Upload upload = new Upload(buffer);
		upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

		Div output = new Div();
		output.setWidth("320px");
		output.setHeight("320px");

		HorizontalLayout horizontalFoto = this.getVaadinHorizontalLayoutFoto().as(HorizontalLayout.class);
		horizontalFoto.add(upload);

		upload.addSucceededListener(event -> {
			Component component = createComponent(event.getMIMEType(), event.getFileName(), buffer.getInputStream());
			File targetFile = new File("src/main/resources/targetFile.tmp");

			try {
				FileUtils.copyInputStreamToFile(buffer.getInputStream(), targetFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fotoPerfil = Uploader.upload(targetFile);
			System.out.println(fotoPerfil);
			System.out.println("index of title  " + fotoPerfil.indexOf("title"));
			System.out.println("https://i.imgur.com/" + fotoPerfil.subSequence(15, 22) + ".jpg");
			fotoPerfil = "https://i.imgur.com/" + fotoPerfil.subSequence(15, 22) + ".jpg";
			output.removeAll();
			showOutput(event.getFileName(), component, output);
			getImg().setSrc(fotoPerfil);
		});

		this.getRegistrarseButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {

				Administrador administrador = null;
				Encargado_compras encargado = null;
				Transportista transportista = null;

				if (getTipoUsuario().isEmpty()) {
					Notification.show("Debe seleccionar un tipo de usuario.", 3000, Position.MIDDLE);
					return;
				}

				if (getTipoUsuario().getValue().equals("Administrador")) {
					administrador = new Administrador();
					administrador.setApellidos(getApellidos().getValue());
					administrador.setDireccion(getDireccion().getValue());
					administrador.setDni(getDni().getValue());
					administrador.setEmail(getEmail().getValue());
					administrador.setNombre(getNombre().getValue());
					if (getPassword().getValue().equals(getPassword2().getValue())) {
						administrador.setPassword(getPassword().getValue());
					} else {
						Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);

					}
					administrador.setFoto_perfil(fotoPerfil);
					if (adm.crearAdministrador(administrador)) {
						Notification.show("El usuario ha sido creado con éxito.", 3000, Position.MIDDLE);
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   
						
						VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
				        Admin admin = (Admin) session.getAttribute("adminInterfaz");
				        Registrarse _registrarse = (Registrarse) session.getAttribute("Registrarse");

				        
				        Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados(); 
				        		

				        mainView.remove(_registrarse);
				        mainView.add(_vista_gestion_empleados);


					}	
					
				}

				if (getTipoUsuario().getValue().equals("Encargado de compras")) {
					encargado = new Encargado_compras();
					encargado.setApellidos(getApellidos().getValue());
					encargado.setDireccion(getDireccion().getValue());
					encargado.setDni(getDni().getValue());
					encargado.setEmail(getEmail().getValue());
					encargado.setNombre(getNombre().getValue());
					if (getPassword().getValue().equals(getPassword2().getValue())) {
						encargado.setPassword(getPassword().getValue());
					} else {
						Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);
					}
					encargado.setFoto_perfil(fotoPerfil);
					if (adm.crearEncargadoCompras(encargado)) {
						Notification.show("El usuario ha sido creado con éxito.", 3000, Position.MIDDLE);
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
				        Admin admin = (Admin) session.getAttribute("adminInterfaz");
				        Registrarse _registrarse = (Registrarse) session.getAttribute("Registrarse");
				        Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados(); 
				        mainView.remove(_registrarse);
				        mainView.add(_vista_gestion_empleados);
					}	
				}

				if (getTipoUsuario().getValue().equals("Transportista")) {
					transportista = new Transportista();
					transportista.setApellidos(getApellidos().getValue());
					transportista.setDireccion(getDireccion().getValue());
					transportista.setDni(getDni().getValue());
					transportista.setEmail(getEmail().getValue());
					transportista.setNombre(getNombre().getValue());
					if (getPassword().getValue().equals(getPassword2().getValue())) {
						transportista.setPassword(getPassword().getValue());
					} else {
						Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);

					}
					transportista.setFoto_perfil(fotoPerfil);
					if (adm.crearTransportista(transportista)) {
						Notification.show("El usuario ha sido creado con éxito.", 3000, Position.MIDDLE);
					    try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   
						
						VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
				        Admin admin = (Admin) session.getAttribute("adminInterfaz");
				        Visualizar_Pantalla_Principal_Administrador _visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");

				        
				        Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados(); 
				        		

				        mainView.remove(_visualizar_Pantalla_Principal_Administrador);
				        mainView.add(_vista_gestion_empleados);


					}	
				}

				// TODO Auto-generated method stub
			

				if (getTipoUsuario().isEmpty()) {
					Notification.show("Debe seleccionar un tipo de usuario.", 3000, Position.MIDDLE);
					return;
				}


			}
		});
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