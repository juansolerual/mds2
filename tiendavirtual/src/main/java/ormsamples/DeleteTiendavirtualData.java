/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteTiendavirtualData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = basededatos.TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.loadProductoByQuery(null, null);
			// Delete the persistent object
			basededatos.ProductoDAO.delete(lbasededatosProducto);
			basededatos.Categoria lbasededatosCategoria = basededatos.CategoriaDAO.loadCategoriaByQuery(null, null);
			// Delete the persistent object
			basededatos.CategoriaDAO.delete(lbasededatosCategoria);
			basededatos.Usuario lbasededatosUsuario = basededatos.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			basededatos.UsuarioDAO.delete(lbasededatosUsuario);
			basededatos.Encargado_compras lbasededatosEncargado_compras = basededatos.Encargado_comprasDAO.loadEncargado_comprasByQuery(null, null);
			// Delete the persistent object
			basededatos.Encargado_comprasDAO.delete(lbasededatosEncargado_compras);
			basededatos.Pedido lbasededatosPedido = basededatos.PedidoDAO.loadPedidoByQuery(null, null);
			// Delete the persistent object
			basededatos.PedidoDAO.delete(lbasededatosPedido);
			basededatos.Oferta lbasededatosOferta = basededatos.OfertaDAO.loadOfertaByQuery(null, null);
			// Delete the persistent object
			basededatos.OfertaDAO.delete(lbasededatosOferta);
			basededatos.Cliente lbasededatosCliente = basededatos.ClienteDAO.loadClienteByQuery(null, null);
			// Delete the persistent object
			basededatos.ClienteDAO.delete(lbasededatosCliente);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			basededatos.AdministradorDAO.delete(lbasededatosAdministrador);
			basededatos.Valoracion lbasededatosValoracion = basededatos.ValoracionDAO.loadValoracionByQuery(null, null);
			// Delete the persistent object
			basededatos.ValoracionDAO.delete(lbasededatosValoracion);
			basededatos.Anuncio lbasededatosAnuncio = basededatos.AnuncioDAO.loadAnuncioByQuery(null, null);
			// Delete the persistent object
			basededatos.AnuncioDAO.delete(lbasededatosAnuncio);
			basededatos.Lineas_de_Pedido lbasededatosLineas_de_Pedido = basededatos.Lineas_de_PedidoDAO.loadLineas_de_PedidoByQuery(null, null);
			// Delete the persistent object
			basededatos.Lineas_de_PedidoDAO.delete(lbasededatosLineas_de_Pedido);
			basededatos.Transportista lbasededatosTransportista = basededatos.TransportistaDAO.loadTransportistaByQuery(null, null);
			// Delete the persistent object
			basededatos.TransportistaDAO.delete(lbasededatosTransportista);
			basededatos.Mensaje lbasededatosMensaje = basededatos.MensajeDAO.loadMensajeByQuery(null, null);
			// Delete the persistent object
			basededatos.MensajeDAO.delete(lbasededatosMensaje);
			basededatos.Foto lbasededatosFoto = basededatos.FotoDAO.loadFotoByQuery(null, null);
			// Delete the persistent object
			basededatos.FotoDAO.delete(lbasededatosFoto);
			basededatos.Enviado lbasededatosEnviado = basededatos.EnviadoDAO.loadEnviadoByQuery(null, null);
			// Delete the persistent object
			basededatos.EnviadoDAO.delete(lbasededatosEnviado);
			basededatos.Pendiente lbasededatosPendiente = basededatos.PendienteDAO.loadPendienteByQuery(null, null);
			// Delete the persistent object
			basededatos.PendienteDAO.delete(lbasededatosPendiente);
			basededatos.Entregado lbasededatosEntregado = basededatos.EntregadoDAO.loadEntregadoByQuery(null, null);
			// Delete the persistent object
			basededatos.EntregadoDAO.delete(lbasededatosEntregado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTiendavirtualData deleteTiendavirtualData = new DeleteTiendavirtualData();
			try {
				deleteTiendavirtualData.deleteTestData();
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
