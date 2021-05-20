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

	public boolean nuevo_usuario(Cliente aUsuario) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			resultado = ClienteDAO.save(aUsuario);
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

	public boolean guardarCambiosUsuario(Cliente aUsuario) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			System.out.println("BDCLIENTE guardarCambiosCliente ");
			//Transportista transportistaTemp = TransportistaDAO.getTransportistaByORMID(aTransportista.getID());
			
			Cliente nuevoCliente = ClienteDAO.createCliente();
			
			
			nuevoCliente = (Cliente) TiendavirtualPersistentManager.instance().getSession().merge(aUsuario);

			System.out.println("cliente nuevoo " + nuevoCliente.getNombre() );

			resultado = ClienteDAO.save(nuevoCliente);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		

		return resultado;	
	}

	public boolean darBajaUsuario(int aIdUsuario) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			//Transportista transportistaTemp = TransportistaDAO.getTransportistaByORMID(aTransportista.getID());
			
			Cliente nuevoCliente = ClienteDAO.createCliente();
			
			nuevoCliente = (Cliente) TiendavirtualPersistentManager.instance().getSession().merge(aIdUsuario);
			nuevoCliente.setPassword("BAJA");
			
			resultado = ClienteDAO.save(nuevoCliente);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		

		return resultado;	
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