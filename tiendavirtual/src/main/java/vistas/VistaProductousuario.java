package vistas;

import com.vaadin.flow.templatemodel.TemplateModel;

import basededatos.BDPrincipal;
import basededatos.Categoria;
import basededatos.Foto;
import basededatos.FotoDAO;
import basededatos.Oferta;
import basededatos.Producto;
import basededatos.ProductoDAO;
import basededatos.iAdmin;
import interfaz.Producto_usuario;
import interfaz.Visualizar_Pantalla_Principal_Administrador;
import interfaz.Visualizar_Pantalla_Principal_Usuario_Registrado;
import interfaz.Visualizar_Pantalla_Usuario_no_registrado;
import tiendavirtual.Uploader;
import tiendavirtual.cookiesHelper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.orm.PersistentException;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Shortcuts;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.internal.MessageDigestUtil;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;

/**
 * A Designer generated component for the vista-producto_usuario template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Tag("vista-productousuario")
@JsModule("./src/vista-productousuario.js")
public class VistaProductousuario extends PolymerTemplate<VistaProductousuario.VistaProductousuarioModel> {

	
	public Producto nuevoProducto;
	public int resultado;
	public Producto productoEditado;

	private boolean image1b = false;
	private boolean image2b = false;
	private boolean image3b = false;
	private boolean image4b = false;
	private boolean image5b = false;
	private boolean image1Editada = false;
	private boolean image2Editada = false;
	private boolean image3Editada = false;
	private boolean image4Editada = false;
	private boolean image5Editada = false;

	public String fotoOferta = null;
	public Image imageOfertaNueva = new Image();
	private Foto foto1;
	private Foto foto2;
	private Foto foto3;
	private Foto foto4;
	private Foto foto5;
	public String url = "";
	private boolean isEditarProducto = false;
	List<Foto> fotos2 = null;

	@Id("vaadinVerticalLayout")
	private Element vaadinVerticalLayout;
	@Id("fotos")
	private HorizontalLayout fotos;
	@Id("image1")
	private Image image1;
	@Id("image2")
	private Image image2;
	@Id("image3")
	private Image image3;
	@Id("image4")
	private Image image4;
	@Id("image5")
	private Image image5;
	@Id("addCarritoButton")
	private Button addCarritoButton;
	@Id("cantidad")
	private ComboBox cantidad;
	@Id("descripcion")
	private HorizontalLayout descripcion;
	@Id("caracteristicas")
	private HorizontalLayout caracteristicas;
	@Id("valoraciones")
	private HorizontalLayout valoraciones;
	@Id("caracteristicasText")
	private TextArea caracteristicasText;
	@Id("descripcionText")
	private TextArea descripcionText;
	@Id("precio")
	private TextField precio;
	@Id("buttonCrearCategoria")
	private Button buttonCrearCategoria;
	@Id("nombreProducto")
	private TextField nombreProducto;
	@Id("oferta")
	private ComboBox<Oferta> oferta;
	@Id("buttonCrearOferta")
	private Button buttonCrearOferta;
	@Id("categoria1")
	private ComboBox<Categoria> categoria;
	@Id("precioRebajado")
	private TextField precioRebajado;
	@Id("volver")
	private Button volver;
	private String fotoCategoria;
	public iAdmin adm;

	/**
	 * Creates a new VistaProducto_usuario.
	 */
	public VistaProductousuario(Producto producto, boolean admin) {
		// You can initialise any data required for the connected UI components here.
		
		if (producto != null) {
			isEditarProducto = true;
		}
		List<String> cantidadItems = new ArrayList<String>();
		for (int i=1;i<15;i++) {
			cantidadItems.add(i+"");
		}
		cantidad.setItems(cantidadItems);
		precio.setReadOnly(true);
		nombreProducto.setReadOnly(true);
		precioRebajado.setReadOnly(true);
		buttonCrearCategoria.setVisible(false);
		categoria.setReadOnly(true);
		categoria.setVisible(false);
		buttonCrearOferta.setVisible(false);
		oferta.setReadOnly(true);
		oferta.setVisible(false);
		cantidad.setLabel("Cantidad");
		adm = new BDPrincipal();
		List<Categoria> categorias = adm.cargarCategorias();
		List<Oferta> ofertas = adm.cargarOfertas();
		
		
		volver.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				VaadinSession session = VaadinSession.getCurrent();
				
				String usuario = (String)session.getAttribute("username");
				
				
				if (cookiesHelper.isNoRegistrado()) {
					VerticalLayout verticalLayoutUsuarioNoIdentificado = (VerticalLayout) session.getAttribute("verticalLayoutUsuarioNoIdentificado");
		    		Visualizar_Pantalla_Usuario_no_registrado visualizar_Pantalla_Usuario_no_registrado = (Visualizar_Pantalla_Usuario_no_registrado) session.getAttribute("Visualizar_Pantalla_Usuario_no_registrado");
		    		VistaProductousuario vistaProductoUsuario = (VistaProductousuario) session.getAttribute("vistaProductoUsuario");
		    		
		    		verticalLayoutUsuarioNoIdentificado.remove(vistaProductoUsuario);
		    		verticalLayoutUsuarioNoIdentificado.add(visualizar_Pantalla_Usuario_no_registrado);
				}
				
				if (cookiesHelper.isCliente()) {
			    	VerticalLayout verticalLayoutUsuarioIdentificado = (VerticalLayout) session.getAttribute("verticalLayoutUsuarioIdentificado");
			    	Visualizar_Pantalla_Principal_Usuario_Registrado visualizar_Pantalla_Principal_Usuario_Registrado = (Visualizar_Pantalla_Principal_Usuario_Registrado) session.getAttribute("Visualizar_Pantalla_Principal_Usuario_Registrado");
		    		VistaProductousuario vistaProductoUsuario = (VistaProductousuario) session.getAttribute("vistaProductoUsuario");
		    		
		    		verticalLayoutUsuarioIdentificado.remove(vistaProductoUsuario);
		    		verticalLayoutUsuarioIdentificado.add(visualizar_Pantalla_Principal_Usuario_Registrado);
				}
				if (cookiesHelper.isAdministrador()) {
					VerticalLayout verticalLayoutAdmin = (VerticalLayout) session.getAttribute("verticalLayoutAdmin");
			    	Visualizar_Pantalla_Principal_Administrador visualizar_Pantalla_Principal_Administrador = (Visualizar_Pantalla_Principal_Administrador) session.getAttribute("visualizar_Pantalla_Principal_Administrador");
		    		VistaProductousuario vistaProductoUsuario = (VistaProductousuario) session.getAttribute("vistaProductoUsuario");
		    		verticalLayoutAdmin.remove(vistaProductoUsuario);
		    		verticalLayoutAdmin.add(visualizar_Pantalla_Principal_Administrador);
				}
				
		    	
			}
		});
		
		// categoria= new ComboBox<>();
		// String[] items = new String[categorias.length];

		// this.categoria.setItems(categorias);

		Dialog dialogUpload = new Dialog();
		HorizontalLayout dialogUploadHorizontal = new HorizontalLayout();
		dialogUpload.setCloseOnOutsideClick(true);
		Label tituloUploadDialog = new Label("Subir imagen");
		dialogUploadHorizontal.add(tituloUploadDialog);
		dialogUpload.setWidth("800px");
		dialogUpload.setHeight("600px");
		dialogUpload.setMinHeight("600px");
		dialogUpload.setMinWidth("800px");
		dialogUpload.setCloseOnEsc(true);
		dialogUpload.setCloseOnOutsideClick(true);

		dialogUpload.setModal(false);
		dialogUpload.setDraggable(true);
		dialogUpload.setResizable(true);

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
			url = Uploader.upload(targetFile);
			System.out.println(url);
			System.out.println("index of title  " + url.indexOf("title"));
			System.out.println("https://i.imgur.com/" + url.subSequence(15, 22) + ".jpg");
			url = "https://i.imgur.com/" + url.subSequence(15, 22) + ".jpg";
			output.removeAll();
			showOutput(event.getFileName(), component, output);
		});

		Button guardarUploadButton = new Button("Guardar foto");
		guardarUploadButton.getStyle().set("margin", "20px");

		guardarUploadButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				if (image1b) {
					image1Editada = true;
					if (!image1.getSrc().isEmpty()) {
						//producto.tieneFoto.remove(foto1);
						adm.eliminarFoto(foto1);
						//FotoDAO.delete(foto1);							
						if (foto1 != null) {
							foto1.setURLFoto(url);
							image1.setSrc(url);
						}
					} else {
						foto1 = new Foto();
						foto1.setURLFoto(url);
						image1.setSrc(url);
					}
					dialogUpload.close();
					image1b = false;
				}
				if (image2b) {
					image2Editada = true;
					if (!image2.getSrc().isEmpty()) {
						//producto.tieneFoto.remove(foto1);
						adm.eliminarFoto(foto2);
						//FotoDAO.delete(foto1);							
						if (foto2 != null) {
							foto2.setURLFoto(url);
							image2.setSrc(url);
						}
					} else {
						foto2 = new Foto();
						foto2.setURLFoto(url);
						image2.setSrc(url);
					}
					dialogUpload.close();
					image2b = false;
				}
				if (image3b) {
					image3Editada = true;
					if (!image3.getSrc().isEmpty()) {
						//producto.tieneFoto.remove(foto1);
						adm.eliminarFoto(foto3);
						//FotoDAO.delete(foto1);							
						if (foto3 != null) {
							foto3.setURLFoto(url);
							image3.setSrc(url);
						}
					} else {
						foto3 = new Foto();
						foto3.setURLFoto(url);
						image3.setSrc(url);
					}
					dialogUpload.close();
					image3b = false;
				}
				if (image4b) {
					image4Editada = true;
					if (!image4.getSrc().isEmpty()) {
						//producto.tieneFoto.remove(foto1);
						adm.eliminarFoto(foto4);
						//FotoDAO.delete(foto1);							
						if (foto4 != null) {
							foto4.setURLFoto(url);
							image4.setSrc(url);
						}
					} else {
						foto4 = new Foto();
						foto4.setURLFoto(url);
						image4.setSrc(url);
					}
					dialogUpload.close();
					image4b = false;
				}
				if (image5b) {
					image5Editada = true;
					if (!image5.getSrc().isEmpty()) {
						//producto.tieneFoto.remove(foto1);
						adm.eliminarFoto(foto5);
						//FotoDAO.delete(foto1);							
						if (foto5 != null) {
							foto5.setURLFoto(url);
							image5.setSrc(url);
						}
					} else {
						foto5 = new Foto();
						foto5.setURLFoto(url);
						image5.setSrc(url);
					}
					dialogUpload.close();
					image5b = false;
				}
			}
		});
		dialogUpload.add(dialogUploadHorizontal, upload, output, guardarUploadButton);
		
		if (admin) {
			image1.addClickListener(event -> {
				image1b = true;
				dialogUpload.open();
			});
			image2.addClickListener(event -> {
				image2b = true;
				dialogUpload.open();
			});
			image3.addClickListener(event -> {
				image3b = true;
				dialogUpload.open();
			});
			image4.addClickListener(event -> {
				image4b = true;
				dialogUpload.open();
			});
			image5.addClickListener(event -> {
				image5b = true;
				dialogUpload.open();
			});
		}

		

		categoria.setItemLabelGenerator(Categoria::getNombreCategoria);
		categoria.setItems(categorias);
		oferta.setItemLabelGenerator(Oferta::getNombreOferta);
		oferta.setItems(ofertas);

		if (producto != null) {
			System.out.println("NOMBRE: ");
			System.out.println(producto.getNombreProducto());
			java.util.Date date = producto.getAplica_oferta().getFechaCaducidadOferta();
			java.util.Date datenow = new java.util.Date();
			int resultadoDate = datenow.compareTo(date);
			if (producto.getAplica_oferta().getActivada() && resultadoDate == -1) {
				if (producto.getAplica_oferta().getPorcentajeOferta()) {
					precioRebajado.setValue(String.valueOf(producto.getPrecio()
							- (producto.getPrecio() * (producto.getAplica_oferta().getPrecioOferta() / 100))));
				} else {
					precioRebajado.setValue(String.valueOf(producto.getAplica_oferta().getPrecioOferta()));
				}
			} else {
				precioRebajado.setVisible(false);
			}

			nombreProducto.setValue(producto.getNombreProducto());
			caracteristicasText.setValue(producto.getCaracteristicas());
			descripcionText.setValue(producto.getDescripcion());
			oferta.setValue(producto.getAplica_oferta());
			categoria.setValue(producto.getPertenece_a());
			precio.setValue(String.valueOf(producto.getPrecio()));
			fotos2 = adm.cargarFotos(producto.getID());
			
			
			int contadorFoto = 1;
			if (fotos2 != null) {
				for (Foto foto : fotos2) {
					

					System.out.println(foto.getURLFoto());
					System.out.println("Contador " + contadorFoto);
					System.out.println("isPrincipal " + !foto.getIsPrincipal());
					if (contadorFoto == 6) {
						break;
					}
					
					
					

//					if (contadorFoto == 1) {
//						if (image1.getSrc().isEmpty()) {
//							image1.setSrc(foto.getURLFoto());
//							foto1 = foto;
//						}
//					}
					if (contadorFoto == 1) {
						if (foto.getIsPrincipal()) {
							image1.setSrc(foto.getURLFoto());
							foto1 = foto;
							continue;
						}
						System.out.println("Dentrod e image1");
						image2.setSrc(foto.getURLFoto());
						foto2 = foto;
					}
					if (contadorFoto == 2) {
						if (foto.getIsPrincipal()) {
							image1.setSrc(foto.getURLFoto());
							foto1 = foto;
							continue;
						}
						image3.setSrc(foto.getURLFoto());
						foto3 = foto;

					}
					if (contadorFoto == 3 ) {
						if (foto.getIsPrincipal()) {
							image1.setSrc(foto.getURLFoto());
							foto1 = foto;
							continue;
						}
						image4.setSrc(foto.getURLFoto());
						foto4 = foto;

					}
					if (contadorFoto == 4) {
						if (foto.getIsPrincipal()) {
							image1.setSrc(foto.getURLFoto());
							foto1 = foto;
							continue;
						}
						image5.setSrc(foto.getURLFoto());
						foto5 = foto;

					}
					
					if (contadorFoto == 5) {
						if (foto.getIsPrincipal()) {
							image1.setSrc(foto.getURLFoto());
							foto1 = foto;
							continue;
						}
					}
					
					contadorFoto++;

				}
			}

		}

		if (admin) {
			buttonCrearCategoria.setVisible(true);
			categoria.setReadOnly(false);
			categoria.setVisible(true);
			categoria.setRequiredIndicatorVisible(true);
			buttonCrearOferta.setVisible(true);
			oferta.setReadOnly(false);
			oferta.setVisible(true);
			oferta.setRequiredIndicatorVisible(true);

			// oferta.addValueChangeListener(listener)

			precio.setReadOnly(false);
			nombreProducto.setReadOnly(false);
			caracteristicasText.setReadOnly(false);
			descripcionText.setReadOnly(false);
			// addCarritoButton.setEnabled(false);
			addCarritoButton.setText("Guardar producto");
			// addCarritoButton.setVisible(false);
			cantidad.setEnabled(false);
			// cantidad.setVisible(false);
			
			

			addCarritoButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				



				@Override
				public void onComponentEvent(ClickEvent<Button> event) {

					if (oferta.isEmpty() || categoria.isEmpty()) {
						Notification.show("Oferta y Categoeria deben estar seleccionadas.", 3000, Position.MIDDLE);
						return;
					}

					if (precio.isEmpty()) {
						Notification.show("El precio es obligatorio", 3000, Position.MIDDLE);
						return;
					}

					if (precio.getValue().contains(",")) {
						Notification.show("El separador de decimales debe ser un punto (Ejemplo 1.1€)", 3000,
								Position.MIDDLE);
						return;
					}

					try {
						double d = Double.parseDouble(precio.getValue());
					} catch (NumberFormatException nfe) {
						Notification.show("Compruebe el valor del precio.", 3000, Position.MIDDLE);
						return;
					}
					// TODO Auto-generated method stub
					if (producto == null) {
						Producto producto = new Producto();
					}
					nuevoProducto = new Producto();
					nuevoProducto.setNombreProducto(nombreProducto.getValue());
					nuevoProducto.setDescripcion(descripcionText.getValue());
					nuevoProducto.setCaracteristicas(caracteristicasText.getValue());
					nuevoProducto.setPrecio(Double.parseDouble(precio.getValue()));
					nuevoProducto.setAplica_oferta(oferta.getValue());
					nuevoProducto.setPertenece_a(categoria.getValue());
					nuevoProducto.setLimiteFotos(0);
					resultado = -1;
					if (isEditarProducto) {
						
							System.out.println("ID producto a EDITAR " + producto.getID());
							productoEditado = adm.cargarProducto(producto.getID());
							//Producto productoEditado = ProductoDAO.getProductoByORMID(producto.getID());
							productoEditado.setNombreProducto(nombreProducto.getValue());
							productoEditado.setDescripcion(descripcionText.getValue());
							productoEditado.setCaracteristicas(caracteristicasText.getValue());
							productoEditado.setPrecio(Double.parseDouble(precio.getValue()));
							productoEditado.setAplica_oferta(oferta.getValue());
							productoEditado.setPertenece_a(categoria.getValue());
							productoEditado.setLimiteFotos(0);

							// ProductoDAO.save();

							if (image1Editada) {
								foto1.setIsPrincipal(true);
								productoEditado.tieneFoto.add(foto1);
								image1Editada = false;
							}
							if (image2Editada) {
								foto2.setIsPrincipal(false);
								productoEditado.tieneFoto.add(foto2);
								image2Editada = false;
							}
							if (image3Editada) {
								foto3.setIsPrincipal(false);
								productoEditado.tieneFoto.add(foto3);
								image3Editada = false;
							}
							if (image4Editada) {
								foto4.setIsPrincipal(false);
								productoEditado.tieneFoto.add(foto4);
								image4Editada = false;
							}
							if (image5Editada) {
								foto5.setIsPrincipal(false);
								productoEditado.tieneFoto.add(foto5);
								image5Editada = false;
							}
							
							
							editarProducto();
							System.out.println("Resultado editar id " + resultado);
							
							

							/*
							 * for (Foto foto : fotos2) {
							 * 
							 * if (!image1.getSrc().isEmpty()) { if
							 * (foto.getURLFoto().equals(image1.getSrc())) { image1Existe = true; } } if
							 * (!image2.getSrc().isEmpty()) { if (foto.getURLFoto().equals(image2.getSrc()))
							 * { image2Existe = true; } } if (!image3.getSrc().isEmpty()) { if
							 * (foto.getURLFoto().equals(image3.getSrc())) { image3Existe = true; } } if
							 * (!image4.getSrc().isEmpty()) { if (foto.getURLFoto().equals(image4.getSrc()))
							 * { image4Existe = true; } } if (!image5.getSrc().isEmpty()) { if
							 * (foto.getURLFoto().equals(image5.getSrc())) { image5Existe = true; } }
							 * 
							 * 
							 * }
							 */
							/*
							 * if (!image1Existe && !image1.getSrc().isEmpty()) { Foto foto = new Foto();
							 * foto.setURLFoto(image1.getSrc()); foto.setIsPrincipal(true);
							 * foto.setPertenece_a(productoEditado); try { FotoDAO.save(foto); } catch
							 * (PersistentException e) { // TODO Auto-generated catch block
							 * e.printStackTrace(); } } if (!image2Existe && !image2.getSrc().isEmpty()) {
							 * Foto foto = new Foto(); foto.setURLFoto(image2.getSrc());
							 * foto.setIsPrincipal(true); foto.setPertenece_a(productoEditado); try {
							 * FotoDAO.save(foto); } catch (PersistentException e) { // TODO Auto-generated
							 * catch block e.printStackTrace(); } } if (!image3Existe &&
							 * !image3.getSrc().isEmpty()) { Foto foto = new Foto();
							 * foto.setURLFoto(image3.getSrc()); foto.setIsPrincipal(true);
							 * foto.setPertenece_a(productoEditado); try { FotoDAO.save(foto); } catch
							 * (PersistentException e) { // TODO Auto-generated catch block
							 * e.printStackTrace(); } } if (!image4Existe && !image4.getSrc().isEmpty()) {
							 * Foto foto = new Foto(); foto.setURLFoto(image4.getSrc());
							 * foto.setIsPrincipal(true); foto.setPertenece_a(productoEditado); try {
							 * FotoDAO.save(foto); } catch (PersistentException e) { // TODO Auto-generated
							 * catch block e.printStackTrace(); } } if (!image5Existe &&
							 * !image5.getSrc().isEmpty()) { Foto foto = new Foto();
							 * foto.setURLFoto(image5.getSrc()); foto.setIsPrincipal(true);
							 * foto.setPertenece_a(productoEditado); try { FotoDAO.save(foto); } catch
							 * (PersistentException e) { // TODO Auto-generated catch block
							 * e.printStackTrace(); } }
							 */

						

					} else {
						if (image1Editada) {
							foto1.setIsPrincipal(true);
							nuevoProducto.tieneFoto.add(foto1);
							image1Editada = false;
						}
						if (image2Editada) {
							foto2.setIsPrincipal(false);
							nuevoProducto.tieneFoto.add(foto2);
							image2Editada = false;
						}
						if (image3Editada) {
							foto3.setIsPrincipal(false);
							nuevoProducto.tieneFoto.add(foto3);
							image3Editada = false;
						}
						if (image4Editada) {
							foto4.setIsPrincipal(false);
							nuevoProducto.tieneFoto.add(foto4);
							image4Editada = false;
						}
						if (image5Editada) {
							foto5.setIsPrincipal(false);
							nuevoProducto.tieneFoto.add(foto5);
							image5Editada = false;
						}
						
						guardarProducto();
						
					}

					if (resultado != -1) {
						Notification notification = Notification.show("El producto se ha guardado correctamente.", 3000,
								Position.MIDDLE);

						nombreProducto.setValue("");
						descripcionText.setValue("");
						caracteristicasText.setValue("");
						precio.setValue("");
						oferta.clear();
						categoria.clear();
					} else {
						Notification notification = Notification.show("Ha habido un error guardando el producto.", 3000,
								Position.MIDDLE);
					}
				}

			});

			Dialog dialog = new Dialog();
			HorizontalLayout dialogHorizontal = new HorizontalLayout();
			dialog.setCloseOnOutsideClick(true);
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
			
			MemoryBuffer bufferCategoria = new MemoryBuffer();
			Upload uploadCategoria = new Upload(bufferCategoria);
			uploadCategoria.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif");

			

			uploadCategoria.addSucceededListener(event -> {
				Component component = createComponent(event.getMIMEType(), event.getFileName(), bufferCategoria.getInputStream());
				File targetFile = new File("src/main/resources/targetFile.tmp");

				try {
					FileUtils.copyInputStreamToFile(bufferCategoria.getInputStream(), targetFile);
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
				//output.removeAll();
				//showOutput(event.getFileName(), component, output);
			});


			guardar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					iAdmin adm = new BDPrincipal();
					basededatos.Categoria aCategoria = new basededatos.Categoria();
					aCategoria.setNombreCategoria(nombreCategoria.getValue());
					aCategoria.setDescripcion(descripcion.getValue());
					int result = adm.guardarCategoria(aCategoria);
					if (result != -1) {
						Notification notification = Notification.show("La categoría ha sido creada correctamente", 3000,
								Position.MIDDLE);
						nombreCategoria.setValue("");
						descripcion.setValue("");
						dialog.close();
						categorias.add(aCategoria);
						categoria.setItems(categorias);

					} else {
						Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.", 3000,
								Position.TOP_CENTER);
					}
				}

			});
			VerticalLayout dialogVertical = new VerticalLayout(nombreCategoria, descripcion, imageCategoriaNueva, uploadCategoria);
			HorizontalLayout dialogButtons = new HorizontalLayout(guardar, cancelButton);
			dialogHorizontal.getStyle().set("margin", "20px").set("width", "100%");
			dialogVertical.getStyle().set("margin", "20px").set("width", "100%");
			Label mesageEsc = new Label("pulsa ESC para salir");

			dialog.add(dialogHorizontal, dialogVertical, dialogButtons, mesageEsc);

			buttonCrearCategoria.addClickListener(event -> dialog.open());

			// DIALOGO OFERTA
			
			imageOfertaNueva.setWidth("150px");
			imageOfertaNueva.setHeight("150px");
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

			Dialog dialogOferta = new Dialog();
			HorizontalLayout dialogOfertaHorizontal = new HorizontalLayout();
			dialog.setCloseOnOutsideClick(true);
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
			activada.setLabel("Si la oferta es un porcentaje, activar.");
			activada.getStyle().set("margin", "20px").set("width", "400px");

			Button guardarOferta = new Button("Guardar");
			guardarOferta.getStyle().set("margin", "20px");

			Button cancelOfertaButton = new Button("Cancelar", event -> {
				dialogOferta.close();
			});
			cancelOfertaButton.getStyle().set("margin", "20px");

			// Cancel action on ESC press
			Shortcuts.addShortcutListener(dialog, () -> {
				dialogOferta.close();
			}, Key.ESCAPE);

			guardarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
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
						fotoOferta = "";
						imageOfertaNueva = new Image();
						fechaCaducidad.clear();
						porcentajeOferta.setValue(false);
						activada.setValue(false);
						dialogOferta.close();
						ofertas.add(aOferta);
						oferta.setItems(ofertas);

					} else {
						Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.", 3000,
								Position.TOP_CENTER);
					}
				}

			});
			VerticalLayout dialogOfertaVertical = new VerticalLayout(nombreOferta, uploadOferta, imageOfertaNueva, precioOferta, porcentajeOferta,
					fechaCaducidad, activada);
			HorizontalLayout dialogOfertaButtons = new HorizontalLayout(guardarOferta, cancelOfertaButton);
			dialogOfertaHorizontal.getStyle().set("margin", "20px").set("width", "100%");
			dialogOfertaVertical.getStyle().set("margin", "20px").set("width", "100%");
			Label mesageOfertaEsc = new Label("pulsa ESC para salir");

			dialogOferta.add(dialogOfertaHorizontal, dialogOfertaVertical, dialogOfertaButtons, mesageOfertaEsc);

			buttonCrearCategoria.addClickListener(event -> dialog.open());
			buttonCrearOferta.addClickListener(event -> dialogOferta.open());
			
			System.out.println("final clase Vista Prudcto " );
		}

	}

	protected void editarProducto() {
		// TODO Auto-generated method stub
		resultado = adm.editarProducto(productoEditado);

	}

	protected void guardarProducto() {
		// TODO Auto-generated method stub
		resultado = adm.guardarProducto(nuevoProducto);
	}

	/**
	 * This model binds properties between VistaProducto_usuario and
	 * vista-producto_usuario
	 */
	public interface VistaProductousuarioModel extends TemplateModel {
		// Add setters and getters for template properties here.
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
