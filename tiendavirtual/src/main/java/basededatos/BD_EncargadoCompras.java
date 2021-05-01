package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Encargado_compras;

public class BD_EncargadoCompras {
	public BDPrincipal _bDPrincipal;
	public Vector<Encargado_compras> _contiene_encargados = new Vector<Encargado_compras>();

	public List<Encargado_compras> cargarEncargadoCompras() throws PersistentException {
		List<Encargado_compras> clientes = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			clientes = Encargado_comprasDAO.queryEncargado_compras(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return clientes;
	}

	public boolean eliminarEncargadoCompras(int aIdEncargado) {
		throw new UnsupportedOperationException();
	}

	public Encargado_compras cargarEncargadoCompras(int aIdEncargado) throws PersistentException {
		Encargado_compras encargado_compras = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			encargado_compras = Encargado_comprasDAO.getEncargado_comprasByORMID(aIdEncargado);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return encargado_compras;
	}

	public boolean crearEncargadoCompras(Encargado_compras aEncargadoCompras) {
		throw new UnsupportedOperationException();
	}
}