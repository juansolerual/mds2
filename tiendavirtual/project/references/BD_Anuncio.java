package basededatos;

import java.util.Vector;
import basededatos.Anuncio;

public class BD_Anuncio {
	public BDPrincipal _bDPrincipal;
	public Vector<Anuncio> _contiene_anuncios = new Vector<Anuncio>();

	public Anuncio[] cargarAnuncios() {
		throw new UnsupportedOperationException();
	}

	public Anuncio cargarAnuncio(int aIdAnuncio) {
		throw new UnsupportedOperationException();
	}
}