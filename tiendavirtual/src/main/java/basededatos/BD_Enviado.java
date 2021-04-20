package basededatos;

import java.util.Vector;
import basededatos.Enviado;

public class BD_Enviado {
	public BDPrincipal _bDPrincipal;
	public Vector<Enviado> _contiene_pedidos_enviados = new Vector<Enviado>();

	public Enviado[] cargarPedidosEnviados() {
		throw new UnsupportedOperationException();
	}

	public Enviado Ver_detalles_pedido_enviado(int aIdPedidoEnviado) {
		throw new UnsupportedOperationException();
	}

	public boolean guardarComoEnviado(Enviado aPedido) {
		throw new UnsupportedOperationException();
	}
}