package basededatos;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Pendiente;

public class BD_Pendiente {
	public BDPrincipal _bDPrincipal;
	public Vector<Pendiente> _contiene_pedidos_pendientes = new Vector<Pendiente>();

	public List<Pendiente> cargarPedidosPendientes() throws PersistentException {
		List<Pendiente> pendientes = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			pendientes = PendienteDAO.queryPendiente(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return pendientes;
	}

	public boolean Marcar_como_enviado(int aIdPedido) throws PersistentException {
		boolean resultado = false;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			
			
			
			Pendiente pend = PendienteDAO.getPendienteByORMID(aIdPedido);
			System.out.println("Pendiente cargado " + pend.getHoraPedido());
			Enviado env = EnviadoDAO.createEnviado();
			env.setFechaPedido(pend.getFechaPedido());
			env.setHoraPedido(pend.getHoraPedido());
			env.setMarcado_por(pend.getMarcado_por());
			env.setPagado(pend.getPagado());
			env.setRealizado_por(pend.getRealizado_por());
			//pend.tiene.clear();
			Set set =  pend.tiene.getCollection();
			
			List<Lineas_de_Pedido> carrito = Lineas_de_PedidoDAO.queryLineas_de_Pedido("Lineas_de_Pedido.pertenecen_a='" + pend.getID()+"'", null);
			for (Lineas_de_Pedido ldp : carrito) {
				ldp.setPertenecen_a(env);
			}
			
			
			pend.setMarcado_por(null);
			pend.setRealizado_por(null);
			PendienteDAO.delete(pend);
			
			resultado = EnviadoDAO.save(env);
			t.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			t.rollback();

		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return resultado;

	}

	public Pendiente Ver_detalles_pedido_pendiente(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPedidoPendiente(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarPedidoPendiente(Pendiente aPedidoPendiente) throws PersistentException {
		boolean resultado = false;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {

			
//			Pendiente pendiente = PendienteDAO.createPendiente();
//			//pendiente. =  aPedidoPendiente.tiene;
//			pendiente.setFechaPedido(aPedidoPendiente.getFechaPedido());
//			pendiente.setHoraPedido(aPedidoPendiente.getHoraPedido());
//			pendiente.setPagado(aPedidoPendiente.getPagado());
//			pendiente.setRealizado_por(aPedidoPendiente.getRealizado_por());
//			
			
			resultado = PendienteDAO.save(aPedidoPendiente);
			
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		TiendavirtualPersistentManager.instance().disposePersistentManager();

		return resultado;
	}

	public List<Pendiente> cargarPedidosPendientes(int id) throws PersistentException {
		List<Pendiente> pendientes = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			pendientes = PendienteDAO.queryPendiente("Pendiente.realizado_por='" + id +"'", null);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return pendientes;
	}
}