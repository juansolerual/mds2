package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Lineas_de_Pedido;

public class BD_LineaDePedido {
	public BDPrincipal _bDPrincipal;
	public Vector<Lineas_de_Pedido> _contiene_lineas_de_Pedido = new Vector<Lineas_de_Pedido>();

	public List<Lineas_de_Pedido> cargarCarrito() throws PersistentException {
		List<Lineas_de_Pedido> ldp = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {	
			ldp = Lineas_de_PedidoDAO.queryLineas_de_Pedido(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return ldp;
	}

	public boolean Eliminar_Producto_del_carrito(int aIdLineaDePedido) {
		throw new UnsupportedOperationException();
	}

	public boolean Modificar_cantidad_unidades(int aNumUnidades) {
		throw new UnsupportedOperationException();
	}
}