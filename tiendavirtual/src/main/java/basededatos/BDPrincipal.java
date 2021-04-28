package basededatos;

import interfaz.Usuario_no_identificado;
import interfaz.Usuario_registrado;
import interfaz.Encargado_de_compras;
import interfaz.App_transportes;

import java.util.List;

import org.orm.PersistentException;

import interfaz.Admin;

public class BDPrincipal implements iUsuario_no_identificado, iUsuario_registrado, iEncargado_de_compras, iApp_transportes, iAdmin {
	public BD_Valoracion _bD_Valoracion = new BD_Valoracion();
	public BD_Anuncio _bD_Anuncio = new BD_Anuncio();
	public BD_LineaDePedido _bD_LineaDePedido = new BD_LineaDePedido();
	public BD_Producto _bD_Producto = new BD_Producto();
	public BD_Categoria _bD_Categoria = new BD_Categoria();
	public BD_Enviado _bD_Enviado = new BD_Enviado();
	public BD_Pendiente _bD_Pendiente = new BD_Pendiente();
	public BD_Entregado _bD_Entregado = new BD_Entregado();
	public BD_Oferta _bD_Oferta = new BD_Oferta();
	public BD_Transportista _bD_Transportista = new BD_Transportista();
	public BD_Cliente _bD_Cliente = new BD_Cliente();
	public BD_Administrador _bD_Administrador = new BD_Administrador();
	public BD_EncargadoCompras _bD_EncargadoCompras = new BD_EncargadoCompras();
	public BD_Mensaje _bD_Mensaje = new BD_Mensaje();


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
		Usuario usuario = UsuarioDAO.createUsuario();
		usuario.setNombre("prueba");
		try {
			return _bD_Cliente.nuevo_usuario(usuario);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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

	public List<Categoria> cargarCategorias() {
		List<Categoria> cls = null;
		try {
			cls = _bD_Categoria.cargarCategorias();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
		}

	public Oferta cargarOferta(int aIdOferta) {
		throw new UnsupportedOperationException();
	}

	public List<Oferta> cargarOfertas() {
		List<Oferta> cls = null;
		try {
			cls = _bD_Oferta.cargarOfertas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}
	

	public Producto cargarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public List<Producto> cargarProductos() {
		List<Producto> cls = null;
		try {
			cls = _bD_Producto.cargarProductos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
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
		int Id_oferta = -1;
		Oferta temp = null;
		try {
			temp = OfertaDAO.loadOfertaByQuery("Oferta.nombreOferta='"+aOferta.getNombreOferta()+"'", null);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (temp != null) {
			return -1;
		}
		try {
			Id_oferta = _bD_Oferta.guardarOferta(aOferta);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Id_oferta;
	}

	public boolean eliminarProducto(int aIdProducto) {
		throw new UnsupportedOperationException();
	}

	public int guardarProducto(Producto aProducto) {
		int Id_producto = -1;
		try {
			Id_producto = _bD_Producto.guardarProducto(aProducto);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Id_producto;
	}

	public int guardarCategoria(Categoria aCategoria) {
		int Id_categoria = -1;
		Categoria temp = null;
		try {
			temp = CategoriaDAO.loadCategoriaByQuery("Categoria.nombreCategoria='"+aCategoria.getNombreCategoria()+"'", null);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (temp != null) {
			return -1;
		}
		try {
			Id_categoria = _bD_Categoria.guardarCategoria(aCategoria);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Id_categoria;
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
	
	public List<Producto> cargarProductos(String string){
		List<Producto> cls = null;
		try {
			cls = _bD_Producto.cargarProductos(string);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}

}