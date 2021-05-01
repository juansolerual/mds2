package basededatos;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Administrador;

public class BD_Administrador {
	public BDPrincipal _bDPrincipal;
	public Vector<Administrador> _contiene_administradores = new Vector<Administrador>();

	public List<Administrador> cargarAdministradores() throws PersistentException {
		List<Administrador> administradores = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			administradores = AdministradorDAO.queryAdministrador(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return administradores;
	}

	public boolean eliminarAdministrador(int aIdAdministrador) {
		throw new UnsupportedOperationException();
	}

	public Administrador cargarAdministrador(int aIdAdministrador) throws PersistentException {
		Administrador administrador = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			administrador = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return administrador;
	}

	public boolean crearAdministrador(Administrador aAdministrador) {
		throw new UnsupportedOperationException();
	}
}