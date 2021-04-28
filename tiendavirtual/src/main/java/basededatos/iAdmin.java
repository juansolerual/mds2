package basededatos;

import java.util.List;

public interface iAdmin {

	public List<Categoria> cargarCategorias();

	public Categoria cargarCategoria(int aId);

	public boolean eliminarCategoria(int aId);

	public Producto[] verProductosCategoria(int aIdCategoria);

	public Mensaje[] cargarMensajesEnviados(int aIdUsuario);

	public Mensaje[] cargarMensajesRecibidos(int aIdUsuario);

	public boolean enviarMensaje(Mensaje aMensaje);

	public Mensaje abrirMensaje(int aIdMensaje);

	public Administrador[] cargarAdministradores();

	public boolean eliminarAdministrador(int aIdAdministrador);

	public Administrador cargarAdministrador(int aIdAdministrador);

	public boolean crearAdministrador(Administrador aAdministrador);

	public List<Oferta> cargarOfertas();

	public Oferta cargarOferta(int aIdOferta);

	public boolean eliminarOferta(int aIdOferta);

	public int guardarOferta(Oferta aOferta);

	public List<Producto> cargarProductos();

	public Producto cargarProducto(int aIdProducto);

	public boolean eliminarProducto(int aIdProducto);

	public Anuncio[] cargarAnuncios();

	public Anuncio cargarAnuncio(int aIdAnuncio);

	public int guardarProducto(Producto aProducto);

	public int guardarCategoria(Categoria aCategoria);

	public Transportista[] cargarTransportistas();

	public boolean eliminarTransportista(int aIdTransportista);

	public boolean eliminarEncargadoCompras(int aIdEncargado);

	public Transportista cargarTransportista(int aIdTransportista);

	public Encargado_compras cargarEncargadoCompras(int aIdEncargado);

	public Encargado_compras[] cargarEncargadosCompras();

	public boolean crearTransportista(Transportista aTransportista);

	public boolean crearEncargadoCompras(Encargado_compras aEncargadoCompras);
}