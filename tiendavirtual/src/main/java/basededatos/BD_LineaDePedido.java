package basededatos;

import java.util.Vector;
import basededatos.Lineas_de_Pedido;

public class BD_LineaDePedido {
	public BDPrincipal _bDPrincipal;
	public Vector<Lineas_de_Pedido> _contiene_lineas_de_Pedido = new Vector<Lineas_de_Pedido>();

	public Lineas_de_Pedido[] cargarCarrito() {
		throw new UnsupportedOperationException();
	}

	public boolean Eliminar_Producto_del_carrito(int aIdLineaDePedido) {
		throw new UnsupportedOperationException();
	}

	public boolean Modificar_cantidad_unidades(int aNumUnidades) {
		throw new UnsupportedOperationException();
	}
}