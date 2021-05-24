package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Entregado;
import tiendavirtual.cookiesHelper;

public class BD_Entregado {
	public BDPrincipal _bDPrincipal;
	public Vector<Entregado> _contiene_pedidos = new Vector<Entregado>();

	public List<Entregado> cargarPedidosEntregados() throws PersistentException {
		List<Entregado> entregados = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			entregados = EntregadoDAO.queryEntregado(null, null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return entregados;
	}

	public Entregado Ver_detalles_pedido_entregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarPedidoEntregado(Entregado aPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPedidoEntregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public List<Entregado> cargarPedidosEntregados(int id) throws PersistentException {
		List<Entregado> entregados = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			entregados = EntregadoDAO.queryEntregado("Entregado.realizado_por='" + id +"'", null);

			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return entregados;
	}

	public boolean desmarcar_como_entregado(int aIdPedido) throws PersistentException {
		boolean resultado = false;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			
			
			
			Entregado ent = EntregadoDAO.getEntregadoByORMID(aIdPedido);
			System.out.println("Entregado cargado " + ent.getHoraPedido());
			Enviado enviado = EnviadoDAO.createEnviado();
			
			enviado.setFechaPedido(ent.getFechaPedido());
			enviado.setHoraPedido(ent.getHoraPedido());
			enviado.setMarcado_por(ent.getMarcado_por());
			enviado.setPagado(ent.getPagado());
			enviado.setRealizado_por(ent.getRealizado_por());
			
			System.out.println("Transportista es " + cookiesHelper.getTransportista().getNombre() );
			
			enviado.setMarcado_por(Encargado_comprasDAO.getEncargado_comprasByORMID(3));
			//pend.tiene.clear();
			List<Lineas_de_Pedido> carrito = Lineas_de_PedidoDAO.queryLineas_de_Pedido("Lineas_de_Pedido.pertenecen_a='" + ent.getID()+"'", null);
			for (Lineas_de_Pedido ldp : carrito) {
				ldp.setPertenecen_a(enviado);
				System.out.println("linea de pedido " + ldp.getDe_un().getNombreProducto());
			}
			ent.setGestionado_por(null);
			ent.setMarcado_por(null);
			ent.setRealizado_por(null);
			
			System.out.println(EntregadoDAO.delete(ent));
			
			resultado = EnviadoDAO.save(enviado);
			t.commit();

		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		}
		TiendavirtualPersistentManager.instance().disposePersistentManager();
		return resultado;
	}
}