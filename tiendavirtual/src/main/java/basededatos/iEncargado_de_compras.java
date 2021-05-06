package basededatos;

import java.util.List;

public interface iEncargado_de_compras {


	public boolean Marcar_como_enviado(int aIdPedido);

	public Pendiente Ver_detalles_pedido_pendiente(int aIdPedidoPendiente);

	public Enviado Ver_detalles_pedido_enviado(int aIdPedidoEnviado);

	public Entregado Ver_detalles_pedido_entregado(int aIdPedidoEntregado);

	public List<Pendiente> cargarPedidosPendientes();

	public List<Entregado> cargarPedidosEntregados();

	public List<Enviado> cargarPedidosEnviados();

	public List<Lineas_de_Pedido> cargarCarrito(int i);
}