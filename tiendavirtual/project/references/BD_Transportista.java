package basededatos;

import java.util.List;
import java.util.Vector;

import org.hibernate.collection.internal.PersistentSet;
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

	public boolean eliminarTransportista(int aIdTransportista) throws PersistentException {
		boolean resultado = false;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			Transportista transportista = TransportistaDAO.getTransportistaByORMID(aIdTransportista);
			resultado = TransportistaDAO.delete(transportista);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;	}

	public Transportista cargarTransportista(int aIdTransportista) throws PersistentException {
		Transportista transportista = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			transportista = TransportistaDAO.getTransportistaByORMID(aIdTransportista);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return transportista;
	}

	public boolean crearTransportista(Transportista aTransportista) throws PersistentException {
		boolean resultado = false;
		
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			//Transportista transportistaTemp = TransportistaDAO.getTransportistaByORMID(aTransportista.getID());
			
			Transportista nuevoTransportista = TransportistaDAO.createTransportista();
			
			nuevoTransportista = (Transportista) TiendavirtualPersistentManager.instance().getSession().merge(aTransportista);

//			nuevoTransportista.setApellidos(aTransportista.getApellidos());
//			nuevoTransportista.setDireccion(aTransportista.getDireccion());
//			nuevoTransportista.setDni(aTransportista.getDni());
//			nuevoTransportista.setEmail(aTransportista.getEmail());
//			nuevoTransportista.setFoto_perfil(aTransportista.getFoto_perfil());
//			nuevoTransportista.setNombre(aTransportista.getNombre());
//			nuevoTransportista.setPassword(aTransportista.getPassword());
//			
//			
//			List<Mensaje> mensajes = MensajeDAO.queryMensaje("Mensaje.pertenece_a='" + aTransportista.getID()+"'", null);
//			for (Mensaje mensaje : mensajes) {
//				mensaje.setPertenece_a(nuevoTransportista);
//			}
//			
//			List<Entregado> entregados = EntregadoDAO.queryEntregado("Entregado.gestionado_por='" + aTransportista.getID()+"'", null);
//			for (Entregado entregado : entregados) {
//				entregado.setGestionado_por(nuevoTransportista);
//			}
			
			
			//((PersistentSet)aTransportista.gestiona.getCollection()).getSession().flush();
			//((PersistentSet)aTransportista.marca_como_entregado.getCollection()).getSession().flush();


			//TransportistaDAO.delete(aTransportista);
			
			resultado = TransportistaDAO.save(nuevoTransportista);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		

		return resultado;	
		}	
	}
