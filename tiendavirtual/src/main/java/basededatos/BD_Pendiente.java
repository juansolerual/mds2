package basededatos;

import java.util.Vector;
import basededatos.Pendiente;

public class BD_Pendiente {
	public BDPrincipal _bDPrincipal;
	public Vector<Pendiente> _contiene_pedidos_pendientes = new Vector<Pendiente>();

	public Pendiente[] cargarPedidosPendientes() {
		throw new UnsupportedOperationException();
	}

	public boolean Marcar_como_enviado(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public Pendiente Ver_detalles_pedido_pendiente(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarPedidoPendiente(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarPedidoPendiente(Pendiente aPedidoPendiente) {
		throw new UnsupportedOperationException();
	}
}