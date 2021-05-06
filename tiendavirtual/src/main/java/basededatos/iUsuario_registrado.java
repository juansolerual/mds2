package basededatos;

import java.util.List;

public interface iUsuario_registrado {

	public List<Producto> cargarProductos();

	public List<Categoria> cargarCategorias();

	public List<Oferta> cargarOfertas();

	public Anuncio[] cargarAnuncios();

	public Producto cargarProducto(int aIdProducto);

	public Oferta cargarOferta(int aIdOferta);

	public Categoria cargarCategoria(int aId);

	public Anuncio cargarAnuncio(int aIdAnuncio);

	public boolean guardarCambiosUsuario(Usuario aUsuario);

	public boolean darBajaUsuario(int aIdUsuario);

	public boolean cambiarContrasena(String aContrasenaNueva);

	public Mensaje[] cargarMensajesRecibidos(int aIdUsuario);

	public Mensaje[] cargarMensajesEnviados(int aIdUsuario);

	public boolean enviarMensaje(Mensaje aMensaje);

	public Mensaje abrirMensaje(int aIdMensaje);

	public List<Producto> cargarProductos(String string);
	
	public boolean realizarPedido(Pendiente aPedido);
	
	public List<List> cargarPedidos(int i);

	public List<Lineas_de_Pedido> cargarCarrito(int id);

}