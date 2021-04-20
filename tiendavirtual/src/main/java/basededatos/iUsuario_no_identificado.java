package basededatos;

public interface iUsuario_no_identificado {

	public boolean loginUsuario(Usuario aUsuario);

	public boolean nuevo_usuario();

	public Lineas_de_Pedido[] cargarCarrito();

	public boolean Eliminar_Producto_del_carrito(int aIdLineaDePedido);

	public boolean Modificar_cantidad_unidades(int aNumUnidades);

	public Anuncio cargarAnuncio(int aIdAnuncio);

	public Anuncio[] cargarAnuncios();

	public Categoria cargarCategoria(int aId);

	public Categoria[] cargarCategorias();

	public Oferta cargarOferta(int aIdOferta);

	public Oferta[] cargarOfertas();

	public Producto cargarProducto(int aIdProducto);

	public Producto[] cargarProductos();
}