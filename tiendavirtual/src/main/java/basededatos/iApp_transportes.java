package basededatos;

import java.util.List;

public interface iApp_transportes {

	public List<Pendiente> cargarPedidosPendientes();

	public Pendiente cargarPedidoPendiente(int aIdPedidoPendiente);

	public List<Entregado> cargarPedidosEntregados();

	public Entregado cargarPedidoEntregado(int aIdPedidoEntregado);

	public boolean marcarComoEntregado(int aIdPedidoPendiente);

	public boolean desmarcarComoEntregado(int aIdPedido);

	public List<Lineas_de_Pedido> cargarCarrito(int id);

	public List<Enviado> cargarPedidosEnviados();
}