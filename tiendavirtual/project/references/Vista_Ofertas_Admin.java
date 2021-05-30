package interfaz;

import java.time.LocalDate;
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

import basededatos.BDPrincipal;
import basededatos.iAdmin;

public class Vista_Ofertas_Admin extends VerticalLayout {
	public Admin _admin;
	public Dar_de_alta_oferta _dar_de_alta_oferta;
	public Lista_ofertas _lista_ofertas;
	public Lista_empleados _lista_empleados;
	public Dar_alta_empleado _dar_alta_empleado;
	public Button nuevaOfertaButton;
	public HorizontalLayout cabeceraVista;
	public VaadinSession session;
	public basededatos.Oferta ofertaTemp;
	public Oferta_admin ofertaVistaTemp;
	public VerticalLayout scrollableLayout;
	public iAdmin adm;
	
	public Vista_Ofertas_Admin() {
		super();
		session = VaadinSession.getCurrent();

		setWidth("100%");
		setHeight("100%");
		_lista_ofertas = new Lista_ofertas();
		_lista_ofertas.setWidth("100%");
		_lista_ofertas.setHeight("100%");

		adm = new BDPrincipal();

		_lista_ofertas._lista_ofertas = adm.cargarOfertas();
		// List<Cliente> clientes = adm.cargarClientes();

		scrollableLayout = new VerticalLayout();
		scrollableLayout.setId("verticalLayout_lista_ofertas");
		for (basededatos.Oferta oferta : _lista_ofertas._lista_ofertas) {

			Oferta_admin ofer = new Oferta_admin();

			ofer.nombreOferta.setText(oferta.getNombreOferta());
			ofer.descripcionOferta.setText("Fecha de caducidad "  + oferta.getFechaCaducidadOferta().toString()   +  " Activada: " + oferta.getActivada());
			if (oferta.getUrlImagen() != null) {
				ofer.img.setSrc(oferta.getUrlImagen());
			} else {

				ofer.img.setSrc("https://picsum.photos/200");
			}

			scrollableLayout.add(ofer);
			ofer.eliminarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					ofertaVistaTemp = ofer;
					ofertaTemp = oferta;

					eliminarOferta();
					

				}
			});

			ofer.modificarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

				@Override
				public void onComponentEvent(ClickEvent<Button> event) {
					// TODO Auto-generated method stub
					
					ofertaTemp = oferta;
					guardarOferta();
					
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
		staticElement.getStyle().set("color", "#1676f3").set("font-weight", "bold").set("margin-top", "10px")
				.set("margin-left", "200px");
		staticElement.add(new Text("Ofertas"));

		// Add both the scrollable layout and
		// the static element to the layout
		_lista_ofertas.add(scrollableLayout);
		_lista_ofertas.getStyle().set("border","2px solid #1676f3").set("border-radius","25px");

		cabeceraVista = new HorizontalLayout();
		nuevaOfertaButton = new Button("Nueva oferta");
		cabeceraVista.add(nuevaOfertaButton, staticElement);

		add(cabeceraVista, _lista_ofertas);

		nuevaOfertaButton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				Editar_oferta editarOferta = new Editar_oferta(null);
				editarOferta.dialogOferta.open();

			}
		});
	}
	
	protected void eliminarOferta() {
		// TODO Auto-generated method stub
		this.scrollableLayout.remove(this.ofertaVistaTemp);
		adm.eliminarOferta(this.ofertaTemp.getID());
	}

	protected void guardarOferta() {
		// TODO Auto-generated method stub

		Editar_oferta editarOferta = new Editar_oferta(ofertaTemp);
		editarOferta.dialogOferta.open();

		editarOferta.guardarOferta.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				// TODO Auto-generated method stub
				iAdmin adm = new BDPrincipal();
				basededatos.Oferta aOferta = new basededatos.Oferta();
				aOferta.setNombreOferta(editarOferta.nombreOferta.getValue());
				aOferta.setActivada(editarOferta.activada.getValue());
				aOferta.setFechaCaducidadOferta(java.sql.Date.valueOf(editarOferta.fechaCaducidad.getValue().toString()));
				aOferta.setPorcentajeOferta(editarOferta.porcentajeOferta.getValue());
				aOferta.setPrecioOferta(Double.parseDouble(editarOferta.precioOferta.getValue()));
				aOferta.setUrlImagen(editarOferta.imageOfertaNueva.getSrc());
				
				int result = adm.guardarOferta(aOferta);
				if (result != -1) {
					Notification notification = Notification
							.show("La oferta ha sido creada correctamente", 3000, Position.MIDDLE);
					editarOferta.dialogOferta.close();
					
					
					
					_lista_ofertas._lista_ofertas.add(aOferta);

				} else {
					Notification notification = Notification.show("Ha habido un error. Inténtalo de nuevo.",
							3000, Position.TOP_CENTER);
				}
			}

		});
	}
	
}