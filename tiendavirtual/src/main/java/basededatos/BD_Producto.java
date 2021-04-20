package basededatos;

import java.util.Vector;
import basededatos.Producto;

public class BD_Producto {
	public BDPrincipal _bDPrincipal;
	public Vector<Producto> _contiene_productos = new Vector<Producto>();

	public Producto[] cargarProductos() {
		throw new UnsupportedOperationException();
	}

	public Producto cargarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public Producto[] verProductosCategoria(int aIdCategoria) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarProducto(Producto aProducto) {
		throw new UnsupportedOperationException();
	}
}