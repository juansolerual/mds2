package interfaz;

import java.util.List;
import java.util.Vector;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import basededatos.BDPrincipal;
import basededatos.iAdmin;
import interfaz.Editar_oferta;

public class Lista_ofertas extends VerticalLayout{
	private event _eliminar_oferta;
	public Vista_Ofertas_Admin _vista_Ofertas_Admin;
	public List<basededatos.Oferta> _lista_ofertas;

	public Lista_ofertas() {
		super();
		iAdmin adm = new BDPrincipal();

		_lista_ofertas = adm.cargarOfertas();
	}

	public void Eliminar_oferta() {
		throw new UnsupportedOperationException();
	}
}