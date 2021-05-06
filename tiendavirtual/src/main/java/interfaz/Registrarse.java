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
import javax.servlet.http.Cookie;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasValue.ValueChangeEvent;
import com.vaadin.flow.component.HasValue.ValueChangeListener;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
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
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinSession;

import basededatos.Administrador;
import basededatos.BDPrincipal;
import basededatos.Cliente;
import basededatos.Encargado_compras;
import basededatos.Transportista;
import basededatos.Usuario;
import basededatos.iAdmin;
import basededatos.iUsuario_no_identificado;
import tiendavirtual.Uploader;
import vistas.VistaRegistrarse;

public class Registrarse extends VistaRegistrarse {

	public String fotoPerfil = "";
	public VaadinSession session;

	public Registrarse() {
		super();
		Cliente cliente = new Cliente();
		session = VaadinSession.getCurrent();
		getTipoUsuario().setVisible(false);

		iUsuario_no_identificado usr = new BDPrincipal();
		getFormaDePago().setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");

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
			fotoPerfil = "https://i.imgur.com/" + fotoPerfil.subSequence(15, 22) + ".jpg";
			output.removeAll();
			showOutput(event.getFileName(), component, output);
			getImg().setSrc(fotoPerfil);
		});

		this.getRegistrarseButton().addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				cliente.setApellidos(getApellidos().getValue());
				cliente.setDireccion(getDireccion().getValue());
				cliente.setDni(getDni().getValue());
				cliente.setEmail(getEmail().getValue());
				cliente.setNombre(getNombre().getValue());
				cliente.setFormaDePago(getFormaDePago().getValue());
				cliente.setDatosPago(getNumeroTarjeta().getValue());

				if (getPassword().getValue().equals(getPassword2().getValue())) {
					cliente.setPassword(getPassword().getValue());
				} else {
					Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);

				}
				if (fotoPerfil.startsWith("http")) {
					cliente.setFoto_perfil(fotoPerfil);
				}else {
					cliente.setFoto_perfil("https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd-300x238.png");
				}
				

				if (usr.nuevo_usuario(cliente)) {
					Notification.show("El usuario ha sido creado con éxito.", 3000, Position.MIDDLE);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					VerticalLayout mainView = (VerticalLayout) session.getAttribute("MainView");
					Usuario_no_identificado usuarioNoIdentificado = (Usuario_no_identificado) session
							.getAttribute("usuarioNoIdentificado");

					Iniciar_sesion _iniciar_sesion = new Iniciar_sesion();

					mainView.remove(usuarioNoIdentificado);
					mainView.add(_iniciar_sesion);

				}

			}
		});
		getFormaDePago().setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");

			
		// añadir espacio en numero de tarjeta _ NO FUNCIONA.
			
		/*
		 * getFormaDePago().addValueChangeListener(new
		 * ValueChangeListener<ValueChangeEvent<?>>() {
		 * 
		 * @Override public void valueChanged(ValueChangeEvent<?> event) {
		 * System.out.println("geRTFormade pago listener"); if
		 * (getFormaDePago().getValue().equals("Tarjeta de crédito")) {
		 * getNumeroTarjeta().addValueChangeListener(new
		 * ValueChangeListener<ValueChangeEvent<?>>() {
		 * 
		 * @Override public void valueChanged(ValueChangeEvent<?> event) {
		 * System.out.println("getnumero tarjeta listener"); // TODO Auto-generated
		 * method stub if (getNumeroTarjeta().getValue().length() == 4) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue() + " "); }else if
		 * (getNumeroTarjeta().getValue().length() == 9) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue() + " "); }else if
		 * (getNumeroTarjeta().getValue().length() == 14) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue() + " "); }else if
		 * (getNumeroTarjeta().getValue().length() == 19) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue() + " "); }else if
		 * (getNumeroTarjeta().getValue().length() == 5) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue().subSequence(0,
		 * 4).toString()); }else if (getNumeroTarjeta().getValue().length() == 10) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue().subSequence(0,
		 * 9).toString()); }else if (getNumeroTarjeta().getValue().length() == 15) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue().subSequence(0,
		 * 14).toString()); }else if (getNumeroTarjeta().getValue().length() == 20) {
		 * getNumeroTarjeta().setValue(getNumeroTarjeta().getValue().subSequence(0,
		 * 19).toString()); }
		 * 
		 * }
		 * 
		 * }); }else { getNumeroTarjeta().addValueChangeListener(null); }
		 * 
		 * } });
		 */
			
		
	}

	public Registrarse(Administrador administrador2) {
		super();
		this.getRegistrarseButton().setText("Actualizar usuario");

		Administrador administrador;
		if (administrador2 == null) {
			administrador = new Administrador();
		} else {
			administrador = administrador2;
		}
		getApellidos().setValue(administrador.getApellidos());
		getNombre().setValue(administrador2.getNombre());
		getDireccion().setValue(administrador2.getDireccion());
		getDni().setValue(administrador2.getDni());
		getEmail().setValue(administrador2.getEmail());
		//getFormaDePago().setValue(administrador2.getFormaDePago());
		//getNumeroTarjeta().setValue(administrador2.getNumeroTarjeta());
		
		if (administrador2.getFoto_perfil() != null) {
			getImg().setSrc(administrador2.getFoto_perfil());	
		}
		getPassword().setValue(administrador2.getPassword());
		getTipoUsuario().setItems("Administrador", "Encargado de compras", "Transportista");

		getTipoUsuario().setValue("Administrador");
		
		getFormaDePago().setVisible(false);
		getNumeroTarjeta().setVisible(false);

		session = VaadinSession.getCurrent();

		iAdmin adm = new BDPrincipal();

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
				// TODO Auto-generated method stub
				administrador.setApellidos(getApellidos().getValue());
				administrador.setDireccion(getDireccion().getValue());
				administrador.setDni(getDni().getValue());
				administrador.setEmail(getEmail().getValue());
				administrador.setNombre(getNombre().getValue());
				administrador.setFoto_perfil(getImg().getSrc());
				if (getPassword().getValue().equals(getPassword2().getValue())) {
					administrador.setPassword(getPassword().getValue());
				} else {
					Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);
					return;
				}
				administrador.setFoto_perfil(fotoPerfil);

				if (adm.crearAdministrador(administrador)) {
					Notification.show("El usuario ha sido actualizado con éxito.", 3000, Position.MIDDLE);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");

					Registrarse _registrarse = (Registrarse) session.getAttribute("Registrarse");

					Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados();

					verticalLayoutAdmin.remove(_registrarse);
					verticalLayoutAdmin.add(_vista_gestion_empleados);

				}

			}
		});
	}

	public Registrarse(boolean b) {
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

	public Registrarse(Encargado_compras encargado2) {
		super();
		this.getRegistrarseButton().setText("Actualizar usuario");

		Encargado_compras encargado;
		if (encargado2 == null) {
			encargado = new Encargado_compras();
		} else {
			encargado = encargado2;
		}
		getApellidos().setValue(encargado.getApellidos());
		getNombre().setValue(encargado.getNombre());
		getDireccion().setValue(encargado.getDireccion());
		getDni().setValue(encargado.getDni());
		getEmail().setValue(encargado.getEmail());
		//getFormaDePago().setValue(administrador2.getFormaDePago());
		//getNumeroTarjeta().setValue(administrador2.getNumeroTarjeta());
		
		if (encargado.getFoto_perfil() != null) {
			getImg().setSrc(encargado.getFoto_perfil());	
		}
		getPassword().setValue(encargado.getPassword());
		getTipoUsuario().setItems("Administrador", "Encargado de compras", "Transportista");

		getTipoUsuario().setValue("Encargado de compras");
		
		getFormaDePago().setVisible(false);
		getNumeroTarjeta().setVisible(false);

		session = VaadinSession.getCurrent();

		iAdmin adm = new BDPrincipal();
		getFormaDePago().setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");

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
				// TODO Auto-generated method stub
				encargado.setApellidos(getApellidos().getValue());
				encargado.setDireccion(getDireccion().getValue());
				encargado.setDni(getDni().getValue());
				encargado.setEmail(getEmail().getValue());
				encargado.setNombre(getNombre().getValue());
				encargado.setFoto_perfil(getImg().getSrc());
				if (getPassword().getValue().equals(getPassword2().getValue())) {
					encargado.setPassword(getPassword().getValue());
				} else {
					Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);
					return;
				}
				encargado.setFoto_perfil(fotoPerfil);

				if (adm.crearEncargadoCompras(encargado)) {
					Notification.show("El usuario ha sido actualizado con éxito.", 3000, Position.MIDDLE);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");

					Registrarse _registrarse = (Registrarse) session.getAttribute("Registrarse");

					Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados();

					verticalLayoutAdmin.remove(_registrarse);
					verticalLayoutAdmin.add(_vista_gestion_empleados);

				}

			}
		});
	}

	public Registrarse(Transportista transportista2) {
		super();
		this.getRegistrarseButton().setText("Actualizar usuario");

		Transportista transportista;
		if (transportista2 == null) {
			transportista = new Transportista();
		} else {
			transportista = transportista2;
		}
		getApellidos().setValue(transportista.getApellidos());
		getNombre().setValue(transportista.getNombre());
		getDireccion().setValue(transportista.getDireccion());
		getDni().setValue(transportista.getDni());
		getEmail().setValue(transportista.getEmail());
		//getFormaDePago().setValue(administrador2.getFormaDePago());
		//getNumeroTarjeta().setValue(administrador2.getNumeroTarjeta());
		
		if (transportista.getFoto_perfil() != null) {
			getImg().setSrc(transportista.getFoto_perfil());	
		}
		getPassword().setValue(transportista.getPassword());
		getTipoUsuario().setItems("Administrador", "Encargado de compras", "Transportista");

		getTipoUsuario().setValue("Transportista");
		
		getFormaDePago().setVisible(false);
		getNumeroTarjeta().setVisible(false);

		session = VaadinSession.getCurrent();

		iAdmin adm = new BDPrincipal();
		getFormaDePago().setItems("Tarjeta de crédito", "Transferencia", "Paypal", "Bizum");

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
				// TODO Auto-generated method stub
				transportista.setApellidos(getApellidos().getValue());
				transportista.setDireccion(getDireccion().getValue());
				transportista.setDni(getDni().getValue());
				transportista.setEmail(getEmail().getValue());
				transportista.setNombre(getNombre().getValue());
				transportista.setFoto_perfil(getImg().getSrc());
				if (getPassword().getValue().equals(getPassword2().getValue())) {
					transportista.setPassword(getPassword().getValue());
				} else {
					Notification.show("La contraseña debe coincidir.", 3000, Position.MIDDLE);
					return;
				}
				
				transportista.setFoto_perfil(fotoPerfil);

				if (adm.crearTransportista(transportista)) {
					Notification.show("El usuario ha sido actualizado con éxito.", 3000, Position.MIDDLE);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					 VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");

					Registrarse _registrarse = (Registrarse) session.getAttribute("Registrarse");

					Vista_gestion_empleados _vista_gestion_empleados = new Vista_gestion_empleados();

					verticalLayoutAdmin.remove(_registrarse);
					verticalLayoutAdmin.add(_vista_gestion_empleados);

				}

			}
		});
	}

	public Usuario_no_identificado _usuario_no_identificado;

	public void Validar_registro() {

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