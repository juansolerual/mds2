package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Entregado;

public class BD_Entregado {
	public BDPrincipal _bDPrincipal;
	public Vector<Entregado> _contiene_pedidos = new Vector<Entregado>();

	public List<Entregado> cargarPedidosEntregados() throws PersistentException {
		List<Entregado> entregados = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			entregados = EntregadoDAO.queryEntregado(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return entregados;
	}

	public Entregado Ver_detalles_pedido_entregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarPedidoEntregado(Entregado aPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPedidoEntregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}
}