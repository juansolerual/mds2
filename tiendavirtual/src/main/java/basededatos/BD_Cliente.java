package basededatos;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Cliente;

public class BD_Cliente {
	public BDPrincipal _bDPrincipal;
	public Vector<Cliente> _contiene_clientes = new Vector<Cliente>();

	public boolean nuevo_usuario(Usuario aUsuario) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			resultado = UsuarioDAO.save(aUsuario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
	}

	public boolean compruebarUsuario(Usuario aUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean loginUsuario(Usuario aUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarCambiosUsuario(Usuario aUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean darBajaUsuario(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean cambiarContrasena(String aContrasenaNueva) {
		throw new UnsupportedOperationException();
	}

	public List<Cliente> cargarClientes() throws PersistentException {
		List<Cliente> clientes = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			clientes = ClienteDAO.queryCliente(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return clientes;
	}

	public Cliente cargarCliente(int idUsuario) throws PersistentException {
		Cliente cliente = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			cliente = ClienteDAO.getClienteByORMID(idUsuario);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return cliente;
	}
	
}