/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListTiendavirtualData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Producto...");
		basededatos.Producto[] basededatosProductos = basededatos.ProductoDAO.listProductoByQuery(null, null);
		int length = Math.min(basededatosProductos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosProductos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Categoria...");
		basededatos.Categoria[] basededatosCategorias = basededatos.CategoriaDAO.listCategoriaByQuery(null, null);
		length = Math.min(basededatosCategorias.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosCategorias[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario...");
		basededatos.Usuario[] basededatosUsuarios = basededatos.UsuarioDAO.listUsuarioByQuery(null, null);
		length = Math.min(basededatosUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Encargado_compras...");
		basededatos.Encargado_compras[] basededatosEncargado_comprases = basededatos.Encargado_comprasDAO.listEncargado_comprasByQuery(null, null);
		length = Math.min(basededatosEncargado_comprases.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosEncargado_comprases[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido...");
		basededatos.Pedido[] basededatosPedidos = basededatos.PedidoDAO.listPedidoByQuery(null, null);
		length = Math.min(basededatosPedidos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPedidos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Oferta...");
		basededatos.Oferta[] basededatosOfertas = basededatos.OfertaDAO.listOfertaByQuery(null, null);
		length = Math.min(basededatosOfertas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosOfertas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Cliente...");
		basededatos.Cliente[] basededatosClientes = basededatos.ClienteDAO.listClienteByQuery(null, null);
		length = Math.min(basededatosClientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosClientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		basededatos.Administrador[] basededatosAdministradors = basededatos.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(basededatosAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Valoracion...");
		basededatos.Valoracion[] basededatosValoracions = basededatos.ValoracionDAO.listValoracionByQuery(null, null);
		length = Math.min(basededatosValoracions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosValoracions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Anuncio...");
		basededatos.Anuncio[] basededatosAnuncios = basededatos.AnuncioDAO.listAnuncioByQuery(null, null);
		length = Math.min(basededatosAnuncios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosAnuncios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Lineas_de_Pedido...");
		basededatos.Lineas_de_Pedido[] basededatosLineas_de_Pedidos = basededatos.Lineas_de_PedidoDAO.listLineas_de_PedidoByQuery(null, null);
		length = Math.min(basededatosLineas_de_Pedidos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosLineas_de_Pedidos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Transportista...");
		basededatos.Transportista[] basededatosTransportistas = basededatos.TransportistaDAO.listTransportistaByQuery(null, null);
		length = Math.min(basededatosTransportistas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosTransportistas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Mensaje...");
		basededatos.Mensaje[] basededatosMensajes = basededatos.MensajeDAO.listMensajeByQuery(null, null);
		length = Math.min(basededatosMensajes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosMensajes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Foto...");
		basededatos.Foto[] basededatosFotos = basededatos.FotoDAO.listFotoByQuery(null, null);
		length = Math.min(basededatosFotos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosFotos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Enviado...");
		basededatos.Enviado[] basededatosEnviados = basededatos.EnviadoDAO.listEnviadoByQuery(null, null);
		length = Math.min(basededatosEnviados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosEnviados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pendiente...");
		basededatos.Pendiente[] basededatosPendientes = basededatos.PendienteDAO.listPendienteByQuery(null, null);
		length = Math.min(basededatosPendientes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosPendientes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Entregado...");
		basededatos.Entregado[] basededatosEntregados = basededatos.EntregadoDAO.listEntregadoByQuery(null, null);
		length = Math.min(basededatosEntregados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(basededatosEntregados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Producto by Criteria...");
		basededatos.ProductoCriteria lbasededatosProductoCriteria = new basededatos.ProductoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosProductoCriteria.ID.eq();
		lbasededatosProductoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Producto[] basededatosProductos = lbasededatosProductoCriteria.listProducto();
		int length =basededatosProductos== null ? 0 : Math.min(basededatosProductos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosProductos[i]);
		}
		System.out.println(length + " Producto record(s) retrieved."); 
		
		System.out.println("Listing Categoria by Criteria...");
		basededatos.CategoriaCriteria lbasededatosCategoriaCriteria = new basededatos.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosCategoriaCriteria.ID.eq();
		lbasededatosCategoriaCriteria.setMaxResults(ROW_COUNT);
		basededatos.Categoria[] basededatosCategorias = lbasededatosCategoriaCriteria.listCategoria();
		length =basededatosCategorias== null ? 0 : Math.min(basededatosCategorias.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosCategorias[i]);
		}
		System.out.println(length + " Categoria record(s) retrieved."); 
		
		System.out.println("Listing Usuario by Criteria...");
		basededatos.UsuarioCriteria lbasededatosUsuarioCriteria = new basededatos.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosUsuarioCriteria.ID.eq();
		lbasededatosUsuarioCriteria.setMaxResults(ROW_COUNT);
		basededatos.Usuario[] basededatosUsuarios = lbasededatosUsuarioCriteria.listUsuario();
		length =basededatosUsuarios== null ? 0 : Math.min(basededatosUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Encargado_compras by Criteria...");
		basededatos.Encargado_comprasCriteria lbasededatosEncargado_comprasCriteria = new basededatos.Encargado_comprasCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosEncargado_comprasCriteria.ID.eq();
		lbasededatosEncargado_comprasCriteria.setMaxResults(ROW_COUNT);
		basededatos.Encargado_compras[] basededatosEncargado_comprases = lbasededatosEncargado_comprasCriteria.listEncargado_compras();
		length =basededatosEncargado_comprases== null ? 0 : Math.min(basededatosEncargado_comprases.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosEncargado_comprases[i]);
		}
		System.out.println(length + " Encargado_compras record(s) retrieved."); 
		
		System.out.println("Listing Pedido by Criteria...");
		basededatos.PedidoCriteria lbasededatosPedidoCriteria = new basededatos.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosPedidoCriteria.ID.eq();
		lbasededatosPedidoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Pedido[] basededatosPedidos = lbasededatosPedidoCriteria.listPedido();
		length =basededatosPedidos== null ? 0 : Math.min(basededatosPedidos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosPedidos[i]);
		}
		System.out.println(length + " Pedido record(s) retrieved."); 
		
		System.out.println("Listing Oferta by Criteria...");
		basededatos.OfertaCriteria lbasededatosOfertaCriteria = new basededatos.OfertaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosOfertaCriteria.ID.eq();
		lbasededatosOfertaCriteria.setMaxResults(ROW_COUNT);
		basededatos.Oferta[] basededatosOfertas = lbasededatosOfertaCriteria.listOferta();
		length =basededatosOfertas== null ? 0 : Math.min(basededatosOfertas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosOfertas[i]);
		}
		System.out.println(length + " Oferta record(s) retrieved."); 
		
		System.out.println("Listing Cliente by Criteria...");
		basededatos.ClienteCriteria lbasededatosClienteCriteria = new basededatos.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosClienteCriteria.ID.eq();
		lbasededatosClienteCriteria.setMaxResults(ROW_COUNT);
		basededatos.Cliente[] basededatosClientes = lbasededatosClienteCriteria.listCliente();
		length =basededatosClientes== null ? 0 : Math.min(basededatosClientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosClientes[i]);
		}
		System.out.println(length + " Cliente record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		basededatos.AdministradorCriteria lbasededatosAdministradorCriteria = new basededatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosAdministradorCriteria.ID.eq();
		lbasededatosAdministradorCriteria.setMaxResults(ROW_COUNT);
		basededatos.Administrador[] basededatosAdministradors = lbasededatosAdministradorCriteria.listAdministrador();
		length =basededatosAdministradors== null ? 0 : Math.min(basededatosAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Valoracion by Criteria...");
		basededatos.ValoracionCriteria lbasededatosValoracionCriteria = new basededatos.ValoracionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosValoracionCriteria.ID.eq();
		lbasededatosValoracionCriteria.setMaxResults(ROW_COUNT);
		basededatos.Valoracion[] basededatosValoracions = lbasededatosValoracionCriteria.listValoracion();
		length =basededatosValoracions== null ? 0 : Math.min(basededatosValoracions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosValoracions[i]);
		}
		System.out.println(length + " Valoracion record(s) retrieved."); 
		
		System.out.println("Listing Anuncio by Criteria...");
		basededatos.AnuncioCriteria lbasededatosAnuncioCriteria = new basededatos.AnuncioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosAnuncioCriteria.ID.eq();
		lbasededatosAnuncioCriteria.setMaxResults(ROW_COUNT);
		basededatos.Anuncio[] basededatosAnuncios = lbasededatosAnuncioCriteria.listAnuncio();
		length =basededatosAnuncios== null ? 0 : Math.min(basededatosAnuncios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosAnuncios[i]);
		}
		System.out.println(length + " Anuncio record(s) retrieved."); 
		
		System.out.println("Listing Lineas_de_Pedido by Criteria...");
		basededatos.Lineas_de_PedidoCriteria lbasededatosLineas_de_PedidoCriteria = new basededatos.Lineas_de_PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosLineas_de_PedidoCriteria.ID.eq();
		lbasededatosLineas_de_PedidoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Lineas_de_Pedido[] basededatosLineas_de_Pedidos = lbasededatosLineas_de_PedidoCriteria.listLineas_de_Pedido();
		length =basededatosLineas_de_Pedidos== null ? 0 : Math.min(basededatosLineas_de_Pedidos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosLineas_de_Pedidos[i]);
		}
		System.out.println(length + " Lineas_de_Pedido record(s) retrieved."); 
		
		System.out.println("Listing Transportista by Criteria...");
		basededatos.TransportistaCriteria lbasededatosTransportistaCriteria = new basededatos.TransportistaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosTransportistaCriteria.ID.eq();
		lbasededatosTransportistaCriteria.setMaxResults(ROW_COUNT);
		basededatos.Transportista[] basededatosTransportistas = lbasededatosTransportistaCriteria.listTransportista();
		length =basededatosTransportistas== null ? 0 : Math.min(basededatosTransportistas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosTransportistas[i]);
		}
		System.out.println(length + " Transportista record(s) retrieved."); 
		
		System.out.println("Listing Mensaje by Criteria...");
		basededatos.MensajeCriteria lbasededatosMensajeCriteria = new basededatos.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosMensajeCriteria.ID.eq();
		lbasededatosMensajeCriteria.setMaxResults(ROW_COUNT);
		basededatos.Mensaje[] basededatosMensajes = lbasededatosMensajeCriteria.listMensaje();
		length =basededatosMensajes== null ? 0 : Math.min(basededatosMensajes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosMensajes[i]);
		}
		System.out.println(length + " Mensaje record(s) retrieved."); 
		
		System.out.println("Listing Foto by Criteria...");
		basededatos.FotoCriteria lbasededatosFotoCriteria = new basededatos.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosFotoCriteria.ID.eq();
		lbasededatosFotoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Foto[] basededatosFotos = lbasededatosFotoCriteria.listFoto();
		length =basededatosFotos== null ? 0 : Math.min(basededatosFotos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosFotos[i]);
		}
		System.out.println(length + " Foto record(s) retrieved."); 
		
		System.out.println("Listing Enviado by Criteria...");
		basededatos.EnviadoCriteria lbasededatosEnviadoCriteria = new basededatos.EnviadoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosEnviadoCriteria.ID.eq();
		lbasededatosEnviadoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Enviado[] basededatosEnviados = lbasededatosEnviadoCriteria.listEnviado();
		length =basededatosEnviados== null ? 0 : Math.min(basededatosEnviados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosEnviados[i]);
		}
		System.out.println(length + " Enviado record(s) retrieved."); 
		
		System.out.println("Listing Pendiente by Criteria...");
		basededatos.PendienteCriteria lbasededatosPendienteCriteria = new basededatos.PendienteCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosPendienteCriteria.ID.eq();
		lbasededatosPendienteCriteria.setMaxResults(ROW_COUNT);
		basededatos.Pendiente[] basededatosPendientes = lbasededatosPendienteCriteria.listPendiente();
		length =basededatosPendientes== null ? 0 : Math.min(basededatosPendientes.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosPendientes[i]);
		}
		System.out.println(length + " Pendiente record(s) retrieved."); 
		
		System.out.println("Listing Entregado by Criteria...");
		basededatos.EntregadoCriteria lbasededatosEntregadoCriteria = new basededatos.EntregadoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lbasededatosEntregadoCriteria.ID.eq();
		lbasededatosEntregadoCriteria.setMaxResults(ROW_COUNT);
		basededatos.Entregado[] basededatosEntregados = lbasededatosEntregadoCriteria.listEntregado();
		length =basededatosEntregados== null ? 0 : Math.min(basededatosEntregados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(basededatosEntregados[i]);
		}
		System.out.println(length + " Entregado record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListTiendavirtualData listTiendavirtualData = new ListTiendavirtualData();
			try {
				listTiendavirtualData.listTestData();
				//listTiendavirtualData.listByCriteria();
			}
			finally {
				basededatos.TiendavirtualPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
