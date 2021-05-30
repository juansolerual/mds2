package basededatos;

import java.util.List;

public interface iUsuario_no_identificado {

	public boolean loginUsuario(Usuario aUsuario);

	public boolean nuevo_usuario(Cliente cliente);

	public List<Lineas_de_Pedido> cargarCarrito(int numeroPedido);

	public boolean Eliminar_Producto_del_carrito(int aIdLineaDePedido);

	public boolean Modificar_cantidad_unidades(int aNumUnidades);

	public Anuncio cargarAnuncio(int aIdAnuncio);

	public Anuncio[] cargarAnuncios();

	public Categoria cargarCategoria(int aId);

	public List<Categoria> cargarCategorias();

	public Oferta cargarOferta(int aIdOferta);

	public List<Oferta> cargarOfertas();

	public Producto cargarProducto(int aIdProducto);

	public List<Producto> cargarProductos();
}