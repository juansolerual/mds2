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

	public boolean eliminarAdministrador(int aIdAdministrador) throws PersistentException {
		boolean resultado = false;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			Administrador administrador  = AdministradorDAO.getAdministradorByORMID(aIdAdministrador);
			resultado = AdministradorDAO.delete(administrador);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
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

	public boolean crearAdministrador(Administrador aAdministrador) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			//Administrador administrador = AdministradorDAO.getAdministradorByORMID(aAdministrador.getID());
//			if (administrador != null) {
//				resultado = AdministradorDAO.refresh(aAdministrador);
//			}else {
//			}
			Administrador nuevoAdministrador = (Administrador) TiendavirtualPersistentManager.instance().getSession().merge(aAdministrador);

			resultado = AdministradorDAO.save(nuevoAdministrador);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
	}

	public boolean eliminarCliente(int id) throws PersistentException {
		boolean resultado = false;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			Cliente cliente  = ClienteDAO.getClienteByORMID(id);
			resultado = ClienteDAO.delete(cliente);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
	}
}