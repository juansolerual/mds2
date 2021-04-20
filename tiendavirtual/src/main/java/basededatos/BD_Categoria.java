package basededatos;

import java.util.Vector;
import basededatos.Categoria;

public class BD_Categoria {
	public BDPrincipal _bDPrincipal;
	public Vector<Categoria> _contiene_categorias = new Vector<Categoria>();

	public Categoria[] cargarCategorias() {
		throw new UnsupportedOperationException();
	}

	public Categoria cargarCategoria(int aId) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCategoria(int aId) {
		throw new UnsupportedOperationException();
	}

	public int guardarCategoria(Categoria aCategoria) {
		throw new UnsupportedOperationException();
	}
}