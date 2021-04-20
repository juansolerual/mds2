package basededatos;

import java.util.Vector;
import basededatos.Entregado;

public class BD_Entregado {
	public BDPrincipal _bDPrincipal;
	public Vector<Entregado> _contiene_pedidos = new Vector<Entregado>();

	public Entregado[] cargarPedidosEntregados() {
		throw new UnsupportedOperationException();
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
}