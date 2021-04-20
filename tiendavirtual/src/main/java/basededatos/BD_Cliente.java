package basededatos;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Cliente;

public class BD_Cliente {
	public BDPrincipal _bDPrincipal;
	public Vector<Cliente> _contiene_clientes = new Vector<Cliente>();

	public boolean nuevo_usuario(Usuario aUsuario) throws PersistentException {
		boolean result = false;
		
		PersistentTransaction t = basededatos.TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			result = UsuarioDAO.save(aUsuario);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		return result;
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
}