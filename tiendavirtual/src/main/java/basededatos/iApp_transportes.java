package basededatos;

public interface iApp_transportes {

	public Pendiente[] cargarPedidosPendientes();

	public Pendiente cargarPedidoPendiente(int aIdPedidoPendiente);

	public Entregado[] cargarPedidosEntregados();

	public Entregado cargarPedidoEntregado(int aIdPedidoEntregado);

	public boolean marcarComoEntregado(int aIdPedidoPendiente);

	public boolean desmarcarComoEntregado(int aIdPedido);
}