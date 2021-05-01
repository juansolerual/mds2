package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Transportista;

public class BD_Transportista {
	public BDPrincipal _bDPrincipal;
	public Vector<Transportista> _contiene_transportistas = new Vector<Transportista>();

	public List<Transportista> cargarTransportistas() throws PersistentException {
		List<Transportista> transportistas = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			transportistas = TransportistaDAO.queryTransportista(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return transportistas;
	}

	public boolean eliminarTransportista(int aIdTransportista) {
		throw new UnsupportedOperationException();
	}

	public Transportista cargarTransportista(int aIdTransportista) {
		throw new UnsupportedOperationException();
	}

	public boolean crearTransportista(Transportista aTransportista) {
		throw new UnsupportedOperationException();
	}
}