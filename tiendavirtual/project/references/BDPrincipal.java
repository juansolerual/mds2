package basededatos;

import interfaz.Usuario_no_identificado;
import interfaz.Usuario_registrado;
import interfaz.Encargado_de_compras;
import interfaz.App_transportes;

import java.util.ArrayList;
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
	public BD_Foto _bD_Foto = new BD_Foto();


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

	public boolean nuevo_usuario(Cliente cliente) {
		boolean resultado = false;
		try {
			return _bD_Cliente.nuevo_usuario(cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public List<Lineas_de_Pedido> cargarCarrito(int numeroPedido) {
		List<Lineas_de_Pedido> cls = null;
		try {
			cls = _bD_LineaDePedido.cargarCarrito(numeroPedido);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
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
	

	public Producto cargarProducto(int idProducto) {
		Producto producto = null;
		try {
			producto = _bD_Producto.cargarProducto(idProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;	
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

	public boolean guardarCambiosUsuario(Cliente aUsuario) {
		System.out.println("BDPRINCIPAL guardarCambiosUsuario");
		boolean resultado = false;
		try {
			return _bD_Cliente.guardarCambiosUsuario(aUsuario);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
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

	public List<List> cargarPedidos(int id) {
		List<List> listas = new ArrayList<List>();
		List<basededatos.Pedido> pedidos = null;
		List<basededatos.Entregado> entregados = null;
		List<basededatos.Pendiente> pendientes = null;
		List<basededatos.Enviado> enviados = null;

		try {
			
			pendientes = _bD_Pendiente.cargarPedidosPendientes(id);
			entregados = _bD_Entregado.cargarPedidosEntregados(id);
			enviados =_bD_Enviado.cargarPedidosEnviados(id);
			listas.add(enviados);
			listas.add(pendientes);
			listas.add(entregados);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listas;	
	}

	public boolean Marcar_como_enviado(int aIdPedido) {
		System.out.println("BDPRINCIPAL marcar como enviado");

		boolean resultado = false;
		

		try {
			
			resultado = _bD_Pendiente.Marcar_como_enviado(aIdPedido);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	
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

	public List<Pendiente> cargarPedidosPendientes() {
		
		List<basededatos.Pendiente> pendientes = null;
		

		try {
			
			pendientes = _bD_Pendiente.cargarPedidosPendientes();
			
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pendientes;	
	}

	public Pendiente cargarPedidoPendiente(int aIdPedidoPendiente) {
		throw new UnsupportedOperationException();
	}

	public List<Entregado> cargarPedidosEntregados() {
		List<basededatos.Entregado> entregados = null;
		try {
			entregados = _bD_Entregado.cargarPedidosEntregados();
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return entregados;	
	}

	public Entregado cargarPedidoEntregado(int aIdPedidoEntregado) {
		throw new UnsupportedOperationException();
	}

	public boolean marcarComoEntregado(int idPedidoEnviado) {
		System.out.println("BDPRINCIPAL marcar como entregado");

		boolean resultado = false;
		

		try {
			
			resultado = _bD_Enviado.Marcar_como_entregado(idPedidoEnviado);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	
	}

	public boolean desmarcarComoEntregado(int aIdPedido) {
		System.out.println("BDPRINCIPAL desmarcar como entregado");

		boolean resultado = false;
		

		try {
			
			resultado = _bD_Entregado.desmarcar_como_entregado(aIdPedido);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	
	}

	public boolean eliminarCategoria(int aId) {
		System.out.println("BDPRINCIPAL eliminarCategoria");
		boolean resultado = false;
		try {
			resultado = _bD_Categoria.eliminarCategoria(aId);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public Producto[] verProductosCategoria(int aIdCategoria) {
		throw new UnsupportedOperationException();
	}

	public List<Administrador> cargarAdministradores() {
		List<Administrador> cls = null;
		try {
			cls = _bD_Administrador.cargarAdministradores();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}

	public boolean eliminarAdministrador(int aIdAdministrador) {
		System.out.println("BDPRINCIPAL eliminarAdministrador");
		boolean resultado = false;
		try {
			resultado = _bD_Administrador.eliminarAdministrador(aIdAdministrador);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	}

	public Administrador cargarAdministrador(int aIdAdministrador) {
		Administrador administrador = null;
		try {
			administrador = _bD_Administrador.cargarAdministrador(aIdAdministrador);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return administrador;	
	}

	public boolean crearAdministrador(Administrador aAdministrador) {
		boolean resultado = false;
		try {
			return _bD_Administrador.crearAdministrador(aAdministrador);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
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

	public List<Transportista> cargarTransportistas() {
		List<Transportista> cls = null;
		try {
			cls = _bD_Transportista.cargarTransportistas();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}

	public boolean eliminarTransportista(int aIdTransportista) {
		System.out.println("BDPRINCIPAL eliminarTransportista");
		boolean resultado = false;
		try {
			resultado = _bD_Transportista.eliminarTransportista(aIdTransportista);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	}

	public boolean eliminarEncargadoCompras(int aIdEncargado) {
		System.out.println("BDPRINCIPAL eliminarEncargadoCompras");
		boolean resultado = false;
		try {
			resultado = _bD_EncargadoCompras.eliminarEncargadoCompras(aIdEncargado);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public Transportista cargarTransportista(int aIdTransportista) {
		Transportista transportista = null;
		try {
			transportista = _bD_Transportista.cargarTransportista(aIdTransportista);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transportista;	
	}

	public Encargado_compras cargarEncargadoCompras(int aIdEncargado) {
		Encargado_compras encargado_compras = null;
		try {
			encargado_compras = _bD_EncargadoCompras.cargarEncargadoCompras(aIdEncargado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encargado_compras;	
	}

	public List<Encargado_compras> cargarEncargadosCompras() {
		List<Encargado_compras> cls = null;
		try {
			cls = _bD_EncargadoCompras.cargarEncargadoCompras();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}

	public boolean crearTransportista(Transportista aTransportista) {
		boolean resultado = false;
		try {
			return _bD_Transportista.crearTransportista(aTransportista);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean crearEncargadoCompras(Encargado_compras aEncargadoCompras) {
		boolean resultado = false;
		try {
			return _bD_EncargadoCompras.crearEncargadoCompras(aEncargadoCompras);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
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

	@Override
	public int editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		int resultado = -1;
		try {
			resultado = _bD_Producto.editarProducto(producto);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public int guardarFoto(Foto foto1) {
		System.out.println("BDPRINCIPAL guardarFoto");
		int resultado = -1;
		try {
			resultado = _bD_Foto.guardarFoto(foto1);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public int editarFoto(Foto fotobis) {
		System.out.println("BDPRINCIPAL editarFoto");
		int resultado = -1;
		try {
			resultado = _bD_Foto.editarFoto(fotobis);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean eliminarFoto(Foto foto) {
		System.out.println("BDPRINCIPAL eliminarFoto");
		boolean resultado = false;
		try {
			resultado = _bD_Foto.eliminarFoto(foto);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public List<Foto> cargarFotos(int idProducto) {
		List<Foto> fotos = null;
		try {
			fotos = _bD_Foto.cargarFotos(idProducto);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fotos;	
	}

	@Override
	public List<Cliente> cargarClientes() {
		List<Cliente> cls = null;
		try {
			cls = _bD_Cliente.cargarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cls;	
	}

	@Override
	public boolean realizarPedido(Pendiente aPedido) {
		System.out.println("BDPRINCIPAL realizarPedido");
		boolean resultado = false;
		try {
			resultado = _bD_Pendiente.guardarPedidoPendiente(aPedido);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Cliente cargarCliente(int idUsuario) {
		System.out.println("BDPRINCIPAL cargarCliente");

		Cliente cliente = null;
		try {
			cliente = _bD_Cliente.cargarCliente(idUsuario);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;	
	}

	@Override
	public List<Enviado> cargarPedidosEnviados() {
		
		List<basededatos.Enviado> enviados = null;

		try {
			
			
			enviados =_bD_Enviado.cargarPedidosEnviados();
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enviados;	
	}

	@Override
	public boolean eliminarCliente(int id) {
		System.out.println("BDPRINCIPAL eliminarAdministrador");
		boolean resultado = false;
		try {
			resultado = _bD_Administrador.eliminarCliente(id);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;	
	}

	

	

}