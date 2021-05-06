package basededatos;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Enviado;
import tiendavirtual.cookiesHelper;

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

	public boolean Marcar_como_entregado(int idPedidoEnviado) throws PersistentException {
		boolean resultado = false;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			
			
			
			Enviado env = EnviadoDAO.getEnviadoByORMID(idPedidoEnviado);
			System.out.println("Enviado cargado " + env.getHoraPedido());
			Entregado entregado = EntregadoDAO.createEntregado();
			
			entregado.setFechaPedido(env.getFechaPedido());
			entregado.setHoraPedido(env.getHoraPedido());
			entregado.setMarcado_por(env.getMarcado_por());
			entregado.setPagado(env.getPagado());
			entregado.setRealizado_por(env.getRealizado_por());
			System.out.println("Transportista es" + cookiesHelper.getTransportista().getNombre() );
			entregado.setGestionado_por(cookiesHelper.getTransportista());
			//pend.tiene.clear();
			List<Lineas_de_Pedido> carrito = Lineas_de_PedidoDAO.queryLineas_de_Pedido("Lineas_de_Pedido.pertenecen_a='" + env.getID()+"'", null);
			for (Lineas_de_Pedido ldp : carrito) {
				ldp.setPertenecen_a(entregado);
			}
			
			env.setMarcado_por(null);
			env.setRealizado_por(null);
			EnviadoDAO.delete(env);
			
			resultado = EntregadoDAO.save(entregado);
			t.commit();

		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return resultado;
	}

	public List<Enviado> cargarPedidosEnviados(int id) throws PersistentException {
		List<Enviado> enviados = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			enviados = EnviadoDAO.queryEnviado("Enviado.realizado_por='" + id +"'", null);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return enviados;
	}
}