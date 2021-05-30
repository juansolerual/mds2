/**
 * Licensee: juansoler1(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTiendavirtualData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = basededatos.TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {
			basededatos.Producto lbasededatosProducto = basededatos.ProductoDAO.createProducto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : asignado_a, recibe_valoracion, tieneFoto, limiteFotos, precio, pertenece_a, aplica_oferta
			basededatos.ProductoDAO.save(lbasededatosProducto);
			basededatos.Categoria lbasededatosCategoria = basededatos.CategoriaDAO.createCategoria();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contiene
			basededatos.CategoriaDAO.save(lbasededatosCategoria);
			basededatos.Usuario lbasededatosUsuario = basededatos.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : gestiona
			basededatos.UsuarioDAO.save(lbasededatosUsuario);
			basededatos.Encargado_compras lbasededatosEncargado_compras = basededatos.Encargado_comprasDAO.createEncargado_compras();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : crea, marca_como_enviado
			basededatos.Encargado_comprasDAO.save(lbasededatosEncargado_compras);
			basededatos.Pedido lbasededatosPedido = basededatos.PedidoDAO.createPedido();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : tiene, pagado, marcado_por, realizado_por
			basededatos.PedidoDAO.save(lbasededatosPedido);
			basededatos.Oferta lbasededatosOferta = basededatos.OfertaDAO.createOferta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contiene, porcentajeOferta, activada, precioOferta
			basededatos.OfertaDAO.save(lbasededatosOferta);
			basededatos.Cliente lbasededatosCliente = basededatos.ClienteDAO.createCliente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : realiza_pedido, realiza
			basededatos.ClienteDAO.save(lbasededatosCliente);
			basededatos.Administrador lbasededatosAdministrador = basededatos.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			basededatos.AdministradorDAO.save(lbasededatosAdministrador);
			basededatos.Valoracion lbasededatosValoracion = basededatos.ValoracionDAO.createValoracion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : valoracion, producto_valorado, valorado_por
			basededatos.ValoracionDAO.save(lbasededatosValoracion);
			basededatos.Anuncio lbasededatosAnuncio = basededatos.AnuncioDAO.createAnuncio();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : creadoPor
			basededatos.AnuncioDAO.save(lbasededatosAnuncio);
			basededatos.Lineas_de_Pedido lbasededatosLineas_de_Pedido = basededatos.Lineas_de_PedidoDAO.createLineas_de_Pedido();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : cantidad, pertenecen_a, de_un
			basededatos.Lineas_de_PedidoDAO.save(lbasededatosLineas_de_Pedido);
			basededatos.Transportista lbasededatosTransportista = basededatos.TransportistaDAO.createTransportista();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : marca_como_entregado
			basededatos.TransportistaDAO.save(lbasededatosTransportista);
			basededatos.Mensaje lbasededatosMensaje = basededatos.MensajeDAO.createMensaje();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : respuesta, pertenece_a, original
			basededatos.MensajeDAO.save(lbasededatosMensaje);
			basededatos.Foto lbasededatosFoto = basededatos.FotoDAO.createFoto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : isPrincipal, pertenece_a
			basededatos.FotoDAO.save(lbasededatosFoto);
			basededatos.Enviado lbasededatosEnviado = basededatos.EnviadoDAO.createEnviado();
			// Initialize the properties of the persistent object here
			basededatos.EnviadoDAO.save(lbasededatosEnviado);
			basededatos.Pendiente lbasededatosPendiente = basededatos.PendienteDAO.createPendiente();
			// Initialize the properties of the persistent object here
			basededatos.PendienteDAO.save(lbasededatosPendiente);
			basededatos.Entregado lbasededatosEntregado = basededatos.EntregadoDAO.createEntregado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : gestionado_por
			basededatos.EntregadoDAO.save(lbasededatosEntregado);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTiendavirtualData createTiendavirtualData = new CreateTiendavirtualData();
			try {
				createTiendavirtualData.createTestData();
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
