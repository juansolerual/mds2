package basededatos;

import java.util.List;
import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import basededatos.Foto;

public class BD_Foto {
	public BDPrincipal _bDPrincipal;
	public Vector<Foto> _contiene_fotos = new Vector<Foto>();
	
	public int guardarFoto(Foto foto1) throws PersistentException {
		int idFoto = -1;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {

			
			Foto foto = FotoDAO.createFoto();
			foto.setURLFoto(foto1.getURLFoto());
			foto.setPertenece_a(foto1.getPertenece_a());
			foto.setIsPrincipal(foto1.getIsPrincipal());
			
			
			FotoDAO.save(foto);
			idFoto = foto.getID();
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return idFoto;
	}

	public int editarFoto(Foto fotobis) throws PersistentException {
		// TODO Auto-generated method stub
				int resultado = -1;
				PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
				//ProductoDAO.delete(producto);
				try {
//					Producto prod = ProductoDAO.createProducto();
//					prod.setCaracteristicas(producto.getCaracteristicas());
//					prod.setDescripcion(producto.getDescripcion());
//					prod.setPrecio(producto.getPrecio());
//					prod.setNombreProducto(producto.getNombreProducto());
//					prod.setPertenece_a(producto.getPertenece_a());
//					prod.setAplica_oferta(producto.getAplica_oferta());
					FotoDAO.save(fotobis);
					resultado = fotobis.getORMID();
					t.commit();
				} catch (Exception e) {
					t.rollback();
				}
				
				
				return resultado;
	}

	public boolean eliminarFoto(Foto foto) throws PersistentException {
		boolean resultado = false;
		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		//ProductoDAO.delete(producto);
		try {
			resultado = FotoDAO.delete(foto);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}
		
		
		return resultado;
	}

	public List<Foto> cargarFotos(int idProducto) throws PersistentException {
		List<Foto> fotos = null;

		PersistentTransaction t = TiendavirtualPersistentManager.instance().getSession().beginTransaction();
		try {	
			fotos = FotoDAO.queryFoto("Foto.pertenece_a='" + idProducto + "'", null);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		return fotos;
	}
}