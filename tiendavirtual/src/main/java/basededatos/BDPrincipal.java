package basededatos;

import interfaz.Usuario_no_identificado;
import interfaz.Usuario_registrado;
import interfaz.Encargado_de_compras;
import interfaz.App_transportes;

import org.orm.PersistentException;

import interfaz.Admin;

public class BDPrincipal implements iUsuario_no_identificado, iUsuario_registrado, iEncargado_de_compras, iApp_transportes, iAdmin {
	public BD_Foto _bD_Foto;
	public BD_Valoracion _bD_Valoracion;
	public BD_Anuncio _bD_Anuncio;
	public BD_LineaDePedido _bD_LineaDePedido;
	public BD_Producto _bD_Producto;
	public BD_Categoria _bD_Categoria;
	public BD_Enviado _bD_Enviado;
	public BD_Pendiente _bD_Pendiente;
	public BD_Entregado _bD_Entregado;
	public BD_Oferta _bD_Oferta;
	public BD_Transportista _bD_Transportista;
	public BD_Cliente _bD_Cliente = new BD_Cliente();
	public BD_Administrador _bD_Administrador;
	public BD_EncargadoCompras _bD_EncargadoCompras;
	public BD_Mensaje _bD_Mensaje;

	public Usuario_no_identificado get_Usuario_no_identificado() {
		throw new UnsupportedOperationException();
	}

	public Usuario_registrado get_Usuario_registrado() {
		throw new UnsupportedOperationException();
	}

	public Encargado_de_compras get_Encargado_de_compras() {
		throw new UnsupportedOperationException();
	}

	public App_transportes get_App_transportes() {
		throw new UnsupportedOperationException();
	}

	public Admin get_Admin() {
		throw new UnsupportedOperationException();
	}

	public boolean loginUsuario(Usuario aUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean nuevo_usuario() {
		boolean result = false;
		try {
			Usuario usuario = UsuarioDAO.createUsuario();
			usuario.setNombre("Prueba");
			
			result = _bD_Cliente.nuevo_usuario(usuario);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Lineas_de_Pedido[] cargarCarrito() {
		throw new UnsupportedOperationException();
	}

	public boolean Eliminar_Producto_del_carrito(int aIdLineaDePedido) {
		throw new UnsupportedOperationException();
	}

	public boolean Modificar_cantidad_unidades(int aNumUnidades) {
		throw new UnsupportedOperationException();
	}

	public Anuncio cargarAnuncio(int aIdAnuncio) {
		throw new UnsupportedOperationException();
	}

	public Anuncio[] cargarAnuncios() {
		throw new UnsupportedOperationException();
	}

	public Categoria cargarCategoria(int aId) {
		throw new UnsupportedOperationException();
	}

	public Categoria[] cargarCategorias() {
		throw new UnsupportedOperationException();
	}

	public Oferta cargarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public Oferta[] cargarOfertas() {
		throw new UnsupportedOperationException();
	}

	public Producto cargarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public Producto[] cargarProductos() {
		throw new UnsupportedOperationException();
	}

	public boolean guardarCambiosUsuario(Usuario aUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean darBajaUsuario(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean cambiarContrasena(String aContrasenaNueva) {
		throw new UnsupportedOperationException();
	}

	public Mensaje[] cargarMensajesRecibidos(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public Mensaje[] cargarMensajesEnviados(int aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public boolean enviarMensaje(Mensaje aMensaje) {
		throw new UnsupportedOperationException();
	}

	public Mensaje abrirMensaje(int aIdMensaje) {
		throw new UnsupportedOperationException();
	}

	public Pedido[] cargarPedidos() {
		throw new UnsupportedOperationException();
	}

	public boolean Marcar_como_enviado(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public Pendiente Ver_detalles_pedido_pendiente(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public Enviado Ver_detalles_pedido_enviado(int aIdPedidoEnviado) {
		throw new UnsupportedOperationException();
	}

	public Entregado Ver_detalles_pedido_entregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public Pendiente[] cargarPedidosPendientes() {
		throw new UnsupportedOperationException();
	}

	public Pendiente cargarPedidoPendiente(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public Entregado[] cargarPedidosEntregados() {
		throw new UnsupportedOperationException();
	}

	public Entregado cargarPedidoEntregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean marcarComoEntregado(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public boolean desmarcarComoEntregado(int aIdPedido) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarCategoria(int aId) {
		throw new UnsupportedOperationException();
	}

	public Producto[] verProductosCategoria(int aIdCategoria) {
		throw new UnsupportedOperationException();
	}

	public Administrador[] cargarAdministradores() {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarAdministrador(int aIdAdministrador) {
		throw new UnsupportedOperationException();
	}

	public Administrador cargarAdministrador(int aIdAdministrador) {
		throw new UnsupportedOperationException();
	}

	public boolean crearAdministrador(Administrador aAdministrador) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public int guardarOferta(Oferta aOferta) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public int guardarProducto(Producto aProducto) {
		throw new UnsupportedOperationException();
	}

	public int guardarCategoria(Categoria aCategoria) {
		throw new UnsupportedOperationException();
	}

	public Transportista[] cargarTransportistas() {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarTransportista(int aIdTransportista) {
		throw new UnsupportedOperationException();
	}

	public boolean eliminarEncargadoCompras(int aIdEncargado) {
		throw new UnsupportedOperationException();
	}

	public Transportista cargarTransportista(int aIdTransportista) {
		throw new UnsupportedOperationException();
	}

	public Encargado_compras cargarEncargadoCompras(int aIdEncargado) {
		throw new UnsupportedOperationException();
	}

	public Encargado_compras[] cargarEncargadosCompras() {
		throw new UnsupportedOperationException();
	}

	public boolean crearTransportista(Transportista aTransportista) {
		throw new UnsupportedOperationException();
	}

	public boolean crearEncargadoCompras(Encargado_compras aEncargadoCompras) {
		throw new UnsupportedOperationException();
	}
}