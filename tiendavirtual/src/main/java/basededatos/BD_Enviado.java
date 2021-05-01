package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Enviado;

public class BD_Enviado {
	public BDPrincipal _bDPrincipal;
	public Vector<Enviado> _contiene_pedidos_enviados = new Vector<Enviado>();

	public List<Enviado> cargarPedidosEnviados() throws PersistentException {
		List<Enviado> enviados = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			enviados = EnviadoDAO.queryEnviado(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return enviados;
	}

	public Enviado Ver_detalles_pedido_enviado(int aIdPedidoEnviado) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarComoEnviado(Enviado aPedido) {
		throw new UnsupportedOperationException();
	}
}