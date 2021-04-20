package basededatos;

import java.util.Vector;
import basededatos.Oferta;

public class BD_Oferta {
	public BDPrincipal _bDPrincipal;
	public Vector<Oferta> _contiene_ofertas = new Vector<Oferta>();

	public Oferta[] cargarOfertas() {
		throw new UnsupportedOperationException();
	}

	public Oferta cargarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarOferta(Oferta aOferta) {
		throw new UnsupportedOperationException();
	}
}