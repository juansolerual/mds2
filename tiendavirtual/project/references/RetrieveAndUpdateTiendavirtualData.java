/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTiendavirtualData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = basededatos.TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.loadProductoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.ProductoDAO.save(lbasededatosProducto);
			basededatos.Categoria lbasededatosCategoria = basededatos.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.CategoriaDAO.save(lbasededatosCategoria);
			basededatos.Usuario lbasededatosUsuario = basededatos.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.UsuarioDAO.save(lbasededatosUsuario);
			basededatos.Encargado_compras lbasededatosEncargado_compras = basededatos.Encargado_comprasDAO.loadEncargado_comprasByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.Encargado_comprasDAO.save(lbasededatosEncargado_compras);
			basededatos.Pedido lbasededatosPedido = basededatos.PedidoDAO.loadPedidoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.PedidoDAO.save(lbasededatosPedido);
			basededatos.Oferta lbasededatosOferta = basededatos.OfertaDAO.loadOfertaByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.OfertaDAO.save(lbasededatosOferta);
			basededatos.Cliente lbasededatosCliente = basededatos.ClienteDAO.loadClienteByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.ClienteDAO.save(lbasededatosCliente);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.AdministradorDAO.save(lbasededatosAdministrador);
			basededatos.Valoracion lbasededatosValoracion = basededatos.ValoracionDAO.loadValoracionByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.ValoracionDAO.save(lbasededatosValoracion);
			basededatos.Anuncio lbasededatosAnuncio = basededatos.AnuncioDAO.loadAnuncioByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.AnuncioDAO.save(lbasededatosAnuncio);
			basededatos.Lineas_de_Pedido lbasededatosLineas_de_Pedido = basededatos.Lineas_de_PedidoDAO.loadLineas_de_PedidoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.Lineas_de_PedidoDAO.save(lbasededatosLineas_de_Pedido);
			basededatos.Transportista lbasededatosTransportista = basededatos.TransportistaDAO.loadTransportistaByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.TransportistaDAO.save(lbasededatosTransportista);
			basededatos.Mensaje lbasededatosMensaje = basededatos.MensajeDAO.loadMensajeByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.MensajeDAO.save(lbasededatosMensaje);
			basededatos.Foto lbasededatosFoto = basededatos.FotoDAO.loadFotoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.FotoDAO.save(lbasededatosFoto);
			basededatos.Enviado lbasededatosEnviado = basededatos.EnviadoDAO.loadEnviadoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.EnviadoDAO.save(lbasededatosEnviado);
			basededatos.Pendiente lbasededatosPendiente = basededatos.PendienteDAO.loadPendienteByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.PendienteDAO.save(lbasededatosPendiente);
			basededatos.Entregado lbasededatosEntregado = basededatos.EntregadoDAO.loadEntregadoByQuery(null, null);
			// Update the properties of the persistent object
			basededatos.EntregadoDAO.save(lbasededatosEntregado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Producto by ProductoCriteria");
		basededatos.ProductoCriteria lbasededatosProductoCriteria = new basededatos.ProductoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosProductoCriteria.ID.eq();
		System.out.println(lbasededatosProductoCriteria.uniqueProducto());
		
		System.out.println("Retrieving Categoria by CategoriaCriteria");
		basededatos.CategoriaCriteria lbasededatosCategoriaCriteria = new basededatos.CategoriaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosCategoriaCriteria.ID.eq();
		System.out.println(lbasededatosCategoriaCriteria.uniqueCategoria());
		
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		basededatos.UsuarioCriteria lbasededatosUsuarioCriteria = new basededatos.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosUsuarioCriteria.ID.eq();
		System.out.println(lbasededatosUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Encargado_compras by Encargado_comprasCriteria");
		basededatos.Encargado_comprasCriteria lbasededatosEncargado_comprasCriteria = new basededatos.Encargado_comprasCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosEncargado_comprasCriteria.ID.eq();
		System.out.println(lbasededatosEncargado_comprasCriteria.uniqueEncargado_compras());
		
		System.out.println("Retrieving Pedido by PedidoCriteria");
		basededatos.PedidoCriteria lbasededatosPedidoCriteria = new basededatos.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosPedidoCriteria.ID.eq();
		System.out.println(lbasededatosPedidoCriteria.uniquePedido());
		
		System.out.println("Retrieving Oferta by OfertaCriteria");
		basededatos.OfertaCriteria lbasededatosOfertaCriteria = new basededatos.OfertaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosOfertaCriteria.ID.eq();
		System.out.println(lbasededatosOfertaCriteria.uniqueOferta());
		
		System.out.println("Retrieving Cliente by ClienteCriteria");
		basededatos.ClienteCriteria lbasededatosClienteCriteria = new basededatos.ClienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosClienteCriteria.ID.eq();
		System.out.println(lbasededatosClienteCriteria.uniqueCliente());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		basededatos.AdministradorCriteria lbasededatosAdministradorCriteria = new basededatos.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosAdministradorCriteria.ID.eq();
		System.out.println(lbasededatosAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Valoracion by ValoracionCriteria");
		basededatos.ValoracionCriteria lbasededatosValoracionCriteria = new basededatos.ValoracionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosValoracionCriteria.ID.eq();
		System.out.println(lbasededatosValoracionCriteria.uniqueValoracion());
		
		System.out.println("Retrieving Anuncio by AnuncioCriteria");
		basededatos.AnuncioCriteria lbasededatosAnuncioCriteria = new basededatos.AnuncioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosAnuncioCriteria.ID.eq();
		System.out.println(lbasededatosAnuncioCriteria.uniqueAnuncio());
		
		System.out.println("Retrieving Lineas_de_Pedido by Lineas_de_PedidoCriteria");
		basededatos.Lineas_de_PedidoCriteria lbasededatosLineas_de_PedidoCriteria = new basededatos.Lineas_de_PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosLineas_de_PedidoCriteria.ID.eq();
		System.out.println(lbasededatosLineas_de_PedidoCriteria.uniqueLineas_de_Pedido());
		
		System.out.println("Retrieving Transportista by TransportistaCriteria");
		basededatos.TransportistaCriteria lbasededatosTransportistaCriteria = new basededatos.TransportistaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosTransportistaCriteria.ID.eq();
		System.out.println(lbasededatosTransportistaCriteria.uniqueTransportista());
		
		System.out.println("Retrieving Mensaje by MensajeCriteria");
		basededatos.MensajeCriteria lbasededatosMensajeCriteria = new basededatos.MensajeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosMensajeCriteria.ID.eq();
		System.out.println(lbasededatosMensajeCriteria.uniqueMensaje());
		
		System.out.println("Retrieving Foto by FotoCriteria");
		basededatos.FotoCriteria lbasededatosFotoCriteria = new basededatos.FotoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosFotoCriteria.ID.eq();
		System.out.println(lbasededatosFotoCriteria.uniqueFoto());
		
		System.out.println("Retrieving Enviado by EnviadoCriteria");
		basededatos.EnviadoCriteria lbasededatosEnviadoCriteria = new basededatos.EnviadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosEnviadoCriteria.ID.eq();
		System.out.println(lbasededatosEnviadoCriteria.uniqueEnviado());
		
		System.out.println("Retrieving Pendiente by PendienteCriteria");
		basededatos.PendienteCriteria lbasededatosPendienteCriteria = new basededatos.PendienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosPendienteCriteria.ID.eq();
		System.out.println(lbasededatosPendienteCriteria.uniquePendiente());
		
		System.out.println("Retrieving Entregado by EntregadoCriteria");
		basededatos.EntregadoCriteria lbasededatosEntregadoCriteria = new basededatos.EntregadoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lbasededatosEntregadoCriteria.ID.eq();
		System.out.println(lbasededatosEntregadoCriteria.uniqueEntregado());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTiendavirtualData retrieveAndUpdateTiendavirtualData = new RetrieveAndUpdateTiendavirtualData();
			try {
				retrieveAndUpdateTiendavirtualData.retrieveAndUpdateTestData();
				//retrieveAndUpdateTiendavirtualData.retrieveByCriteria();
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
