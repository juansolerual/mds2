package basededatos;

public interface iUsuario_registrado {

	public Producto[] cargarProductos();

	public Categoria[] cargarCategorias();

	public Oferta[] cargarOfertas();

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
}