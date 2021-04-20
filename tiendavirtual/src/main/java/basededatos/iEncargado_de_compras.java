package basededatos;

public interface iEncargado_de_compras {

	public Pedido[] cargarPedidos();

	public boolean Marcar_como_enviado(int aIdPedido);

	public Pendiente Ver_detalles_pedido_pendiente(int aIdPedidoPendiente);

	public Enviado Ver_detalles_pedido_enviado(int aIdPedidoEnviado);

	public Entregado Ver_detalles_pedido_entregado(int aIdPedidoEntregado);
}